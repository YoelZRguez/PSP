package Practica3_1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor extends Thread {
   private static final int PUERTO = 3000;
   private Socket socketCliente;
    
   public void run(){
        try {
               System.out.println("¡Cliente conectado!");
               DataInputStream flujoEntrada = new DataInputStream (socketCliente.getInputStream());
               DataOutputStream flujoSalida = new DataOutputStream (socketCliente.getOutputStream());
               String cliente="";

               String nombreFichero = flujoEntrada.readUTF();
               if(comprobarNombre(nombreFichero)){
                   BufferedReader br = new BufferedReader (new FileReader("./"+nombreFichero));
                   String texto = br.readLine();
                   
                   while(texto !=null){
                       cliente+=texto+"\n";
                       texto = br.readLine();
                   }
               }else{
                   cliente = "No existe el fichero que has introducido";
               }
               System.out.println("Comprobación de fichero realizada: Mandando mensaje a cliente...");
               
               flujoSalida.writeUTF(cliente);
               System.out.println("¡Conexión Finalizada!");
               socketCliente.close();
               
            System.out.println("-----------------------------------------------");
           
       } catch (IOException ex) {
           System.out.println(ex.getMessage());    
       }
   }
   
    public Servidor(Socket socketCliente){
        this.socketCliente = socketCliente;
       
    }
    
    public static void main(String [] args){
         
        try {
               ServerSocket servidor = new ServerSocket(PUERTO);
               System.out.println("-----------------------------------------------");
               System.out.println("Esperando conexiones...");

            while(true){       
                Socket socketCliente = servidor.accept();
                new Servidor(socketCliente).start();

            }
        }catch (IOException ex) {
               ex.getMessage();
        }
    }
    
    private boolean comprobarNombre(String fichero){
        File f = new File("./"+fichero);
        boolean existe = false;
        
        if (f.exists() && fichero.compareTo("Yoel.txt") == 0){
            existe = true;
        }
        return existe;
    }

}