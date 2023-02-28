/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prog25;

/**
 *
 * @author yoelzr
 */
public class Main {
    public static void main(String [] args){
        GestionarHilos gh = new GestionarHilos();
        
        Thread pim = new Hilo_Pim(gh);
        Thread pam = new Hilo_Pam(gh);
        Thread pum = new Hilo_Pum(gh);
        
        pim.start();
        pam.start();
        pum.start();
    }
}
