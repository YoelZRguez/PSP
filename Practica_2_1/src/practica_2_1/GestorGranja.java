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
    private int tiempoAyer, tiempo;   

    public GestorGranja(Semaphore semaforoGallinas, Semaphore semaforoGranjero) {
        this.semaforoGallinas = semaforoGallinas;
        this.semaforoGranjero = semaforoGranjero;
        this.huevosRotos = huevosRotos;
        this.nHuevos = nHuevos;
        this.tiempoAyer = tiempoAyer;
        this.tiempo = tiempo;
    }
    
    public void ponerHuevos(){
        
        try {
            System.out.println("---------------------------------------------------");
            semaforoGallinas.acquire();
            System.out.println("Día "+i);
            for(int j = 1; j<=5; j++){
                
                tiempo = (int) (Math.random()*24);
                
                romperHuevo(tiempoAyer, tiempo);
                tiempoAyer = tiempo;
                System.out.println("Gallina "+j+"\nHora de la ponida: "+tiempo+":00");
                
                
            }
            
            
            System.out.println("---------------------------------------------------");

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        i++;
        semaforoGranjero.release();
        
    }
    
    public void recogerHuevos(){
        try {
            semaforoGranjero.acquire();
            System.out.println("---------------------------------------------------");
            System.out.println("¡Se recogen los huevos!");
            System.out.println("Huevos recogidos: "+nHuevos);
            System.out.println("Huevos perdidos: "+huevosRotos);
            Thread.sleep(24);
        } catch (InterruptedException ex) {
            ex.getStackTrace();
        }
        
        semaforoGallinas.release();
        
    }
    
    public void romperHuevo(int tiempoAyer, int tiempo){
        int tDiferencia = 24-tiempoAyer;
        
        
    if(i == 1 && tiempo <12){
            nHuevos++;
        
    }else if(i == 1 && tiempo > 12 ){
           
    }else{

        if(tiempo > tDiferencia && tiempo < (tDiferencia+12)){
            huevosRotos++;


        }else{
            nHuevos++;
            
        }
        
    }
        
       
        
    }
    
    
}
