/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author yoelzr
 */
public class Main {
   
    //Iniciamos valores absolutos para el programa
        private Scanner sc;
        private Runtime rt;
        
        
        //Iniciamos arrayList
        private ArrayList <Proceso> procesos = new ArrayList<Proceso>();
        
        public Main(){
        sc = new Scanner (System.in);
        rt = Runtime.getRuntime();
        
    }
        
        
        private void crearProceso(){
        String descripcion, comando;
        int tipo=0;
        
            System.out.print("Introduce el comando del proceso: ");
            comando = sc.nextLine();
            
            System.out.print("Introduce su descripción: ");
            descripcion = sc.nextLine();
            
            do{
            System.out.println("Selecciona un tipo: "
                    + "\n1 - Proceso del sistema operativo"
                    + "\n2 - Proceso externo");
            tipo = Integer.parseInt(sc.nextLine());
            
            }while(tipo !=1 && tipo!=2);
            
            System.out.println("Proceso creado correctamente y añadido a la lista");
            
        
        try{
            
                Process p2 = rt.exec(comando);
                Proceso p = new Proceso(comando,descripcion,tipo, p2.pid());
                p.setPid(p2.pid());
                procesos.add(p);
            }catch(IOException e){
                e.printStackTrace();
            }
  
        
        
        }
        
        private void gestionarProceso(){
            System.out.println(">> Menú secundario <<"
                    + "\n1 - Listar Procesos"
                    + "\n2 - Borrar proceso"
                    + "\n0 - Volver al menú principal");
            
            int gestion = Integer.parseInt(sc.nextLine());
            procesarGestion(gestion);
        }
        
        private void procesarGestion(int gestion){
            switch(gestion){
                case 1: 
                    listarProceso();
                    break;
                    
                case 2: 
                    cerrarProceso();
                    break;
                    
                case 0: 
                    menu();
                    break;
                    
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
        
        
        
        //Creamos la lista de los procesos creados!
        private void listarProceso(){
            int i=1;
            for (Proceso p : procesos) {
                System.out.println("Proceso "+i+" > Proceso "
                + "[Comando = "+p.getComando()+", "
                + "Descripcion = "+p.getDescripcion()+", "
                + "tipo = "+p.getTipo()+", "
                + "PID = "+p.getPid()+"]");
                i++;
            }
        }
        
        
        //Cerramos el proceso indicado por teclado
        private void cerrarProceso(){
            
            int i=0;
            long PID[] = new long[procesos.size()];
            for (Proceso p : procesos) {
                System.out.println("Proceso "+(i+1)+" > Proceso "
                + "[Comando = "+p.getComando()+", "
                + "Descripcion = "+p.getDescripcion()+", "
                + "tipo = "+p.getTipo()+", "
                + "PID = "+p.getPid()+"]");
                
                PID[i] = p.getPid();
                i++;
            }
            
            System.out.print("Introduce el número del proceso que quieres cerrar: ");
            int borrar = Integer.parseInt(sc.nextLine());
            
            Proceso pb = procesos.get(borrar-1);
            try{
                String[] comando2 = {"taskkill /pid "};
                rt.exec(comando2[0]+pb.getPid());
            }catch(IOException e){
                e.printStackTrace();
            }
            procesos.remove(borrar-1);
            
            System.out.println("Proceso cerrado correctamente y borrado de la lista");
        }
            
        

        private void menu(){
            System.out.println(">> Menú Principal <<");
            System.out.println("1 - Crear Proceso"
                    + "\n2 - Gestionar Procesos"
                    + "\n0 - Salir");
            System.out.print("> ");
            
        }
        
        private int procesarOpcion(){
            int opcion = Integer.parseInt(sc.nextLine());
            return opcion;
        }
        
        private void ejecutarOpcion(int opcion){
            switch(opcion){
                case 1: 
                    crearProceso();
                    break;
                    
                case 2: 
                    gestionarProceso();
                    break;
                    
                case 0: 
                    System.out.println("Finalizando el programa");
                    break;
                    
                default: 
                    System.out.println("¡Opción no válida!");
                    break;
            }
        }
        
        private void iniciarPrograma(){
            int opcion = 0;
            System.out.println(">>Bienvenid@ al ejercicio 1<<");
            do{
            menu();
            opcion = procesarOpcion();
            ejecutarOpcion(opcion);
            }while(opcion!=0);
            
        }
        
        public static void main(String [] args){
            Main m = new Main();
            m.iniciarPrograma();
        }
}
