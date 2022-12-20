package Prog31;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
Crear una aplicación cliente/servidor usando sockets TCP en la que:
–El servidor está constantemente a la espera de recibir conexiones. 
Al recibir una, muestra por pantalla la dirección IP del cliente que se ha conectado.
Además, debe llevar una cuenta del número de clientes que se han ido conectando. 
El servidor enviará un mensaje al cliente indicándole el número de cliente y el 
cliente mostrará por pantalla dicho mensaje.
PISTA: getInetAddress()
*/
public class Servidor {
   private static final int PUERTO = 2000;
    
    
    public Servidor(){
        int num = 1;
        
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
    
}
