/*

 */
package negocio;

import datos.UsuarioDAO;
import entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class UsuarioControl {

    private final UsuarioDAO DATOS;
    private Usuario obj;
    private DefaultTableModel modeloTabla;
    public int registrosMostrados;

    public UsuarioControl() {
        this.DATOS = new UsuarioDAO();
        this.obj = new Usuario();
        this.registrosMostrados = 0;
    }

    public DefaultTableModel listar(String texto) {
        List<Usuario> lista = new ArrayList<>();
        lista.addAll(DATOS.listar(texto));
        String[] titulos = {"ID", "Rol ID", "Nombre", "Email", "Clave", "Estado"};
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String estado;
        String[] registro = new String[6];
        this.registrosMostrados = 0;

        for (Usuario item : lista) {
            estado = item.isActivo() ? "Activo" : "Inactivo";

            registro[0] = Integer.toString(item.getId());
            registro[1] = Integer.toString(item.getRol_id());
            registro[2] = item.getNombre();
            registro[3] = item.getEmail();
            registro[4] = item.getClave();
            registro[5] = estado;

            this.modeloTabla.addRow(registro);
            this.registrosMostrados++;
        }
        return this.modeloTabla;
    }

    public String insertar(int rol_id, String nombre, String email, String clave) {
        if (DATOS.existe(email)) {
            return "El registro ya existe";
        } else {
            obj.setRol_id(rol_id);
            obj.setNombre(nombre);
            obj.setEmail(email);
            obj.setClave(clave);
            if (DATOS.insertar(obj)) {
                return "OK";
            } else {
                return "Error en el registro";
            }
        }
    }

    public String actualizar(int id, int rol_id, String nombre, String email, String clave, String emailAnt) {
        if (email.equals(emailAnt)) {
            obj.setId(id);
            obj.setRol_id(rol_id);
            obj.setNombre(nombre);
            obj.setEmail(email);
            obj.setClave(clave);
            if (DATOS.actualizar(obj)) {
                return "OK";
            } else {
                return "Error en la actualización";
            }
        } else {
            if (DATOS.existe(email)) {
                return "El registro ya existe";
            } else {
                obj.setId(id);
                obj.setRol_id(rol_id);
                obj.setNombre(nombre);
                obj.setEmail(email);
                obj.setClave(clave);
                if (DATOS.actualizar(obj)) {
                    return "OK";
                } else {
                    return "Error en la actualización";
                }
            }
        }
    }

    public String desactivar(int id) {
        if (DATOS.desactivar(id)) {
            return "OK";
        } else {
            return "No se puede desactivar el registro";
        }
    }

    public String activar(int id) {
        if (DATOS.activar(id)) {
            return "OK";
        } else {
            return "No se puede activar el registro";
        }
    }

    public int total() {
        return DATOS.total();
    }

    public int totalMostrados() {
        return this.registrosMostrados;
    }

    public boolean validarCredenciales(String email, String clave) {
        // Llamar al método buscarPorEmail para obtener el usuario
        Usuario usuario = DATOS.buscarPorEmail(email);  // Llama al método buscarPorEmail
        if (usuario != null && usuario.getClave().equals(clave)) {
            return true;  // Si el usuario existe y la contraseña coincide
        } else {
            return false;  // Si no existe el usuario o la contraseña no coincide
        }
    }

}
