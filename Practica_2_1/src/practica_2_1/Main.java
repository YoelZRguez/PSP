/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica_2_1;

import java.util.concurrent.Semaphore;

/**
 *
 * @author yoelzr
 */
public class Main {
           
    
    public static void main(String[] args) {
           Semaphore semaforoGallina = new Semaphore(1);
           Semaphore semaforoGranjero = new Semaphore(0);
           GestorGranja gg = new GestorGranja(semaforoGallina, semaforoGranjero);
           
                        
                System.out.println("Bienvenido a la Práctica 2.1");
                Thread gallinas = new Hilo_Gallinas(gg);
                Thread granjero = new HiloGranjero(gg);
                
                
                
                gallinas.start();
                granjero.start();
              
                
    }
    
}
