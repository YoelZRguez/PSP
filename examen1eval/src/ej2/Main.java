package ej2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    private Scanner sc;
    private Process p;
    private Runtime rt;
    
    public Main(){
        sc = new Scanner (System.in);
        rt = Runtime.getRuntime();
    }
    
    public static void main(String [] args){
        Main m = new Main();
        m.iniciarPrograma();
    }
    
    private void iniciarPrograma(){
        String comando, fichero;

        comando = pedirCmd();
        fichero = crearFichero();
        resultadoCmd(fichero, comando);
    }
    
    private String pedirCmd(){
        System.out.print("> Comando: ");
        String comando = sc.nextLine();
        return comando;
    }
    
    private String crearFichero(){
        System.out.print("> Nombre fichero: ");
        String fichero = sc.nextLine();
        
        return fichero;
        
        
    }
    
    private void resultadoCmd(String fichero, String comando){
        String linea;
        File f = new File(fichero);
        
        try {
            System.out.println("Resultado comando: ");
            p = rt.exec("cmd.exe /c "+comando);
            BufferedReader br = new BufferedReader (new InputStreamReader(p.getInputStream()));
            BufferedWriter bw = new BufferedWriter (new FileWriter (f, true));
            while((linea = br.readLine()) !=null){
                System.out.println(linea);
                bw.write(linea);
                bw.newLine();
            }
            bw.close();
            br.close();
            
            System.out.println("Resultado guardado en el fichero: "+f);
            
            
        } catch (IOException ex) {
            ex.getStackTrace();
        }
        
        
            
        
    }
    
    
}
