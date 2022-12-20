/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej3;

/**
 *
 * @author yoelzr
 */
public class Hilo_Contento extends Thread {
private Gestor gh;
    
    public Hilo_Contento(Gestor gh){
        this.gh = gh;
    }
    
    public void run(){
        for (int i = 0; i<25; i++){
            gh.contento();
        }
    }
}
