/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorCliente;
import java.util.Scanner;
import modelo.Cliente;

/**
 *
 * @author tians
 */
public class VistaCliente {
    //Variables globales para utilizar
    //Variable teclado para ingresar datos desde la consola
    public Scanner teclado;
    //Objeto controladorCliente de la clase ControladorCliente para usar sus metodos
    private ControladorCliente controladorCliente;

    //Constructor de vistaCliente para usar su controlador como parametro desde vistaGeneral
    public VistaCliente(ControladorCliente controladorCliente) {
        teclado=new Scanner(System.in);
        this.controladorCliente = controladorCliente;
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
        System.out.println("Ingrese: \n nombre completo");
        teclado.nextLine();
        String nombreCompleto = teclado.nextLine();
        System.out.println("Ingrese: \n cedula");
        String cedula = teclado.nextLine();
        System.out.println("Ingrese: \n fiabilidad de pago");
        int fiabilidadPago = Integer.parseInt(teclado.nextLine());
        System.out.println("Res:" + controladorCliente.crear(nombreCompleto, cedula, fiabilidadPago));
    }

    //Metodo actualizar para volver a pedir los datos y enviar el objeto a reemplazar
    public void actualizar() {
        System.out.println("Ingrese: \n nombre completo");
        teclado.nextLine();
        String nombreCompleto = teclado.nextLine();
        System.out.println("Ingrese: \n cedula");
        String cedula = teclado.nextLine();
        System.out.println("Ingrese: \n fiabilidad de pago");
        int fiabilidadPago = Integer.parseInt(teclado.nextLine());
        System.out.println("Res:" + controladorCliente.actualizar(nombreCompleto, cedula, fiabilidadPago));
    }

    //Metodo buscar para encontrar un objeto mediante un parametro que pide este metodo
    public Cliente buscar() {
        System.out.println("Ingrese: \n nombre completo");
        teclado.nextLine();
        String nombreCompleto = teclado.nextLine();
        System.out.println(controladorCliente.buscar(nombreCompleto));
        return controladorCliente.buscar(nombreCompleto);
    }

    //Metodo eliminar que busca y envia un objeto para su eliminacion en el controlador
    public void eliminar() {
        this.buscar();
        System.out.println("Res: " + controladorCliente.eliminar(controladorCliente.getSeleccionado().getNombre()));
    }

    //Metodo listar que muestra todos los objetos de la lista desde el controlador
    public void listar() {
        for (Cliente cliente : controladorCliente.getListaCliente()) {
            System.out.println(cliente);
        }
    }
}
