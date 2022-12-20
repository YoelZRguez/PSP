/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prog25;

/**
 *
 * @author yoelzr
 */
public class GestionarHilos {
    private int contador = 0;
    
    public synchronized void pim(){
        
        while(contador != 0){
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }

        }
            System.out.println("PIM");
            contador++;
            notifyAll();
    }
    
    
    public synchronized void pam(){
        
        while(contador != 1){
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }

        }
            System.out.println("PAM");
            contador++;
            notifyAll();
    }
    
    public synchronized void pum(){
        
        while(contador != 2){
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }

        }
            System.out.println("PUM");
            contador = 0;
            notifyAll();
    }
}
