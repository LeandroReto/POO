/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Directivo;

/**
 *
 * @author jaslyn
 */
public class ControladorPersona { //solo cuando hay herencia
    
    private List<Directivo> listaDirectivo;
    private Directivo seleccionado;
    public ControladorPersona(){
        //this se utiliza 
        this.listaDirectivo=new ArrayList(); //this de esta clase
        this.seleccionado=null;
    }
    public long generarId(){
        if(listaDirectivo.size()>0)
            return listaDirectivo.get(listaDirectivo.size()-1).getId()+1;
        return 1;
    }
    public boolean crear( String cedula, String nombre, String apellido, String direccion, double SueldoBruto,String categoria){
        Directivo directivo=new Directivo(this.generarId(), cedula, nombre, apellido, direccion, SueldoBruto,categoria);
        return listaDirectivo.add(directivo);
    }
    public Directivo buscar(String cedula){
        for (Directivo directivo : listaDirectivo) {
            if(directivo.getCedula().equals(cedula))
                return directivo;
        }
        return null;
    }
    public boolean actualizar( String cedula, String nombre, String apellido, String direccion, double SueldoBruto,String categoria){
        Directivo directivo=buscar(cedula);
        if(directivo!=null){
            int posicion=listaDirectivo.indexOf(directivo);
            directivo.setApellido(apellido);
            directivo.setNombre(nombre);
            directivo.setSueldoButro(SueldoBruto);
            directivo.setCategoria(categoria);
            directivo.setDireccion(direccion);
            listaDirectivo.set(posicion, directivo);
            return true;
        }
        return false;
    }
    public boolean eliminar(String cedula){
        Directivo directivo=buscar(cedula);
        return listaDirectivo.remove(directivo);
    }

    public List<Directivo> getListaDirectivo() {
        return listaDirectivo;
    }

    public void setListaDirectivo(List<Directivo> listaDirectivo) {
        this.listaDirectivo = listaDirectivo;
    }

    public Directivo getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Directivo seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    
}
