/*

 */
package negocio;

import datos.rolDAO;
import entidades.Rol;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class RolControl {

    private final rolDAO DATOS;
    private Rol obj;
    private DefaultTableModel modeloTabla;
    public int registrosMostrados;

    public RolControl() {
        this.DATOS = new rolDAO();
        this.obj = new Rol();
        this.registrosMostrados = 0;
    }

    public DefaultTableModel listar(String texto) {
        List<Rol> lista = new ArrayList<>();
        lista.addAll(DATOS.listar(texto));

        String[] titulos = {"ID", "Nombre", "Descripción"};
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String[] registro = new String[3];
        this.registrosMostrados = 0;

        for (Rol item : lista) {
            registro[0] = Integer.toString(item.getId());
            registro[1] = item.getNombre();
            registro[2] = item.getDescripcion();

            this.modeloTabla.addRow(registro);
            this.registrosMostrados++;
        }

        return this.modeloTabla;
    }

    public String insertar(String nombre, String descripcion) {
        if (DATOS.existe(nombre)) {
            return "El rol ya existe";
        } else {
            obj.setNombre(nombre);
            obj.setDescripcion(descripcion);
            return DATOS.insertar(obj) ? "OK" : "Error en el registro";
        }
    }

    //Aactualizar roles
    public String actualizar(int id, String nombre, String descripcion, String nombreAnt) {
        if (nombre.equals(nombreAnt) || !DATOS.existe(nombre)) {
            obj.setId(id);
            obj.setNombre(nombre);
            obj.setDescripcion(descripcion);
            return DATOS.actualizar(obj) ? "OK" : "Error en la actualización";
        } else {
            return "El registro ya existe";
        }
    }
    
    //Cantidad de roles 
    public int total() {
        return DATOS.total();
    }
    
    //Metodo para mostrar roles
    public int totalMostrados() {
        return this.registrosMostrados;
    }
}
