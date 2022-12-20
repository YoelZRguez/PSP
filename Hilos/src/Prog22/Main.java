/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prog22;

/**
 *
 * @author yoelzr
 */
public class Main {
    public static void main(String [] args){
        GestionarHilos gh = new GestionarHilos();
        
        Thread panadero = new Hilos_Panadero(gh);
        Thread ventas = new HilosVenta(gh);
        
        panadero.start();
        ventas.start();
    }
}
