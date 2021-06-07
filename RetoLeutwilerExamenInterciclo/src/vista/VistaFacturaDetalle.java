/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorFacturaDetalle;
import controlador.ControladorProducto;
import java.util.Scanner;
import modelo.FacturaDetalle;
import modelo.Producto;

/**
 *
 * @author tians
 */
public class VistaFacturaDetalle {
    //Variables globales para utilizar
    //Variable teclado para ingresar datos desde la consola
    public Scanner teclado;
    //Objeto controladorFacturaDetalle de la clase ControladorFacturaDetalle para usar sus metodos
    private ControladorFacturaDetalle controladorFacturaDetalle;
    //Objeto controladorProducto de la clase ControladorProducto para usar sus metodos
    private ControladorProducto controladorProducto;

    //Constructor de vistaFacturaDetalle para usar su controlador como parametro desde vistaGeneral
    public VistaFacturaDetalle(ControladorFacturaDetalle controladorFacturaDetalle, ControladorProducto controladorProducto) {
        teclado=new Scanner(System.in);
        this.controladorFacturaDetalle = controladorFacturaDetalle;
        this.controladorProducto = controladorProducto;
    }
    //Metodo menu que muestra las opciones de CRUD
    public void menu() {
        int opcion = 0;
        do {
            System.out.println(" 1. Crear \n 2. Actualizar \n 3. Buscar \n 4. Eliminar \n 5. Listar \n 6. Salir");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    this.crear();
                    break;
                case 2:
                    this.actualizar();
                    break;
                case 3:
                    this.buscar();
                    break;
                case 4:
                    this.eliminar();
                    break;
                case 5:
                    this.listar();
                    break;
            }
        } while (opcion < 6);
    }
    //Metodo crear para ingresar datos de un objeto y enviarlos al controlador para su ingreso
    public void crear() {
        Producto producto=null;
        long idP;
        
         do {
            System.out.println("Ingrese: \n id del producto");
            teclado.nextLine();
            idP = Integer.parseInt(teclado.nextLine());
            if (controladorProducto.buscar(idP) == null) {
                System.out.println("Producto no existe");
            } else {
                producto = controladorProducto.buscar(idP);
            }
        }while(controladorProducto.buscar(idP) == null);
        System.out.println("Ingrese: \n cantidad");
        long cantidad = Integer.parseInt(teclado.nextLine());
        System.out.println("Ingrese: \n valor");
        double valor = Double.parseDouble(teclado.nextLine());
        System.out.println("Res:" + controladorFacturaDetalle.crear(producto,cantidad,valor));
    }
    //Metodo actualizar para volver a pedir los datos y enviar el objeto a reemplazar
    public void actualizar(){
        long id;
        do{
            System.out.println("Ingrese: \n id de la lista");
            teclado.nextLine();
            id = Integer.parseInt(teclado.nextLine());
            if(controladorFacturaDetalle.buscar(id)==null){
                System.out.println("Factura Detalle no existe");
            }
        }while(controladorFacturaDetalle.buscar(id)==null);
        
        long idP;
        Producto producto=null;
        do {
            System.out.println("Ingrese: \n id del producto");
            teclado.nextLine();
            idP = Integer.parseInt(teclado.nextLine());
            if (controladorProducto.buscar(idP) == null) {
                System.out.println("Producto no existe");
            } else {
                producto = controladorProducto.buscar(idP);
            }
        } while (controladorProducto.buscar(idP) == null);
        System.out.println("Ingrese: \n cantidad");
        teclado.nextLine();
        long cantidad = Integer.parseInt(teclado.nextLine());
        System.out.println("Ingrese: \n valor");
        teclado.nextLine();
        double valor = Double.parseDouble(teclado.nextLine());
        System.out.println("Res:" + controladorFacturaDetalle.actualizar(id,producto,cantidad,valor));
    }
    //Metodo buscar para encontrar un objeto mediante un parametro que pide este metodo
    public FacturaDetalle buscar(){
        System.out.println("Ingrese: \n id");
        teclado.nextLine();
        long id = Integer.parseInt(teclado.nextLine());
        System.out.println(controladorFacturaDetalle.buscar(id));
        return controladorFacturaDetalle.buscar(id);
    }
    //Metodo eliminar que busca y envia un objeto para su eliminacion en el controlador
    public void eliminar(){
        this.buscar();
        System.out.println("Res: "+ controladorFacturaDetalle.eliminar(controladorFacturaDetalle.getSeleccionado().getId()));
    }
    //Metodo listar que muestra todos los objetos de la lista desde el controlador
    public void listar(){
        for (FacturaDetalle facturaDetalle : controladorFacturaDetalle.getListaFacturaDetalle()) {
            System.out.println(facturaDetalle);
        }
    }
}
