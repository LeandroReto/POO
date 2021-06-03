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

/**
 *
 * @author jaslyn
 */
public class ControladorFecha {
    private List<Fecha> listaFecha;
    private Fecha Seleccionado;
    
    public ControladorFecha(){
        listaFecha=new ArrayList();
    }
    public long generarId(){
        if(listaFecha.size()>0)      //si su linea de accion es unicamente 1 no hay necesidad de llaves for if do while
            return listaFecha.get(listaFecha.size()-1).getId()+1;
        else
            return 1;
        
    }
    public boolean crear(int dia,int mes,int anio){
        return listaFecha.add(new Fecha(this.generarId(), dia, mes, anio));
        
    }
    public Fecha buscar(int dia,int mes){
        for (Fecha fecha: listaFecha) {
            if(fecha.getDia()==dia && fecha.getMes()==mes){
                Seleccionado = fecha;
                return fecha;
            }
        }
        return null;
    }
    public boolean actualizar(int dia,int mes,int anio){
        Fecha fecha= buscar(dia,mes);
        if(fecha != null){
            int posicion = listaFecha.indexOf(fecha);
            fecha.setDia(dia);
            fecha.setAnio(anio);
            fecha.setMes(mes);
            listaFecha.set(posicion, fecha);
            return true;
        }
        return false;
    }
    public boolean eliminar(int dia,int mes){
        Fecha fecha = buscar(dia, mes);
        return listaFecha.remove(fecha);
    }

    public List<Fecha> getListaFecha() {
        return listaFecha;
    }

    public void setListaFecha(List<Fecha> listaFecha) {
        this.listaFecha = listaFecha;
    }

    public Fecha getSeleccionado() {
        return Seleccionado;
    }

    public void setSeleccionado(Fecha Seleccionado) {
        this.Seleccionado = Seleccionado;
    }
    
}
