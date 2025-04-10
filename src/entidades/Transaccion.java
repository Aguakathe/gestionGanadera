
package entidades;

public class Transaccion {
    private int id;
    private int ganaderoId;
    private String tipoTransaccion;
    private String fecha;
    private double total;
    private String estado;

    public Transaccion() {
    }

    public Transaccion(int id, int ganaderoId, String tipoTransaccion, String fecha, double total, String estado) {
        this.id = id;
        this.ganaderoId = ganaderoId;
        this.tipoTransaccion = tipoTransaccion;
        this.fecha = fecha;
        this.total = total;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGanaderoId() {
        return ganaderoId;
    }

    public void setGanaderoId(int ganaderoId) {
        this.ganaderoId = ganaderoId;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Transaccion" + "id:" + id + ", ganaderoId:" + ganaderoId + ", tipoTransaccion:" + tipoTransaccion
                + ", fecha:" + fecha
                + ", total:" + total + ", estado:" + estado;
    }

}
