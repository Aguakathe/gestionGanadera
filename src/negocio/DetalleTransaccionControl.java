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
        List<DetalleTransaccion> lista = new ArrayList<>(DATOS.listar(texto));

        String[] titulos = {"Id", "IdTransaccion", "IdGanado", "PrecioUnitario", "Cantidad"};
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String[] registro = new String[5];
        this.RegistrosMostrados = 0;

        for (DetalleTransaccion item : lista) {
            registro[0] = Integer.toString(item.getId());
            registro[1] = Integer.toString(item.getIdTransaccion());
            registro[2] = Integer.toString(item.getIdGanado());
            registro[3] = Double.toString(item.getPrecioUnitario());
            registro[4] = Integer.toString(item.getCantidad());

            this.modeloTabla.addRow(registro);
            this.RegistrosMostrados++;
        }

        return this.modeloTabla;
    }

    public String insertar(int idTransaccion, int idGanado, double precioUnitario, int cantidad) {
        if (DATOS.existe(idTransaccion, idGanado)) {
            return "El registro ya existe.";
        } else {
            obj.setIdTransaccion(idTransaccion);
            obj.setIdGanado(idGanado);
            obj.setCantidad(cantidad);
            obj.setPrecioUnitario(precioUnitario);

            return DATOS.insertar(obj) ? "OK" : "Error en el registro.";
        }
    }

    public String actualizar(int id, int idTransaccion, int idGanado, double precioUnitario, int cantidad) {
        if (DATOS.existe(idTransaccion, idGanado) && !DATOS.esElMismoRegistro(id, idTransaccion, idGanado)) {
            return "Ya existe otro registro con esta combinación";
        }

        obj.setId(id);
        obj.setIdTransaccion(idTransaccion);
        obj.setIdGanado(idGanado);
        obj.setPrecioUnitario(precioUnitario);
        obj.setCantidad(cantidad);

        return DATOS.actualizar(obj) ? "OK" : "Error en la actualización";
    }

    public int total() {
        return DATOS.total();
    }

    public int totalMostrados() {
        return this.RegistrosMostrados;
    }
}
