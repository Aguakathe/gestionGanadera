package datos;

import database.Conexion;
import datos.interfaces.CrudSimpleInterface;
import entidades.Rol;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class rolDAO implements CrudSimpleInterface<Rol> {

    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean respuesta;

    public rolDAO() {
        CON = Conexion.getInstancia();
    }

    @Override
    public List<Rol> listar(String texto) {
        List<Rol> registros = new ArrayList<>();
        try {
            ps = CON.conectar().prepareStatement("SELECT * FROM rol WHERE nombre LIKE ?");
            ps.setString(1, "%" + texto + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                registros.add(new Rol(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion")
                ));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            rs = null;
            ps = null;
            CON.desconectar();
        }
        return registros;
    }

    @Override
    public boolean insertar(Rol obj) {
        respuesta = false;
        try {
            ps = CON.conectar().prepareStatement("INSERT INTO rol(nombre, descripcion) VALUES (?, ?)");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDescripcion());
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
    public boolean actualizar(Rol obj) {
        respuesta = false;
        try {
            ps = CON.conectar().prepareStatement("UPDATE rol SET nombre=?, descripcion=? WHERE id=?");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDescripcion());
            ps.setInt(3, obj.getId());
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
            ps = CON.conectar().prepareStatement("DELETE FROM rol WHERE id=?");
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
        int total = 0;
        try {
            ps = CON.conectar().prepareStatement("SELECT COUNT(id) FROM rol");
            rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getInt(1);
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            rs = null;
            ps = null;
            CON.desconectar();
        }
        return total;
    }
}
