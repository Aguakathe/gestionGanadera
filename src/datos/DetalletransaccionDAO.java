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
            ps = con.conectar().prepareStatement("SELECT * FROM detalle_transaccion WHERE transaccion_id = ?");
            ps.setInt(1, Integer.parseInt(texto));
            rs = ps.executeQuery();

            while (rs.next()) {
                registro.add(new DetalleTransaccion(
                        rs.getInt("id"),
                        rs.getInt("transaccion_id"),
                        rs.getInt("ganado_id"),
                        rs.getDouble("precio_unitario"),
                        rs.getInt("cantidad")
                ));
            }

            ps.close();
            rs.close();
        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            con.desconectar();
        }
        return registro;
    }

    public boolean existe(int transaccionId, int ganadoId) {
        boolean existe = false;
        try {
            ps = con.conectar().prepareStatement("SELECT 1 FROM detalle_transaccion WHERE transaccion_id = ? AND ganado_id = ?");
            ps.setInt(1, transaccionId);
            ps.setInt(2, ganadoId);
            rs = ps.executeQuery();
            if (rs.next()) {
                existe = true;
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
        return existe;
    }

    public boolean esElMismoRegistro(int id, int transaccionId, int ganadoId) {
        boolean esElMismo = false;
        try {
            ps = con.conectar().prepareStatement("SELECT 1 FROM detalle_transaccion WHERE id = ? AND transaccion_id = ? AND ganado_id = ?");
            ps.setInt(1, id);
            ps.setInt(2, transaccionId);
            ps.setInt(3, ganadoId);
            rs = ps.executeQuery();
            if (rs.next()) {
                esElMismo = true;
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
        return esElMismo;
    }

    @Override
    public boolean insertar(DetalleTransaccion obj) {
        respuesta = false;
        try {
            ps = con.conectar().prepareStatement(
                "INSERT INTO detalle_transaccion (transaccion_id, ganado_id, precio_unitario, cantidad) VALUES (?, ?, ?, ?)");
            ps.setInt(1, obj.getIdTransaccion());
            ps.setInt(2, obj.getIdGanado());
            ps.setDouble(3, obj.getPrecioUnitario());
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
                "UPDATE detalle_transaccion SET transaccion_id = ?, ganado_id = ?, precio_unitario = ?, cantidad = ? WHERE id = ?");
            ps.setInt(1, obj.getIdTransaccion());
            ps.setInt(2, obj.getIdGanado());
            ps.setDouble(3, obj.getPrecioUnitario());
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
        boolean respuesta = false;
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
 