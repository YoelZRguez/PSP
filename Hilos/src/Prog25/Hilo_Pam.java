/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prog25;

/**
 *
 * @author yoelzr
 */
public class Hilo_Pam extends Thread {
        
    private GestionarHilos gh = new GestionarHilos();
    
    public Hilo_Pam(GestionarHilos gh){
        this.gh = gh;
    }
    
    public void run(){
        for (int i = 0; i<50; i++){
            gh.pam();
        }
    }
}

