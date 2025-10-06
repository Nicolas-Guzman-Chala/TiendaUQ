package model;

import java.util.LinkedList;
import java.util.List;

public abstract class Producto {

    protected String codigo;
    protected String nombre;
    protected double precio;
    protected List<DetalleFactura> listaDetallesFactura;

    public Producto(String codigo, String nombre, double precio) {

        if(codigo.isBlank() || nombre.isBlank() || precio <= 0){
            throw new IllegalArgumentException("Ingrese todos los valores");
        }
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.listaDetallesFactura = new LinkedList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<DetalleFactura> getListaDetallesFactura() {
        return listaDetallesFactura;
    }

    public void setListaDetallesFactura(List<DetalleFactura> listaDetallesFactura) {
        this.listaDetallesFactura = listaDetallesFactura;
    }
}
