/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorFecha;
import java.util.Scanner;
import modelo.Fecha;

/**
 *
 * @author jaslyn
 */
public class VistaFecha {
    private ControladorFecha controladorFecha;
    public Scanner teclado;
    public VistaFecha(ControladorFecha controladorFecha){
        controladorFecha=new ControladorFecha();
        teclado=new Scanner(System.in);
    }
    public void menu(){
        int opcion=0;
        do{
            System.out.println(" 1.crear \n 2.Actualizar \n 3.Buscar \n 4.eliminar \n 5.listar \n 6.salir");
            opcion=teclado.nextInt();
            switch(opcion){
                case 1: this.crear();break;
                case 2:this.Actualizar();break;
                case 3:this.buscar();break;
                case 4:this.eliminar();break;
                case 5:this.listar();break;
            }
        }while(opcion<6);
    }
    public void crear(){
        System.out.println("Ingrese \n dia");
        int dia=teclado.nextInt();
        System.out.println("mes en numero");
        int mes=teclado.nextInt();
        System.out.println("anio en numero");
        int anio=teclado.nextInt();
        System.out.println("creado "+ controladorFecha.crear(dia, mes, anio));
    }
    public void Actualizar(){
        System.out.println("Ingrese \n dia");
        int dia=teclado.nextInt();
        System.out.println("mes en numero");
        int mes=teclado.nextInt();
        System.out.println("anio en numero");
        int anio=teclado.nextInt();
        System.out.println("creado "+ controladorFecha.actualizar(dia, mes, anio));
    }
    public Fecha buscar(){
        System.out.println("Ingrese \n dia");
        int dia=teclado.nextInt();
        System.out.println(" mes en numero");
        int mes=teclado.nextInt();
        System.out.println("encontrado "+controladorFecha.buscar(dia, mes));
        return controladorFecha.buscar(dia, mes);
    }
    public void eliminar(){
        this.buscar();
        System.out.println(controladorFecha.eliminar(controladorFecha.getSeleccionado().getDia(),controladorFecha.getSeleccionado().getMes()));
    }
    public void listar(){
        for (Fecha fecha : controladorFecha.getListaFecha()) {
            System.out.println(fecha);
        }
        
    }
    
}
