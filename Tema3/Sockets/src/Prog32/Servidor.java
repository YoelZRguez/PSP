package Prog32;

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
public class Servidor {
   private static final int PUERTO = 2000;
   private Scanner sc = new Scanner(System.in);
    
    public Servidor(){
        int num = 1;
        int introducido=0;
        
       try {
           ServerSocket servidor = new ServerSocket(PUERTO);
         while(true){
            System.out.println("-----------------------------------------------");
               System.out.println("Esperando conexiones...");
               Socket cliente = servidor.accept();

               DataInputStream flujoEntrada = new DataInputStream (cliente.getInputStream());
               DataOutputStream flujoSalida = new DataOutputStream (cliente.getOutputStream());
     
               System.out.println("Dirección IP del cliente "+num+": "+cliente.getInetAddress());

               String nombreCliente = flujoEntrada.readUTF();
               flujoSalida.writeUTF(nombreCliente+" "+num+". Te has conectado al servidor correctamente.");
               
               int secreto = numSecreto();
               System.out.println("Número secreto: "+secreto);
               
               do{  
               introducido = flujoEntrada.readInt();
               flujoSalida.writeUTF(adivinar(secreto, introducido));
               
               }while(introducido !=secreto);

               cliente.close();
               num++;
            System.out.println("-----------------------------------------------");
           }
       } catch (IOException ex) {
           System.out.println(ex.getMessage());    
       }
    }
    
    public static void main(String [] args){
        Servidor server = new Servidor();
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