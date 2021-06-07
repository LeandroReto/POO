/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jaslyn
 */
public class Empresa {
    private long id;
    private String nombre;
    private List<Cliente> listadoCliente;
    private List<Empleado> listadoEmpleado;
    private List<Directivo> listaDirectivo;

    public Empresa(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.listadoCliente=new ArrayList();
        this.listadoEmpleado=new ArrayList();
        this.listaDirectivo=new ArrayList();
    }

    public Empresa(long id, String nombre, List<Cliente> listadoCliente, List<Empleado> listadoEmpleado,List<Directivo> listaDirectivo) {
        this.id = id;
        this.nombre = nombre;
        this.listadoCliente = listadoCliente;
        this.listadoEmpleado = listadoEmpleado;
        this.listaDirectivo=listaDirectivo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cliente> getListadoCliente() {
        return listadoCliente;
    }

    public void setListadoCliente(List<Cliente> listadoCliente) {
        this.listadoCliente = listadoCliente;
    }

    public List<Empleado> getListadoEmpleado() {
        return listadoEmpleado;
    }

    public void setListadoEmpleado(List<Empleado> listadoEmpleado) {
        this.listadoEmpleado = listadoEmpleado;
    }

    public List<Directivo> getListaDirectivo() {
        return listaDirectivo;
    }

    public void setListaDirectivo(List<Directivo> listaDirectivo) {
        this.listaDirectivo = listaDirectivo;
    }
    

    @Override
    public String toString() {
        return "Empresa{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
    
}
