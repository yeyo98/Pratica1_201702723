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
        String aux;                         //si ya no me sirve volverla a utilizar para el titulo
        String nivel = null;
        String jugar = null;
        String elegir = null;
        int menu_principal=0;
        int fila =0, columna=0;
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
        
        try{
        menu_principal = op.nextInt();
        }catch(Exception e){
            System.out.println("Eliga un valor correcto");
        }
        
        //INICIO TAMAÑO DEL TABLERO
        switch(menu_principal){
            case 1: {
                tablero=new String[4][4];
                trampa=new String[4][4];
                nivel= "Principiante";
                break;
            }
            case 2: {
                tablero=new String[6][6];
                trampa=new String[6][6];
                nivel= "Intermedio";
                //cant=2;
                break;
            }
            case 3: {
                tablero=new String[8][8];
                trampa=new String[8][8];
                nivel= "Experto";
                //cant=4;
                break;
            }
        }//FIN TAMAÑO DEL TABLERO
        
            Llenado(tablero);
            Random(trampa);
            
            System.out.print("        NIvel " +nivel +"       ");
            Mostrar(tablero);
            
            System.out.println("");
            System.out.println("");
            System.out.println("Chivo");
            
            Mostrar(trampa);
            System.out.println("");
            System.out.println("--------------------------------------------");
            
            System.out.println("    Voltear: V");
            System.out.println("    Reinciar: R");
            System.out.println("    Salir: S");
            System.out.println("--------------------------------------------");
            
            Scanner po = new Scanner(System.in);
            jugar = po.nextLine();
            
            switch(jugar){
                case "V":{
                    
                    do{
                    fila = 0;
                    columna = 0;
                    System.out.println("Ingrese fila y columna");
                    Scanner el = new Scanner(System.in);
                    elegir = el.nextLine();
                    
                    System.out.println(" ");
                    System.out.println("Desea aceptar los datos ingresados");
                    Scanner de = new Scanner(System.in);
                    aux = de.nextLine();
                    
                    switch(aux){
                     case "Y": {  
                        fila = Integer.parseInt(elegir.substring(0,1));
                        columna = Integer.parseInt(elegir.substring(2,3));
                    
                        if(fila>trampa.length || columna>trampa.length){
                        System.out.println("ERROR, INGRESE COORDENADAS CORRECTAS");
                        }else{
                            Jugar(fila,columna,tablero,trampa);
                        
                        }
                        
                        
                        break;
                    }
                    
                     case "N":{
                         Mostrar(tablero);
                         Mostrar(trampa);
                        break;
                     }
                  }//FIN SWITCH AUX
                }while(fila>trampa.length || columna>trampa.length); 
                    
                break;
                }//FIN SWTICH V
                
                case "r":{
                
                break;
                }
                
                case "s":{
                
                break;
                }
                
            }//FIN SWITCH JUGAR
            
            
        
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
    
    //METODO PARA LLENAR CON BOMBAS
    public static void Random(String[][] chivo){
        int cont=0;
        int cant=0;
        
        //INCREMENTO DE LAS BOMBAS
        if(chivo.length==4){
            cant=4;
        }else if(chivo.length==6){
            cant=8;
        }else{
            cant=12;
        }
        
        //LLENANDO LA MATRIZ
        for(int i=0; i<chivo.length ;i++){
            for(int j=0; j<chivo.length ;j++){
                chivo[i][j] = "[ ]";
                }
         }
        
        //IMPLEMENTACION DE LAS BOMBAS
        do{
            int fila = (int)(Math.random()*10);
            int columna = (int)(Math.random()*10);
            
            if(fila<chivo.length && columna<chivo.length){
                if(chivo[fila][columna] != " * "){
                chivo[fila][columna]= " * ";
                cont++;
                }
            }
        }while(cont!=cant);
    }//FIN LLENADO DE BOMBAS
    
    
    //METODO MUESTRA
    /*public static void Rmostrar(String[][] matrix){
        for(int i=0; i<matrix.length ;i++){
            System.out.println();
            for(int j=0; j<matrix.length ;j++){
            System.out.print(matrix[i][j] +" ");
            }
        }
    }*/
    
    public static void Jugar(int fil, int col, String[][] tab1, String[][] tab2){
        
        //if(fil<=tab1.length && col<=tab1.length){
           if(tab1[fil-1][col-1] == "[X]" ){
               if(tab2[fil-1][col-1] == " * "){
                   System.out.println("perdio");
               }
           }else{
               System.out.println("elija otra");
           }
            
        
    }
    
    
}
