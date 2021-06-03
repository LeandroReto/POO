/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorServicio;
import controlador.ControladorVehiculo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import modelo.Servicio;
import modelo.Vehiculo;

/**
 *
 * @author jaslyn
 */
public class VistaServicio {
    private ControladorServicio servicioControlador;
    private ControladorVehiculo vehiculoControlador;
    private Scanner teclado;
    private SimpleDateFormat formatofecha;
    public static String formato="";
    public VistaServicio(ControladorVehiculo vehiculoControlador){
        this.vehiculoControlador=vehiculoControlador;
        servicioControlador= new ControladorServicio();
        teclado=new Scanner(System.in);
        formatofecha=new SimpleDateFormat();
    }
    public void menu(){
        int opcion=0;
        do{
            System.out.println("Gestion de servicios");
            System.out.println("1.Crear");
            System.out.println("2.Actualizar");
            System.out.println("3.Buscar");
            System.out.println("4.Eliminar");
            System.out.println("5.Imprimir");
            System.out.println("6.Salir");
            opcion= teclado.nextInt();
            switch(opcion){
                case 1: 
                    this.crear(); break;
                case 2: 
                    this.actualizar();break;
                case 3: 
                    this.buscar();break;
                case 4: 
                    this.eliminar();break;
                case 5:
                    System.out.println("Lista de clientes");
                    this.listar();break;
            }
        }while(opcion<6);
    }
    //Java simple date format ayuda a convertir un valor de fecha en base a un String
    public void crear(){
        System.out.println("Ingrese la hora de entrada:  "+formato);
        try {
            Date horaEntrada=formatofecha.parse(teclado.nextLine());
            boolean resultado=servicioControlador.crear(horaEntrada, null, 0, vehiculoControlador.getSeleccionado());
            System.out.println("Creado "+resultado);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
            this.menu();
        }
    }
    public Servicio buscar(){
        System.out.println("Ingrese la hora de entrada:  "+formato);
        try {
            Date horaEntrada=formatofecha.parse(teclado.nextLine());
            Servicio servicio=servicioControlador.buscar(horaEntrada);
            System.out.println(servicio);
            return servicio;
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
            this.menu();
        }
        return null;
    }
    public void actualizar(){
        Servicio servicio=this.buscar();
        System.out.println("Ingrese la hora de salida:  "+formato);
        try {
            Date horaSalida=formatofecha.parse(teclado.nextLine());
            boolean resultado=servicioControlador.actualizar(servicio.getHoraEntrada(), horaSalida);
            System.out.println("Resultado: "+resultado);
            System.out.println("Valor a pagar "+servicio.getValorPagar());
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
            this.menu();
        }
    }
    public void eliminar(){
        Servicio servicio=this.buscar();
        if(servicio!=null){
            boolean resultado=servicioControlador.eliminar(servicio.getHoraEntrada());
            System.out.println("Eliminado: "+resultado);
        }
    }
    public void listar(){
        for (Servicio dato : servicioControlador.getDatos()) {
            System.out.println(dato);
        }
    }
    
}

