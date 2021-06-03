/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorPersona;
import java.util.Scanner;
import modelo.Directivo;

/**
 *
 * @author jaslyn
 */
public class VistaDirectivo {
    private ControladorPersona controladorDirectivo;
    private Scanner teclado;
    public VistaDirectivo(){
        controladorDirectivo=new ControladorPersona();
        teclado=new Scanner(System.in);
        
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
        System.out.println("ingrese el Sueldo bruto");
        double sueldobruto=teclado.nextDouble();
        System.out.println("ingrese la categoria ");
        String categoria=teclado.next();
        System.out.println("Resultado "+controladorDirectivo.crear(cedula, nombre, apellido, direccion, sueldobruto, categoria));
    }
    public Directivo buscar(){
        System.out.println("ingrese la cedula");
        String cedula=teclado.next();
        Directivo directivo=controladorDirectivo.buscar(cedula);
        controladorDirectivo.setSeleccionado(directivo);
        System.out.println(directivo);
        return directivo;
    }
    public void actualizar(){
        Directivo directivo=buscar();
        if (directivo!=null){
            System.out.println("ingrese el nombre");
            String nombre=teclado.next();
            System.out.println("ingrese el apellido");
            String apellido=teclado.next();
            System.out.println("ingrese la direccion");
            String direccion=teclado.next();
            System.out.println("ingrese el sueldo bruto");
            double sueldobruto=teclado.nextDouble();
            System.out.println("ingrese la categoria");
            String categoria=teclado.next();
            System.out.println("Actualizado "+controladorDirectivo.actualizar(directivo.getCedula(), nombre, apellido, direccion, sueldobruto, categoria));
        }
    }
    public void eliminar(){
        Directivo directivo=buscar();
        if(directivo!=null)
            System.out.println("Resultado: "+controladorDirectivo.eliminar(directivo.getCedula()));
    }
    public void listar(){
        for (Directivo directivo : controladorDirectivo.getListaDirectivo()) {
            System.out.println(directivo);
        }
    }

    public ControladorPersona getControladorDirectivo() {
        return controladorDirectivo;
    }

    public void setControladorDirectivo(ControladorPersona controladorDirectivo) {
        this.controladorDirectivo = controladorDirectivo;
    }
    
            
}
