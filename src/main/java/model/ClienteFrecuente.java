package model;

public class ClienteFrecuente extends Cliente{
    private int puntosF;
    private double descuento = 0.05;

    public ClienteFrecuente(String cedula, String nombre, String direccion, double descuento, int puntosF) {
        if(puntosF == 0 ){
            throw new IllegalArgumentException("No deje los campos vacios");
        }
        this.descuento = descuento;
        this.puntosF = puntosF;
    }

    public int getPuntosF() {
        return puntosF;
    }

    public void setPuntosF(int puntosF) {
        this.puntosF = puntosF;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
}
