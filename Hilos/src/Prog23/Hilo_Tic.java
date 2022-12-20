/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prog23;

/**
 *
 * @author yoelzr
 */
public class Hilo_Tic extends Thread {
    private GestionarHilos gh = new GestionarHilos();
    
    public Hilo_Tic(GestionarHilos gh){
        this.gh = gh;
    }
    
    public void run (){
        for (int i = 0; i<200; i++){
            gh.tic();
        }
    }
}

