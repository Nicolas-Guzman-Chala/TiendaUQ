package model;

public class ProductoElectrodomestico extends Producto{

    private int garantia;

    public ProductoElectrodomestico(String codigo, String nombre, double precio, int garantia) {
        super(codigo, nombre, precio);

        if(garantia == 0){
            throw new IllegalArgumentException("Tiene que llenar todos los campos");
        }
        this.garantia = garantia;
    }

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }
}
