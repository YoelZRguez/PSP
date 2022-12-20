/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prog22;

/**
 *
 * @author yoelzr
 */
public class GestionarHilos {
    private int contador = 0;
    
    public synchronized void panadero(){
        while(contador != 0){
            try {
              wait();  
            } catch (InterruptedException e) {
            }

        }
            System.out.println("-------------------------------------------------");
            System.out.println("¡Barras de pan realizadas!");
            contador+=2;
            System.out.println("Ahora mismo hay "+contador+" barras de pan");
            System.out.println("-------------------------------------------------");
            notify();
    }
    
    public  synchronized void venta(){
        while(contador == 0){
            try{
                wait();
            }catch(InterruptedException e){
            }
        }
        System.out.println("-------------------------------------------------");
            System.out.println("Barras de pan: "+contador);
            contador--;
            System.out.println("Barra de pan vendida! \n"+contador+" barras restantes");
            notify();
        System.out.println("-------------------------------------------------");
        
        
    }
}
