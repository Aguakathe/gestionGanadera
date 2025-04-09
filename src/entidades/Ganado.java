

package entidades;


public class Ganado {
    private int id;
    private int ganaderoId;
    private String numeroIdentificacion;
    private String raza;
    private int edad;
    private double peso;
    private boolean vacunado;
    private String fechaRegistro;

    public Ganado() {
    }

    public Ganado(int id, int ganaderoId, String numeroIdentificacion, String raza, int edad, double peso, boolean vacunado, String fechaRegistro) {
        this.id = id;
        this.ganaderoId = ganaderoId;
        this.numeroIdentificacion = numeroIdentificacion;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
        this.vacunado = vacunado;
        this.fechaRegistro = fechaRegistro;
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

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public boolean isVacunado() {
        return vacunado;
    }

    public void setVacunado(boolean vacunado) {
        this.vacunado = vacunado;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "Ganado" + "id:" + id + ", ganaderoId:" + ganaderoId + ", numeroIdentificacion:" + 
                numeroIdentificacion + ", raza" + raza + ", edad" + edad + ", peso" + peso + 
                ", vacunado" + vacunado + ", fechaRegistro" + fechaRegistro ;
    }
    
    
    
}
