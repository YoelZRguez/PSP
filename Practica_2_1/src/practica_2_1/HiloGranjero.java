/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica_2_1;



/**
 *
 * @author yoelzr
 */
public class HiloGranjero extends Thread {
        private GestorGranja gestor;

    public HiloGranjero(GestorGranja gestor) {
        this.gestor = gestor;
    }
        
        public void run(){
            try {
                Thread.sleep(12);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            for (int i = 0; i<30; i++){
                gestor.recogerHuevos();
            }
        }
}
