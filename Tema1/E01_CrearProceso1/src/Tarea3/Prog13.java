/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea3;

import java.util.Scanner;

/**
Crear un programa en Java con las siguientes opciones:
1.
Abrir bloc de notas + mostrar mensaje “Aplicación cerrada con éxito” al cerrarla.
2.
Ejecutar comando ipconfig + mostrar resultado.
3.
Pedir comando a ejecutar (usuario) + mostrar resultado.
0. Salir.
 */
public class Prog13 {
    Metodos_F metodo = new Metodos_F();
    Scanner sc = new Scanner (System.in);
    
    
    public static void main (String [] args){
        Prog13 obj = new Prog13();
        obj.iniciarPrograma();
    }
    
    public void iniciarPrograma(){
        int opcion = 0;
        do{
            menu();
            opcion = elegirOpcion();
            procesar(opcion);
            
        }while(opcion != 0);
        
    }
    
    public void menu(){
            int opcion; 
        
                System.out.println("--------------------------------------------------------------------");
                System.out.println("Menú de opciones: "
                + "\n1. Abrir bloc de notas + mostrar mensaje 'Aplicación Cerrada con éxito' al cerrarla"
                + "\n2. Ejecutar comando ipconfig + mostrar resultado"
                + "\n3. Pedir comando a ejecutar (usuario) + mostrar resultado"
                + "\n0. Salir");
                System.out.println("--------------------------------------------------------------------");
                System.out.print("> ");    
    }
    
    public int elegirOpcion(){
        int opcion = Integer.parseInt(sc.nextLine());
        return opcion;
    }

    public void procesar (int opcion){
            switch(opcion){
        
                case 1: 
                metodo.abrirBloc();
                break;

                case 2: 
                metodo.ipConfig();
                break;
                        
                case 3: 
                metodo.cmdTeclado();
                break;
            
                case 0: 
                System.out.println("Saliendo del menú...");
                break;
            
                default: 
                System.out.println("Opción no valida...");
                break;
            }
        }
        
    }

