package Tarea1;
import java.io.*;
import java.util.Scanner;
/**
Crear un programa en Java que muestre (hasta que se seleccione la opción salir) 
un menú al usuario con 4 programas y le permita elegir cuál quiere abrir.
Entodos los casos se debe mostrar el número y la información
completa del proceso creado.
 */
public class Prog11 {
    public static void main (String [] args ){
    Scanner sc = new Scanner (System.in);
    int opcion; 
    Process miProceso;
    String nProceso = "notepad.exe";
    String nProceso2 = "mspaint.exe";
    
    ProcessBuilder pb = new ProcessBuilder (nProceso);
    ProcessBuilder pb2 = new ProcessBuilder (nProceso2);
    Runtime rt = Runtime.getRuntime();
    
    try{
        do{
            System.out.println("-----------------------------------------------");
            System.out.println("Introduzca lo que desea ejecutar: "
            + "\n 1. Notepad con ProcessBuilder"
            + "\n 2. Paint con ProcessBuilder"
            + "\n 3. Notepad con Runtime"
            + "\n 4. Paint con Runtime"
            + "\n 5. Salir");
            System.out.println("-----------------------------------------------");
            opcion = sc.nextInt();
            
        switch (opcion){
        case 1 : 
            pb.command(nProceso);
            miProceso = pb.start();
            System.out.println("Número de proceso: "+miProceso.pid());
            System.out.println("Información del proceso: "+miProceso.info());
            break;
            
        case 2 : 
            pb.command(nProceso2);
            miProceso = pb.start();
            System.out.println("Número de proceso: "+miProceso.pid());
            System.out.println("Información del proceso: "+miProceso.info());
            break;
        
        case 3 : 
            miProceso =  rt.exec(nProceso);
            System.out.println("Número de proceso: "+miProceso.pid());
            System.out.println("Información del proceso: "+miProceso.info());
            break;
            
        case 4: 
            miProceso = rt.exec(nProceso2);
            System.out.println("Número de proceso: "+miProceso.pid());
            System.out.println("Información del proceso: "+miProceso.info());
            break;
        
        case 5: 
            System.out.println("Saliendo del menú...");
            break;
            
        default : 
            System.out.println("Valor no válido! Vuelve a intentarlo");
            break;
        }
        }while (opcion != 5 );
        
    
    }catch(IOException e){
        e.printStackTrace();
    }
    }
}
