package model;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Factura {

    private int numero;
    private LocalDate fecha;
    private Cliente cliente;
    private List<Producto> listaProductos;
    private List<DetalleFactura> listaDetallesFactura;


    public Factura(int numero, LocalDate fecha, Cliente cliente) {

        if(numero < 0 || fecha.isBefore(LocalDate.now()) || cliente == null){
            throw new IllegalArgumentException("Llena todos los campos");
        }
        this.numero = numero;
        this.fecha = fecha;
        this.cliente = cliente;
        this.listaProductos = new LinkedList<>();
        this.listaDetallesFactura = new LinkedList<>();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public List<DetalleFactura> getListaDetallesFactura() {
        return listaDetallesFactura;
    }

    public void setListaDetallesFactura(List<DetalleFactura> listaDetallesFactura) {
        this.listaDetallesFactura = listaDetallesFactura;
    }

    //Calcular total a pagar del cliente

    public double calcularTotal(){
        double descuento = cliente.descuento();

        double sumaTotal = 0;
        for(DetalleFactura f : listaDetallesFactura){
            sumaTotal = f.generarSubTotal();
        }

        return sumaTotal - (sumaTotal * descuento);
    }

}
