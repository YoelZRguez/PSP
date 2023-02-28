/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prog23;

/**
 *
 * @author yoelzr
 */
public class GestionarHilos {
     private int contador = 0;
    
    public synchronized void tic(){
    
        while(contador != 0){
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }

        }
            System.out.println("TIC");
            contador++;
            notify();
            
    }
    
    public synchronized void tac(){
    
        while(contador == 0){
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }

        }
            System.out.println("TAC");
            contador--;
            notify();
        
    }
}
