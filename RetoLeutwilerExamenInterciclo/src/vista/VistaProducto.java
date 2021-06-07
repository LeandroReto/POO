/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorProducto;
import java.util.Scanner;
import modelo.Producto;

/**
 *
 * @author tians
 */
public class VistaProducto {
    //Variables globales para utilizar
    //Variable teclado para ingresar datos desde la consola
    public Scanner teclado;
    //Objeto controladorProducto de la clase ControladorProducto para usar sus metodos
    private ControladorProducto controladorProducto;

    //Constructor de vistaProducto para usar su controlador como parametro desde vistaGeneral
    public VistaProducto(ControladorProducto controladorProducto) {
        this.controladorProducto = controladorProducto;
        teclado=new Scanner(System.in);
    }
    //Metodo menu que muestra las opciones de CRUD
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
    //Metodo crear para ingresar datos de un objeto y enviarlos al controlador para su ingreso
    public void crear(){
        System.out.println("Ingrese: \n descripcion");
        teclado.nextLine();
        String descripcion = teclado.nextLine();
        System.out.println("Ingrese: \n precio unitario");
        double precioUnitario = Double.parseDouble(teclado.nextLine());
        System.out.println("Ingrese: \n stock");
        int stock = Integer.parseInt(teclado.nextLine());
        System.out.println("Ingrese: \n iva (S/N) o (true/false)");
        String ivaS=teclado.nextLine();
        System.out.println(descripcion);
        System.out.println(precioUnitario);
        System.out.println(stock);
        System.out.println(ivaS);
      
        boolean iva;
        if (ivaS.equalsIgnoreCase("S") || ivaS.equalsIgnoreCase("true"))
            iva=true;
        else
            iva=false;
        System.out.println(iva);
        System.out.println("Res:" + controladorProducto.crear(descripcion, precioUnitario, stock, iva));
    }
    //Metodo actualizar para volver a pedir los datos y enviar el objeto a reemplazar
    public void actualizar(){
        this.listar();
        System.out.println("Ingrese: \n id de la lista");
        teclado.nextLine();
        long id = Integer.parseInt(teclado.nextLine());
        System.out.println("Ingrese: \n descripcion");
        teclado.nextLine();
        String descripcion = teclado.nextLine();
        System.out.println("Ingrese: \n precio unitario");
        teclado.nextLine();
        double precioUnitario = Double.parseDouble(teclado.nextLine());
        System.out.println("Ingrese: \n stock");
        teclado.nextLine();
        int stock = Integer.parseInt(teclado.nextLine());
        System.out.println("Ingrese: \n iva (S/N) o (true/false)");
        String ivaS=teclado.nextLine();
        boolean iva;
        if (ivaS.equalsIgnoreCase("S") || ivaS.equalsIgnoreCase("true"))
            iva=true;
        else
            iva=false;
        System.out.println("Res:" + controladorProducto.actualizar(id,descripcion,precioUnitario,stock,iva));
    }
    //Metodo buscar para encontrar un objeto mediante un parametro que pide este metodo
    public Producto buscar(){
        this.listar();
        System.out.println("Ingrese: \n id de la lista");
        teclado.nextLine();
        long id = Integer.parseInt(teclado.nextLine());
        System.out.println(controladorProducto.buscar(id));
        return controladorProducto.buscar(id);
    }
     //Metodo eliminar que busca y envia un objeto para su eliminacion en el controlador
    public void eliminar(){
        this.buscar();
        System.out.println("Res: "+ controladorProducto.eliminar(controladorProducto.getSeleccionado().getId()));
    }
    //Metodo listar que muestra todos los objetos de la lista desde el controlador
    public void listar(){
        for (Producto producto : controladorProducto.getListaProducto()) {
            System.out.println(producto);
        }
    }
}
