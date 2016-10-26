/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author BLABPC23
 */
public class ModelProductos {
    private String producto;
    private String descripcion;
    private int precio_compra;
    private double precio_venta;
    private int productos_existentes;

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(int precio_compra) {
        this.precio_compra = precio_compra;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public int getProductos_existentes() {
        return productos_existentes;
    }

    public void setProductos_existentes(int productos_existentes) {
        this.productos_existentes = productos_existentes;
    }
    
    
    
}
    
