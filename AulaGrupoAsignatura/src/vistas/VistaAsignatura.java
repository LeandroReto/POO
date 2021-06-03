/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.ControladorAsignatura;
import controladores.ControladorGrupo;
import java.util.Scanner;
import modelo.Asignatura;

/**
 *
 * @author jaslyn
 */
public class VistaAsignatura {
    private ControladorAsignatura controladorAsignatura;
    private ControladorGrupo controladorGrupo;
    private Scanner teclado;
    public VistaAsignatura(ControladorGrupo controladorGrupo){
        this.controladorGrupo=new ControladorGrupo();
        controladorAsignatura=new ControladorAsignatura();
        teclado=new Scanner(System.in);
    }
    public void menu(){
        int opcion=0;
        do{
            System.out.println("\ngestion de asignaturas");
            System.out.println("1.para crear");
            System.out.println("2.para buscar");
            System.out.println("3.para actualizar");
            System.out.println("4.para eliminar");
            System.out.println("5.para listar");
            System.out.println("6.para salir");
            opcion= teclado.nextInt();
            switch(opcion){
                case 1: this.crear();break; 
                case 2: this.buscar();break;
                case 3: this.actualizar();break;
                case 4: this.eliminar();break;
                case 5: 
                    System.out.println("lista de asignaturas");
                    controladorAsignatura.imprimir();break;
            }
        }while(opcion<6);
    }
    public void crear(){
        System.out.println("ingrese el nombre de la asignatura");
        String nombre= teclado.next();
        System.out.println("ingrese el id de asignatura");
        long id=teclado.nextLong();
        boolean resultado= controladorAsignatura.crear(id, nombre,controladorGrupo.getSeleccionado());
        System.out.println("creado "+resultado);
    }
    public Asignatura buscar(){
        System.out.println("ingrese el nombre de la asignatura a buscar");
        String nombre=teclado.next();
        Asignatura asignatura=controladorAsignatura.buscar(nombre);
        System.out.println(asignatura);
        return asignatura;
    }
    public void actualizar(){
        System.out.println("ingrese el nombre anterior de asignatura");
        String nombreanterior= teclado.next();
        System.out.println("ingrese el nombre nuevo de asignatura");
        String nombrenuevo=teclado.next();
        boolean resultado= controladorAsignatura.actualizar(nombreanterior, nombrenuevo);
        System.out.println("actualizado "+resultado);
    }
    public void eliminar(){
        System.out.println("ingrese la asignatura a elminar");
        String nombre=teclado.next();
        boolean resultado=controladorAsignatura.eliminar(nombre);
        System.out.println("eliminado "+resultado);
    }
    public void asignarSeleccionado(Asignatura asignatura){
        controladorAsignatura.setSeleccionado(asignatura);
    }

    public ControladorAsignatura getControladorAsignatura() {
        return controladorAsignatura;
    }

    public void setControladorAsignatura(ControladorAsignatura controladorAsignatura) {
        this.controladorAsignatura = controladorAsignatura;
    }

    public ControladorGrupo getControladorGrupo() {
        return controladorGrupo;
    }

    public void setControladorGrupo(ControladorGrupo controladorGrupo) {
        this.controladorGrupo = controladorGrupo;
    }
    
}
