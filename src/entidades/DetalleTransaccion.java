package entidades;

public class DetalleTransaccion {
    private int id;
    private int id_transaccion;
    private int id_ganado;
    private double precio_Unitario;
    private int cantidad;
    private String estado;
    

    public DetalleTransaccion(int id, int id_transaccion, int id_ganado, double precio_Unitario, int cantidad, String estado) {
        this.id = id;
        this.id_transaccion = id_transaccion;
        this.id_ganado = id_ganado;
        this.precio_Unitario = precio_Unitario;
        this.cantidad = cantidad;
        this.estado = estado;
    }
    public DetalleTransaccion(){
        
    }

    

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public int getId_ganado() {
        return id_ganado;
    }

    public void setId_ganado(int id_ganado) {
        this.id_ganado = id_ganado;
    }

    public double getPrecio_Unitario() {
        return precio_Unitario;
    }

    public void setPrecio_Unitario(double precio_Unitario) {
        this.precio_Unitario = precio_Unitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
