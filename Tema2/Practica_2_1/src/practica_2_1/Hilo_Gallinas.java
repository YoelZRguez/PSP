/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica_2_1;

/**
 *
 * @author yoelzr
 */
public class Hilo_Gallinas extends Thread {
    private GestorGranja gg;
    

    public Hilo_Gallinas(GestorGranja gg) {
        this.gg = gg;
        
    }
    
    public void run(){
        for(int i = 0; i<30; i++){
               gg.ponerHuevos();
        }
        
        
    }
}
