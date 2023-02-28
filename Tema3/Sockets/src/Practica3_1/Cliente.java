package Practica3_1;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class Cliente {
    //Inicializamos las variables globales de la clase (PUERTO, HOST y Scanner)
    private static final int PUERTO = 3000;
    private static final String HOST = "localhost";
    private Scanner sc = new Scanner(System.in);
    
    public Cliente(){
            
       try {
           
               //Inicializamos el cliente
               Socket cliente = new Socket(HOST, PUERTO);
               
               //Creamos el flujo de entrada y de salida
               DataInputStream flujoEntrada = new DataInputStream (cliente.getInputStream());
               DataOutputStream flujoSalida = new DataOutputStream (cliente.getOutputStream());
               
               //Llamamos al método para introducir el nombre y lo mandamos al servidor
               String fichero = introducirNombre();
               flujoSalida.writeUTF(fichero);
               
               //Nos llega la respuesta del servidor y la sacamos por pantalla
               String textoFichero = flujoEntrada.readUTF();
               System.out.println(textoFichero);
               
               //Llamamos al método de comprobación de fichero
               crearFichero(textoFichero, fichero);
               
               //Cerramos el cliente
               cliente.close();
           
       } catch (IOException ex) {
           System.out.println(ex.getMessage());    
       }
    }
    
    //Creamos el main para poder ejecutar el cliente
    public static void main(String [] args){
        Cliente user = new Cliente();

    }
    
    //Método para introducir el nombre del fichero que enviaremos al Servidor
    private String introducirNombre(){
        String fichero ="";       
        System.out.println("Introduce el nombre del fichero: ");
               System.out.print("> ");
               fichero = sc.nextLine();
               
              return fichero; 
    }

    /*
    Si el texto del fichero es correcto se creará un fichero de texto en la misma carpeta en la que ejecutamos el proyecto            
    con el contenido del fichero del Servidor
    */
    private void crearFichero(String textoFichero, String fichero){
         try {
        if(textoFichero.contains("No existe el fichero")){
                                     
               }else{
                   BufferedWriter bw; 
                   bw = new BufferedWriter(new FileWriter("src/Practica3_1/"+fichero, true));
                   bw.write(textoFichero);
                   bw.close();
        }
        } catch (IOException ex) {
                System.out.println("No se ha podido crear el fichero");
            }
    }
    
}
