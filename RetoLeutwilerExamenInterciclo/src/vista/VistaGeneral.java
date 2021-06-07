/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorCliente;
import controlador.ControladorFacturaCabecera;
import controlador.ControladorFacturaDetalle;
import controlador.ControladorProducto;
import java.util.Scanner;
import modelo.Cliente;
import modelo.Producto;

/**
 *
 * @author tians
 */
public class VistaGeneral {
    private Scanner teclado; 
    private VistaCliente vistaCliente;
    private VistaFacturaCabecera vistaFacturaCabecera;
    private VistaFacturaDetalle vistaFacturaDetalle;
    private VistaProducto vistaProducto;
    private ControladorCliente controladorCliente;
    private ControladorFacturaCabecera controladorFacturaCabecera;
    private ControladorFacturaDetalle controladorFacturaDetalle;
    private ControladorProducto controladorProducto;

    public VistaGeneral() {
        teclado = new Scanner(System.in);
        controladorCliente = new ControladorCliente();
        controladorFacturaCabecera = new ControladorFacturaCabecera();
        controladorFacturaDetalle = new ControladorFacturaDetalle();
        controladorProducto = new ControladorProducto();
        vistaCliente = new VistaCliente(controladorCliente);
        vistaFacturaCabecera = new VistaFacturaCabecera(controladorFacturaCabecera, controladorCliente, controladorFacturaDetalle);
        vistaFacturaDetalle = new VistaFacturaDetalle(controladorFacturaDetalle, controladorProducto);
        vistaProducto = new VistaProducto(controladorProducto);
    }
     public void menu() {
        int opcion = 0;
        do {
            System.out.println("Gestión de Registros");
            System.out.println(" 1. Cliente \n 2. Producto \n 3. Factura Cabecera \n 4. Factura Detalle \n 5. Salir");
            opcion = teclado.nextInt();
            switch(opcion){
                case 1: vistaCliente.menu(); break;
                case 2: vistaProducto.menu(); break;
                case 3: vistaFacturaCabecera.menu();break;
                case 4: vistaFacturaDetalle.menu();break;
            }
        } while (opcion < 5);
    }
    public void persona(){
        Cliente cliente=vistaCliente.buscar();
        if(cliente == null){
            vistaCliente.menu();
        }
    }
    public void producto(){
        Producto producto=vistaProducto.buscar();
        if(producto == null){
            vistaProducto.menu();
        }
    }
}
