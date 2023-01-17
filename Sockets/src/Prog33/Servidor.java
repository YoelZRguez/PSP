package Prog33;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;



public class Servidor {
   private static final int PUERTO = 2000;
   private static final int PUERTO2 = 2001;
    
    
    public Servidor(){
        int num = 1;
        
       try {
           DatagramSocket servidor = new DatagramSocket(PUERTO);
           
           byte mensaje [] = new byte[1000];
           DatagramPacket paquete = new DatagramPacket(mensaje, mensaje.length);
           while(true){
               System.out.println("Esperando mensajes...");
               
               servidor.receive(paquete);
               String datos = new String (paquete.getData(), 0, paquete.getLength());
               System.out.println("IP del "+datos+" "+num+": "+paquete.getAddress().toString());
               
               
               byte mensajeCliente [] = new byte [1000];
               String mensajeEnviar = "Mensaje del servidor: Cliente "+num+". Te has conectado al servidor";
               mensajeCliente = mensajeEnviar.getBytes();
               
               DatagramPacket envios = new DatagramPacket(mensajeCliente, mensajeCliente.length, paquete.getAddress(), paquete.getPort());
               servidor.send(envios);
               num++;
           }
       } catch (IOException ex) {
           System.out.println(ex.getMessage());    
       }
    }
    
    public static void main(String [] args){
        Servidor server = new Servidor();
    }
    
}
