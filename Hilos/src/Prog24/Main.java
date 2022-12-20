package Prog24;

import java.util.concurrent.Semaphore;


/**
Crear un programa en Java usando hilos:
–
Uno de ellos mostrará 200 veces la palabra TIC.
–
Otro mostrará 200 veces la palabra TAC.
Utilizando
notificaciones debes conseguir que se
muestre por pantalla:
TIC TAC TIC TAC TIC TAC…
 */
public class Main {
        
    
    public static void main(String [] args){
        Semaphore sTic = new Semaphore(1);
        Semaphore sTac = new Semaphore(0);
        
        GestionarHilos gh = new GestionarHilos(sTic, sTac);
        
        Thread tic = new Hilo_Tic(gh);
        Thread tac = new Hilo_Tac(gh);
        
        tic.start();
        tac.start();
    }
}
