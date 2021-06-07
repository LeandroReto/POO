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
public class Cliente extends Persona{
    private String telefono;

    public Cliente(long id, String cedula, String nombre, String apellido, String direccion) {
        super(id, cedula, nombre, apellido, direccion);
    }

    public Cliente( long id, String cedula, String nombre, String apellido, String direccion,String telefono) {
        super(id, cedula, nombre, apellido, direccion);
        this.telefono = telefono; // de esta clase el telefono sino seria de cliente
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" + "telefono=" + telefono + super.toString()+'}'; //llamo a los datos de persona
    }
    
}
