/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import modelo.Vehiculo;

/**
 *
 * @author jaslyn
 */
public class ControladorVehiculo {
    private List<Vehiculo> ListaVehiculo;
    private Vehiculo seleccionado;
    
    public ControladorVehiculo(){
        ListaVehiculo= new ArrayList();
    }
    public long generarId(){
        if(ListaVehiculo.size()>0){ //valido que existe datos en la lista 
            return ListaVehiculo.get(ListaVehiculo.size()-1).getId()+1; //obtengo el ultimo elemento de la lista y le sumo uno
        }else{
            return 1; //de no haber datos por defecto empieza en uno
        }
    }
    public boolean crear(String placa, String marca, String modelo){
        Vehiculo vehiculo=new Vehiculo(this.generarId(),placa, marca, modelo);
        return this.ListaVehiculo.add(vehiculo);
    }
    
    public boolean crear(String placa, String marca, String modelo,Cliente propietario){
        Vehiculo vehiculo=new Vehiculo(this.generarId(),placa, marca, modelo,propietario);
        propietario.getListaVehiculo().add(vehiculo);
        return this.ListaVehiculo.add(vehiculo);
    }
    public Vehiculo buscar(String placa){
        for(Vehiculo vehiculo:ListaVehiculo){
            if(vehiculo.getPlaca().equals(placa)){
                return vehiculo;
            }
        }
        return null;
    }
    public boolean actualizar(String placa, String marca, String modelo){
        Vehiculo vehiculo= this.buscar(placa);
        if(vehiculo!=null){
            int posicion=ListaVehiculo.indexOf(vehiculo);
            vehiculo.setMarca(marca);
            vehiculo.setModelo(modelo);
            ListaVehiculo.set(posicion, vehiculo);
            return true;
        }
        return false;
    }
    public boolean eliminar(String placa){
        Vehiculo vehiculo=this.buscar(placa);
        if(vehiculo!=null){
            vehiculo.getPropietario().getListaVehiculo().remove(vehiculo);
            return ListaVehiculo.remove(vehiculo);
        }
        return false;
    }
    public void imprimir(){
        for(Vehiculo vehiculo: ListaVehiculo){ //recoro clientes en la lista de datos
            System.out.println(vehiculo);
        }
    }

    public List<Vehiculo> getListaVehiculo() {
        return ListaVehiculo;
    }

    public void setListaVehiculo(List<Vehiculo> ListaVehiculo) {
        this.ListaVehiculo = ListaVehiculo;
    }

    public Vehiculo getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Vehiculo seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    
}
