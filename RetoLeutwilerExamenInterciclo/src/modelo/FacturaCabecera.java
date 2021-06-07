/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import java.util.List;

/**
 *
 * @author tians
 */
public class FacturaCabecera {
    //Atributos pedidos en la guia de practica son su respectivo tipo de dato
    private long id;
    private Cliente cliente;
    private List<FacturaDetalle> detalles;
    private double total;
    private Date fechaFactura;

    //Constructor FacturaCabecera que inicializa las variables de atributos
    public FacturaCabecera(long id, Cliente cliente, List<FacturaDetalle> detalles, double total, Date fechaFactura) {
        this.id = id;
        this.cliente = cliente;
        this.detalles = detalles;
        this.total = total;
        this.fechaFactura = fechaFactura;
    }

    //Metodos gett and setter del modelo FacturaCabecera
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<FacturaDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<FacturaDetalle> detalles) {
        this.detalles = detalles;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    //Metodo sobrecardago toString de la clase FacturaCabecera
    @Override
    public String toString() {
        return "FacturaCabecera{" + "cliente=" + cliente + ", detalles=" + detalles + ", total=" + total + ", fechaFactura=" + fechaFactura + '}';
    }
    
    
}
