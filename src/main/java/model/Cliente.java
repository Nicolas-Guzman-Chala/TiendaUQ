package model;

import java.util.LinkedList;
import java.util.List;

public abstract class Cliente {
    protected String cedula;
    protected String nombre;
    protected String direccion;

    protected List<Factura> listaFacturas;

    public Cliente(String cedula, String nombre, String direccion){
        if(cedula.isBlank() || nombre.isBlank() || direccion.isBlank()){
            throw new IllegalArgumentException("Tiene que llenar los datos");
        }
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaFacturas = new LinkedList<>();
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Factura> getListaFacturas() {
        return listaFacturas;
    }

    public void setListaFacturas(List<Factura> listaFacturas) {
        this.listaFacturas = listaFacturas;
    }

    public abstract double descuento(){
        return descuento;
    }
}
