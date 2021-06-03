/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.DNI;
import modelo.Fecha;
import modelo.Persona;
import modelo.Registro;

/**
 *
 * @author Christian
 * 
 */
public class ControladorRegistro {
    private List<Registro> listaRegistro;
    private Registro seleccionado;
    
    public ControladorRegistro(){
        listaRegistro = new ArrayList<>();
    }
     public long generarId(){
        return (listaRegistro.size() >0)? listaRegistro.get(listaRegistro.size() - 1).getId() + 1 : 1;
    }
    public boolean crear(String codigo, Date fechaRegistro, Persona persona){
        return listaRegistro.add(new Registro(generarId(), codigo, fechaRegistro, persona));
    }
    public Registro buscar(String codigo){
        for (Registro registro : listaRegistro) {
            if(registro.getCodigo().equals(codigo)){
                seleccionado = registro;
                return registro;
            }
        }
        return null;
    }
    public boolean actualizar(String codigo, Date fechaRegistro, Persona persona){
        Registro registro = buscar(codigo);
        if(registro != null){
            int posicion = listaRegistro.indexOf(registro);
            registro.setFechaRegistro(fechaRegistro);
            registro.setPersona(persona);
            listaRegistro.set(posicion, registro);
            return true;
        }
        return false;
    }
    public boolean eliminar(String codigo){
        Registro registro = buscar(codigo);
        return listaRegistro.remove(registro);
    }

    public List<Registro> getListaRegistro() {
        return listaRegistro;
    }

    public void setListaRegistro(List<Registro> listaRegistro) {
        this.listaRegistro = listaRegistro;
    }

    public Registro getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Registro seleccionado) {
        this.seleccionado = seleccionado;
    }
    
}
