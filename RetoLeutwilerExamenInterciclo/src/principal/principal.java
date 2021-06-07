/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import vista.VistaGeneral;

/**
 *
 * @author jaslyn
 */
public class principal {

    /**
     * @param args the command line arguments
     */
    //Clase main que se ejecuta primero
    public static void main(String[] args) {
        //Instanciacion de la clase vista general
        VistaGeneral vistageneral=new VistaGeneral();
        //Metodo menu de la clase vistageneral
        vistageneral.menu();
    }
    
}
