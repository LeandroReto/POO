/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorFecha;
import controlador.ControladorPersona;
import controlador.ControladorRegistro;
import controlador.ControladorDNI;
import java.util.Scanner;
import modelo.DNI;
import modelo.Fecha;
import modelo.Persona;

/**
 *
 * @author jaslyn
 */
public class VistaGeneral {
    private Scanner teclado; 
    private VistaFecha vistaFecha;
    private ControladorFecha controladorFecha;
    private VistaPersona vistaPersona;
    private ControladorPersona  controladorPersona;
    private VistaRegistro vistaRegistro;
    private ControladorRegistro controladorRegistro;
    private VistaDNI vistaDNI;
    private ControladorDNI controladorDNI;
    public VistaGeneral(){
        teclado=new Scanner(System.in);
        controladorFecha = new ControladorFecha();
        controladorDNI = new ControladorDNI();
        controladorPersona = new ControladorPersona();
        controladorRegistro = new ControladorRegistro();
        vistaFecha = new VistaFecha(controladorFecha);
        vistaFecha = new VistaFecha(controladorFecha);
        vistaDNI = new VistaDNI(controladorDNI);
        vistaPersona = new VistaPersona(controladorPersona, controladorFecha, controladorDNI);
        vistaRegistro = new VistaRegistro(controladorRegistro, controladorPersona);
        
    }
    public void menu() {
        int opcion = 0;
        do {
            System.out.println("Gestión de Registros");
            System.out.println(" 1. Fecha \n 2. DNI \n 3. Persona \n 4. Registro \n 5. Salir");
            opcion = teclado.nextInt();
            switch(opcion){
                case 1: vistaFecha.menu(); break;
                case 2: vistaDNI.menu(); break;
                case 3: this.persona();break;
                case 4: this.registro();break;
            }
        } while (opcion < 5);
    }
    public void persona(){
        Fecha  fecha = vistaFecha.buscar();
        DNI dni = vistaDNI.buscar();
        if(fecha != null && dni != null){
            vistaPersona.menu();
        }
    }
    public void registro(){
        Persona persona = vistaPersona.buscar();
        if(persona != null){
            vistaRegistro.menu();
        }
    }

    
}
