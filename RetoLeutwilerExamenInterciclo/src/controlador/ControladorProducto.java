/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Producto;

public class ControladorProducto {
    private List<Producto> listaProducto;
    private Producto seleccionado;
    
    public ControladorProducto() {
        listaProducto = new ArrayList();
    }
    
    public long generarId(){
        if(listaProducto.size()>0)      //si su linea de accion es unicamente 1 no hay necesidad de llaves for if do while
            return listaProducto.get(listaProducto.size()-1).getId()+1;
        else
            return 1;
    }
    
    public boolean crear(String descripcion, double precioUnitario, long stock, boolean iva){
        return listaProducto.add(new Producto(this.generarId(), descripcion, precioUnitario, stock, iva));
    }
    
    public Producto buscar(long id){
        for (Producto producto: listaProducto) {
            if(producto.getId()==id){
                seleccionado = producto;
                return producto;
            }
        }
        return null;
    }
    
    public boolean actualizar(long id,String descripcion, double precioUnitario, long stock, boolean iva){
        Producto producto= buscar(id);
        if(producto != null){
            int posicion = listaProducto.indexOf(producto);
            producto.setDescripcion(descripcion);
            producto.setStock(stock);
            producto.setPrecioUnitario(precioUnitario);
            producto.setIva(iva);
            listaProducto.set(posicion, producto);
            return true;
        }
        return false;
    }
    
    public boolean eliminar(long id){
        Producto producto = buscar(id);
        return listaProducto.remove(producto);
    }

    public List<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public Producto getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Producto seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    
}
