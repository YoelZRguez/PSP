/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica_2_1;

import java.util.concurrent.Semaphore;


/**
 *
 * @author yoelzr
 */
public class GestorGranja {
    private Semaphore semaforoGranjero;
    private Semaphore semaforoGallinas;
    private GestorGranja gestor;
    private int huevosRotos = 0;
    private int nHuevos = 0;
    private int i = 1;
    private int w = 1;

    public GestorGranja(Semaphore semaforoGallinas, Semaphore semaforoGranjero) {
        this.semaforoGranjero = semaforoGranjero;
        this.semaforoGallinas = semaforoGallinas;
        this.huevosRotos = huevosRotos;
        this.nHuevos = nHuevos;
    }
    
    
    
    public void recogerHuevos(){
        try {
            semaforoGranjero.acquire();
            System.out.println("¡Se recogen los huevos!");
            System.out.println("Huevos recogidos: "+nHuevos);
            System.out.println("Huevos perdidos: "+huevosRotos);
            Thread.sleep(24);
        } catch (InterruptedException ex) {
            ex.getStackTrace();
        }
        
        semaforoGallinas.release();
        
    }
    
    public void ponerHuevos(){
        w=1;
        try {
            System.out.println("---------------------------------------------------");
            System.out.println("Día "+i);
            semaforoGallinas.acquire();
            
            for(int j = 1; j<=5; j++){
                int tiempo = (int) (Math.random()*24);
                System.out.println("Gallina "+w+"\nHora de la ponida: "+tiempo+":00");
            
                if(tiempo <=12){
                nHuevos++;
                }else{
                huevosRotos++;
                }
                
            w++;
            }
            System.out.println("---------------------------------------------------");
            
            
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        i++;
        semaforoGranjero.release();
        
    }
}
