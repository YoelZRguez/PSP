package hilos;


public class Main {
    
    
    public static void main(String [] args){
        
        Thread hilo1 = new HiloThread("Hola1");
        Thread hilo2 = new HiloThread("Hola2");
        Thread hilo3 = new HiloThread("Hola3");
        Thread hilo4 = new HiloThread("Hola4");
        
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
    }
}
