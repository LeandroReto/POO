/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.Scanner;
import modelo.Cliente;
import modelo.Empresa;
import modelo.Vehiculo;

/**
 *
 * @author jaslyn
 */
public class VistaGeneral {
    private VistaCliente clientevista;
    private VistaEmpresa Empresavista;
    private VistaVehiculo vehiculovista;
    private VistaServicio servicioVista;
    private Scanner teclado;
    public VistaGeneral(){
        Empresavista=new VistaEmpresa();
        clientevista=new VistaCliente(Empresavista.getEmpresaControlador()); //unifico el controladorEmpresa en uno solo
        vehiculovista=new VistaVehiculo(clientevista.getClientecontrolador());
        servicioVista=new VistaServicio(vehiculovista.getVehiculoControlador());
        teclado=new Scanner(System.in);
    }
    public void menu(){
        int op=0;
        do{
            System.out.println("SELECCIONE UNA OPCION");
            System.out.println("1.Empresa");
            System.out.println("2.Cliente");
            System.out.println("3.Vehiculo");
            System.out.println("4.Servicio");
            op=teclado.nextInt();
            switch(op){
                case 1:Empresavista.menu();break;
                case 2:this.cliente();break;
                case 3:this.vehiculo();break;
                case 4:this.servicio();break;
            }
        }while(op<5);//para los demas modelos
    }
    public void cliente(){
        System.out.println("Seleccione una empresa para gestionar los clientes");
        Empresa empresa=Empresavista.buscar();
        if(empresa!=null){
            clientevista.menu();
        }else{
            System.out.println("Empresa no existe");
            this.cliente();
        }
    }
    public void vehiculo(){
        System.out.println("Seleccione un propietario para gestionar los vehiculos");
        Cliente cliente=clientevista.buscar();
        if(cliente!=null){
            clientevista.asignarSeleccionado(cliente);
            vehiculovista.menu();
        }else{
            System.out.println("Cliente no existe");
            this.vehiculo();
        }
    }//cuando se pone el asignado fuera del buscar en 
    
    public void servicio(){
        System.out.println("Seleccione un vehiculo para gestionar el servicio");
        Vehiculo vehiculo= vehiculovista.buscar();
        if(vehiculo!=null){
            vehiculovista.asignarSeleccionado(vehiculo);
            vehiculovista.menu();
        }else{
            System.out.println("Vehiculo no existente");
            this.servicio();
        }
    }
}
