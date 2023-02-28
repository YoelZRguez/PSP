
package practica41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Practica41 {
private static final int PUERTO = 8500;
    
    public Practica41(){
        try{
            ServerSocket serverSocket = new ServerSocket(PUERTO);
            System.out.println("Esperando clientes...");
            while(true){
                Socket socketCliente = serverSocket.accept();
                System.out.println("Atendiendo al cliente");
                procesarPeticion(socketCliente);
                
                System.out.println("Cliente atendido correctamente");
                
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    private void procesarPeticion(Socket socketCliente){
       String peticion = "", html = "";
       PrintWriter flujoSalida = null;
       
       try{
           BufferedReader bufferEntrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
           flujoSalida = new PrintWriter(socketCliente.getOutputStream(), true);
           peticion = bufferEntrada.readLine();
           System.out.println(">>>> Petición recibida:\n"+peticion);
       }catch(IOException e){
           e.printStackTrace();
       }
       
       peticion = peticion.replaceAll(" ", "");

       if(peticion.startsWith("GET")){
           peticion = peticion.substring(3, peticion.lastIndexOf("HTTP"));
           
           if(peticion.length() == 0 || peticion.equals("/")){
               html = "<html><head><title>Principal</title> <head>"
                       + "<body><h1>Pagina Principal</h1> <p>Servidor Funciona Correctamente</p></body></html>";
                       flujoSalida.println("HTTP/1.1 200 OK");
                       flujoSalida.println("Content-Type:text/html; charset=ISO-8859-1 ");
                       flujoSalida.println("Content-Length: "+html.length() + 1);
                       flujoSalida.println("\n");
                       flujoSalida.println(html);
           }else if(peticion.equals("/prueba")){
               html = "<html><head><title>Prueba</title> <head>"
                       + "<body><h1>Pagina de Prueba</h1> <p>Servidor Funciona Correctamente</p></body></html>";
                       flujoSalida.println("HTTP/1.1 200 OK");
                       flujoSalida.println("Content-Type:text/html; charset=ISO-8859-1 ");
                       flujoSalida.println("Content-Length: "+html.length() + 1);
                       flujoSalida.println("\n");
                       flujoSalida.println(html);
           }else{
               html = "<html><head><title>Error</title> <head>"
                       + "<body><h1>Página de error</h1> <p>Página no encontrada</p></body></html>";
                       flujoSalida.println("HTTP/1.1 200 OK");
                       flujoSalida.println("Content-Type:text/html; charset=ISO-8859-1 ");
                       flujoSalida.println("Content-Length: "+html.length() + 1);
                       flujoSalida.println("\n");
                       flujoSalida.println(html);
           }
       }else{
           System.out.println("ERROR: El servidor solo acepta peticiones GET");
       }
    }
    
    public static void main(String[] args) {
        Practica41 p = new Practica41();
    }
    
}
