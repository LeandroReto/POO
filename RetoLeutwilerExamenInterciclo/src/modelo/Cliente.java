
package modelo;

public class Cliente {
    //Atributos pedidos en la guia de practica son su respectivo tipo de dato
    private long id;
    private String nombre;
    private String cedula;
    private int fiabilidadPago;

    //Constructor Cliente que inicializa las variables de atributos
    public Cliente(long id, String nombre, String cedula, int fiabilidadPago) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.fiabilidadPago = fiabilidadPago;
    }

    //Metodos gett and setter del modelo Cliente
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getFiabilidadPago() {
        return fiabilidadPago;
    }

    public void setFiabilidadPago(int fiabilidadPago) {
        this.fiabilidadPago = fiabilidadPago;
    }

    //Metodo sobrecardago toString de la clase Cliente
    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", cedula=" + cedula + ", fiabilidadPago=" + fiabilidadPago + '}';
    }
    
    
}
