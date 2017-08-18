/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_201602723;
import java.util.Scanner;
/**
 *
 * @author mi pc
 */
public class Practica1_201602723 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        //INICIO DE VARIABLE
        String aux;
        int opciones;
        String[][] tablero = null;
        String[][] trampa = null;
        
        //FIN DE VARIABLES
        
        System.out.println("    Diego Alejandro Caballeros Melchor  ");
        System.out.println("                201602723               ");
        System.out.println("            IPC A Practica 1            "); 
        System.out.println("              BUSCAMINAS!!              ");
        
        Scanner op = new Scanner(System.in);
        aux = op.nextLine();
        
        //INICIO MENU
        System.out.println("----------------------------------");
        System.out.println("            BUSCAMINAS!!          ");
        System.out.println("        1. Principiante");
        System.out.println("        2. Intermedio");
        System.out.println("        3. Experto");
        System.out.println("        4. Salir");
        System.out.println("");
        System.out.println("Ingrese Opcion");
        //FIN MENU
        
        opciones = op.nextInt();
        
        //INICIO TAMAÑO DEL TABLERO
        switch(opciones){
            case 1: {
                tablero=new String[4][4];
                trampa=new String[4][4];
                break;
            }
            case 2: {
                tablero=new String[4][4];
                trampa=new String[4][4];
                break;
            }
            case 3: {
                tablero=new String[8][8];
                trampa=new String[8][8];
                break;
            }
        }//FIN TAMAÑO DEL TABLERO
        
            Llenado(tablero);
            Mostrar(tablero);
            
            Random(trampa);
            Mostrar(trampa);
        
    }
    
    //METODOS
    
    //METODO DE LLENADO
    public static void Llenado(String[][] tablero){
        for(int i=0; i<tablero.length ;i++){
            for(int j=0; j<tablero.length ;j++){
                tablero[i][j] = "[X]";
                }
         }
    }//FIN METODO DE LLENADO
    
    //METODO PARA MOSTRAR
    public static void Mostrar(String[][] matriz){
        for(int i=0; i<matriz.length ;i++){
            System.out.println();
            for(int j=0; j<matriz.length ;j++){
            System.out.print(matriz[i][j] +" ");
            }
        }
    }//FIN METODO MOSTRAR
    
    public static void Random(String[][] chivo){
        int cont=0;
        
        for(int i=0; i<chivo.length ;i++){
            for(int j=0; j<chivo.length ;j++){
                chivo[i][j] = "[ ]";
                }
         }
        
        do{
            
            int fila = (int)(Math.random()*10);
            int columna = (int)(Math.random()*10);
            System.out.println(fila+" "+columna);
            
            if(fila<=chivo.length && columna<=chivo.length){
                chivo[fila][columna]= " * ";
                cont++;
            }
        
        }while(cont==4);
    }
    
    
    //METODO MUESTRA
    public static void Muestra(String[][] matrix){
        for(int i=0; i<matrix.length ;i++){
            System.out.println();
            for(int j=0; j<matrix.length ;j++){
            System.out.print(matrix[i][j] +" ");
            }
        }
    }
        
}
