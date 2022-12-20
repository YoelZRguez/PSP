/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ej3;

import java.util.concurrent.Semaphore;

/**
 *
 * @author yoelzr
 */
public class Gestor {

    /**
     * @param args the command line arguments
     */
  private Semaphore semaforoHoy, semaforoEstoy, semaforoTriste, semaforoContento;
  private int contador = 2;

    public Gestor(Semaphore semaforoHoy, Semaphore semaforoEstoy, Semaphore semaforoTriste, Semaphore semaforoContento) {
        this.semaforoHoy = semaforoHoy;
        this.semaforoEstoy = semaforoEstoy;
        this.semaforoTriste = semaforoTriste;
        this.semaforoContento = semaforoContento;
    }

    
    public void hoy(){
        try{
            
            semaforoHoy.acquire();
            
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Hoy");
        semaforoEstoy.release();
        
    }
    
    
    public void estoy(){
        
        try{
            
            semaforoEstoy.acquire();
           
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("estoy");
        
        if(contador%2 == 0){
           semaforoContento.release(); 
        }else{
            semaforoTriste.release();
        }
        contador++;
        
        
    }
    
    public void triste(){
        try{
            
            semaforoTriste.acquire();
            
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("triste");
        semaforoHoy.release();
        
    }
    
    public void contento(){
        try{
            
            semaforoContento.acquire();
            
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("contento");
        semaforoHoy.release();
        
    }
}
