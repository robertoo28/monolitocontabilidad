package Modelo;


public class Contabilidad {
    int id;
    String concepto;
    double ingreso;
    double egreso;
    String fecha;

    public Contabilidad() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getIngreso() {
        return ingreso;
    }

    public void setIngreso(double ingreso) {
        this.ingreso = ingreso;
    }

    public double getEgreso() {
        return egreso;
    }

    public void setEgreso(double egreso) {
        this.egreso = egreso;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Contabilidad{" +
                "id=" + id +
                ", concepto='" + concepto + '\'' +
                ", ingreso=" + ingreso +
                ", egreso=" + egreso +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
