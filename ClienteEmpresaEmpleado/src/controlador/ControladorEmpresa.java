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
    private Empresa seleccionado;
    public ControladorEmpresa(){
        listaEmpresa=new ArrayList();
        seleccionado=null;
    }
    public long generarId(){
        //operadores terniarios
        //poder if else en una sola linea
        return(listaEmpresa.size()>0)? listaEmpresa.get(listaEmpresa.size()-1).getId()+1 : 1;
    }
    public boolean crear(String nombre){
        return listaEmpresa.add(new Empresa(generarId(),nombre));
    }
    public Empresa buscar(String nombre){
        for (Empresa empresa : listaEmpresa) {
            if(empresa.getNombre().equals(nombre))
                return empresa;
        }
        return null;
        //buscar en una linea  ///adelanto de proximo ciclo
        //listaEmpresa.stream().filter(empresa->empresa.getNombre().equals(nombre)).findFirst();
        //no vale por el return
    }
    
    public boolean actualizar(String nombreanterior, String nombre){
        Empresa empresa=buscar(nombreanterior);
        if(empresa!=null){
            int posicion=listaEmpresa.indexOf(empresa);
            empresa.setNombre(nombre);
            listaEmpresa.set(posicion, empresa);
            System.out.println(empresa);
            return true;
            
        }
        return false;
    }
    public boolean eliminar(String nombre){
        return listaEmpresa.remove(buscar(nombre)); //buscar y remove unidos
    }

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

