/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.ControladorAula;
import controladores.ControladorGrupo;
import java.util.Scanner;
import modelo.Aula;
import modelo.Grupo;

/**
 *
 * @author jaslyn
 */
public class VistaGrupo {
    private ControladorGrupo controladorGrupo;
    private ControladorAula controladorAula;
    private Scanner teclado;
    public VistaGrupo(ControladorAula controladorAula){
        this.controladorAula=new ControladorAula();
        controladorGrupo=new ControladorGrupo();
        teclado=new Scanner(System.in);
    }
    public void menu(){
        int opcion=0;
        do{
            System.out.println("\ngestion de grupos");
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
                    System.out.println("lista de grupos");
                    controladorGrupo.imprimir();break;
            }
        }while(opcion<6);
    }
    public void crear(){
        System.out.println("ingrese el nombre de grupo");
        String nombre= teclado.next();
        System.out.println("ingrese el id de grupo");
        long id=teclado.nextLong();
        boolean resultado= controladorGrupo.crear(id, nombre,controladorAula.getSeleccionado());
        System.out.println("creado "+resultado);
    }
    public Grupo buscar(){
        System.out.println("ingrese el nombre del grupo a buscar");
        String nombre=teclado.next();
        Grupo grupo=controladorGrupo.buscar(nombre);
        System.out.println(grupo);
        return grupo;
    }
    public void actualizar(){
        System.out.println("ingrese el nombre anterior de grupo");
        String nombreanterior= teclado.next();
        System.out.println("ingrese el nombre nuevo de grupo");
        String nombrenuevo=teclado.next();
        boolean resultado= controladorGrupo.actualizar(nombreanterior, nombrenuevo);
        System.out.println("actualizado "+resultado);
    }
    public void eliminar(){
        System.out.println("ingrese el nombre del grupo a elminar");
        String nombre=teclado.next();
        boolean resultado=controladorGrupo.eliminar(nombre);
        System.out.println("eliminado "+resultado);
    }
    public void asignarSeleccionado(Grupo grupo){
        controladorGrupo.setSeleccionado(grupo);
    }

    public ControladorGrupo getControladorGrupo() {
        return controladorGrupo;
    }

    public void setControladorGrupo(ControladorGrupo controladorGrupo) {
        this.controladorGrupo = controladorGrupo;
    }

    public ControladorAula getControladorAula() {
        return controladorAula;
    }

    public void setControladorAula(ControladorAula controladorAula) {
        this.controladorAula = controladorAula;
    }
    
}
