/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;


import controlador.ControladorPersona;
import controlador.ControladorRegistro;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Registro;
/**
 *
 * @author jaslyn
 */
public class VistaRegistro {
    public Scanner teclado;
    private ControladorRegistro controladorRegistro;
    private ControladorPersona controladorPersona;
    public DateFormat formatoFecha;
    
    public VistaRegistro(ControladorRegistro controladorRegistro, ControladorPersona controladorPersona){
        teclado = new Scanner(System.in);
        this.controladorRegistro = controladorRegistro;
        this.controladorPersona = controladorPersona; 
        formatoFecha = new SimpleDateFormat("dd/mm/yyyy");
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
        System.out.println("Ingrese: \n codigo");        
        String codigo = teclado.next();
        System.out.println("Fecha (dd/mm/yyyy):");
        String fecha = teclado.next();        
        try {
            System.out.println("Res:" + controladorRegistro.crear(codigo, formatoFecha.parse(fecha), controladorPersona.getSeleccionado()));
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void actualizar(){
        System.out.println("Ingrese: \n codigo");        
        String codigo = teclado.next();
        System.out.println("Fecha (dd/mm/yyyy):");
        String fecha = teclado.next();        
        try {
            System.out.println("Res:" + controladorRegistro.actualizar(codigo, formatoFecha.parse(fecha), controladorPersona.getSeleccionado()));
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void buscar(){
        System.out.println("Ingrese: \n codigo");
        String codigo = teclado.next();
        System.out.println(controladorRegistro.buscar(codigo));
    }
    public void eliminar(){
        this.buscar();
        System.out.println("Res: "+ controladorRegistro.eliminar(controladorRegistro.getSeleccionado().getCodigo()));
    }
    public void listar(){
        for (Registro registro : controladorRegistro.getListaRegistro()) {
            System.out.println(registro);
        }
    }
}
