/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorCliente;
import java.util.Scanner;
import modelo.Cliente;

/**
 *
 * @author jaslyn
 */
public class VistaCliente {
    private ControladorCliente controladorCliente;
    private Scanner teclado;
    public VistaCliente(){
        controladorCliente=new ControladorCliente();
        teclado= new Scanner(System.in);
        
    }
    public void menu(){
        int opcion=0;
        do{
            System.out.println("1.Crear");
            System.out.println("2.Actualizar");
            System.out.println("3.Buscar");
            System.out.println("4.Eliminar");
            System.out.println("5.Listar");
            System.out.println("6.Salir");
            opcion=teclado.nextInt();
            switch(opcion){
                case 1:this.crear();break;
                case 2:this.actualizar();break;
                case 3:this.buscar();break;
                case 4:this.eliminar();break;
                case 5:this.listar();break;
            }
        }while(opcion<6);
    }
    public void crear(){
        System.out.println("ingrese el nombre");
        String nombre=teclado.next();
        System.out.println("ingrese el apellido");
        String apellido=teclado.next();
        System.out.println("ingrese la cedula");
        String cedula=teclado.next();
        System.out.println("ingrese la direccion");
        String direccion=teclado.next();
        System.out.println("ingrese el telefono");
        String telefono=teclado.next();
        System.out.println("Resultado "+controladorCliente.crear(cedula, nombre, apellido, direccion, telefono));
    }
    public Cliente buscar(){
        System.out.println("Ingrese la cedula");
        String cedula=teclado.next();
        Cliente cliente=controladorCliente.buscar(cedula);
        controladorCliente.setSeleccionado(cliente);
        System.out.println(cliente);
        return cliente;
    }
    public void actualizar(){
        Cliente cliente=buscar();
        if (cliente!=null){
            System.out.println("ingrese el nombre");
            String nombre=teclado.next();
            System.out.println("ingrese el apellido");
            String apellido=teclado.next();
            System.out.println("ingrese la direccion");
            String direccion=teclado.next();
            System.out.println("ingrese el telefono");
            String telefono=teclado.next();
            System.out.println("Actualizado "+controladorCliente.actualizar(cliente.getCedula(), nombre, apellido, direccion, telefono));
        }
    }
    public void eliminar(){
        Cliente cliente=buscar();
        if(cliente!=null)
            System.out.println("Resultado: "+controladorCliente.eliminar(cliente.getCedula()));
    }
    public void listar(){
        for (Cliente cliente : controladorCliente.getListaCliente()) {
            System.out.println(cliente);
        }
    }

    public ControladorCliente getControladorCliente() {
        return controladorCliente;
    }

    public void setControladorCliente(ControladorCliente controladorCliente) {
        this.controladorCliente = controladorCliente;
    }
    
}
