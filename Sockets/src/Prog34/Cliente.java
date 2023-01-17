
package Prog34;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;


public class Cliente {


    private static final int PUERTO = 2000;
    private static final int PUERTO2 = 2001;
    private static final String HOST = "localhost";
    Scanner sc = new Scanner (System.in);
    
    public Cliente(){
            
        String numero;
        int valor = 0;
        String comprobacion ="";
        
       try {   
           DatagramSocket clienteR = new DatagramSocket(PUERTO2);
           DatagramSocket clienteE = new DatagramSocket();
           String textoEnviar = "Cliente";
            byte[] mensaje = new byte[1000];
            mensaje = textoEnviar.getBytes();
            DatagramPacket paquete = new DatagramPacket(mensaje, mensaje.length, InetAddress.getByName(HOST), PUERTO);
            clienteE.send(paquete);

            byte mensajeRecibido [] = new byte [1000];
            DatagramPacket recibido = new DatagramPacket(mensajeRecibido, mensajeRecibido.length);
            clienteR.receive(recibido);
            String mensajeB = new String (recibido.getData(), 0, recibido.getLength());
            
            System.out.println(mensajeB);
            
            do{
            numero = Integer.toString(adivinar((valor)));
            byte enviarNum [] = new byte [1000];
            enviarNum = numero.getBytes();
            DatagramPacket numEnviado = new DatagramPacket(enviarNum, enviarNum.length, InetAddress.getByName(HOST), PUERTO);
            clienteE.send(numEnviado);
            
            byte numRecibido [] = new byte [1000];
            DatagramPacket servidorC = new DatagramPacket(numRecibido, numRecibido.length);
            clienteR.receive(servidorC);
            comprobacion = new String (servidorC.getData(), 0, servidorC.getLength());
            
            if(comprobacion.equals("+")){
                System.out.println("El número es mayor que el número secreto.");
            }else if(comprobacion.equals("-")){
                System.out.println("El número es menor que el número secreto.");
            }else if(comprobacion.equals("=")){
                System.out.println("Genial, has acertado!");
            }
            
            }while(!comprobacion.equals("="));
            
            
            System.out.println("¡Conexión finalizada!");

            clienteR.close();
            clienteE.close();
           
       } catch (IOException ex) {
           System.out.println(ex.getMessage());    
       }
    }
    
    public static void main(String [] args){
        Cliente user = new Cliente();
    }
    

    private int adivinar(int numero){
        System.out.println("Adivina el número: ");
        System.out.print("> ");
        numero = Integer.parseInt(sc.nextLine());
        
        return numero; 
    }
    
    
}

    

