/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica_21_Restaurante;

import java.util.concurrent.Semaphore;

/**
 *
 * @author yoelzr
 */
public class Main {
    
    public static void main(String [] args){
        
        Semaphore semaforoBarista = new Semaphore(1);
        Semaphore semaforoCliente = new Semaphore(0);
        
        PuntoVenta pdv = new PuntoVenta(semaforoBarista, semaforoCliente);
        
            Thread barista = new Hilo_Barista(pdv);
            barista.start();
        
        for(int i = 1; i<=20; i++){
            new Hilo_Cliente("Cliente "+i, pdv).start();
        }
        

    }
}
