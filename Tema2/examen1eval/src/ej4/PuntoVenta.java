/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej4;

import java.util.concurrent.Semaphore;

/**
 *
 * @author yoelzr
 */
public class PuntoVenta {
    
        private Semaphore semaforoCliente;
        private Semaphore semaforoBarista;
        private int cafeLeche = 0, cafeSolo = 0, cafeCortado = 0, cafeAmericano;
        
        public PuntoVenta(Semaphore semaforoBarista, Semaphore semaforoCliente){
            this.semaforoBarista = semaforoBarista;
            this.semaforoCliente = semaforoCliente;
            cafeLeche = 0;
            cafeSolo = 0;
            cafeCortado = 0;
            cafeAmericano = 0;
            
        }
        
        public void realizarCafes(){
            try {
                semaforoBarista.acquire();
                System.out.println("-------------------------------------------");
                int tiempo = (int) (Math.random()*200);
                System.out.println("Tiempo preparando el café: "+tiempo);
                Thread.sleep(tiempo);
                
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            
            rellenar();
            System.out.println("Número cafés solos: "+cafeSolo+""
                    + "\nNúmero cafés con leche: "+cafeLeche+""
                    + "\nNúmero cafés cortados: "+cafeCortado+""
                    + "\nNúmero cafés americanos: "+cafeAmericano);
            System.out.println("-------------------------------------------");
            semaforoCliente.release();
        }
        
        
        public void tomarCafe(String nombre){
            try {
                semaforoCliente.acquire();
                System.out.println("-------------------------------------------");
                int tiempo = (int) (Math.random()*300);
                System.out.println("Tiempo tomándose el café: "+tiempo);
                Thread.sleep(tiempo);
                String cafe = cafeBebido();
                System.out.println(nombre+" acaba de tomarse un "+cafe);

            } catch (InterruptedException ex) {  
            }
            
            System.out.println("Número cafés solos: "+cafeSolo+""
                    + "\nNúmero cafés con leche: "+cafeLeche+""
                    + "\nNúmero cafés cortados: "+cafeCortado+""
                    + "\nNúmero cafés americanos: "+cafeAmericano);
            System.out.println("-------------------------------------------");
            semaforoBarista.release();
        }
        
        
        
        private String cafeBebido(){
                
                String cafe="";
                int tipo = (int) (Math.random()*4);
                switch(tipo){
                    case 0: 
                    
                    cafeSolo--;
                    cafe = "café solo";
                        break;
                        
                    case 1: 
                    cafeLeche--;
                    cafe = "café con leche";
                        break;
                        
                    case 2: 
                    cafeCortado--;
                    cafe = "café cortado";
                        break;
                        
                    case 3: 
                    cafeAmericano--;
                    cafe = "café americano";    
                        break;
                }
                
                
              return cafe;  
             
        }
        
        private void rellenar(){
            
            if(cafeLeche == 0 && cafeSolo == 0 && cafeCortado==0 && cafeAmericano ==0){
               cafeLeche++; 
               cafeSolo++;
               cafeCortado++;
               cafeAmericano++;
               
            }else if(cafeLeche == 0){
                cafeLeche++;
                
            }else if(cafeSolo == 0){
                cafeSolo++;
                
            }else if(cafeCortado==0){
                cafeCortado++;
                
            }else if(cafeAmericano==0){
                cafeAmericano++;
            }
        }
    
        
        
}
