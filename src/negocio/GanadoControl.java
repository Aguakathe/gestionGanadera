package negocio;

import datos.GanadoDAO;
import entidades.Ganado;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class GanadoControl {

    private final GanadoDAO DATOS; // Objeto que maneja las operaciones con la base de datos
    private Ganado obj; // Objeto de tipo Ganado que se usa para manipular datos temporalmente
    private DefaultTableModel modeloTabla; // Modelo de tabla utilizado para mostrar datos en la interfaz gráfica
    public int registrosMostrados; // Variable que almacena el número de registros que se muestran en la tabla

    // Constructor de la clase GanadoControl
    public GanadoControl() {
        this.DATOS = new GanadoDAO(); // Inicializa el objeto GanadoDAO
        this.obj = new Ganado(); // Inicializa un objeto vacío de tipo Ganado
        this.registrosMostrados = 0;
    }

    // Método para listar los ganados en la base de datos y mostrarlos en la tabla
    public DefaultTableModel listar(String texto) {
        List<Ganado> lista = new ArrayList<>();
        lista.addAll(DATOS.listar(texto)); // Llama al método listar de GanadoDAO y obtiene los resultados

        // Encabezados de la tabla
        String[] titulos = {"ID", "Ganadero ID", "Número Identificación", "Raza", "Edad", "Peso", "Vacunado", "Fecha Registro"};
        this.modeloTabla = new DefaultTableModel(null, titulos); // Inicializa el modelo de la tabla con los encabezados

        String[] registro = new String[8]; // Arreglo para almacenar los datos de cada fila
        this.registrosMostrados = 0; // Reinicia el contador de registros mostrados

        // Recorre cada ganado obtenido de la base de datos y los agrega a la tabla
        for (Ganado item : lista) {
            registro[0] = Integer.toString(item.getId());
            registro[1] = Integer.toString(item.getGanaderoId());
            registro[2] = item.getNumeroIdentificacion();
            registro[3] = item.getRaza();
            registro[4] = Integer.toString(item.getEdad());
            registro[5] = Double.toString(item.getPeso());
            registro[6] = item.isVacunado() ? "Sí" : "No";
            registro[7] = item.getFechaRegistro();

            this.modeloTabla.addRow(registro); // Agrega la fila de datos a la tabla
            this.registrosMostrados++;
        }
        return this.modeloTabla; // Devuelve el modelo de la tabla con los datos
    }

    // metodo para insertar un nuevo ganado en la base de datos
    public String insertar(int ganaderoId, String numeroIdentificacion, String raza, int edad, double peso, boolean vacunado, String fechaRegistro) {
        obj.setGanaderoId(ganaderoId);
        obj.setNumeroIdentificacion(numeroIdentificacion);
        obj.setRaza(raza);
        obj.setEdad(edad);
        obj.setPeso(peso);
        obj.setVacunado(vacunado);
        obj.setFechaRegistro(fechaRegistro);

        if (DATOS.insertar(obj)) {
            return "OK"; // Si la inserción es exitosa
        } else {
            return "Error en el registro"; // Si ocurre un error en la inserción
        }
    }

    public String actualizar(int id, int ganaderoId, String numeroIdentificacion, String raza, int edad, double peso, boolean vacunado, String fechaRegistro) {
        // Verifica si el número de identificación ya existe en otro ganado
        if (DATOS.existe(numeroIdentificacion, id)) {  // El método existe necesita considerar el ID para que no verifique el propio registro
            return "El número de identificación ya existe para otro ganado";
        } else {
            // Si el número de identificación no existe, procede con la actualización
            obj.setId(id);
            obj.setGanaderoId(ganaderoId);
            obj.setNumeroIdentificacion(numeroIdentificacion);
            obj.setRaza(raza);
            obj.setEdad(edad);
            obj.setPeso(peso);
            obj.setVacunado(vacunado);
            obj.setFechaRegistro(fechaRegistro);

            // Realiza la actualización en la base de datos
            if (DATOS.actualizar(obj)) {
                return "OK"; // Si la actualización es exitosa
            } else {
                return "Error en la actualización"; // Si ocurre un error durante la actualización
            }
        }
    }

    // Método para eliminar un ganado de la base de datos
    public String eliminar(int id) {
        if (DATOS.eliminar(id)) {
            return "OK"; // Si la eliminación es exitosa
        } else {
            return "Error en la eliminación"; // Si ocurre un error en la eliminación
        }
    }

    // Método para obtener el total de registros de ganado en la base de datos
    public int total() {
        return DATOS.total(); // Llama al método total de GanadoDAO y devuelve el total
    }

    // Método para obtener el número de registros mostrados en la tabla
    public int totalMostrados() {
        return this.registrosMostrados; // Devuelve el número de registros mostrados
    }
}
