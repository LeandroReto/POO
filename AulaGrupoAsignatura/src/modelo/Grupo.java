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
public class Grupo {
    private long id;
    private String nombre;
    private Aula aula;
    private List<Asignatura> listaAsignatura;

    public Grupo(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        listaAsignatura=new ArrayList<>();
    }
              
    public Grupo(long id, String nombre, Aula aula) {
        this.id = id;
        this.nombre = nombre;
        this.aula = aula;
    }

    public Grupo(long id, String nombre,Aula aula, List<Asignatura> listaAsignatura) {
        this.id = id;
        this.nombre = nombre;
        this.aula = aula;
        this.listaAsignatura = new ArrayList<>();
    }
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

   

    public List<Asignatura> getListaAsignatura() {
        return listaAsignatura;
    }

    public void setListaAsignatura(List<Asignatura> listaAsignatura) {
        this.listaAsignatura = listaAsignatura;
    }
    

    @Override
    public String toString() {
        return "Grupo{" + "id=" + id + ", nombre=" + nombre +", Aula=" +aula+'}';
    }
    
}
