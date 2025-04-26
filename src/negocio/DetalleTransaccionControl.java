
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

    public DefaultTableModel listar(String texto) {
        List<DetalleTransaccion> lista = new ArrayList<>();
        lista.addAll(DATOS.listar(texto));

        String[] titulos = {"Id", "IdTransaccion", "IdGanado", "PrecioUnitario", "Cantidad"};
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String[] registro = new String[5];
        this.RegistrosMostrados = 0;

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
    
    public String Insertar(int idTransaccion, int idGanado, double precioUnitario, int cantidad) {
    if (DATOS.Existe(idTransaccion, idGanado)) {
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
                return "Error en la  actualizacion";
            }
        } else {//Si se cambuio el nombre se verifica que no exista otro registro con ese nombre
            if (DATOS.Existe(idtransaccion, idganado)) {
                return "El registro ya exite";

            } else {
               obj.setId(id);
            obj.setId_transaccion(idtransaccion);
            obj.setId_ganado(idganado);
            obj.setPrecio_Unitario(perciounitario);
            obj.setCantidad(cantidad);
                if (DATOS.actualizar(obj)) {
                    return "Ok";
                } else {
                    return "Error en la  actualizacion";
                }
            }

        }
    }


    public int total() {
        return DATOS.total();
    }

    public int totalMostrados() {
        return this.RegistrosMostrados;
    }
}
