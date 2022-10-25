/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica_1_1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author yoelzr
 */
public class Practica_1_1 {
    //Inicializamos variables globales, incluido el ArrayList donde guardaremos los procesos
    //Además, creamos un objeto de la clase Proceso
        private Scanner sc;
        private Runtime rt;
        private Proceso p;
        ArrayList <Proceso> procesos = new ArrayList <Proceso>();
        
        //Creamos constructor de la clase
        public Practica_1_1(){
            sc = new Scanner (System.in);
            rt = Runtime.getRuntime();
        }
       
        //Clase pedir comando donde retornamos el comando del proceso
        private String pedirComando(){
            System.out.println("Introduce el comando del proceso que desea crear: ");
            String comando = sc.nextLine();
            return comando;
        }
        
        //Creamos el proceso pedido anteriormente y lo añadimos al ArrayList
        private void crearProceso(String comando){
            try{
                Process p = rt.exec(comando);
                Proceso p2 = new Proceso (comando, p.pid());
                
                p2.setPid(p.pid());
                procesos.add(p2);
                System.out.println("¡Proceso creado con éxito!");
                System.out.println("");
                
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        
        
        //Mostramos la lista de procesos creados
        private void listarProcesos(){
            for (int i = 0; i<procesos.size(); i++){
                System.out.println("Proceso "+(i)+"\t"+procesos.get(i).toString());
                
            }
        }
        
        
        //Cerramos el proceso pedido por consola
        private void cerrarProceso(){
                int opcion;
                System.out.println("");
                System.out.println("Introduzca el numero del proceso que quiere cerrar: ");
                opcion = Integer.parseInt(sc.nextLine());
        
                try{
                    for (int i = 0; i<procesos.size(); i++){
                        if (opcion == i){
                            long pid = procesos.get(opcion).getPid(); //inicializamos variable para guardar el PID que borraremos
                            rt.exec("taskkill /pid "+pid);
                            procesos.remove(i);
                        } 
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
        }
        
        //Inicializamos programa con dos bucles while para controlar la cantidad
        //de veces que queremos ejecutar cada parte
        private void iniciarPrograma(){
            int i = 0;
            String comando;
            
            System.out.println("Bienvenid@ a la Practica 1.1");
            while(i<2){
                comando = pedirComando();
                crearProceso(comando);
                i++;
            }
            while(!procesos.isEmpty()){
                listarProcesos();
                cerrarProceso();
            }
            System.out.println("Fin de la Practica 1.1");
        }
             
        
    //Ejecutamos el programa
    public static void main(String[] args) {
        Practica_1_1 pr = new Practica_1_1();
        pr.iniciarPrograma();
    }
    
}
