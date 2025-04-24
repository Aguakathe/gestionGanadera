package negocio;

import datos.TransaccionDAO;
import entidades.Transaccion;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class TransaccionControl {
    private final TransaccionDAO DATOS; // Objeto para manejar operaciones con la BD
    private Transaccion obj; // Objeto temporal de tipo Transaccion
    private DefaultTableModel modeloTabla; // Modelo de la tabla para la interfaz gráfica
    public int registrosMostrados; // Número de registros mostrados

    // Constructor
    public TransaccionControl() {
        this.DATOS = new TransaccionDAO(); // Inicializa el DAO
        this.obj = new Transaccion();
        this.registrosMostrados = 0;
    }

    // Método para listar las transacciones
    public DefaultTableModel listar(String texto) {
        List<Transaccion> lista = new ArrayList<>();
        lista.addAll(DATOS.listar(texto)); // Llenamos la lista con los resultados de la consulta
        String[] titulos = {"ID", "Ganadero ID", "Tipo Transacción", "Fecha", "Total", "Estado"};
        this.modeloTabla = new DefaultTableModel(null, titulos); // Inicializa la tabla

        String[] registro = new String[6]; // Arreglo para almacenar los datos de cada fila
        this.registrosMostrados = 0; // Reinicia el contador

        // Iteramos sobre las transacciones y las agregamos a la tabla
        for (Transaccion item : lista) {
            registro[0] = Integer.toString(item.getId());
            registro[1] = Integer.toString(item.getGanaderoId());
            registro[2] = item.getTipoTransaccion();
            registro[3] = item.getFecha();
            registro[4] = String.valueOf(item.getTotal());
            registro[5] = item.getEstado();

            this.modeloTabla.addRow(registro);
            this.registrosMostrados++; // Aumentamos el contador de registros
        }
        return this.modeloTabla;
    }

    // Método para insertar una nueva transacción
    public String insertar(int ganaderoId, String tipoTransaccion, String fecha, double total, String estado) {
        obj.setGanaderoId(ganaderoId);
        obj.setTipoTransaccion(tipoTransaccion);
        obj.setFecha(fecha);
        obj.setTotal(total);
        obj.setEstado(estado);

        if (DATOS.insertar(obj)) {
            return "OK"; // Si la inserción es exitosa
        } else {
            return "Error en la inserción"; // Si ocurre un error
        }
    }

    // Método para actualizar una transacción existente
    public String actualizar(int id, int ganaderoId, String tipoTransaccion, String fecha, double total, String estado) {
        obj.setId(id);
        obj.setGanaderoId(ganaderoId);
        obj.setTipoTransaccion(tipoTransaccion);
        obj.setFecha(fecha);
        obj.setTotal(total);
        obj.setEstado(estado);

        if (DATOS.actualizar(obj)) {
            return "OK"; // Si la actualización es exitosa
        } else {
            return "Error en la actualización"; // Si ocurre un error
        }
    }

    // Método para eliminar una transacción
    public String eliminar(int id) {
        if (DATOS.eliminar(id)) {
            return "OK"; // Si la eliminación es exitosa
        } else {
            return "Error al eliminar"; // Si ocurre un error
        }
    }

    // Método para obtener el total de transacciones registradas
    public int total() {
        return DATOS.total();
    }

    // Método para obtener el total de transacciones mostradas
    public int totalMostrados() {
        return this.registrosMostrados;
    }
}
