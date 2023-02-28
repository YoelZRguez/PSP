/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prog22;

/**
 *
 * @author yoelzr
 */
public class HilosVenta extends Thread{
    private GestionarHilos gh;
    
    public HilosVenta(GestionarHilos gh){
        this.gh = gh;
    }
    
    public void run(){
        for (int i = 0; i<50; i++){
            gh.venta();
        }
    }
}
