/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorEmpresa;
import java.util.Scanner;
import modelo.Empresa;


/**
 *
 * @author jaslyn
 */
public class VistaEmpresa {
    private ControladorEmpresa controladorEmpresa;
    private VistaCliente vistaCliente;
    private VistaEmpleado vistaEmpleado;
    private VistaDirectivo vistaDirectivo;
    private Scanner teclado;
    public VistaEmpresa(VistaCliente vistaCliente,VistaEmpleado vistaEmpleado,VistaDirectivo vistaDirectivo){
        controladorEmpresa=new ControladorEmpresa();
        this.vistaCliente=vistaCliente;
        this.vistaDirectivo=vistaDirectivo;
        this.vistaEmpleado=vistaEmpleado;
        teclado=new Scanner(System.in);
    }
    public void menu(){
        int opcion=0;
        do{
            System.out.println("1.Crear");
            System.out.println("2.Actualizar");
            System.out.println("3.Buscar");
            System.out.println("4.Eliminar");
            System.out.println("5.Listar");
            System.out.println("6.Gestionar Cliente");
            System.out.println("7.Gestionar empleado");
            System.out.println("8.Gestionar directivo");
            System.out.println("9.Salir");
            opcion=teclado.nextInt();
            switch(opcion){
                case 1:this.crear();break;
                case 2:this.actualizar();break;
                case 3:this.buscar();break;
                case 4:this.eliminar();break;
                case 5:this.listar();break;
                case 6:
                    this.cliente();
                    break;
                case 7:this.empleado();break;
                case 8:this.directivo();break;
                
            }
        }while(opcion<8);
    }
    public void crear(){
        System.out.println("Ingrese el nombre");
        String nombre=teclado.next();
        boolean resultado =controladorEmpresa.crear(nombre);
        System.out.println("Resultado: "+resultado);
    }
    public Empresa buscar(){
        System.out.println("Ingrese el nombre de la empresa");
        String nombre= teclado.next();
        Empresa empresa=controladorEmpresa.buscar(nombre);
        controladorEmpresa.setSeleccionado(empresa);
        System.out.println(empresa);
        return empresa;
    }
    public void actualizar(){
        Empresa empresa=buscar();
        System.out.println("Ingrese el nombre nuevo");
        String nombrenuevo=teclado.next();
        System.out.println("Resultado: "+controladorEmpresa.actualizar(empresa.getNombre(), nombrenuevo));
    }
    public void eliminar(){
        Empresa empresa=buscar();
        System.out.println("Resultado: "+controladorEmpresa.eliminar(empresa.getNombre()));
    }
    public void listar(){
        for (Empresa empresa : controladorEmpresa.getListaEmpresa()) {
            System.out.println(empresa);
        }
    }
    public void cliente(){
        Empresa empresa=buscar();
        if(empresa!=null){
            vistaCliente.getControladorCliente().setListaCliente(empresa.getListadoCliente());
            vistaCliente.menu();
        }
    }
    public void empleado(){
        Empresa empresa=buscar();
        if(empresa!=null){
            vistaEmpleado.getControladorEmpleado().setListaEmpleado(empresa.getListadoEmpleado());
            vistaEmpleado.menu();
        }
    }
    public void directivo(){
        Empresa empresa=buscar();
        if(empresa!=null){
            vistaDirectivo.getControladorDirectivo().setListaDirectivo(empresa.getListaDirectivo());
            vistaDirectivo.menu();
        }
    }
}
