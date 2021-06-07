/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.FacturaDetalle;
import modelo.Producto;

public class ControladorFacturaDetalle {
    //Lista de tipo FacturaDetalle
    private List<FacturaDetalle> listaFacturaDetalle;
    //Variable FacturaDetalle que guarda la seleccion de busqueda
    private FacturaDetalle seleccionado;
    
    //Constructor que inicializa la lista de FacturaCabecera
    public ControladorFacturaDetalle() {
        listaFacturaDetalle = new ArrayList();
    }
    
    //Metodo generar ID que devuelve un valor de forma incremental 
    public long generarId(){
        if(listaFacturaDetalle.size()>0)      //si su linea de accion es unicamente 1 no hay necesidad de llaves for if do while
            return listaFacturaDetalle.get(listaFacturaDetalle.size()-1).getId()+1;
        else
            return 1;
    }
    //Metodo crear que ingresa un objeto Producto con los parametros de los atributos y devuelve un booleano si se ingresa o no
    public boolean crear(Producto producto, long cantidad, double valor){
        return listaFacturaDetalle.add(new FacturaDetalle(this.generarId(), producto, cantidad, valor));
    }
    
    //Metodo buscar que encuentra un objeto FacturaCabecera en la lista, recibiendo como parametro su id en caso de no existir se devuelve un null
    public FacturaDetalle buscar(long id){
        for (FacturaDetalle facturaDetalle: listaFacturaDetalle) {
            if(facturaDetalle.getId()==id){
                seleccionado = facturaDetalle;
                return facturaDetalle;
            }
        }
        return null;
    }
    
    //Metodo actualizar para dar valores a un objeto FacturaDetalle y reemplazarlo por otro, este metodo utiliza otro de buscar,donde le devuelve el objeto a reemplazar
    public boolean actualizar(long id, Producto producto, long cantidad, double valor){
        FacturaDetalle facturaDetalle= buscar(id);
        if(facturaDetalle != null){
            int posicion = listaFacturaDetalle.indexOf(facturaDetalle);
            facturaDetalle.setProducto(producto);
            facturaDetalle.setValor(valor);
            facturaDetalle.setCantidad(cantidad);
            listaFacturaDetalle.set(posicion, facturaDetalle);
            return true;
        }
        return false;
    }
    
    //Metodo eliminar para remover un objeto de la lista FacturaDetalle, que emplea el metodo buscar para encontra el objeto a eliminar
    public boolean eliminar(long id){
        FacturaDetalle facturaDetalle = buscar(id);
        return listaFacturaDetalle.remove(facturaDetalle);
    }

    //Metodo get que devuelve la lista FacturaDetalle
    public List<FacturaDetalle> getListaFacturaDetalle() {
        return listaFacturaDetalle;
    }
    
    //Metodo set de FacturaDetalle
    public void setListaFacturaDetalle(List<FacturaDetalle> listaFacturaDetalle) {
        this.listaFacturaDetalle = listaFacturaDetalle;
    }

    //Metodo get que devuelve el seleccionado
    public FacturaDetalle getSeleccionado() {
        return seleccionado;
    }

    //Metodo set de lista seleccionado
    public void setSeleccionado(FacturaDetalle seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    
}
