/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Cliente;
import modelo.FacturaCabecera;
import modelo.FacturaDetalle;

public class ControladorFacturaCabecera {
    //Lista de tipo FacturaCabecera
    private List<FacturaCabecera> listaFacturaCabecera;
    //Variable FacturaCabecera que guarda la seleccion de busqueda
    private FacturaCabecera seleccionado;

     //Constructor que inicializa la lista de FacturaCabecera
    public ControladorFacturaCabecera() {
        listaFacturaCabecera = new ArrayList();
    }
    
    //Metodo generar ID que devuelve un valor de forma incremental 
    public long generarId(){
        if(listaFacturaCabecera.size()>0)      //si su linea de accion es unicamente 1 no hay necesidad de llaves for if do while
            return listaFacturaCabecera.get(listaFacturaCabecera.size()-1).getId()+1;
        else
            return 1;
    }
    
    //Metodo crear que ingresa un objeto FacturaCabecera con los parametros de los atributos y devuelve un booleano si se ingresa o no
    public boolean crear(Cliente cliente, List<FacturaDetalle> detalles, double total, Date fechaFactura){
        return listaFacturaCabecera.add(new FacturaCabecera(this.generarId(),cliente, detalles, total, fechaFactura));
    }
    
    //Metodo buscar que encuentra un objeto FacturaCabecera en la lista, recibiendo como parametro su id en caso de no existir se devuelve un null
    public FacturaCabecera buscar(long id){
        for (FacturaCabecera facturaCabecera: listaFacturaCabecera) {
            if(facturaCabecera.getId()==id){
                seleccionado = facturaCabecera;
                return facturaCabecera;
            }
        }
        return null;
    }
    
    //Metodo actualizar para dar valores a un objeto Cliente y reemplazarlo por otro, este metodo utiliza otro de buscar,donde le devuelve el objeto a reemplazar
    public boolean actualizar(long id, Cliente cliente, List<FacturaDetalle> detalles, double total, Date fechaFactura){
        FacturaCabecera facturaCabecera= buscar(id);
        if(facturaCabecera != null){
            int posicion = listaFacturaCabecera.indexOf(facturaCabecera);
            facturaCabecera.setCliente(cliente);
            facturaCabecera.setDetalles(detalles);
            facturaCabecera.setFechaFactura(fechaFactura);
            facturaCabecera.setTotal(total);
            listaFacturaCabecera.set(posicion, facturaCabecera);
            return true;
        }
        return false;
    }
    //Metodo eliminar para remover un objeto de la lista FacturaCabeceras, que emplea el metodo buscar para encontra el objeto a eliminar
    public boolean eliminar(long id){
        FacturaCabecera facturaCabecera = buscar(id);
        return listaFacturaCabecera.remove(facturaCabecera);
    }

    //Metodo get que devuelve la lista FacturaCabecera
    public List<FacturaCabecera> getListaFacturaCabecera() {
        return listaFacturaCabecera;
    }

    //Metodo set de lista FacturaCabecera
    public void setListaFacturaCabecera(List<FacturaCabecera> listaFacturaCabecera) {
        this.listaFacturaCabecera = listaFacturaCabecera;
    }

    //Metodo get que devuelve el seleccionado
    public FacturaCabecera getSeleccionado() {
        return seleccionado;
    }

    //Metodo set de lista seleccionado
    public void setSeleccionado(FacturaCabecera seleccionado) {
        this.seleccionado = seleccionado;
    }

    
}
