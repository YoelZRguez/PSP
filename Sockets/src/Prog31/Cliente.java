
package Prog31;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {


    private static final int PUERTO = 2000;
    private static final String HOST = "localhost";
    
    public Cliente(){
        
       try {           
               Socket cliente = new Socket(HOST, PUERTO);
               
               DataInputStream flujoEntrada = new DataInputStream (cliente.getInputStream());
               DataOutputStream flujoSalida = new DataOutputStream (cliente.getOutputStream());
               
               flujoSalida.writeUTF("Cliente");
               
               String mensaje = flujoEntrada.readUTF();
               System.out.println("Mensaje servidor: "+mensaje);
               
               cliente.close();
           
       } catch (IOException ex) {
           System.out.println(ex.getMessage());    
       }
    }
    
    public static void main(String [] args){
        Cliente user = new Cliente();
    }
    
    
}

    

