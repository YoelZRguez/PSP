/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prog21;

/**
 *
 * @author yoelzr
 */
public class Hilo_Thread extends Thread {
    private String cadena; 
    
    
    public Hilo_Thread(String cadena){
        this.cadena = cadena;
    }
    
    
    public void run(){
        for (int i = 0; i<100; i++){
            System.out.println(cadena);
        }
    }
}
