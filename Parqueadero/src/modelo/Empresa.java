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
    private List<Cliente> ListaCliente; //bidireccional //si se elimina solo accesible por cliente 
    //private Cliente[] ListCliente= new Cliente[10];
    public Empresa(){ //contructor vacio siempre al inicio
        id=0;
        nombre="";
        ListaCliente= new ArrayList();
    
}   //metodo de encapsulamiento, se aisla de la clase padre,
    //creo 3 constructores.

    public Empresa(long id, String nombre ) { //necesito
        this.id = id;
        this.nombre = nombre;
        ListaCliente= new ArrayList();
    }
    public Empresa(long id, String nombre, List<Cliente> ListaCliente ) { //necesito en una parte
        this.id = id;
        this.nombre = nombre;
        this.ListaCliente=ListaCliente;
    }
    
    public  long getId(){
        return this.id;
    }
    public void setId(long id){ //void para automaticamente retornar
        this.id=id;    
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public List<Cliente> getListaCliente() {
        return ListaCliente;
    }

    public void setListaCliente(List<Cliente> ListaCliente) {
        this.ListaCliente = ListaCliente;
    }

    @Override
    public String toString() {
        return "Empresa{" + "id=" + id + ", nombre=" + nombre +  '}';
    }
    
    
    
}
