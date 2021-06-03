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
public class Aula {
    private long id;
    private String descripcion;
    private List<Grupo> listaGrupo;
    
    public Aula(){
        id=0;
        descripcion="";
        listaGrupo = new ArrayList<>();
    }
    public Aula(long id, String descripcion) {
        this.id =id;
        this.descripcion=descripcion;
        this.listaGrupo = new ArrayList<>();

    }

    public Aula(long id, String descripcion, List<Grupo> listaGrupo) {
        this.id = id;
        this.descripcion= descripcion;
        this.listaGrupo = listaGrupo;
    }
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Grupo> getListaGrupo() {
        return listaGrupo;
    }

    public void setListaGrupo(List<Grupo> listaGrupo) {
        this.listaGrupo = listaGrupo;
    }
    

    @Override
    public String toString() {
        return "Aula{" + "id=" + id + ", descripcion=" + descripcion + '}';
    }
    
}
