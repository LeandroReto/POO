/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Empresa;

/**
 *
 * @author jaslyn
 */
public class ControladorEmpresa {
    private List<Empresa> listaEmpresa;
    private Empresa seleccionado; //  guarda los datos de empresa seleccionado
    public ControladorEmpresa(){
        listaEmpresa=new ArrayList();
    }
    //metodos
    public boolean crear(long id, String nombre){ //no poner listas
        Empresa empresa=new Empresa(id, nombre);
        return listaEmpresa.add(empresa);
    }
    public Empresa buscar(String nombre){
        for(Empresa empresa:listaEmpresa){
            if(empresa.getNombre().equals(nombre)==true){
                return empresa;
            }
        }
        return null;
    }
    public boolean actualizar(String nombreAnterior, String nombreNuevo){
        Empresa empresa=this.buscar(nombreAnterior);
        if(empresa!=null){
            int posic=listaEmpresa.indexOf(empresa);
            empresa.setNombre(nombreNuevo);;
            listaEmpresa.set(posic, empresa);
            return true;
        }
        return false;
    }
    public boolean eliminar(String nombre){
        Empresa empresa=this.buscar(nombre);
        if(empresa!=null){
            return listaEmpresa.remove(empresa);
        }
        return false;
    }
    //en controladores encapsular

    public List<Empresa> getListaEmpresa() {
        return listaEmpresa;
    }

    public void setListaEmpresa(List<Empresa> listaEmpresa) {
        this.listaEmpresa = listaEmpresa;
    }

    public Empresa getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Empresa seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    
}
