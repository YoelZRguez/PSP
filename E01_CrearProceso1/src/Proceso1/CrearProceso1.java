package Proceso1;
import java.io.*;

public class CrearProceso1 {

    /**
     CREAR UN PROCESO (bloc de notas) - 1ª Forma
     */
    public static void main(String[] args) {
        String nombreProceso = "notepad.exe";
        ProcessBuilder pb = new ProcessBuilder (nombreProceso);
    
    try{
        pb.start();
    }catch (IOException e){
        e.printStackTrace();
    }
    
    }
    
}
