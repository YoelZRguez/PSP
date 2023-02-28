
package Prog33;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class Cliente {


    private static final int PUERTO = 2000;
    private static final int PUERTO2 = 2001;
    private static final String HOST = "localhost";
    
    public Cliente(){

       try {   
           DatagramSocket cliente = new DatagramSocket();
           String textoEnviar = "Cliente";
            byte[] mensaje = new byte[1000];
            mensaje = textoEnviar.getBytes();
            DatagramPacket paquete = new DatagramPacket(mensaje, mensaje.length, InetAddress.getByName(HOST), PUERTO);
            cliente.send(paquete);

            byte mensajeRecibido [] = new byte [1000];
            DatagramPacket recibido = new DatagramPacket(mensajeRecibido, mensajeRecibido.length);
            cliente.receive(recibido);
            String mensajeB = new String (recibido.getData(), 0, recibido.getLength());
            
            System.out.println(mensajeB);
            System.out.println("¡Conexión finalizada!");

            cliente.close();
           
       } catch (IOException ex) {
           System.out.println(ex.getMessage());    
       }
    }
    
    public static void main(String [] args){
        Cliente user = new Cliente();
    }
    
    
}

    

