package datos;

import database.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entidades.Transaccion;
import datos.interfaces.CrudSimpleInterface;
import javax.swing.JOptionPane;

public class TransaccionDAO implements CrudSimpleInterface<Transaccion> {

    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean respuesta;

    public TransaccionDAO() {
        CON = Conexion.getInstancia();
    }

    @Override
    public List<Transaccion> listar(String texto) {
        List<Transaccion> registros = new ArrayList<>();
        try {
            // Modificar la consulta para filtrar por 'id' (ID de transacción)
            ps = CON.conectar().prepareStatement("SELECT * FROM transaccion WHERE id LIKE ?");
            ps.setString(1, "%" + texto + "%"); // Filtrar usando el ID de transacción
            rs = ps.executeQuery();

            // Recorrer el resultado de la consulta y agregarlo a la lista
            while (rs.next()) {
                registros.add(new Transaccion(
                        rs.getInt("id"),
                        rs.getInt("ganadero_id"),
                        rs.getString("tipo_transaccion"),
                        rs.getString("fecha"),
                        rs.getDouble("total"),
                        rs.getString("estado")
                ));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            CON.desconectar();
        }
        return registros;
    }

    @Override
    public boolean insertar(Transaccion obj) {
        respuesta = false;
        try {
            ps = CON.conectar().prepareStatement("INSERT INTO transaccion (ganadero_id, tipo_transaccion, fecha, total, estado) VALUES (?, ?, ?, ?, ?)");
            ps.setInt(1, obj.getGanaderoId());
            ps.setString(2, obj.getTipoTransaccion());
            ps.setString(3, obj.getFecha());
            ps.setDouble(4, obj.getTotal());
            ps.setString(5, obj.getEstado());

            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            CON.desconectar();
        }
        return respuesta;
    }

    @Override
    public boolean actualizar(Transaccion obj) {
        respuesta = false;
        try {
            ps = CON.conectar().prepareStatement("UPDATE transaccion SET ganadero_id = ?, tipo_transaccion = ?, fecha = ?, total = ?, estado = ? WHERE id = ?");
            ps.setInt(1, obj.getGanaderoId());
            ps.setString(2, obj.getTipoTransaccion());
            ps.setString(3, obj.getFecha());
            ps.setDouble(4, obj.getTotal());
            ps.setString(5, obj.getEstado());
            ps.setInt(6, obj.getId());

            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            CON.desconectar();
        }
        return respuesta;
    }

    @Override
    public boolean eliminar(int id) {
        respuesta = false;
        try {
            ps = CON.conectar().prepareStatement("DELETE FROM transaccion WHERE id = ?");
            ps.setInt(1, id);

            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            CON.desconectar();
        }
        return respuesta;
    }

    @Override
    public int total() {
        int totalRegistro = 0;
        try {
            ps = CON.conectar().prepareStatement("SELECT COUNT(id) FROM transaccion");
            rs = ps.executeQuery();
            if (rs.next()) {
                totalRegistro = rs.getInt(1);
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            CON.desconectar();
        }
        return totalRegistro;
    }
}
