package Tarea2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Metodos_Ficheros {
        Scanner sc = new Scanner (System.in);
        String nombreArchivo ="";
        String textoF = "";
        Process p = null;
        ProcessBuilder pb = new ProcessBuilder ("mspaint.exe");
        
        public void crearFichero(){    
        
        try {
           System.out.println("Introduce el nombre del archivo: ");
            nombreArchivo = sc.nextLine();
            File f = new File (nombreArchivo+".txt");
            BufferedWriter bf = new BufferedWriter (new FileWriter(f));
            
            System.out.println("Escribe el texto del fichero: ");
            textoF = sc.nextLine();
            bf.write(textoF);
            bf.close(); 
            
        }catch(FileNotFoundException e){
            e.printStackTrace();
            
        }catch(IOException i){
            i.printStackTrace();
        }
        
    }

        public void abrirFichero(){
            Process p; 
            
            try{
            p = pb.start();
            p.waitFor();
            
            }catch (IOException e){
                e.printStackTrace();
                
            }catch(InterruptedException i){
                i.printStackTrace();
            }
            
        }
        
         public void abrirFicheroN(){

            try{
            p = pb.start();
            
            }catch (IOException e){
                e.printStackTrace();
                
            }
            
        }
         
        public void cerrarFichero(){
               p.destroy(); 
        }
        
        
        public void leerFichero(){
        try{
            BufferedReader br = new BufferedReader (new FileReader(nombreArchivo+".txt"));
            String linea = br.readLine();
            System.out.println(linea);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException i){
            i.printStackTrace();
        }
            
        }
    }

