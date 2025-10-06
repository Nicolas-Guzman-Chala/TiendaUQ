package model;

import java.time.LocalDate;

public class ProductoAlimenticio extends Producto{
    private LocalDate fechaVencimiento;

    public ProductoAlimenticio(String codigo, String nombre, double precio, LocalDate fechaVencimiento) {
        super(codigo, nombre, precio);

        if(fechaVencimiento.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("El producto esta vencido");
        }
        this.fechaVencimiento = fechaVencimiento;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}
