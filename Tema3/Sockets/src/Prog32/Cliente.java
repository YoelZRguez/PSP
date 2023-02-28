
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
               boolean acertar = false;
               Socket cliente = new Socket(HOST, PUERTO);
               
               DataInputStream flujoEntrada = new DataInputStream (cliente.getInputStream());
               DataOutputStream flujoSalida = new DataOutputStream (cliente.getOutputStream());
               flujoSalida.writeUTF("Cliente ");
               System.out.println(flujoEntrada.readUTF());
               
               do{
               int numIntroducido = introduceNum();
               flujoSalida.writeInt(numIntroducido);
               String comprobar = flujoEntrada.readUTF();
               System.out.println(comprobar);
               if(comprobar.contains("Enhorabuena")){
                   acertar = true;
               }
               }while (acertar != true);
               cliente.close();
           
       } catch (IOException ex) {
           System.out.println(ex.getMessage());    
       }
    }
    
    public static void main(String [] args){
        Cliente user = new Cliente();

    }
    
    private int introduceNum(){
        System.out.println("Adivina el número: ");
        System.out.print("> ");
        int num = Integer.parseInt(sc.nextLine());
        return num;
    }
    
    
    
    
}
