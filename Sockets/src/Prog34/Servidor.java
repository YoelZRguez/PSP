package Prog34;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;


public class Servidor {
   private static final int PUERTO = 2000;
   private static final int PUERTO2 = 2001;
   Scanner sc = new Scanner (System.in);
    
    public Servidor(){
        int num = 1;
        
        
       try {
           DatagramSocket servidorR = new DatagramSocket(PUERTO);
           DatagramSocket servidorE = new DatagramSocket();
           String comprobacion ="";
           
           byte mensaje [] = new byte[1000];
           DatagramPacket paquete = new DatagramPacket(mensaje, mensaje.length);
           while(true){
               System.out.println("Esperando mensajes...");
               
               servidorR.receive(paquete);
               String datos = new String (paquete.getData(), 0, paquete.getLength());
               System.out.println("IP del "+datos+" "+num+": "+paquete.getAddress().toString());
               
               byte mensajeCliente [] = new byte [1000];
               String mensajeEnviar = "Mensaje del servidor: Cliente "+num+". Te has conectado al servidor";
               mensajeCliente = mensajeEnviar.getBytes();
               DatagramPacket envios = new DatagramPacket(mensajeCliente, mensajeCliente.length, paquete.getAddress(), PUERTO2);
               servidorE.send(envios);
               
               int secreto = numSecreto();
               System.out.println("Número secreto: "+secreto);
               
               do{
               byte numUser [] = new byte[1000];
               DatagramPacket numero = new DatagramPacket(numUser, numUser.length);
               servidorR.receive(numero);
               String numeroRecibido = new String (numero.getData(), 0, numero.getLength());
               
               
               comprobacion = adivinar(secreto, Integer.parseInt(numeroRecibido));
               byte comprobacionNum [] = new byte [1000];
               comprobacionNum = comprobacion.getBytes();
               DatagramPacket comprobado = new DatagramPacket(comprobacionNum, comprobacionNum.length, paquete.getAddress(), PUERTO2);
               servidorE.send(comprobado);
               
               }while(comprobacion != "=");
               
               num++;
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
                respuesta = "-";
                
            }else if(secreto<introducido){
               respuesta =  "+";
                
            }else{
                respuesta = "=";
            }
            
            return respuesta;
        
    }
    
}
