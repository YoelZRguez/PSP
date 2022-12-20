/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prog26;

import Prog25.*;
import java.util.concurrent.Semaphore;

/**
 *
 * @author yoelzr
 */
public class GestionarHilos {
    private Semaphore semaforoPim, semaforoPam, semaforoPum; 

    public GestionarHilos(Semaphore semaforoPim, Semaphore semaforoPam, Semaphore semaforoPum) {
        this.semaforoPim = semaforoPim;
        this.semaforoPam = semaforoPam;
        this.semaforoPum = semaforoPum;
    }

    
    public void pim(){
        try{
            
            semaforoPim.acquire();
            
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("PIM");
        semaforoPam.release();
        
    }
    
    
    public void pam(){
        
        try{
            
            semaforoPam.acquire();
           
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("PAM");
        semaforoPum.release();
        
    }
    
    public void pum(){
        try{
            
            semaforoPum.acquire();
            
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("PUM");
        semaforoPim.release();
        
    }
}
