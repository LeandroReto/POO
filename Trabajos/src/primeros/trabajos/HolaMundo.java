/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primeros.trabajos;

/**
 *
 * @author jaslyn
 */
public class HolaMundo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a=15;
        if(a>=20){
            System.out.println("el numero es mayor o igual a 20");
        }else if (a>=10){
            System.out.println("el numero es mayor o igual a 10");
        }else if(a<20){
            System.out.println("el numero es menor a 20 ");
        }else{
            System.out.println("el numero es menor a 15");
        }
        System.out.println("hola mundo");
        
        int b=1;
        switch(a){
            case 1:System.out.println("lunes");
            break;
            case 2:System.out.println("martes");
            break;
            case 3:System.out.println("miercoles");
            break;
            case 4:System.out.println("jueves");
            break;
            case 5:System.out.println("viernes");
            break;
            case 6:System.out.println("sabado");
            break;
            default:System.out.println("domingo");
            break;
        }
        
    }
}
