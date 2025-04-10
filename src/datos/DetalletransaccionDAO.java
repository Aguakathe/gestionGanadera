package datos;

import database.Conexion;
import datos.interfaces.CrudSimpleInterface;
import entidades.DetalleTransaccion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DetalletransaccionDAO implements CrudSimpleInterface<DetalleTransaccion> {

    private final Conexion con;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean respuesta;

    public DetalletransaccionDAO() {
        con = Conexion.getInstancia();
    }

    @Override
    public List<DetalleTransaccion> listar(String texto) {
        List<DetalleTransaccion> registro = new ArrayList<>();
        try {
            ps = con.conectar().prepareStatement("SELECT * FROM detalle_transaccion WHERE id_transaccion LIKE ?");
            ps.setString(1, "%" + texto + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                registro.add(new DetalleTransaccion(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getInt(5)));
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
    public boolean insertar(DetalleTransaccion obj) {
        respuesta = false;
        try {
            ps = con.conectar().prepareStatement(
                    "INSERT INTO detalle_transaccion (id_transaccion, id_ganado, precio_unitario, cantidad) VALUES (?, ?, ?, ?)");
            ps.setInt(1, obj.getId_transaccion());
            ps.setInt(2, obj.getId_ganado());
            ps.setDouble(3, obj.getPrecio_Unitario());
            ps.setInt(4, obj.getCantidad());

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
    public boolean actualizar(DetalleTransaccion obj) {
        respuesta = false;
        try {
            ps = con.conectar().prepareStatement(
                    "UPDATE detalle_transaccion SET id_transaccion = ?, id_ganado = ?, precio_unitario = ?, cantidad = ? WHERE id = ?");
            ps.setInt(1, obj.getId_transaccion());
            ps.setInt(2, obj.getId_ganado());
            ps.setDouble(3, obj.getPrecio_Unitario());
            ps.setInt(4, obj.getCantidad());
            ps.setInt(5, obj.getId());

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
            ps = con.conectar().prepareStatement("DELETE FROM detalle_transaccion WHERE id = ?");
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
            ps = con.conectar().prepareStatement("SELECT COUNT(id) FROM detalle_transaccion");
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
