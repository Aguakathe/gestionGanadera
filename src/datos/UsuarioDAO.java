package datos;

import database.Conexion;
import datos.interfaces.CrudSimpleInterface;
import entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UsuarioDAO implements CrudSimpleInterface<Usuario> {

    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean respuesta;

    public UsuarioDAO() {
        CON = Conexion.getInstancia();
    }

    @Override
    public List<Usuario> listar(String texto) {
        List<Usuario> registro = new ArrayList<>();
        try {
            ps = CON.conectar().prepareStatement("SELECT * FROM usuario WHERE nombre LIKE ?");
            ps.setString(1, "%" + texto + "%"); // Correcto uso del comodín %
            rs = ps.executeQuery();

            while (rs.next()) {
                registro.add(new Usuario(
                        rs.getInt("id"),
                        rs.getInt("rol_id"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("clave"),
                        rs.getBoolean("activo")
                ));
            }

            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            CON.desconectar();
        }
        return registro;
    }

    @Override
    public boolean insertar(Usuario obj) {
        respuesta = false;
        try {
            ps = CON.conectar().prepareStatement("INSERT INTO usuario (rol_id, nombre, email, clave, activo) VALUES (?, ?, ?, ?, ?)");
            ps.setInt(1, obj.getRol_id());
            ps.setString(2, obj.getNombre());
            ps.setString(3, obj.getEmail());
            ps.setString(4, obj.getClave());
            ps.setBoolean(5, obj.isActivo());

            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            CON.desconectar();
        }
        return respuesta;
    }

    @Override
    public boolean actualizar(Usuario obj) {
        respuesta = false;
        try {
            ps = CON.conectar().prepareStatement("UPDATE usuario SET rol_id = ?, nombre = ?, email = ?, clave = ?, activo = ? WHERE id = ?");
            ps.setInt(1, obj.getRol_id());
            ps.setString(2, obj.getNombre());
            ps.setString(3, obj.getEmail());
            ps.setString(4, obj.getClave());
            ps.setBoolean(5, obj.isActivo());
            ps.setInt(6, obj.getId());

            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            CON.desconectar();
        }
        return respuesta;
    }

    @Override
    public boolean eliminar(int id) {
        respuesta = false;
        try {
            ps = CON.conectar().prepareStatement("DELETE FROM usuario WHERE id = ?");
            ps.setInt(1, id);

            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            CON.desconectar();
        }
        return respuesta;
    }

    @Override
    public int total() {
        int totalRegistro = 0;
        try {
            ps = CON.conectar().prepareStatement("SELECT COUNT(id) FROM usuario");
            rs = ps.executeQuery();

            if (rs.next()) {
                totalRegistro = rs.getInt(1);
            }

            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            CON.desconectar();
        }
        return totalRegistro;
    }

    public boolean activar(int id) {
        boolean respuesta = false;
        try {
            ps = CON.conectar().prepareStatement("UPDATE Categoria SET activo=1 WHERE id=?");
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            CON.desconectar();
        }
        return respuesta;
    }

    public boolean desactivar(int id) {
        boolean respuesta = false;
        try {
            ps = CON.conectar().prepareStatement("UPDATE Categoria SET activo=0 WHERE id=?");
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            CON.desconectar();
        }
        return respuesta;
    }

    @Override
    public boolean existe(String email) {
        respuesta = false;

        try {
            // Verificamos si ya existe un usuario con el mismo email
            ps = CON.conectar().prepareStatement("SELECT email FROM usuario WHERE email = ?");
            ps.setString(1, email);
            rs = ps.executeQuery();

            if (rs.next()) {
                respuesta = true;  // Si existe un usuario con ese email, devuelve true
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            CON.desconectar();
        }
        return respuesta;
    }

    // Método para buscar un usuario por su email
    // Método para buscar un usuario por su email
    public Usuario buscarPorEmail(String email) {
        Usuario usuario = null;
        try {
            String query = "SELECT * FROM usuario WHERE email = ?";
            ps = CON.conectar().prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setRol_id(rs.getInt("rol_id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setEmail(rs.getString("email"));
                usuario.setClave(rs.getString("clave"));
                usuario.setActivo(rs.getBoolean("activo"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();  // Deberías registrar o mostrar el error de forma detallada
        } finally {
            CON.desconectar();
        }

        return usuario;
    }

}
