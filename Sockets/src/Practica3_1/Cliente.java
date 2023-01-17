
package Practica3_1;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class Cliente {
    private static final int PUERTO = 3000;
    private static final String HOST = "localhost";
    private Scanner sc = new Scanner(System.in);
    
    public Cliente(){

       try {
               
               Socket cliente = new Socket(HOST, PUERTO);
               
               DataInputStream flujoEntrada = new DataInputStream (cliente.getInputStream());
               DataOutputStream flujoSalida = new DataOutputStream (cliente.getOutputStream());
               
               System.out.println("Introduce el nombre del fichero: ");
               System.out.print("> ");
               String fichero = sc.nextLine();
               
               flujoSalida.writeUTF(fichero);
               String textoFichero = flujoEntrada.readUTF();
               System.out.println(textoFichero);
               
               if(textoFichero.contains("Yoel Zamora Rodríguez")){
                   BufferedWriter bw = new BufferedWriter(new FileWriter("src/Practica3_1/Yoel.txt", true)); 
                   bw.write(textoFichero);
                   bw.close();                  
               }
               
               cliente.close();
           
       } catch (IOException ex) {
           System.out.println(ex.getMessage());    
       }
    }
    
    public static void main(String [] args){
        Cliente user = new Cliente();

    }   
    
}
