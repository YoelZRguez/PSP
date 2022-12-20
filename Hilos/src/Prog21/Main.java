/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prog21;

import java.util.Scanner;

/**
 *
 * @author yoelzr
 */
public class Main {
    Scanner sc;
    
    
    
    public Main(){
        sc = new Scanner(System.in);
        
    }
    
    private void menu(){
        System.out.println("----------------------------------------------------");
        System.out.println("Introduce la opción que desees ejecutar: "
                + "\n1. Crear hilo (Extends Thread)"
                + "\n2. Crear hilo (Implements Runnable)"
                + "\n3. Crear 4 hilos (2 de cada tipo)"
                + "\n0. Salir");
        System.out.println("----------------------------------------------------");
        System.out.print("> ");
        
    }
    
    private int procesarOpcion(){
        int opcion = Integer.parseInt(sc.nextLine());
        return opcion;
    }
    
    
    private void ejecutarOpcion(int opcion){
        switch(opcion){
            case 1: 
                crearHiloThread();
                break;
                
            case 2: 
                crearHiloRunnable();
                break;
                
            case 3: 
                crearHilosMultiples();
                break;
                
            case 0: 
                System.out.println("Saliendo del programa...");
                break;
                
            default: 
                System.out.println("¡Opción no válida!");
                break;
        }
    }
    
    
    private void crearHiloThread(){
        String cadena;
        System.out.println("Introduce la cadena que quieres que se repita: ");
        cadena = sc.nextLine();
        
        
        Thread hilo = new Hilo_Thread(cadena);
        hilo.start();
        
        try {
            hilo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
    
    private void crearHiloRunnable(){
        String cadena;
        System.out.println("Introduce la cadena que quieres que se repita: ");
        cadena = sc.nextLine();
        
        Thread hilo = new Thread (new Hilo_Runnable(cadena));
        
        hilo.start();
        
        try {
            hilo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
    
    
    private void crearHilosMultiples(){
        String cadena, cadena2, cadena3, cadena4;
        
        System.out.println("Introduce la cadena para el primer hilo(Thread): ");
        cadena = sc.nextLine();
        
        System.out.println("Introduce la cadena para el segundo hilo(Thread): ");
        cadena2 = sc.nextLine();
        
        System.out.println("Introduce la cadena para el tercer hilo(Runnable): ");
        cadena3 = sc.nextLine();
        
        System.out.println("Introduce la cadena para el cuarto hilo(Runnable): ");
        cadena4 = sc.nextLine();
        
        Thread hilo = new Hilo_Thread(cadena);
        Thread hilo2 = new Hilo_Thread(cadena2);
        Thread hilo3 = new Thread (new Hilo_Runnable(cadena3));
        Thread hilo4 = new Thread (new Hilo_Runnable(cadena4));
        
        hilo.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        
        try{
         hilo.join();
         hilo2.join();
         hilo3.join();
         hilo4.join();
         
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        
        
    }
    
    
    private void iniciarPrograma(){
        int opcion;
        System.out.println("Bienvenido al Programa 2.1.");
        do{
        menu();
        opcion = procesarOpcion();
        ejecutarOpcion(opcion);
    
        }while(opcion!=0);
    }
    
    
    public static void main(String[] args){
            Main m = new Main();
            m.iniciarPrograma();
    }
}
