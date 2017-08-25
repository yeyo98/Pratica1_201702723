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
        String nivel = null;    //SELECCIONAR NIVEL (SOLO NOMBRE)
        String jugar = null;    //OPCIONES DEL JUEGO
        String elegir = null;   //ESCOGER ALGUNA COORDENADA
        String reinicio = null; //PARA PODER REINICIAR
        int menu_principal=0;   //MENU PRINCIPAL  
        int fila =0, columna=0;
        int cont_ganar = 0, minas = 0;
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
        do{
        menu_principal = 0;
        
        System.out.println("----------------------------------");
        System.out.println("            BUSCAMINAS!!          ");
        System.out.println("        1. Principiante");
        System.out.println("        2. Intermedio");
        System.out.println("        3. Experto");
        System.out.println("        4. Salir");
        System.out.println("");
        System.out.println("Ingrese Opcion");
        jugar = null;
        reinicio = null;
        //FIN MENU

        try{
        menu_principal = op.nextInt();
        }catch(Exception e){
            System.out.println("Eliga un valor correcto");              //  QUITAR EL DO/WHILE
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
                nivel= "Leyenda";
                //cant=4;
                break;
            }
            case 4: {
                jugar = "S";
                reinicio = "R";
                //menu_principal = 4;
                
                break;
            }
        }//FIN TAMAÑO DEL TABLERO
        
        while(reinicio != "R"){//do{
            //REINICIO DE VARIABLES
            Llenado(tablero);
            Random(trampa);
            //cont_ganar = 0;
            jugar = null;
            //FIN REINICIO DE VARIABLES
            
            if(tablero.length==4){
                minas=4;
            }else if(tablero.length==6){
                minas=8;
            }else{
                minas=12;
            }
            
            
            
        do{  
            cont_ganar = 0; //PARA LIMPIAR EL CONTADOR DE GANAR
            
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
                            
                            if(tablero[fila-1][columna-1] == " * "){
                               System.out.println("Desea reiniciar el juego Y/N");
                                jugar = po.nextLine();
                                
                                switch(jugar){
                                    case "Y":{
                                        jugar = "S";
                                    break;
                                    }
                                    case "N":{
                                        jugar = "S";
                                        reinicio = "R";
                                        menu_principal = 4;
                                        
                                    break;
                                    }
                                }
                            }else{
                                //TRABAJAR AQUI
                                Ganar(tablero);
                                
                                for(int i=0; i<tablero.length;i++){
                                    for(int j=0; j<tablero.length;j++){
                                        if(tablero[i][j] == "[X]"){
                                            cont_ganar++;
                                        }
                                    }
                                }
        
                            /*if(cont==cant){
                                    System.out.println("FELICIDADES!! GANO :D");
                            }*/
                                
                                
                                
                                //cont_ganar++;
                                
                                if(cont_ganar==minas){
                                System.out.println("Desea seguir jugando Y/N");
                                jugar = po.nextLine();
                                
                                switch(jugar){
                                    case "Y":{
                                        jugar = "S";
                                        reinicio = "R";
                                    break;
                                    }
                                    case "N":{
                                        jugar = "S";
                                        reinicio = "R";
                                        menu_principal = 4;
                                        
                                    break;
                                    }
                                }
                               }  
                            }//ELSE
                        }//FIN IF/ELSE
                        
                        
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
                }//FIN SWTICH "V"
                
                case "R":{
                    jugar = "S";
                    
                break;
                }
                
                case "S":{
                    jugar = "S";
                    reinicio = "R";
                break;
                }
                
            }//FIN SWITCH JUGAR
            }while(jugar != "S");//PARA SALIR
         }//while(reinicio != "R");
            
        }while(menu_principal != 4); //CICLO PARA EL MENU PRINCIPAL
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
    
    
    //METODO PARA JUGAR
    public static void Jugar(int fil, int col, String[][] tab1, String[][] tab2){
        
        //int cont=0;
        
           if(tab1[fil-1][col-1] == "[X]" ){
               if(tab2[fil-1][col-1] == " * "){
                   tab1[fil-1][col-1] = " * ";
                   
                   System.out.println("Solucion");
                   Solucion(tab1, tab2);
                   Mostrar(tab1);
                   System.out.println(" ");
                   System.out.println(" ");
                   System.out.println("BOOM!!  PERDIO :'( - WASTED!!!");
                   
               }else{
                   Num_bombas(fil, col, tab1, tab2);
               
               }
           }else{
               System.out.println("ELIJA OTRA POSICION QUE NO HAYA SIDO VOLTEADA");
               System.out.println(" ");
           }
    }//FIN METODO PARA JUGAR
    
    //METODO PARA CANT. BOMBAS
    public static void Num_bombas(int fil, int col, String[][] tab1, String[][] tab2){
        int cont=0;
        
        for(int filas=2; filas>-1 ;filas--){        //2,1,0
            for(int columnas=2; columnas>-1 ;columnas--){
        
            try
            {   
            if(tab2[fil-filas][col-columnas] == " * "){  
            
            }else{
                cont=0;    
                for(int i=1; i>-2;i--){   //1,0,-1
                    for(int j=1; j>-2 ;j--){
                  if( (fil-filas-i)>=0 && (col-columnas-j>=0) && fil<=tab2.length && col<=tab2.length ){
                    try{ 
                    if(tab2[fil-filas-i][col-columnas-j] == " * "){
                         cont++;
                     }
                    }catch(Exception e){
                     }
                  }
               }//SEGUNDO FOR
             }//PRIMER FOR
                tab1[fil-filas][col-columnas] = " "+cont+" "; //POSICION SELECCIONADA
             }//ELSE
            }catch(Exception e){
                     }
        
           }//SEGUNDO GRAN FOR
        }//PRIMER GRAN FOR
     }//FIN METODO PARA CANT. BOMBAS
    
    //METODO PARA GANAR
    public static void Ganar(String[][] juego){
        int cant=0, cont=0;
        
        if(juego.length==4){
            cant=4;
        }else if(juego.length==6){
            cant=8;
        }else{
            cant=12;
        }
        
        for(int i=0; i<juego.length;i++){
            for(int j=0; j<juego.length;j++){
                if(juego[i][j] == "[X]"){
                    cont++;
                }
            }
        }
        
        if(cont==cant){
            System.out.println("FELICIDADES!! GANO :D");
        }
        
        
    }//FIN METODO PARA GANAR
    
   public static void Solucion(String[][] tab1, String[][] tab2){
        int cont=0;
        //int fil=2;
        //int col=2;
        
        for(int fil=1; fil<=tab2.length ;fil++){
                    for(int col=1; col<=tab2.length ;col++){
        
        for(int filas=2; filas>-1 ;filas--){        //2,1,0
            for(int columnas=2; columnas>-1 ;columnas--){
        
            
            try
            {   
            if(tab2[fil-filas][col-columnas] == " * "){  
            
            }else{
                cont=0;    
                
                
                for(int i=1; i>-2;i--){   //1,0,-1
                    for(int j=1; j>-2 ;j--){
                  if( (fil-filas-i)>=0 && (col-columnas-j>=0) && fil<=tab2.length && col<=tab2.length ){
                    try{ 
                    if(tab2[fil-filas-i][col-columnas-j] == " * "){
                         cont++;
                     }
                    }catch(Exception e){
                     }
                  }
               }//SEGUNDO FOR
             }//PRIMER FOR
                tab1[fil-filas][col-columnas] = " "+cont+" "; //POSICION SELECCIONADA
             }//ELSE
            }catch(Exception e){
                     }
                }
            }
           }//SEGUNDO GRAN FOR
        }//PRIMER GRAN FOR
        
     }//FIN METODO PARA CANT. BOMBAS
    
}//FIN PROGRAMA
