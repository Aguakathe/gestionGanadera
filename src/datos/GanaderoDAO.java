package datos;

import database.Conexion;
import datos.interfaces.CrudSimpleInterface;
import entidades.Ganadero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class GanaderoDAO implements CrudSimpleInterface<Ganadero> {

    private final Conexion con;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean respuesta;

    public GanaderoDAO() {
        con = Conexion.getInstancia();
    }

    @Override
    public List<Ganadero> listar(String texto) {
        List<Ganadero> registro = new ArrayList<>();
        try {
            ps = con.conectar().prepareStatement("SELECT * FROM ganadero WHERE nombre LIKE ?");
            ps.setString(1, "%" + texto + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                registro.add(new Ganadero(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("tipo_documento"),
                        rs.getString("num_documento"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getString("email"),
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
            con.desconectar();
        }
        return registro;
    }

    @Override
    public boolean insertar(Ganadero obj) {
        respuesta = false;
        try {
            ps = con.conectar().prepareStatement(
                "INSERT INTO ganadero (nombre, tipo_documento, num_documento, telefono, direccion, email, activo) VALUES (?, ?, ?, ?, ?, ?, ?)"
            );
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getTipoDocumento());
            ps.setString(3, obj.getNumDocumento());
            ps.setString(4, obj.getTelefono());
            ps.setString(5, obj.getDireccion());
            ps.setString(6, obj.getEmail());
            ps.setBoolean(7, obj.isActivo());

            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            con.desconectar();
        }
        return respuesta;
    }

    @Override
    public boolean actualizar(Ganadero obj) {
        respuesta = false;
        try {
            ps = con.conectar().prepareStatement(
                "UPDATE ganadero SET nombre = ?, tipo_documento = ?, num_documento = ?, telefono = ?, direccion = ?, email = ?, activo = ? WHERE id = ?"
            );
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getTipoDocumento());
            ps.setString(3, obj.getNumDocumento());
            ps.setString(4, obj.getTelefono());
            ps.setString(5, obj.getDireccion());
            ps.setString(6, obj.getEmail());
            ps.setBoolean(7, obj.isActivo());
            ps.setInt(8, obj.getId());

            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            con.desconectar();
        }
        return respuesta;
    }

    @Override
    public boolean eliminar(int id) {
        return desactivar(id); // usa el método ya definido
    }

    public boolean Existe(String texto) {
        respuesta = false;
        try {
            ps = con.conectar().prepareStatement("SELECT 1 FROM ganadero WHERE nombre = ?");
            ps.setString(1, texto);
            rs = ps.executeQuery();
            if (rs.next()) {
                respuesta = true;
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            con.desconectar();
        }
        return respuesta;
    }

    public boolean desactivar(int id) {
        return cambiarEstado(id, false);
    }

    public boolean activar(int id) {
        return cambiarEstado(id, true);
    }

    private boolean cambiarEstado(int id, boolean estado) {
        boolean respuesta = false;
        try {
            ps = con.conectar().prepareStatement("UPDATE ganadero SET activo=? WHERE id=?");
            ps.setBoolean(1, estado);
            ps.setInt(2, id);
            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            con.desconectar();
        }
        return respuesta;
    }

    @Override
    public int total() {
        int total = 0;
        try {
            ps = con.conectar().prepareStatement("SELECT COUNT(id) FROM ganadero");
            rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getInt(1);
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            con.desconectar();
        }
        return total;
    }
}
 