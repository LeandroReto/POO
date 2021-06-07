/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorCliente;
import controlador.ControladorFacturaCabecera;
import controlador.ControladorFacturaDetalle;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Cliente;
import modelo.FacturaCabecera;
import modelo.FacturaDetalle;

/**
 *
 * @author tians
 */
public class VistaFacturaCabecera {
    //Variables globales para utilizar
    //Variable teclado para ingresar datos desde la consola
    public Scanner teclado;
    //Objetos de controladores de las clases para usar los metodos
    private ControladorFacturaCabecera controladorFacturaCabecera;
    private ControladorCliente controladorCliente;
    private ControladorFacturaDetalle controladorFacturaDetalle;
    //Objeto de clase DateFormat para establecer un formato de fecha 
    public DateFormat formatoFecha;

     //Constructor de vistaFacturaCabecera para usar su controlador como parametro desde vistaGeneral
    public VistaFacturaCabecera(ControladorFacturaCabecera controladorFacturaCabecera, ControladorCliente controladorCliente, ControladorFacturaDetalle controladorFacturaDetalle) {
        teclado=new Scanner(System.in);
        this.controladorFacturaCabecera = controladorFacturaCabecera;
        this.controladorCliente = controladorCliente;
        this.controladorFacturaDetalle = controladorFacturaDetalle;
        //Variable formatoFecha para establecer la clase Date como dd/mm/yyyy
        formatoFecha = new SimpleDateFormat("dd/mm/yyyy");
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
        String nombre;
        Cliente cliente = null;
        System.out.println("Ingrese: \n total");
        teclado.nextLine();
        double total = Double.parseDouble(teclado.nextLine());
        System.out.println("Ingrese: \n fecha (dd/mm/yyyy)");
        String fecha = teclado.nextLine();
        do {
            System.out.println("Ingrese: \n nombre de cliente");
            nombre = teclado.nextLine();
            if (controladorCliente.buscar(nombre) == null) {
                System.out.println("Cliente no existe");
            } else {
                cliente = controladorCliente.buscar(nombre);
            }
        } while (controladorCliente.buscar(nombre) == null);
        List<FacturaDetalle> listaFacturaDetalle = new ArrayList<FacturaDetalle>();
        String seguir="";
        do {
            System.out.println("Ingrese: \n id del detalle");
            long id = Integer.parseInt(teclado.nextLine());
            if (controladorFacturaDetalle.buscar(id) == null) {
                System.out.println("Factura Detalle no existe");
                seguir="S";
            } else {
                listaFacturaDetalle.add(controladorFacturaDetalle.buscar(id));
                System.out.println("Ingrese: \n S/N para ingresar mas detalles");
                seguir = teclado.nextLine();
            }
        }while (seguir.equalsIgnoreCase("S"));
        
        try{
            System.out.println("Res:" + controladorFacturaCabecera.crear(cliente, listaFacturaDetalle, total, formatoFecha.parse(fecha)));
        }catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }
    //Metodo actualizar para volver a pedir los datos y enviar el objeto a reemplazar
    public void actualizar(){
        this.listar();
        System.out.println("Ingrese: \n id de la lista");
        teclado.nextLine();
        long id = Integer.parseInt(teclado.nextLine());
        String nombre;
        Cliente cliente = null;
        do {
            System.out.println("Ingrese: \n nombre de cliente");
            teclado.nextLine();
            nombre = teclado.nextLine();
            if (controladorCliente.buscar(nombre) == null) {
                System.out.println("Cliente no existe");
            } else {
                cliente = controladorCliente.buscar(nombre);
            }
        } while (controladorCliente.buscar(nombre) == null);
        List<FacturaDetalle> listaFacturaDetalle = new ArrayList<FacturaDetalle>();
        String seguir="";
        do {
            System.out.println("Ingrese: \n id del detalle factura");
            teclado.nextLine();
            long idDetalle = Integer.parseInt(teclado.nextLine());
            if (controladorFacturaDetalle.buscar(idDetalle) == null) {
                System.out.println("Factura Detalle no existe");
                seguir="S";
            } else {
                listaFacturaDetalle.add(controladorFacturaDetalle.buscar(idDetalle));
                System.out.println("Ingrese: \n S/N para ingresar mas detalles");
                teclado.nextLine();
                seguir = teclado.nextLine();
            }
        }while (seguir.equalsIgnoreCase("S"));
        System.out.println("Ingrese: \n total");
        teclado.nextLine();
        double total = Double.parseDouble(teclado.nextLine());
        System.out.println("Ingrese: \n fecha (dd/mm/yyyy)");
        teclado.nextLine();
        String fecha = teclado.nextLine();
        try{
            System.out.println("Res:" + controladorFacturaCabecera.actualizar(id, cliente, listaFacturaDetalle, total, formatoFecha.parse(fecha)));
        }catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }
    //Metodo buscar para encontrar un objeto mediante un parametro que pide este metodo
    public FacturaCabecera buscar(){
        System.out.println("Ingrese: \n id ");
        teclado.nextLine();
        long id = Integer.parseInt(teclado.nextLine());
        System.out.println(controladorFacturaCabecera.buscar(id));
        return controladorFacturaCabecera.buscar(id);
    }
    //Metodo eliminar que busca y envia un objeto para su eliminacion en el controlador
    public void eliminar(){
        this.buscar();
        System.out.println("Res: "+ controladorCliente.eliminar(controladorCliente.getSeleccionado().getNombre()));
    }
    //Metodo listar que muestra todos los objetos de la lista desde el controlador
    public void listar(){
        for (FacturaCabecera facturaCabecera : controladorFacturaCabecera.getListaFacturaCabecera()) {
            System.out.println(facturaCabecera);
        }
    }
}
