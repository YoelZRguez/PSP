package Practica3_1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor extends Thread { //Llamamos a la clase Thread para el funcionamiento concurrente
    //Declaramos el puerto y el socket del cliente
   private static final int PUERTO = 3000;
   private Socket socketCliente;
    
   //Creamos el constructor de la clase
   public Servidor(Socket socketCliente){
        this.socketCliente = socketCliente;
       
    }
   
   //Ejecutamos el hilo
   public void run(){
        try {
                //Declaramos flujo de entrada y de salida
               System.out.println("¡Cliente conectado!");
               DataInputStream flujoEntrada = new DataInputStream (socketCliente.getInputStream());
               DataOutputStream flujoSalida = new DataOutputStream (socketCliente.getOutputStream());
               String cliente="";
               
               //Recogemos el nombre del fichero introducido por el cliente
               String nombreFichero = flujoEntrada.readUTF();
               
               /*
               Llamamos al método para comprobar si el nombre introducido ha sido correctamente introducido
               y generamos el texto que mandaremos al Cliente
               */
               cliente = mensajeCliente(nombreFichero, cliente);
               
               System.out.println("Comprobación de fichero realizada: Mandando mensaje a cliente...");
               //Mandamos la respuesta al cliente
               flujoSalida.writeUTF(cliente);
               
               //Finalizamos conexion con el cliente
               System.out.println("¡Conexión Finalizada!");
               socketCliente.close();
               
            System.out.println("-----------------------------------------------");
           
       } catch (IOException ex) {
           System.out.println(ex.getMessage());    
       }
   }
   
    
    //Creamos el Main para que el programa pueda ser ejecutado con diferentes hilos
    public static void main(String [] args){
         
        try {
            //Inicializamos el servidor
               ServerSocket servidor = new ServerSocket(PUERTO);
               System.out.println("-----------------------------------------------");
               System.out.println("Esperando conexiones...");
            
            //Ponemos el while true para que el servidor nunca se desconecte
            while(true){
                //Inicializamos el servidor
                Socket socketCliente = servidor.accept();
                new Servidor(socketCliente).start();

            }
        }catch (IOException ex) {
               ex.getMessage();
        }
    }
    
    //Método que comprobará si el fichero es correcto o no
    private boolean comprobarNombre(String fichero){
        File f = new File("./"+fichero);
        boolean existe = false;
        File dir = new File ("./");
        String [] listado = dir.list();
        
        if (f.exists() && f.isFile()){
            for (int i = 0; i<listado.length; i++){
                if(listado[i].compareTo(fichero) == 0){
                    existe = true;
                }
            }
        }
        return existe;
    }
    
    //Método para mandar el mensaje al cliente
    private String mensajeCliente(String nombreFichero, String cliente){
        try{
            if(comprobarNombre(nombreFichero)){
                   BufferedReader br = new BufferedReader (new FileReader("./"+nombreFichero));
                   String texto = br.readLine();
                   
                   //Si el nombre ha sido correcto recogemos el contenido del fichero en una variable String y lo mandamos al cliente
                   while(texto !=null){
                       cliente+=texto+"\n";
                       texto = br.readLine();
                   }
                   
                //Si el nombre del fichero no es correcto se le envía mensaje de error
            }else{
                   cliente = "No existe el fichero que has introducido";
               }
        
    }catch(FileNotFoundException ex){
            System.out.println("No se ha encontrado el archivo");
    }catch(IOException ex){
            System.out.println("No se ha podido realizar la");
    }
    
    return cliente;
}

}