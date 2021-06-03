/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.ArrayList;
import java.util.List;
import modelo.Asignatura;
import modelo.Grupo;

/**
 *
 * @author jaslyn
 */
public class ControladorAsignatura {
    private List<Asignatura> listaAsignatura;
    private Asignatura seleccionado;
    public ControladorAsignatura(){
        listaAsignatura= new ArrayList();
    }
    public boolean crear(long id, String nombre){
        Asignatura asignatura= new Asignatura(id, nombre);
        return listaAsignatura.add(asignatura);
    }
    public boolean crear(long id, String nombre, Grupo grupo){
        Asignatura asignatura= new Asignatura(id, nombre,grupo);
        return listaAsignatura.add(asignatura);
    }
    public Asignatura buscar(String nombre){
        for (Asignatura asignatura : listaAsignatura) {
            if(asignatura.getNombre().equals(nombre)==true)
                return asignatura;
        }
        return null;
    }
    public boolean actualizar(String nombreAnterior, String nombreNuevo){
        Asignatura asignatura=this.buscar(nombreAnterior);
        if(asignatura!=null){
            int posic=listaAsignatura.indexOf(asignatura);
            asignatura.setNombre(nombreNuevo);
            listaAsignatura.set(posic, asignatura);
            return true;
        }
        return false;
    }
    public boolean eliminar(String nombre){
        Asignatura asignatura=this.buscar(nombre);
        if (asignatura!=null) {
            asignatura.getGrupo().getListaAsignatura().remove(asignatura);
            return listaAsignatura.remove(asignatura);
        }
        return false;
    }
    public void imprimir(){
        for (Asignatura asignatura : listaAsignatura) {
            System.out.println(asignatura);
        }
    }

    public List<Asignatura> getListaAsignatura() {
        return listaAsignatura;
    }

    public void setListaAsignatura(List<Asignatura> listaAsignatura) {
        this.listaAsignatura = listaAsignatura;
    }

    public Asignatura getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Asignatura seleccionado) {
        this.seleccionado = seleccionado;
    }
    
}
