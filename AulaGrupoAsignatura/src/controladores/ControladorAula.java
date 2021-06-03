package controladores;

import java.util.ArrayList;
import java.util.List;
import modelo.Aula;

/**
 *
 * @author jaslyn
 */
public class ControladorAula {
    private List<Aula> listaAula;
    private Aula seleccionado;    
    public ControladorAula(){
        listaAula= new ArrayList();
    }
    public boolean crear(long id, String descripcion){
        Aula aula= new Aula(id, descripcion);
        return listaAula.add(aula);
    }
    public Aula buscar(String descripcion){
        for (Aula aula : listaAula) {
            if(aula.getDescripcion().equals(descripcion)==true)
                seleccionado=aula;
                return aula;
        }
        return null;
    }
    public boolean actualizar(String descripcionAnterior,String descripcionNueva){
        Aula aula=this.buscar(descripcionAnterior);
        if(aula!=null){
            int posic=listaAula.indexOf(aula);
            aula.setDescripcion(descripcionNueva);
            listaAula.set(posic, aula);
            return true;
        }
        return false;
    }
    public boolean eliminar(String descripcion){
        Aula aula=this.buscar(descripcion);
        if (aula!=null) {
            return listaAula.remove(aula);
        }
        return false;
    }

    public List<Aula> getListaAula() {
        return listaAula;
    }

    public void setListaAula(List<Aula> listaAula) {
        this.listaAula = listaAula;
    }

    public Aula getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Aula seleccionado) {
        this.seleccionado = seleccionado;
    }

    
}
