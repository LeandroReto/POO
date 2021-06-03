/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorVehiculo;
import controlador.ControladorCliente;
import java.util.Scanner;
import modelo.Cliente;
import modelo.Vehiculo;

/**
 *
 * @author jaslyn
 */
public class VistaVehiculo {
    
    private ControladorCliente clientecontrolador;
    private ControladorVehiculo vehiculoControlador;
    private Scanner teclado;
    
    public VistaVehiculo(ControladorCliente clientecontrolador){
        this.clientecontrolador= new ControladorCliente();
        vehiculoControlador=new ControladorVehiculo();
        teclado=new Scanner(System.in);
    }
    public void menu(){
        int opcion=0;
        do{
            System.out.println("Gestion de vehiculos");
            System.out.println("1.Crear");
            System.out.println("2.Buscar");
            System.out.println("3.Actualizar");
            System.out.println("4.Eliminar");
            System.out.println("5.Listar");
            opcion=teclado.nextInt();
            switch(opcion){
                case 1: this.crear();break;
                case 2: this.buscar();break;
                case 3: this.actualizar();break;
                case 4: this.eliminar();break;
                case 5: this.imprimir();break;
            }
        }while(opcion<6);
    }
    public void crear(){
        System.out.println("Crear - Ingrese los siguientes datos");
        System.out.println("Placa: ");
        String placa=teclado.next();
        System.out.println("Marca: ");
        String marca=teclado.next();
        System.out.println("Modelo: ");
        String modelo=teclado.next();
        boolean  resultado=vehiculoControlador.crear(placa, marca, modelo,clientecontrolador.getSeleccionado());
        System.out.println("Cliente creado: "+resultado);        
    }
    public void actualizar(){
        System.out.println("Actualizar-ingrese los datos");
        System.out.println("Placa: ");
        String placa=teclado.next();
        System.out.println("Marca: ");
        String marca=teclado.next();
        System.out.println("Modelo: ");
        String modelo=teclado.next();
        boolean  resultado=vehiculoControlador.actualizar(placa, marca, modelo);
        System.out.println("Cliente creado: "+resultado);   
    }
    public Vehiculo buscar(){ //el metodo no es booleano
        System.out.println("Ingrese la placa:");
        String placa= teclado.next();
        Vehiculo vehiculo=vehiculoControlador.buscar(placa);
        System.out.println(vehiculo);
        return vehiculo;
    }
    public void eliminar(){
        System.out.println("Ingrese la placa:");
        String placa=teclado.next();
        boolean resultado=vehiculoControlador.eliminar(placa);
        System.out.println("Eliminado="+resultado);
    }
    public void imprimir(){
        for(Vehiculo vehiculo: vehiculoControlador.getListaVehiculo()){
            System.out.println(vehiculo);
        }
    }
    public void asignarSeleccionado(Vehiculo vehiculo){
        vehiculoControlador.setSeleccionado(vehiculo);
    }

    public ControladorCliente getClientecontrolador() {
        return clientecontrolador;
    }

    public void setClientecontrolador(ControladorCliente clientecontrolador) {
        this.clientecontrolador = clientecontrolador;
    }

    public ControladorVehiculo getVehiculoControlador() {
        return vehiculoControlador;
    }

    public void setVehiculoControlador(ControladorVehiculo vehiculoControlador) {
        this.vehiculoControlador = vehiculoControlador;
    }
    
}
