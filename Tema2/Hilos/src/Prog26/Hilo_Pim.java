/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prog26;


/**
 *
 * @author yoelzr
 */
public class Hilo_Pim extends Thread {
    
    private GestionarHilos gh;
    
    public Hilo_Pim(GestionarHilos gh){
        this.gh = gh;
    }
    
    public void run(){
        for (int i = 0; i<50; i++){
            gh.pim();
        }
    }
}
