package datos;

import database.Conexion;
import java.sql.PreparedStatement; //esto importa la clase nos permite ejecutar consultas sql con parametros
import java.sql.ResultSet; //IMPORTAMOS ESTA CLASE para majenar los resultados de las consultas sql
import java.sql.SQLException; //se importa esta clase para manejar las excepciones con sql
import datos.interfaces.CrudSimpleInterface;
import entidades.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CategoriaDAO implements CrudSimpleInterface<Categoria> {

    private final Conexion CON; //atributo que mantiene enlazado la conexion a la bd
    private PreparedStatement ps; //obbjeto q se utiliza parqa preparar y ejecutar sentenicias sql
    private ResultSet rs; //objeto q almacena los resuktados de las consultas sql
    private boolean respuesta; // es mi variable q almacena si una operacion fue exitosa o no
    //constructor para inicializar la VARIABLE

    public CategoriaDAO() {
        CON = Conexion.getInstancia();
    }

    @Override
    public List<Categoria> listar(String texto) {
        List<Categoria> registro = new ArrayList<>();
        try {
            //preparar la consulta sql con un parametro de busqueda
            ps = CON.conectar().prepareStatement("Select * from categoria WHERE nombre like ?");
            ps.setString(1, "&" + texto + "&");//asiganamos el parametro de busqueda (comodin) a la consulta

            rs = ps.executeQuery();

            //iteramos sobre los resultados y los agregamos a la lista
            while (rs.next()) {
                registro.add(new Categoria(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4))); //listamos
            }

            ps.close(); //cerrar la cosulta sql
            rs.close(); //cerramos el conjunto de resultados
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            CON.desconectar(); //desconectar la bd para librerar recursos
        }
        return registro;
    }

    @Override
    public boolean insertar(Categoria obj) {
        respuesta = false; //inicializamo la respuesta en false(operacion fallida por defecto)
        try {
            ps = CON.conectar().prepareStatement("INSERT INTO categoria (nombre, descripcion, activo) VALUES (?,?,1)");
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
    public boolean actualizar(Categoria obj) {
        respuesta = false;
        try {
            ps = CON.conectar().prepareStatement(" UPDATE categoria SET nombre = ?, descripcion = ?,  WHERE id = ?");
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
    public boolean desactivar(int id) {
        respuesta = true;
        try {
            ps = CON.conectar().prepareStatement("UPDATE categoria Set activo = 0 wHERE id = ? ");
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
    public boolean activar(int id) {
        respuesta = false;

        try {
            ps = CON.conectar().prepareStatement("UPDATE Categoria SET activo=1, WHERE id=?");
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
            ps = CON.conectar().prepareStatement("SELECT COUNT(id) FROM categoria");
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

    @Override
    public boolean existe(String texto) {
        respuesta = false;

        try {
            ps = CON.conectar().prepareStatement("SELECT nombre From categoria Where nombre=?");
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
            CON.desconectar();
        }
        return respuesta;
    }
}
