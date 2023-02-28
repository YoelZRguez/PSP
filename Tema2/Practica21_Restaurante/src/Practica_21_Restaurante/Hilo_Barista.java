/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica_21_Restaurante;



/**
 *
 * @author yoelzr
 */
public class Hilo_Barista extends Thread {
    private PuntoVenta pdv;
    
    public Hilo_Barista(PuntoVenta pdv){
        this.pdv = pdv;
    }
    
        public void run(){
            for (int i = 1; i<=20; i++){
                pdv.realizarCafes();
            }
        }
}

