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
            ps = con.conectar().prepareStatement("SELECT * FROM detalle_transaccion WHERE transaccion_id LIKE ?");
            ps.setString(1, "%" + texto + "%");
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
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            con.desconectar();
        }
        return registro;
    }
    public boolean existe(int idTransaccion, int idGanado) {
    boolean existe = false;
    try {
        // Preparar la consulta SQL para buscar el registro con el idTransaccion y idGanado
        String query = "SELECT 1 FROM detalle_transaccion WHERE transaccion_id = ? AND ganado_id = ?";
        ps = con.conectar().prepareStatement(query);
        ps.setInt(1, idTransaccion);  // Asignar el valor de idTransaccion
        ps.setInt(2, idGanado);        // Asignar el valor de idGanado
        rs = ps.executeQuery();        // Ejecutar la consulta

        // Si se encuentra algún resultado, significa que el registro ya existe
        if (rs.next()) {
            existe = true;  // Registro encontrado
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
    return existe;  // Retorna true si el registro existe, false si no
}

    
    @Override
   
public boolean insertar(DetalleTransaccion obj) {
    respuesta = false;
    try {
        ps = con.conectar().prepareStatement(
            "INSERT INTO detalle_transaccion (transaccion_id, ganado_id, precio_unitario, cantidad) VALUES (?, ?, ?, ?)");
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
public boolean actualizar(DetalleTransaccion obj) {
    boolean respuesta = false;
    try {
        ps = con.conectar().prepareStatement(
            "UPDATE detalle_transaccion SET transaccion_id = ?, ganado_id = ?, precio_unitario = ?, cantidad = ? WHERE id = ?");
        
        // Establecemos los parámetros del PreparedStatement
        ps.setInt(1, obj.getId_transaccion()); // Setea transaccion_id
        ps.setInt(2, obj.getId_ganado()); // Setea ganado_id
        ps.setDouble(3, obj.getPrecio_Unitario()); // Setea precio_unitario
        ps.setInt(4, obj.getCantidad()); // Setea cantidad
        
        ps.setInt(5, obj.getId()); // Setea el id del registro que se va a actualizar
        
        // Ejecuta la actualización
        if (ps.executeUpdate() > 0) {
            respuesta = true; // Si la actualización fue exitosa, se devuelve true
        }
        
        ps.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    } finally {
        ps = null;
        con.desconectar();
    }
    return respuesta; // Devuelve true si la actualización fue exitosa, false si hubo un error
}




}