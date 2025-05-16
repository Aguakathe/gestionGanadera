package entidades;

public class Ganadero {

    private int id;
    private String nombre;
    private String tipoDocumento;
    private String numDocumento;
    private String telefono;
    private String direccion;
    private String email;
    private boolean activo;

    public Ganadero() {}

    public Ganadero(int id, String nombre, String tipoDocumento, String numDocumento, String telefono, String direccion, String email, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.activo = activo;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

   

}