package entidades;

public class Usuario {

    private int id;
    private int rol_id;
    private String nombre;
    private String email;
    private String clave;
    private boolean activo;

    public Usuario() {
    }

    public Usuario(int id, int rol_id, String nombre, String email, String clave, boolean activo) {
        this.id = id;
        this.rol_id = rol_id;
        this.nombre = nombre;
        this.email = email;
        this.clave = clave;
        this.activo = activo;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getRol_id() {
        return rol_id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getClave() {
        return clave;
    }

    public boolean isActivo() {
        return activo;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", rol_id=" + rol_id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", clave='" + clave + '\'' +
                ", activo=" + activo +
                '}';
    }

}
