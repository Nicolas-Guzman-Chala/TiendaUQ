package model;

public class ClienteCorporativo extends Cliente{
    private String nit;
    private double descuento;

    public ClienteCorporativo(String cedula, String nombre, String direccion, String nit, double descuento) {
        super(cedula, nombre, direccion);
        if(nit.isBlank() || descuento < 0){
            throw new IllegalArgumentException("Tiene que llenar los campos");
        }


        this.nit = nit;
        this.descuento = descuento;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public double descuento() {
        return descuento;
    }
}
