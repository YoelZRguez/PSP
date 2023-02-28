package Prog35;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

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
    
   public void run(){
        
        int num = 1;
        int introducido=0;
        
       try {
           
            System.out.println("-----------------------------------------------");
               System.out.println("Esperando conexiones...");
               

               DataInputStream flujoEntrada = new DataInputStream (socketCliente.getInputStream());
               DataOutputStream flujoSalida = new DataOutputStream (socketCliente.getOutputStream());
     
               System.out.println("Dirección IP del cliente "+num+": "+socketCliente.getInetAddress());

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
            while(true){       
                Socket socketCliente = servidor.accept();
                new Servidor(socketCliente).start();
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