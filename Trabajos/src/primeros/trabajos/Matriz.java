/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primeros.trabajos;

import java.util.Scanner;

/**
 *
 * @author jaslyn
 */
public class Matriz {
    public static void main(String args[]){
        Scanner teclado=new Scanner(System.in);
        System.out.println("Ingrese filas");
        int fila= teclado.nextInt();
        System.out.println("Ingrese numero de columnas");
        int columna=teclado.nextInt();
        double matriz[][]=new double[fila][columna];
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++){
                matriz[i][j]=Math.random()*100;
            }
        }
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++){
                System.out.print(""+matriz[i][j]+'\t');
            }
            System.out.println("");
        }  
        double suma=0;
        for (int a=0;a<matriz.length;a++){
            for (int j = 0; j < matriz.length; j++) {
                if (a==j){
                suma+=matriz[a][j];
                }
                }           
                }
        System.out.println("aum diagonal="+suma);
    }
}
