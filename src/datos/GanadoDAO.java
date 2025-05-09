package datos;

import database.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entidades.Ganado;
import datos.interfaces.CrudSimpleInterface;
import javax.swing.JOptionPane;

public class GanadoDAO implements CrudSimpleInterface<Ganado> {

    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean respuesta;

    public GanadoDAO() {
        CON = Conexion.getInstancia();
    }

    @Override
    public List<Ganado> listar(String texto) {
        List<Ganado> registro = new ArrayList<>();
        try {
            ps = CON.conectar().prepareStatement("SELECT * FROM ganado WHERE numero_identificacion LIKE ?");
            ps.setString(1, "&" + texto + "&");
            rs = ps.executeQuery();

            while (rs.next()) {
                registro.add(new Ganado(
                        rs.getInt("id"),
                        rs.getInt("ganadero_id"),
                        rs.getString("numero_identificacion"),
                        rs.getString("raza"),
                        rs.getInt("edad"),
                        rs.getDouble("peso"),
                        rs.getBoolean("vacunado"),
                        rs.getString("fecha_registro")));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            CON.desconectar();
        }
        return registro;
    }

    @Override
    public boolean insertar(Ganado obj) {
        respuesta = false;
        try {
            ps = CON.conectar().prepareStatement("INSERT INTO ganado (ganadero_id, numero_identificacion, raza, edad, peso, vacunado, fecha_registro) VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, obj.getGanaderoId());
            ps.setString(2, obj.getNumeroIdentificacion());
            ps.setString(3, obj.getRaza());
            ps.setInt(4, obj.getEdad());
            ps.setDouble(5, obj.getPeso());
            ps.setBoolean(6, obj.isVacunado());
            ps.setString(7, obj.getFechaRegistro());

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
    public boolean actualizar(Ganado obj) {
        respuesta = false;
        try {
            ps = CON.conectar().prepareStatement("UPDATE ganado SET ganadero_id = ?, numero_identificacion = ?, raza = ?, edad = ?, peso = ?, vacunado = ?, fecha_registro = ? WHERE id = ?");
            ps.setInt(1, obj.getGanaderoId());
            ps.setString(2, obj.getNumeroIdentificacion());
            ps.setString(3, obj.getRaza());
            ps.setInt(4, obj.getEdad());
            ps.setDouble(5, obj.getPeso());
            ps.setBoolean(6, obj.isVacunado());
            ps.setString(7, obj.getFechaRegistro());
            ps.setInt(8, obj.getId());

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
            ps = CON.conectar().prepareStatement("DELETE FROM ganado WHERE id = ?");
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
            ps = CON.conectar().prepareStatement("SELECT COUNT(id) FROM ganado");
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
            ps = null;
            rs = null;
        }
        return totalRegistro;
    }
  
    public boolean existe(String numeroIdentificacion, int id) {
        respuesta = false; // Inicializamos la variable respuesta como falsa

        try {
            // Preparar la consulta para verificar si el número de identificación ya existe en otro ganado
            ps = CON.conectar().prepareStatement("SELECT numero_identificacion FROM ganado WHERE numero_identificacion = ? AND id != ?");
            ps.setString(1, numeroIdentificacion); // Seteamos el número de identificación
            ps.setInt(2, id); // Seteamos el ID del registro actual para que se excluya en la búsqueda
            rs = ps.executeQuery(); // Ejecutamos la consulta

            // Si se encuentra un registro con el mismo número de identificación (pero con un ID diferente)
            if (rs.next()) {
                respuesta = true; // El número de identificación ya existe
            }
            ps.close(); // Cerramos la consulta
            rs.close(); // Cerramos el conjunto de resultados
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage()); // En caso de error, mostramos el mensaje
        } finally {
            ps = null; // Limpiamos el PreparedStatement
            rs = null; // Limpiamos el ResultSet
            CON.desconectar(); // Desconectamos la base de datos
        }

        return respuesta; // Retornamos si el número de identificación ya existe o no
    }
}
