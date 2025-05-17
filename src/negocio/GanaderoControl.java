package negocio;

import datos.GanaderoDAO;
import entidades.Ganadero;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class GanaderoControl {

    private final GanaderoDAO DATOS;
    private Ganadero obj;
    private DefaultTableModel modeloTabla;
    public int RegistrosMostrados;

    public GanaderoControl() {
        this.DATOS = new GanaderoDAO();
        this.obj = new Ganadero();
        this.RegistrosMostrados = 0;
    }

    public DefaultTableModel listar(String texto) {
        List<Ganadero> lista = new ArrayList<>();
        lista.addAll(DATOS.listar(texto));

        String[] titulos = {"ID", "Nombre", "Tipo Documento", "N° Documento", "Teléfono", "Dirección", "Email", "Estado"};
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String[] registro = new String[8];
        this.RegistrosMostrados = 0;

        for (Ganadero item : lista) {
            String estado = item.isActivo() ? "Activo" : "Inactivo";

            registro[0] = Integer.toString(item.getId());
            registro[1] = item.getNombre();
            registro[2] = item.getTipoDocumento();
            registro[3] = item.getNumDocumento();
            registro[4] = item.getTelefono();
            registro[5] = item.getDireccion();
            registro[6] = item.getEmail();
            registro[7] = estado;

            this.modeloTabla.addRow(registro);
            this.RegistrosMostrados++;
        }

        return this.modeloTabla;
    }

    public String Insertar(String nombre, String tipoDocumento, String numDocumento, String telefono, String direccion, String email) {
        if (DATOS.Existe(nombre)) {
            return "El registro ya existe";
        } else {
            obj.setNombre(nombre);
            obj.setTipoDocumento(tipoDocumento);
            obj.setNumDocumento(numDocumento);
            obj.setTelefono(telefono);
            obj.setDireccion(direccion);
            obj.setEmail(email);
            obj.setActivo(true);

            if (DATOS.insertar(obj)) {
                return "OK";
            } else {
                return "Error en el registro";
            }
        }
    }

    public String Actualizar(int id, String nombre, String nombreAnt, String tipoDocumento, String numDocumento, String telefono, String direccion, String email) {
        if (nombre.equals(nombreAnt)) {
            obj.setId(id);
            obj.setNombre(nombre);
            obj.setTipoDocumento(tipoDocumento);
            obj.setNumDocumento(numDocumento);
            obj.setTelefono(telefono);
            obj.setDireccion(direccion);
            obj.setEmail(email);

            if (DATOS.actualizar(obj)) {
                return "OK";
            } else {
                return "Error en la actualización";
            }
        } else {
            if (DATOS.Existe(nombre)) {
                return "El registro ya existe";
            } else {
                obj.setId(id);
                obj.setNombre(nombre);
                obj.setTipoDocumento(tipoDocumento);
                obj.setNumDocumento(numDocumento);
                obj.setTelefono(telefono);
                obj.setDireccion(direccion);
                obj.setEmail(email);

                if (DATOS.actualizar(obj)) {
                    return "OK";
                } else {
                    return "Error en la actualización";
                }
            }
        }
    }

    public String Desactivar(int id) {
        if (DATOS.desactivar(id)) {
            return "OK";
        } else {
            return "No se puede desactivar el registro";
        }
    }

    public String Activar(int id) {
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
        return this.RegistrosMostrados;
    }

    
}
