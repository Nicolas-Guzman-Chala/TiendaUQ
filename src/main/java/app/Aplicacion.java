package app;

import java.time.LocalDate;
import java.util.Scanner;
import model.*;

public class Aplicacion {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Tienda tienda = new Tienda("TechStore", "123456", "Calle 45 #23-10");

        int opcion = 0;
        do {
            System.out.println("\n===== MENÚ TIENDA =====");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Registrar producto");
            System.out.println("3. Registrar factura");
            System.out.println("4. Buscar cliente");
            System.out.println("5. Actualizar cliente");
            System.out.println("6. Eliminar cliente");
            System.out.println("7. Mostrar todas las facturas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> {
                    System.out.println("1. Cliente Frecuente  |  2. Cliente Corporativo");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Cédula: ");
                    String cedula = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Dirección: ");
                    String direccion = sc.nextLine();

                    if (tipo == 1) {
                        System.out.print("Puntos: ");
                        int puntos = sc.nextInt();
                        sc.nextLine();

                        ClienteFrecuente cf = new ClienteFrecuente(cedula, nombre, direccion, puntos);
                        System.out.println(tienda.ingresarCliente(cf));
                    } else {
                        System.out.print("NIT: ");
                        String nit = sc.nextLine();
                        System.out.print("Descuento: ");
                        double desc = sc.nextDouble();
                        sc.nextLine();

                        ClienteCorporativo cc = new ClienteCorporativo(cedula, nombre, direccion, nit, desc);
                        System.out.println(tienda.ingresarCliente(cc));
                    }
                }

                case 2 -> {
                    System.out.println("1. Producto Alimenticio  |  2. Producto Electrodoméstico");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Código: ");
                    String codigo = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();
                    sc.nextLine();

                    if (tipo == 1) {
                        System.out.print("Fecha de vencimiento (YYYY-MM-DD): ");
                        String fecha = sc.nextLine();
                        ProductoAlimenticio pa = new ProductoAlimenticio(codigo, nombre, precio, LocalDate.parse(fecha));
                        System.out.println(tienda.ingresarProducto(pa));
                    } else {
                        System.out.print("Garantía (meses): ");
                        int garantia = sc.nextInt();
                        sc.nextLine();
                        ProductoElectrodomestico pe = new ProductoElectrodomestico(codigo, nombre, precio, garantia);
                        System.out.println(tienda.ingresarProducto(pe));
                    }
                }

                case 3 -> {
                    System.out.print("Número de factura: ");
                    int num = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Cédula del cliente: ");
                    String cedula = sc.nextLine();

                    var clienteOpt = tienda.buscarCliente(cedula);
                    if (clienteOpt.isEmpty()) {
                        System.out.println("Cliente no encontrado.");
                        break;
                    }

                    Factura factura = new Factura(num, LocalDate.now(), clienteOpt.get());

                    System.out.print("Código del producto: ");
                    String cod = sc.nextLine();

                    var prodOpt = tienda.buscarProducto(cod);
                    if (prodOpt.isEmpty()) {
                        System.out.println("Producto no encontrado.");
                        break;
                    }

                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt();
                    sc.nextLine();

                    DetalleFactura detalle = new DetalleFactura(cantidad, prodOpt.get());
                    factura.getListaDetallesFactura().add(detalle);

                    tienda.ingresarFactura(factura);
                    System.out.println("Factura creada con total: " + factura.calcularTotal());
                }

                case 4 -> {
                    System.out.print("Ingrese cédula del cliente: ");
                    String cedula = sc.nextLine();
                    var cliente = tienda.buscarCliente(cedula);
                    if (cliente.isPresent()) {
                        System.out.println("Cliente encontrado: " + cliente.get().getNombre());
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                }

                case 5 -> {
                    System.out.print("Ingrese cédula del cliente a actualizar: ");
                    String cedula = sc.nextLine();
                    var clienteOpt = tienda.buscarCliente(cedula);

                    if (clienteOpt.isEmpty()) {
                        System.out.println("Cliente no existe.");
                        break;
                    }

                    Cliente c = clienteOpt.get();
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = sc.nextLine();
                    System.out.print("Nueva dirección: ");
                    String nuevaDireccion = sc.nextLine();

                    if (c instanceof ClienteFrecuente cf) {
                        System.out.print("Nuevos puntos: ");
                        int puntos = sc.nextInt();
                        System.out.print("Nuevo descuento: ");
                        double desc = sc.nextDouble();
                        sc.nextLine();
                        ClienteFrecuente nuevo = new ClienteFrecuente(c.getCedula(), nuevoNombre, nuevaDireccion, puntos);
                        System.out.println(tienda.actualizarCliente(nuevo));
                    } else if (c instanceof ClienteCorporativo cc) {
                        System.out.print("Nuevo NIT: ");
                        String nit = sc.nextLine();
                        System.out.print("Nuevo descuento: ");
                        double desc = sc.nextDouble();
                        sc.nextLine();
                        ClienteCorporativo nuevo = new ClienteCorporativo(c.getCedula(), nuevoNombre, nuevaDireccion, nit, desc);
                        System.out.println(tienda.actualizarCliente(nuevo));
                    }
                }

                case 6 -> {
                    System.out.print("Ingrese cédula del cliente a eliminar: ");
                    String cedula = sc.nextLine();
                    System.out.println(tienda.eliminarCliente(cedula));
                }

                case 7 -> {
                    if (tienda.getListaFactura().isEmpty()) {
                        System.out.println("No hay facturas registradas.");
                    } else {
                        tienda.getListaFactura().forEach(f ->
                                System.out.println("Factura #" + f.getNumero() + " | Cliente: " + f.getCliente().getNombre() + " | Total: " + f.calcularTotal()));
                    }
                }

                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        sc.close();
    }

}
