package model;

public class ClienteFrecuente extends Cliente{
    private int puntosF;

    public ClienteFrecuente(String cedula, String nombre, String direccion, int puntosF) {
        super(cedula, nombre, direccion);
        if(puntosF < 0 ){
            throw new IllegalArgumentException("No deje los campos vacios");
        }
        this.puntosF = puntosF;
    }

    public int getPuntosF() {
        return puntosF;
    }

    public void setPuntosF(int puntosF) {
        this.puntosF = puntosF;
    }

    @Override
    public double descuento() {
        return 0.05;
    }
}
