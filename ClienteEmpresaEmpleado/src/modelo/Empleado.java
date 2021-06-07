/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author jaslyn
 */
public class Empleado extends Persona{ //relacion de herencia con  respecto a persona/ hereda atributos solo de forma simple
    private double SueldoButro;

    public Empleado( long id, String cedula, String nombre, String apellido, String direccion) {
        super(id, cedula, nombre, apellido, direccion); //super indica que datos vienen del 
    }
    public Empleado( long id, String cedula, String nombre, String apellido, String direccion,double SueldoBruto) {
        super(id, cedula, nombre, apellido, direccion); //super indica que datos vienen del 
        this.SueldoButro = SueldoButro; //agregamos sueldo bruto a un constructor aparte
    }

    public double getSueldoButro() {
        return SueldoButro;
    }

    public void setSueldoButro(double SueldoButro) {
        this.SueldoButro = SueldoButro;
    }

    @Override
    public String toString() {
        return "Empleado{" + "SueldoButro=" + SueldoButro + super.toString()+'}'; //agrega datos de la persona
    }
    

}
