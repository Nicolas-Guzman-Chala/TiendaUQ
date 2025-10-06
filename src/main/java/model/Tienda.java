package model;

import java.util.LinkedList;
import java.util.List;

public class Tienda {
    private String nombre;
    private String nit;
    private String direccion;
    private List<Cliente> listaClientes;
    private List<Producto> listaProducto;
    private List<Factura> listaFactura;

    public Tienda(String nombre, String nit, String direccion) {

        if(nombre.isBlank() || nit.isBlank() || direccion .isBlank()){
            throw new IllegalArgumentException("No puedes dejar campos vacios");
        }

        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.listaClientes = new LinkedList<>();
        this.listaProducto = new LinkedList<>();
        this.listaFactura = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public List<Factura> getListaFactura() {
        return listaFactura;
    }

    public void setListaFactura(List<Factura> listaFactura) {
        this.listaFactura = listaFactura;
    }

    //crud

    public String ingresarCliente(Cliente cliente){
        if(buscarCliente(cliente.getCedula()).isEmpty){

        }
    }
}
