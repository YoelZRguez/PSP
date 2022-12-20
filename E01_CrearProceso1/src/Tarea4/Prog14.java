/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
Crear un programa en Java (usando OO) con las siguientes opciones:
1.Crear proceso. [pidiendo datos a usuario]
2.Listar procesos. [mostrando todos los datos]
3.Cerrar proceso. [mostrando solo nombres]
0. Salir.
–
Proceso > nombre + comando + pid.
–
Usando: lista de procesos.
 */
public class Prog14 {
    //Iniciamos valores absolutos para el programa
        private Scanner sc;
        private Runtime rt;
        
        //Iniciamos arrayList
        ArrayList <Proceso> procesos = new ArrayList<Proceso>();
        
        public Prog14(){
        sc = new Scanner (System.in);
        rt = Runtime.getRuntime();
    }
        
        //Creamos proceso pidiendo nombre de proceso y comando!
        private void crearProceso(){
        String nombre, comando;
        
            System.out.print("Introduce el nombre del proceso: ");
            nombre = sc.nextLine();
            System.out.print("Introduce el comando del proceso: ");
            comando = sc.nextLine();
        
        //Creamos objeto proceso para guardar las variables
        try{
            
                Process p2 = rt.exec(comando);
                Proceso p = new Proceso(nombre, comando, p2.pid());
                p.setPid(p2.pid());
                procesos.add(p);
            }catch(IOException e){
                e.printStackTrace();
            }
  
        }
        
        //Creamos la lista de los procesos creados!
        private void listarProceso(){
            for (Proceso p : procesos) {
                System.out.println("Nombre Proceso: "+p.getNombre()+""
                        + "\nNombre de comando: "+p.getComando()+""
                        + "\nPID: "+p.getPid());
            }
        }
        
        
        //Cerramos el proceso indicado por teclado
        private void cerrarProceso(){
            String nombre; 
            for (Proceso p : procesos) {
                System.out.println("Nombre Proceso: "+p.getNombre());
            }
            
            System.out.print("Introduce el nombre del proceso que quieres cerrar: ");
            nombre = sc.nextLine();
            
        //Recorremos arrayList para buscar el proceso que debemos cerrar    
        try{
            for (Proceso p : procesos){
                if (nombre.compareTo(p.getNombre()) == 0){
                    rt.exec("taskkill /pid "+p.getPid());
                    for (int i = 0; i<procesos.size(); i++){
                        if (procesos.get(i).getPid() == p.getPid()){
                            procesos.remove(i);
                        }
                    }
                }else{
                    System.out.println("Nombre de proceso no existente!");
                }
            }
            
        }catch(IOException e){
            e.printStackTrace();
            }
        }
        
    //Iniciamos programa
    private void iniciarPrograma(){
        
        int opcion = 0;
        System.out.println("Bienvenido al programa 1.4!");
        do{
            menu();
            opcion = elegirOpcion();
            procesarOpcion(opcion);
            
        }while(opcion!= 0);
    }
    
    //Creación de menú
    private void menu (){
        System.out.println("---------------------------------------------------");
        System.out.println("Menú de opciones: "
                + "\nIntroduzca la opción que desee ejecutar: "
                + "\n1. Crear Proceso. "
                + "\n2. Listar Procesos. "
                + "\n3. Cerrar Proceso. "
                + "\n0. Salir. ");
        System.out.println("---------------------------------------------------");
    }
    
    
    //Inicializamos opción y guardamos valor introducido por teclado
    private int elegirOpcion(){
        int opcion = Integer.parseInt(sc.nextLine());
        return opcion;
    }
    
    
    //Procesamos opción y ejecutamos el método en consecuencia
    private void procesarOpcion(int opcion){
        switch(opcion){
            case 1: 
                crearProceso();
                break;
                
            case 2: 
                listarProceso();
                break;
                
            case 3: 
                cerrarProceso();
                break;
                
            case 0: 
                System.out.println("Saliendo del programa...");
                break;
                
            default: 
                System.out.println("Opción no válida!");
                break;
        }
    }
    
    //Iniciamos el main
    public static void main(String [] args){
        Prog14 pr = new Prog14();
        pr.iniciarPrograma();
    
    }
    
    
    
}
