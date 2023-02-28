package Prog53;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

/*
Crear una aplicación cliente/servidor usando sockets TCP en la que:
–El servidor debe generar un número secreto de forma aleatoria entre el 0 y el 100.
El objetivo del cliente es solicitarle al usuario un número y enviarlo al servidor
hasta que adivine el número secreto. 
Para ello, el servidor para cada número que le envía el cliente le indicará si es menor,
mayor o es el número secreto.
*/
public class Servidor extends Thread {
   private static final int PUERTO = 2000;
   private Socket socketCliente;
   private Scanner sc = new Scanner(System.in);
   private static SSLServerSocketFactory factory;
   private static SSLServerSocket socketServidorSSL;
   private static SSLSocket socketSSL;

    
   public void run(){
        
        int num = 1;
        int introducido=0;
        
       try {   
               DataInputStream flujoEntrada = new DataInputStream (socketSSL.getInputStream());
               DataOutputStream flujoSalida = new DataOutputStream (socketSSL.getOutputStream());
     
               System.out.println("Dirección IP del cliente "+num+": "+socketSSL.getInetAddress());

               String nombreCliente = flujoEntrada.readUTF();
               flujoSalida.writeUTF("Bienvenido "+nombreCliente+". Te has conectado al servidor correctamente.");
               
               int secreto = numSecreto();
               System.out.println("Número secreto: "+secreto);
               
               do{  
               introducido = flujoEntrada.readInt();
               flujoSalida.writeUTF(adivinar(secreto, introducido));
               
               }while(introducido !=secreto);

               socketCliente.close();
               num++;
            System.out.println("-----------------------------------------------");
            System.out.println("Esperando conexiones...");
       } catch (IOException ex) {
           System.out.println(ex.getMessage());    
       }
   }
   
    public Servidor(Socket socketCliente){
        this.socketCliente = socketCliente;
       
    }
    
    public static void main(String [] args){
         
        try {
            System.setProperty("javax.net.ssl.keyStore", "StoreSSL");
            System.setProperty("javax.net.ssl.keyStorePassword", "12345678");
            
            factory = (SSLServerSocketFactory)SSLServerSocketFactory.getDefault();
            socketServidorSSL = (SSLServerSocket)factory.createServerSocket(2000);

            while(true){
                System.out.println("-----------------------------------------------");
                System.out.println("Esperando conexiones...");
               
                socketSSL = (SSLSocket)socketServidorSSL.accept();
                new Servidor(socketSSL).start();
            }
        }catch (IOException ex) {
               ex.getMessage();
        }
    }
    
    public int numSecreto(){
        int secreto =(int) (Math.random()*101);
        return secreto;
    }
    
    public String adivinar(int secreto, int introducido){
        String respuesta;
            if(secreto>introducido){
                respuesta = "El número "+introducido+" es menor que el número secreto";
                
            }else if(secreto<introducido){
               respuesta =  "El número "+introducido+" es mayor que el número secreto";
                
            }else{
                respuesta = "Número acertado. Enhorabuena!";
            }
            
            return respuesta;
        
    }
    
    
    
    
    
}