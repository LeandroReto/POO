/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.DNI;
import modelo.Fecha;
import modelo.Persona;

/**
 *
 * @author jaslyn
 */
public class ControladorPersona {
    private List<Persona> listaPersona;
    private Persona Seleccionado;
    
    public ControladorPersona(){
        listaPersona=new ArrayList();
    }
    public long generarId(){
        if(listaPersona.size()>0)      //si su linea de accion es unicamente 1 no hay necesidad de llaves for if do while
            return listaPersona.get(listaPersona.size()-1).getId()+1;
        else
            return 1;
        
    }
    public boolean crear(String nombreCompleto,Fecha persona,DNI dni){
        return listaPersona.add(new Persona(this.generarId(), nombreCompleto, persona, dni));
        
    }
    public Persona buscar(String nombreCompleto){
        for (Persona persona: listaPersona) {
            if(persona.getnombreCompleto().equals(nombreCompleto)){
                Seleccionado = persona;
                return persona;
            }
        }
        return null;
    }
    public boolean actualizar(String nombreCompleto,Fecha fecha,DNI dni){
        Persona persona= buscar(nombreCompleto);
        if(persona != null){
            int posicion = listaPersona.indexOf(persona);
            persona.setDni(dni);
            persona.setFecha(fecha);
            persona.setnombreCompleto(nombreCompleto);
            listaPersona.set(posicion, persona);
            return true;
        }
        return false;
    }
    public boolean eliminar(String nombreCompleto){
        Persona persona = buscar(nombreCompleto);
        return listaPersona.remove(persona);
    }

    public List<Persona> getListaPersona() {
        return listaPersona;
    }

    public void setListaPersona(List<Persona> listaPersona) {
        this.listaPersona = listaPersona;
    }

    public Persona getSeleccionado() {
        return Seleccionado;
    }

    public void setSeleccionado(Persona Seleccionado) {
        this.Seleccionado = Seleccionado;
    }
    
}
