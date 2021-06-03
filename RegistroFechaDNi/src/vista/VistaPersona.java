/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorFecha;
import controlador.ControladorPersona;
import controlador.ControladorDNI;
import java.util.Scanner;
import modelo.Persona;

/**
 *
 * @author jaslyn
 */
public class VistaPersona {
    public Scanner teclado;
    private ControladorPersona  controladorPersona;
    private ControladorFecha controladorFecha;
    private ControladorDNI controladorDNI;
    public VistaPersona(ControladorPersona controladorPersona, ControladorFecha controladorFecha,  ControladorDNI controladorDNI){
        teclado = new Scanner(System.in);
        this.controladorPersona = controladorPersona;
        this.controladorFecha = controladorFecha;
        this.controladorDNI = controladorDNI;
    }
    public void menu(){
        int opcion = 0;
        do {            
            System.out.println(" 1. Crear \n 2. Actualizar \n 3. Buscar \n 4. Eliminar \n 5. Listar \n 6. Salir");
            opcion = teclado.nextInt();
            switch(opcion){
                case 1: this.crear(); break;
                case 2: this.actualizar(); break;
                case 3: this.buscar(); break;
                case 4: this.eliminar(); break;
                case 5: this.listar(); break;
            }
        } while (opcion < 6);
    }
    public void crear(){
        System.out.println("Ingrese: \n nombre completo");
        teclado.nextLine();
        String nombreCompleto = teclado.nextLine();
        System.out.println("Res:" + controladorPersona.crear(nombreCompleto, controladorFecha.getSeleccionado(), controladorDNI.getSeleccionado()));
    }
    public void actualizar(){
        System.out.println("Ingrese: \n nombre completo");
        teclado.nextLine();
        String nombreCompleto = teclado.nextLine();
        System.out.println("Res:" + controladorPersona.actualizar(nombreCompleto, controladorFecha.getSeleccionado(), controladorDNI.getSeleccionado()));
    }
    public Persona buscar(){
        System.out.println("Ingrese: \n nombre completo");
        teclado.nextLine();
        String nombreCompleto = teclado.nextLine();
        System.out.println(controladorPersona.buscar(nombreCompleto));
        return controladorPersona.buscar(nombreCompleto);
    }
    public void eliminar(){
        this.buscar();
        System.out.println("Res: "+ controladorPersona.eliminar(controladorPersona.getSeleccionado().getnombreCompleto()));
    }
    public void listar(){
        for (Persona persona : controladorPersona.getListaPersona()) {
            System.out.println(persona);
        }
    }
}
