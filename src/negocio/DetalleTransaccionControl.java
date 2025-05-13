package negocio;

import datos.DetalletransaccionDAO;
import entidades.DetalleTransaccion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class DetalleTransaccionControl {

    private final DetalletransaccionDAO DATOS;
    private DetalleTransaccion obj;
    private DefaultTableModel modeloTabla;
    public int RegistrosMostrados;

    public DetalleTransaccionControl() {
        this.DATOS = new DetalletransaccionDAO();
        this.obj = new DetalleTransaccion();
        this.RegistrosMostrados = 0;
    }

    // Método listar, con arreglo de tamaño 6 para incluir la columna "Estado"
    public DefaultTableModel listar(String texto) {
        List<DetalleTransaccion> lista = new ArrayList<>();
        lista.addAll(DATOS.listar(texto));

        // Columnas de la tabla, incluyendo "Estado"
        String[] titulos = {"Id", "IdTransaccion", "IdGanado", "PrecioUnitario", "Cantidad", "Estado"};
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String[] registro = new String[6]; 
        this.RegistrosMostrados = 0;

        // Agregar los registros a la tabla
        for (DetalleTransaccion item : lista) {
            registro[0] = Integer.toString(item.getId());
            registro[1] = Integer.toString(item.getId_transaccion());
            registro[2] = Integer.toString(item.getId_ganado());
            registro[3] = Double.toString(item.getPrecio_Unitario());
            registro[4] = Integer.toString(item.getCantidad());
           
            this.modeloTabla.addRow(registro);
            this.RegistrosMostrados++;
        }

        return this.modeloTabla;
    }

    // Método para insertar un nuevo registro
    public String Insertar(int idTransaccion, int idGanado, double precioUnitario, int cantidad ) {
        if (DATOS.existe(idTransaccion, idGanado)) {  
            return "El registro ya existe.";
        } else {
            obj.setId_transaccion(idTransaccion);
            obj.setId_ganado(idGanado);
            obj.setCantidad(cantidad);
            obj.setPrecio_Unitario(precioUnitario);
            

            if (DATOS.insertar(obj)) {
                return "Ok";
            } else {
                return "Error en el registro.";
            }
        }
    }

    // Método para actualizar un registro
    public String Actualizar(int id, int idtransaccion, int idganado, double perciounitario, int cantidad, int idanterior) {
        if (id ==(idanterior)) {
            obj.setId(id);
            obj.setId_transaccion(idtransaccion);
            obj.setId_ganado(idganado);
            obj.setPrecio_Unitario(perciounitario);
            obj.setCantidad(cantidad);

            if (DATOS.actualizar(obj)) {
                return "Ok";
            } else {
                return "Error en la actualización";
            }
        } else { 
            // Si se cambió el nombre, se verifica que no exista otro registro con ese nombre
            if (DATOS.existe(idtransaccion, idganado)) {
                return "El registro ya existe";
            } else {
                obj.setId(id);
                obj.setId_transaccion(idtransaccion);
                obj.setId_ganado(idganado);
                obj.setPrecio_Unitario(perciounitario);
                obj.setCantidad(cantidad);

                if (DATOS.actualizar(obj)) {
                    return "Ok";
                } else {
                    return "Error en la actualización";
                }
            }
        }
    }

    // Método para contar el total de registros
    public int total() {
        return DATOS.total();
    }
}

    // Método para contar los registros mostrados
