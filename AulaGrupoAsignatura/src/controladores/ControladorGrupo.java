/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.ArrayList;
import java.util.List;
import modelo.Aula;
import modelo.Grupo;

/**
 *
 * @author jaslyn
 */
public class ControladorGrupo {
    private List<Grupo> listaGrupo;
    private Grupo seleccionado;
    public ControladorGrupo(){
        listaGrupo=new ArrayList();
        
    }
    public boolean crear(long id, String nombre){ //no poner listas
        Grupo grupo=new Grupo(id, nombre);
        return listaGrupo.add(grupo);
    }
     public boolean crear(long id, String nombre,Aula aula){ //no poner listas
        Grupo grupo=new Grupo(id, nombre,aula);
        return this.listaGrupo.add(grupo);
    }
    public Grupo buscar(String nombre){
        for(Grupo grupo:listaGrupo){
            if(grupo.getNombre().equals(nombre)==true){
                seleccionado=grupo;
                return grupo;
            }
        }
        return null;
    }
    public boolean actualizar(String nombreAnterior, String nombreNuevo){
        Grupo grupo=this.buscar(nombreAnterior);
        if(grupo!=null){
            int posic=listaGrupo.indexOf(grupo);
            grupo.setNombre(nombreNuevo);
            listaGrupo.set(posic, grupo);
            return true;
        }
        return false;
    }
    public boolean eliminar(String nombre){
        Grupo grupo=this.buscar(nombre);
        if(grupo!=null){
            grupo.getAula().getListaGrupo().remove(grupo);
            return listaGrupo.remove(grupo);
        }
        return false;
    }
    public void imprimir(){
        for (Grupo grupo : listaGrupo) {
            System.out.println(grupo);
        }
    }

    public List<Grupo> getListaGrupo() {
        return listaGrupo;
    }

    public void setListaGrupo(List<Grupo> listaGrupo) {
        this.listaGrupo = listaGrupo;
    }

    public Grupo getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Grupo seleccionado) {
        this.seleccionado = seleccionado;
    }
    
}
