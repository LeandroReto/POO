/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Empleado;

/**
 *
 * @author jaslyn
 */
public class ControladorEmpleado {
    private List<Empleado> listaEmpleado;
    private Empleado seleccionado;
    public ControladorEmpleado(){
        listaEmpleado=new ArrayList();
        seleccionado=null;
    }
    public boolean crear(long id, String cedula, String nombre, String apellido, String direccion,double SueldoBruto){
        Empleado e=new Empleado(id,cedula,nombre,apellido,direccion,SueldoBruto);
        return listaEmpleado.add(e);
    }
    public Empleado buscar(String cedula){
        for (Empleado empleado : listaEmpleado) {
            if(empleado.getCedula().equals(cedula))
                return empleado;
        }
        return null;
    }
    public boolean actualizar( String cedula, String nombre, String apellido, String direccion,double SueldoBruto){
        Empleado empleado=this.buscar(cedula);
        if(empleado!=null){
            int posicion=listaEmpleado.indexOf(empleado);
            empleado.setApellido(apellido);
            empleado.setCedula(cedula);
            empleado.setNombre(nombre);
            empleado.setSueldoButro(SueldoBruto);
            listaEmpleado.set(posicion, empleado);
            return true;
        }
        return false;
    }
    public boolean eliminar(String cedula){
        Empleado empleado=this.buscar(cedula);
        if(empleado!=null){
            return listaEmpleado.remove(empleado);
        }
        return false;
    }

    public List<Empleado> getListaEmpleado() {
        return listaEmpleado;
    }

    public void setListaEmpleado(List<Empleado> listaEmpleado) {
        this.listaEmpleado = listaEmpleado;
    }

    public Empleado getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Empleado seleccionado) {
        this.seleccionado = seleccionado;
    }
    
}
