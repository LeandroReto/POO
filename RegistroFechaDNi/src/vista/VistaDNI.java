/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorDNI;
import java.util.Scanner;
import modelo.DNI;

/**
 *
 * @author jaslyn
 */
public class VistaDNI {
    private ControladorDNI controladorDNI;
    public Scanner teclado;
    public VistaDNI(ControladorDNI controladorDNI){
        controladorDNI=new ControladorDNI();
        teclado=new Scanner(System.in);
    }
    public void menu(){
        int opcion=0;
        do{
            System.out.println(" 1.crear \n 2.Actualizar \n 3.Buscar \n 4.eliminar \n 5.listar \n 6.salir");
            opcion=teclado.nextInt();
            switch(opcion){
                case 1: this.crear();break;
                case 2: this.Actualizar();break;
                case 3: this.buscar();break;
                case 4:this.eliminar();break;
                case 5:this.listar();break;
            }
        }while(opcion<6);
    }
    public void crear(){
        System.out.println("Ingrese \n numero");
        String numero=teclado.next();
        System.out.println("codigo de verificacion");
        int codigoverificacion=teclado.nextInt();
        System.out.println("creado "+ controladorDNI.crear( numero, codigoverificacion));
    }
    public void Actualizar(){
        System.out.println("Ingrese \n numero");
        String numero=teclado.next();
        System.out.println("codigo de verificacion");
        int codigoverificacion=teclado.nextInt();
        System.out.println("creado "+ controladorDNI.actualizar(numero, codigoverificacion));
    }
    public DNI buscar(){
        System.out.println("Ingrese \n numero");
        String numero=teclado.next();
        System.out.println(controladorDNI.buscar(numero));
        return controladorDNI.buscar(numero);
    }
    public void eliminar(){
        this.buscar();
        System.out.println("eliminado "+controladorDNI.eliminar(controladorDNI.getSeleccionado().getNumero()));
    }
    public void listar(){
        for (DNI dni : controladorDNI.getListaDNI()) {
            System.out.println(dni);
        }
    }
}
