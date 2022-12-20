/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prog24;

import java.util.concurrent.Semaphore;


/**
 *
 * @author yoelzr
 */
public class GestionarHilos {
     private Semaphore tic, tac;
     
     public GestionarHilos(Semaphore tic, Semaphore tac){
         this.tic = tic ;
         this.tac = tac;
     }
    
    public void tic(){
        try{
            tic.acquire();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("TIC");
        
        tac.release();
    
    }
    
    public void tac(){
        try{
            tac.acquire();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("TAC");
        
        tic.release();
    
    }
}
