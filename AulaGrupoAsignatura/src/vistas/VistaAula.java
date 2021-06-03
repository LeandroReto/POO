package vistas;


import controladores.ControladorAula;
import java.util.Scanner;
import modelo.Aula;
import modelo.Grupo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jaslyn
 */
public class VistaAula {
    private ControladorAula controladorAula;
    private Scanner teclado;
    public VistaAula(){
        controladorAula=new ControladorAula();
        teclado=new Scanner(System.in);
    }
    public void menu(){
        int opcion=0;
        do{
            System.out.println("\ngestion de aulas");
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
                case 5: this.imprimir();break;
            }
        }while(opcion<6);
    }
    public void crear(){
        System.out.println("ingrese los datos de la aula");
        System.out.println("id ");
        long id=teclado.nextLong();
        System.out.println("descripcion ");
        String descripcion=teclado.next();
        boolean resultado=controladorAula.crear(id, descripcion);
        System.out.println("creado "+resultado);
    }
    public Aula buscar(){
        System.out.println("descripcion de la aula a buscar");
        String descripcion=teclado.next();
        Aula aula=controladorAula.buscar(descripcion);
        System.out.println(aula);
        controladorAula.setSeleccionado(aula);
        return aula;
    }
    public void actualizar(){
        System.out.println("ingrese la descripcion Anterior");
        String descripcionAnterior= teclado.next();
        System.out.println("ingrese la descripcion Nueva ");
        String descripcionNueva=teclado.next();
        boolean resultado=controladorAula.actualizar(descripcionAnterior, descripcionNueva);
        System.out.println("Actualizado "+resultado);
    }
    public void eliminar(){
        System.out.println("ingrese la id del aula a eliminar");
        String descripcion=teclado.next();
        boolean resultado= controladorAula.eliminar(descripcion);
        System.out.println("Eliminado "+resultado);
    }
    public void imprimir(){
        for (Aula aula : controladorAula.getListaAula()) {
            System.out.println(aula);
            this.imprimirgrupos(aula);
        }
    }
    public void imprimirgrupos(Aula aula){
        for (Grupo grupo : aula.getListaGrupo()) {
            System.out.println(grupo);
        }
    }
    public void asignarSeleccionado(Aula aula){
        controladorAula.setSeleccionado(aula);
    }

    public ControladorAula getControladorAula() {
        return controladorAula;
    }

    public void setControladorAula(ControladorAula controladorAula) {
        this.controladorAula = controladorAula;
    }
    
}
