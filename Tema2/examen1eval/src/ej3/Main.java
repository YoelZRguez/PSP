/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej3;

import java.util.concurrent.Semaphore;

/**
 *
 * @author yoelzr
 */
public class Main {
    public static void main(String [] args){
        
        
        Semaphore semaforoHoy = new Semaphore(1);
        Semaphore semaforoEstoy = new Semaphore(0);
        Semaphore semaforoTriste = new Semaphore(0);
        Semaphore semaforoContento = new Semaphore(0);
        
        Gestor gh = new Gestor(semaforoHoy, semaforoEstoy, semaforoTriste, semaforoContento);
        
        Thread hoy = new Hilo_Hoy(gh);
        Thread estoy = new Hilo_Estoy(gh);
        Thread triste = new Hilo_Triste(gh);
        Thread contento = new Hilo_Contento(gh);
        
        hoy.start();
        estoy.start();
        triste.start();
        contento.start();
    }
}
