package Prog53;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;


public class Cliente {
    private static final int PUERTO = 2000;
    private static final String HOST = "localhost";
    private Scanner sc = new Scanner(System.in);
    
    public Cliente(){
       try {
           System.setProperty("javax.net.ssl.trustStore", "TrustSSL");
           System.setProperty("javax.net.ssl.trustStorePassword", "87654321");
           
           SSLSocketFactory factory = (SSLSocketFactory)SSLSocketFactory.getDefault();
           SSLSocket socketSSL = (SSLSocket)factory.createSocket("localhost", 2000);
           
               boolean acertar = false;
               String nombre = "";
               DataInputStream flujoEntrada = new DataInputStream (socketSSL.getInputStream());
               DataOutputStream flujoSalida = new DataOutputStream (socketSSL.getOutputStream());
               do{
               System.out.println("Introduce tu nombre: ");
               System.out.print("> ");
               nombre = sc.nextLine();
               }while(nombre.isEmpty());
               flujoSalida.writeUTF(nombre);
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
               socketSSL.close();
           
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
