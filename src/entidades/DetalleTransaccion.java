package entidades;

public class DetalleTransaccion {

    private int id;
    private int idTransaccion;
    private int idGanado;
    private double precioUnitario;
    private int cantidad;

    public DetalleTransaccion() {
    }

    public DetalleTransaccion(int id, int idTransaccion, int idGanado, double precioUnitario, int cantidad) {
        this.id = id;
        this.idTransaccion = idTransaccion;
        this.idGanado = idGanado;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public int getIdGanado() {
        return idGanado;
    }

    public void setIdGanado(int idGanado) {
        this.idGanado = idGanado;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
 