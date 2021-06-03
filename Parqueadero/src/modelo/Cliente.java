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
public class Cliente {
    private long id;
    private String nombre;
    private String apellido;
    private String cedula;
    private Empresa empresa; //biidireccional //poner sus getter and setter, los borre para poder correr el programa
    private List<Vehiculo> ListaVehiculo; // poner de este tambien
    
    public Cliente(){ //inicializar valores. no 
        id=0;
        nombre="Christian";
        apellido="Buestan";
        cedula="0105457251";
    }
    public Cliente(long id, String nombre, String apellido, String cedula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        
    }
    public Cliente(long id, String nombre, String apellido, String cedula,Empresa empresa) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.empresa=empresa;
        this.ListaVehiculo=new ArrayList();
        
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
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Vehiculo> getListaVehiculo() {
        return ListaVehiculo;
    }

    public void setListaVehiculo(List<Vehiculo> ListaVehiculo) {
        this.ListaVehiculo = ListaVehiculo;
    }
    
   
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula +empresa+'}';// aniadir ", Empresa=" + Empresa + ", ListaVehiculo=" + ListaVehiculo +
    }
    

    
    

    

    
    
    
}
