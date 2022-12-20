/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej4;


/**
 *
 * @author yoelzr
 */
public class Hilo_Cliente extends Thread {

    private PuntoVenta pdv;
    private String nombre;
    
    public Hilo_Cliente(String nombre, PuntoVenta pdv){
        this.nombre = nombre;
        this.pdv = pdv;
    }
    
        public void run(){
            
                pdv.tomarCafe(nombre);
            
            
        }
}
