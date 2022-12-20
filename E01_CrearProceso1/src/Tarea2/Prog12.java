/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea2;

import java.util.Scanner;
import java.io.*;

/*
Crear un programa en Java (usando un proceso global único) con las siguientes
opciones:
1.Crear fichero (nombre + texto).
2.Abrir fichero (programa espera).
3.Abrir fichero (programa no espera).
4.Cerrar fichero.
5.Leer fichero.
0.Salir.
*/
public class Prog12 {
    Scanner sc = new Scanner (System.in);
    Metodos_Ficheros fichero = new Metodos_Ficheros();
    
    public void iniciarPrograma(){
    int opcion = 0;
        do{
            menu();
            opcion = elegirOpcion();
            procesar(opcion);
        }while(opcion != 0);
            
        }
        
        public void menu(){
            System.out.println("------------------------------------------------");
            System.out.println("Menú de Opciones: "
                + "\n1. Crear Fichero (nombre+texto)"
                + "\n2. Abrir fichero (programa espera)"
                + "\n3. Abrir fichero (programa no espera)"
                + "\n4. Cerrar fichero"
                + "\n5. Leer fichero"
                + "\n0. Salir");
            System.out.println("------------------------------------------------");
        }
        
            
      public int elegirOpcion(){
        int opcion = Integer.parseInt(sc.nextLine());
        return opcion;
      }  
        
        public void procesar(int opcion){
            switch (opcion){
                case 1: 
                fichero.crearFichero();
                break;
          
                case 2: 
                fichero.abrirFichero();
                break;
                        
                case 3: 
                fichero.abrirFicheroN();
                break;
                
                case 4 : 
                fichero.cerrarFichero();
                break;

                case 5: 
                fichero.leerFichero();
                break;
                
                case 0: 
                System.out.println("Saliendo del menú...");
                break;
        
                default :
                System.out.println("Opción no válida, vuelva a introducir otra opción...");
                break;
        
        }
        }
          
             
    public static void main (String [] args){
        Prog12 p = new Prog12();      
        p.iniciarPrograma();    
    }
}
