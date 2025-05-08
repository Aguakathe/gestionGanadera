package datos;

import database.Conexion;
import datos.interfaces.CrudSimpleInterface;
import entidades.Ganadero;

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
            ps = con.conectar().prepareStatement("SELECT * FROM categoria WHERE nombre LIKE ?");
            ps.setString(1, "%" + texto + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                registro.add(new Ganadero(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
                        rs.getString(6), rs.getString(7), rs.getBoolean(8)));
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
            ps = con.conectar().prepareStatement("INSERT INTO Ganadero (nombre, Email, activo) VALUES (?, ?, 1)");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDireccion());

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
            ps = con.conectar().prepareStatement("UPDATE Ganadero SET nombre = ?, Email = ? WHERE id = ?");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getEmail());
            ps.setInt(3, obj.getId());

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
        respuesta = false;
        try {
            ps = con.conectar().prepareStatement("UPDATE Ganadero SET activo = 0 WHERE id = ?");
            ps.setInt(1, id);

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

    public boolean Existe(String texto) {
        respuesta = false;
        try {
            ps = con.conectar().prepareStatement("SELECT nombre FROM categoria WHERE nombre=?");
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
            con.desconectar();
        }
        return respuesta;
    }

    public boolean desactivar(int id) {
        boolean respuesta = false;
        try {
            ps = con.conectar().prepareStatement("UPDATE Categoria SET activo=0 WHERE id=?");
            ps.setInt(1, id);
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

    public boolean activar(int id) {
        boolean respuesta = false;
        try {
            ps = con.conectar().prepareStatement("UPDATE Categoria SET activo=0 WHERE id=?");
            ps.setInt(1, id);
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
            ps = con.conectar().prepareStatement("SELECT COUNT(id) FROM Ganadero");
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
