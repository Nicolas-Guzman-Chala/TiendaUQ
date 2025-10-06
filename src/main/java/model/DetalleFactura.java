package model;

import java.util.LinkedList;
import java.util.List;

public class DetalleFactura {

    private int cantidad;
    private Producto producto;
    private List<Factura> listaFacturas;

    public DetalleFactura(int cantidad, Producto producto) {

        if(cantidad <= 0 || producto == null){
            throw new IllegalArgumentException("Minimo tiene que haber un producto");
        }

        this.cantidad = cantidad;
        this.producto = producto;
        this.listaFacturas = new LinkedList<>();
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Factura> getListaFacturas() {
        return listaFacturas;
    }

    public void setListaFacturas(List<Factura> listaFacturas) {
        this.listaFacturas = listaFacturas;
    }

    //metodo para el subtotal

    public double generarSubTotal(){
        return cantidad * producto.getPrecio();
    }
}
