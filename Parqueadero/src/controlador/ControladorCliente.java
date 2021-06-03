
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import modelo.Empresa;

/**
 *
 * @author jaslyn
 */
public class ControladorCliente {
    private List<Cliente> datos; //lista de clientes
    private Cliente seleccionado;
    
    public ControladorCliente() {
        datos = new ArrayList();
        seleccionado=null;
    }
    //CRUD create read update delete. crear buscar actualizar 
    //para cliente
    public boolean crear(long id, String nombre, String apellido, String cedula){
        Cliente cliente=new Cliente( id, nombre, apellido, cedula);
        return datos.add(cliente); //ingrego mi lista de datos, si me lo agrega TRUE de lo contrario sera FALSe
    }
    public boolean crear(long id, String nombre, String apellido, String cedula, Empresa empresa){ //sobrecarga de metodos con empresa
        Cliente cliente=new Cliente( id, nombre, apellido, cedula,empresa);
        empresa.getListaCliente().add(cliente); //Relacion bidireccional//agrego el cliente a la empresa
        return datos.add(cliente); //ingrego mi lista de datos, si me lo agrega TRUE de lo contrario sera FALSe
    }
    public Cliente buscar(String cedula){ //read. buscamos cierta cedula para actualizar
        for(Cliente cliente : datos){ //foreign de cliente a datos recorre todos los clientes  dentro de la lista de datos.
            if(cliente.getCedula().equals(cedula)==true){ //comparo la cedula de cada cliente con la que envio como parametro
                return cliente; //regresa el cliente encontrado 
            }
        }
        return null; //nullo si no se encontro
    }
    public boolean actualizar(String cedula,String nombre,String apellido){ //primero exista un cliente
        Cliente cliente=this.buscar(cedula); //busco al cliente con la cedula,aplico la formila anteroos
        if(cliente!=null){ //que cliente si exista en nuestro lista de datos para poder actualizarlo
            int posicion=datos.indexOf(cliente); //obtengo la posicion del cliente
            cliente.setNombre(nombre); //actualizo nombre
            cliente.setApellido(apellido); //actualizo apellido
            datos.set(posicion, cliente); // actualizo en base a la posciion del cliente
            return true;
        }
        return false;
    }
    public boolean eliminar(String cedula){
        Cliente cliente=this.buscar(cedula); //busco a cliente
        if(cliente!=null){
            cliente.getEmpresa().getListaCliente().remove(cliente);
            return datos.remove(cliente); //elimina al cliente
        }
        return false;
    }
    
    public void imprimir(){
        for(Cliente cliente: datos){ //recoro clientes en la lista de datos
            System.out.println(cliente);
        }
    }
    //encapsulamiento
    
    public List<Cliente> getDatos() {
        return datos;
    }
    public void setDatos(List<Cliente> datos) {
        this.datos = datos;
    }

    public Cliente getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Cliente seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    
}
