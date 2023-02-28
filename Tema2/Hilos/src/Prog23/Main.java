package Prog23;

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
        GestionarHilos gh = new GestionarHilos();
        
        Thread tic = new Hilo_Tic(gh);
        Thread tac = new Hilo_Tac(gh);
        
        tic.start();
        tac.start();
    }
}
