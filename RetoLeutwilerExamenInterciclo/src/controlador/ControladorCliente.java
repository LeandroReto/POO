/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;


public class ControladorCliente {
    //Lista de tipo Cliente
    private List<Cliente> listaCliente;
    //Variable Cliente que guarda la seleccion de busqueda
    private Cliente seleccionado;

    //Constructor que inicializa la lista de clientes
    public ControladorCliente() {
        listaCliente = new ArrayList();
    }
    
    //Metodo generar ID que devuelve un valor de forma incremental 
    public long generarId(){
        if(listaCliente.size()>0)      //si su linea de accion es unicamente 1 no hay necesidad de llaves for if do while
            return listaCliente.get(listaCliente.size()-1).getId()+1;
        else
            return 1;
    }
    
    //Metodo crear que ingresa un objeto Cliente con los parametros de los atributos y devuelve un booleano si se ingresa o no
    public boolean crear(String nombre, String cedula, int fiabilidadPago){
        return listaCliente.add(new Cliente(this.generarId(), nombre, cedula, fiabilidadPago));
    }
    
    //Metodo buscar que encuentra un objeto Cliente en la lista, recibiendo como parametro su nombre en caso de no existir se devuelve un null
    public Cliente buscar(String nombre){
        for (Cliente cliente: listaCliente) {
            if(cliente.getNombre().equalsIgnoreCase(nombre)){
                seleccionado = cliente;
                return cliente;
            }
        }
        return null;
    }
    
    //Metodo actualizar para dar valores a un objeto Cliente y reemplazarlo por otro, este metodo utiliza otro de buscar,donde le devuelve el objeto a reemplazar
    public boolean actualizar(String nombre, String cedula, int fiabilidadPago){
        Cliente cliente= buscar(nombre);
        if(cliente != null){
            int posicion = listaCliente.indexOf(cliente);
            cliente.setNombre(nombre);
            cliente.setCedula(cedula);
            cliente.setFiabilidadPago(fiabilidadPago);
            listaCliente.set(posicion, cliente);
            return true;
        }
        return false;
    }
    //Metodo eliminar para remover un objeto de la lista Clientes, que emplea el metodo buscar para encontra el objeto a eliminar
    public boolean eliminar(String nombre){
        Cliente cliente = buscar(nombre);
        return listaCliente.remove(cliente);
    }

    //Metodo get que devuelve la lista clientes
    public List<Cliente> getListaCliente() {
        return listaCliente;
    }
    
    //Metodo set de lista clientes
    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    //Metodo get que devuelve el seleccionado
    public Cliente getSeleccionado() {
        return seleccionado;
    }

    //Metodo set de seleccionado
    public void setSeleccionado(Cliente seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    
}
