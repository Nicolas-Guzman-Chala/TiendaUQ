package model;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Tienda {
    private String nombre;
    private String nit;
    private String direccion;
    private List<Cliente> listaClientes;
    private List<Producto> listaProducto;
    private List<Factura> listaFactura;

    public Tienda(String nombre, String nit, String direccion) {

        if (nombre.isBlank() || nit.isBlank() || direccion.isBlank()) {
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

    public String ingresarCliente(Cliente cliente) {
        if (buscarCliente(cliente.getCedula()).isEmpty()) {
            listaClientes.add(cliente);
            return "El cliente se ha registrado exitosamente.";
        }
        return "El cliente ya existe.";
    }

    public Optional<Cliente> buscarCliente(String cedula) {
        return listaClientes.stream().filter(c -> c.getCedula().equals(cedula)).findFirst();
    }

    public String eliminarCliente(String cedula) {
        Optional<Cliente> clienteOpt = buscarCliente(cedula);
        if (clienteOpt.isPresent()) {
            listaClientes.remove(clienteOpt.get());
            return "El cliente ha sido eliminado.";
        }
        return "El cliente no existe.";
    }

    public String actualizarCliente(Cliente clienteActualizado) {
        Optional<Cliente> clienteExistente = buscarCliente(clienteActualizado.getCedula());

        if (clienteExistente.isEmpty()) {
            return "No se encontró el cliente a actualizar.";
        }

        Cliente cliente = clienteExistente.get();

        cliente.setNombre(clienteActualizado.getNombre());
        cliente.setDireccion(clienteActualizado.getDireccion());

        if (cliente instanceof ClienteFrecuente && clienteActualizado instanceof ClienteFrecuente) {
            ((ClienteFrecuente) cliente).setPuntosF(((ClienteFrecuente) clienteActualizado).getPuntosF());
        } else if (cliente instanceof ClienteCorporativo && clienteActualizado instanceof ClienteCorporativo) {
            ((ClienteCorporativo) cliente).setNit(((ClienteCorporativo) clienteActualizado).getNit());
            ((ClienteCorporativo) cliente).setDescuento(((ClienteCorporativo) clienteActualizado).getDescuento());
        }

        return "El cliente se actualizó correctamente.";
    }

    public String ingresarProducto(Producto producto) {
        if (buscarProducto(producto.getCodigo()).isEmpty()) {
            listaProducto.add(producto);
            return "Producto agregado correctamente.";
        }
        return "El producto ya existe.";
    }

    public Optional<Producto> buscarProducto(String codigo) {
        return listaProducto.stream().filter(p -> p.getCodigo().equals(codigo)).findFirst();
    }

    public String eliminarProducto(String codigo) {
        Optional<Producto> productoOpt = buscarProducto(codigo);
        if (productoOpt.isPresent()) {
            listaProducto.remove(productoOpt.get());
            return "Producto eliminado correctamente.";
        }
        return "El producto no existe.";
    }

    public String actualizarProducto(Producto productoActualizado) {
        Optional<Producto> productoOpt = buscarProducto(productoActualizado.getCodigo());
        if (productoOpt.isEmpty()) {
            return "No se encontró el producto a actualizar.";
        }

        Producto producto = productoOpt.get();
        producto.setNombre(productoActualizado.getNombre());
        producto.setPrecio(productoActualizado.getPrecio());

        if (producto instanceof ProductoAlimenticio && productoActualizado instanceof ProductoAlimenticio) {
            ((ProductoAlimenticio) producto).setFechaVencimiento(((ProductoAlimenticio) productoActualizado).getFechaVencimiento());
        } else if (producto instanceof ProductoElectrodomestico && productoActualizado instanceof ProductoElectrodomestico) {
            ((ProductoElectrodomestico) producto).setGarantia(((ProductoElectrodomestico) productoActualizado).getGarantia());
        }

        return "Producto actualizado correctamente.";
    }

    public String ingresarFactura(Factura factura) {
        if (buscarFactura(factura.getNumero()).isEmpty()) {
            listaFactura.add(factura);
            return "Factura registrada correctamente.";
        }
        return "La factura ya existe.";
    }

    public Optional<Factura> buscarFactura(int numero) {
        return listaFactura.stream().filter(f -> f.getNumero() == numero).findFirst();
    }

    public String eliminarFactura(int numero) {
        Optional<Factura> facturaOpt = buscarFactura(numero);
        if (facturaOpt.isPresent()) {
            listaFactura.remove(facturaOpt.get());
            return "Factura eliminada correctamente.";
        }
        return "No existe una factura con ese número.";
    }

    public String actualizarFactura(Factura facturaActualizada) {
        Optional<Factura> facturaOpt = buscarFactura(facturaActualizada.getNumero());
        if (facturaOpt.isEmpty()) {
            return "No se encontró la factura a actualizar.";
        }

        Factura factura = facturaOpt.get();
        factura.setFecha(facturaActualizada.getFecha());
        factura.setCliente(facturaActualizada.getCliente());
        factura.setListaProductos(facturaActualizada.getListaProductos());
        factura.setListaDetallesFactura(facturaActualizada.getListaDetallesFactura());

        return "Factura actualizada correctamente.";
}
}
