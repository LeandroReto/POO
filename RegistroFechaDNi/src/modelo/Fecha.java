/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author jaslyn
 */
public class Fecha {
    private long id;
    private int dia;
    private int mes;
    private int anio;

    public Fecha(long id, int dia, int mes, int anio) {
        this.id = id;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Fecha{" + "id=" + id + ", dia=" + dia + ", mes=" + mes + ", anio=" + anio + '}';
    }
    
}
