/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prog26;
import java.util.concurrent.Semaphore;

/**
 *
 * @author yoelzr
 */
public class Main {
    public static void main(String [] args){
        
        Semaphore semaforoPim = new Semaphore(1);
        Semaphore semaforoPam = new Semaphore(0);
        Semaphore semaforoPum = new Semaphore(0);
        
        GestionarHilos gh = new GestionarHilos(semaforoPim, semaforoPam, semaforoPum);
        
        Thread pim = new Hilo_Pim(gh);
        Thread pam = new Hilo_Pam(gh);
        Thread pum = new Hilo_Pum(gh);
        
        pim.start();
        pam.start();
        pum.start();
    }
}
