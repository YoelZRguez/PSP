
package Prog32;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class Cliente {
    private static final int PUERTO = 2000;
    private static final String HOST = "localhost";
    private Scanner sc = new Scanner(System.in);
    
    public Cliente(){

       try {
               
               Socket cliente = new Socket(HOST, PUERTO);
               
               DataInputStream flujoEntrada = new DataInputStream (cliente.getInputStream());
               DataOutputStream flujoSalida = new DataOutputStream (cliente.getOutputStream());
               
               flujoSalida.writeUTF("Cliente ");
               adivinar(flujoEntrada.readInt());
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
    
    public void adivinar(int secreto){
        int introducido;
        
        do{
            System.out.println("Introduce el número secreto: ");
            System.out.print("> ");
            introducido = Integer.parseInt(sc.nextLine());
            
            if(secreto>introducido){
                System.out.println("El número "+introducido+" es menor que el número secreto");
                
            }else if(secreto<introducido){
                System.out.println("El número "+introducido+" es mayor que el número secreto");
                
            }else{
                System.out.println("Número acertado. Enhorabuena!");
            }
        }while (secreto!=introducido);
    }
    
    
}
