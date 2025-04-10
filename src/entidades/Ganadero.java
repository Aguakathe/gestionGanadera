package entidades;

public class Ganadero {

    private int id;
    private String Nombre;
    private String Tipo_Documento;
    private int Num_Documento;
    private int Telefono;
    private String Direccion;
    private String Email;
    private boolean Activo;

    public Ganadero(int id, String Nombre, String Tipo_Documento, int Num_Documento, int Telefono, String Direccion, String Email, boolean Activo) {
        this.id = id;
        this.Nombre = Nombre;
        this.Tipo_Documento = Tipo_Documento;
        this.Num_Documento = Num_Documento;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
        this.Email = Email;
        this.Activo = Activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTipo_Documento() {
        return Tipo_Documento;
    }

    public void setTipo_Documento(String Tipo_Documento) {
        this.Tipo_Documento = Tipo_Documento;
    }

    public int getNum_Documento() {
        return Num_Documento;
    }

    public void setNum_Documento(int Num_Documento) {
        this.Num_Documento = Num_Documento;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public boolean isActivo() {
        return Activo;
    }

    public void setActivo(boolean Activo) {
        this.Activo = Activo;
    }

    @Override
    public String toString() {
        return "Ganadero{" + "id=" + id + ", Nombre=" + Nombre + ", Tipo_Documento=" + Tipo_Documento + ", Num_Documento=" + Num_Documento + ", Telefono=" + Telefono + ", Direccion=" + Direccion + ", Email=" + Email + ", Activo=" + Activo + '}';
    }
    
}
