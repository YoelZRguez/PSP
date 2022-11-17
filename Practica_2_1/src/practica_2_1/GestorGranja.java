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
    private int dia = 1;
    private int tiempo;
    int horaAyer[] = new int [5];
    int horaHoy[] = new int [5];

    public GestorGranja(Semaphore semaforoGallinas, Semaphore semaforoGranjero) {
        this.semaforoGallinas = semaforoGallinas;
        this.semaforoGranjero = semaforoGranjero;
        this.huevosRotos = huevosRotos;
        this.nHuevos = nHuevos;
        this.tiempo = tiempo;
        this.horaAyer = horaAyer;
        this.horaHoy = horaHoy;
    }
    
    public void ponerHuevos(){
        
        try {
            System.out.println("---------------------------------------------------");
            semaforoGallinas.acquire();
            System.out.println("Día "+dia);
            for(int j = 0; j<5; j++){
                
                tiempo = (int) (Math.random()*24);
                
                System.out.println("Gallina "+(j+1)+"\nHora de la ponida: "+tiempo+":00");
                horaHoy[j] = tiempo;
            }
            
            System.out.println("---------------------------------------------------");

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        romperHuevo();
        dia++;
        semaforoGranjero.release();
        
    }
    
    public void recogerHuevos(){
        try {
            semaforoGranjero.acquire();
            System.out.println("---------------------------------------------------");
            System.out.println("¡Se recogen los huevos!");
            System.out.println("Huevos recogidos: "+nHuevos);
            System.out.println("Huevos perdidos: "+huevosRotos);
            System.out.println("---------------------------------------------------");
            Thread.sleep(24);
        } catch (InterruptedException ex) {
            ex.getStackTrace();
        }
        
        semaforoGallinas.release();
        
    }
    
    public void romperHuevo(){
        
        switch(dia){
            case 1: 
                for(int j = 0; j<5; j++ ){
                   if(horaHoy[j] <= 12){
                       nHuevos++;
                       
                   }else{
                       if(horaHoy[j]>12){
                           
                       }
                   }
                horaAyer[j] = horaHoy[j];   
                }
                
                break;
                
                
                
            default: 
                
                for(int j = 0; j<5; j++ ){
                   if(horaAyer[j]>12){
                       if(horaHoy[j] <= 12){
                          huevosRotos++;
                          nHuevos++; 
                          
                       }else if(horaHoy[j] >12){
                          nHuevos++; 
                       }

                    }else if(horaAyer[j]<=12){
                        if(horaHoy[j] <=12){
                            nHuevos++;
                            
                        }else if(horaHoy[j]>12){
                            
                        }
                        
                    }
                    horaAyer[j] = horaHoy[j];
                }
                break;
                
                
            case 30: 
                for(int j = 0; j<5; j++ ){
                   if(horaHoy[j] > 12){
                       if(horaAyer[j] > 12){
                          nHuevos++;
                          
                       }else if(horaAyer[j] <= 12){
                           
                       }
                       
                   }else if(horaHoy[j] <= 12){
                       if(horaAyer[j] <=12){
                           nHuevos++;
                           
                       }else if(horaAyer[j] > 12){
                           huevosRotos++;
                           nHuevos++;
                       }
                   }
                 
                }
                break;
                
            
        }

        
       
        
    }
    
    
}
