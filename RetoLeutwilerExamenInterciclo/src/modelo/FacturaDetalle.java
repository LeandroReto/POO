/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author tians
 */
public class FacturaDetalle {
    //Atributos pedidos en la guia de practica son su respectivo tipo de dato
    private long id;
    private Producto producto;
    private long cantidad;
    private double valor;

    //Constructor FacturaDetalle que inicializa las variables de atributos
    public FacturaDetalle(long id, Producto producto, long cantidad, double valor) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.valor = valor;
    }

    //Metodos gett and setter del modelo FacturaDetalle
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
 
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    //Metodo sobrecardago toString de la clase FacturaCabecera
    @Override
    public String toString() {
        return "FacturaDetalle{" + "producto=" + producto + ", cantidad=" + cantidad + ", valor=" + valor + '}';
    }
    
    
}
