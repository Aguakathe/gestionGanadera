package negocio;

import datos.GanaderoDAO;
import entidades.Ganadero;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class GanaderoControl {

    private final GanaderoDAO DATOS; // OBJETOS QUYE MANEJA LAS OPERACIONES CON LAS BASES DE DATOS
    private Ganadero obj;// OBJETO DE TIPO CATEGORIA QUE SE UTILIZA PARA MANIPULAR DATOS TEMPORALES
    private DefaultTableModel modeloTabla;// MODELO DE TABLA UTILIZADO PARA MOSTRAR DATOS EN LA INTERFAZ GRAFICA
    public int RegistrosMostrados;// varibable que almacena el numero de registros que se muestran en la tabla

    // constructor de la ganadero control
    public GanaderoControl() {
        this.DATOS = new GanaderoDAO();
        this.obj = new Ganadero();
        this.RegistrosMostrados = 0;
    }

    public DefaultTableModel listar(String texto) {
        List<Ganadero> lista = new ArrayList<>();
        lista.addAll(DATOS.listar(texto));// LLENA LA LISTA CON LOS RESULTADOS DE LA LISTAS

        String[] titulos = { "Id", "Tipo Documento", "N° Documento", "Teléfono", "Dirección", "Email", "Estado" };

        this.modeloTabla = new DefaultTableModel(null, titulos);// Se inicializa el modelo de la tabla coon los
                                                                // encabezados

        String estado;// Variable temporal para almacenar el estado de ccada categoria
        String[] registro = new String[8];// Arreglo de String para almacenar los datos de cada fila;
        this.RegistrosMostrados = 0;// Se reinicia el contador de registros

        // for que recorre cada categoria obtenida de la base de datos
        for (Ganadero item : lista) {
            if (item.isActivo()) {// VERIFICA SI LA CATEGORIA ESTA ACTIVA O INACTIVA
                estado = "Activo";

            } else {
                estado = "Inactivo";
            }

            registro[0] = Integer.toString(item.getId());
            registro[1] = item.getTipo_Documento();
            registro[2] = Integer.toString(item.getNum_Documento());
            registro[3] = Integer.toString(item.getTelefono());
            registro[4] = item.getDireccion();
            registro[5] = item.getEmail();
            registro[6] = estado;

            this.modeloTabla.addRow(registro);
            this.RegistrosMostrados++;
        }

        return this.modeloTabla;

    }

    // Metodo insertarn una ueva categoria
    public String Insertar(String nombre, String direccion, String tipodocumento, int NumeroDocumento, int telefono,
            String email) {
        if (DATOS.Existe(nombre)) {
            return "El registro ya existe ";
        } else {
            obj.setNombre(nombre);
            obj.setDireccion(direccion);
            obj.setTipo_Documento(tipodocumento);
            obj.setNum_Documento(NumeroDocumento);
            obj.setTelefono(telefono);
            obj.setEmail(email);

            if (DATOS.insertar(obj)) {
                return "Ok";
            } else {
                return "Error en el registro";
            }
        }
    }

    public String Actualizar(int id, String nombre, String direccion, String nombreAnt, String tipodocumento,
            int numrtodocumento, int telefono, String email) {
        if (nombre.equals(nombreAnt)) {
            obj.setId(id);
            obj.setNombre(nombre);
            obj.setDireccion(direccion);
            obj.setTipo_Documento(tipodocumento);
            obj.setNum_Documento(numrtodocumento);
            obj.setTelefono(telefono);
            obj.setEmail(email);

            if (DATOS.actualizar(obj)) {
                return "Ok";
            } else {
                return "Error en la  actualizacion";
            }
        } else {// Si se cambuio el nombre se verifica que no exista otro registro con ese
                // nombre
            if (DATOS.Existe(nombre)) {
                return "El registro ya exite";

            } else {
                obj.setNombre(nombre);
                obj.setDireccion(direccion);
                obj.setTipo_Documento(tipodocumento);
                obj.setNum_Documento(numrtodocumento);
                obj.setTelefono(telefono);
                obj.setEmail(email);
                if (DATOS.actualizar(obj)) {
                    return "Ok";
                } else {
                    return "Error en la  actualizacion";
                }
            }

        }
    }

    // Metodo desactivar
    public String Desactivar(int id) {
        if (DATOS.desactivar(id)) {
            return "OK";
        } else {
            return "No se puede desactivar el registro";
        }
    }

    // METODO PARA ACTIVAR UNA CATEGORIA
    public String Activar(int id) {
        if (DATOS.activar(id)) {
            return "OK";

        } else {
            return "No se puede activar el registro";
        }
    }

    // metodo para obtener el total de categoria registarads en la base de datos
    public int total() {
        return DATOS.total();
    }

    // metodo para obtener el numero de categoria actuales
    public int totalMostrados() {
        return this.RegistrosMostrados;
    }
}