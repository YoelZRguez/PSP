/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica_2_1;



/**
 *
 * @author yoelzr
 */
public class Hilo_Granjero extends Thread {
        private GestorGranja gg;

    public Hilo_Granjero(GestorGranja gg) {
        this.gg = gg;
    }
        
        public void run(){
            try {
                Thread.sleep(12);
                for (int i = 0; i<30; i++){
                gg.recogerHuevos();
            }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            
            System.out.println("---------------------------------------------------");
            System.out.println("¡MES COMPLETADO!");
        }
}
