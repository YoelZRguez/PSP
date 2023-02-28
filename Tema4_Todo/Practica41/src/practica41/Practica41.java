
package practica41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Practica41 extends Thread {
//Declaramos los valores globales necesarios de la clase JAVA
private static final int PUERTO = 8500; //Puerto por el que a través realizaremos la conexión
private Socket socketCliente;//Inicializamos el socket del cliente
    
    public Practica41(Socket socketCliente){//Creamos el constructor de la clase
        this.socketCliente = socketCliente;
    }
    
    public void run(){//Ejecutamos el método run para el funcionamiento concurrente de varios usuarios
        try{
                System.out.println("Atendiendo al cliente");
                procesarPeticion(socketCliente); //LLamamos al método ProcesarPetición
                System.out.println("Cliente atendido correctamente");
                socketCliente.close();//Cada vez que se atiende a un cliente se cierra la conexión
                
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    //Método en el que generaremos las diferentes páginas del servidor "localhost"
    private void procesarPeticion(Socket socketCliente){
       //Inicializamos las variables
       String peticion = "";
       PrintWriter flujoSalida = null;
       
       //Cogemos los datos que nos transmite el usuario y se lo devolvemos en forma de petición y ejecutamos las diferentes peticiones
       try{
           BufferedReader bufferEntrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
           flujoSalida = new PrintWriter(socketCliente.getOutputStream(), true);
           peticion = bufferEntrada.readLine();
           System.out.println(">>>> Petición recibida:\n"+peticion);
       }catch(IOException e){
           e.printStackTrace();
       }
       
       peticion = peticion.replaceAll(" ", "");
        //Dependiendo de la petición ejecutaremos un método en concreto
       if(peticion.startsWith("GET")){
           peticion = peticion.substring(3, peticion.lastIndexOf("HTTP"));
           
           if(peticion.length() == 0 || peticion.equals("/")){
               peticionMain(flujoSalida);
                       
           }else if(peticion.equals("/servidor")){
               peticionServidor(flujoSalida);
               
           }else if(peticion.equals("/sockets")){
               peticionSockets(flujoSalida);
                       
           }else if(peticion.equals("/lenguajes")){
               peticionLenguajes(flujoSalida);
                       
           }else if(peticion.equals("/Java")){
               peticionJava(flujoSalida);
                       
           }else{
               error(flujoSalida);
           }
       }else{
           System.out.println("ERROR: El servidor solo acepta peticiones GET");
       }
    }

    //Método para entrar en "localhost:8500"
    private void peticionMain(PrintWriter flujoSalida){
        String html = "<html><head><title>Pagina Principal</title> <head>"
                       + "<body><h1>Bienvenido a la Practica 41</h1> <p>En este pagina puedes encontrar "
                       + "las diferentes paginas pertenecientes a la practica.</p>"
                       + "<ol> <li><a href="+"http://localhost:8500/servidor"+">Que es un servidor web</a></li> "
                       + "<li> <a href="+"http://localhost:8500/sockets"+">Que son los sockets</a></li>"
                       + "<li><a href="+"http://localhost:8500/lenguajes"+">Lenguajes de programacion mas utilizados en 2023</a></li>"
                       + "<li><a href="+"http://localhost:8500/Java"+">Trabajos relacionados con Java</a></li></ol>"
                       + "</body></html>";
                       flujoSalida.println("HTTP/1.1 200 OK");
                       flujoSalida.println("Content-Type:text/html; charset=ISO-8859-1 ");
                       flujoSalida.println("Content-Length: "+html.length() + 1);
                       flujoSalida.println("\n");
                       flujoSalida.println(html);
    }
    
    //Método para entrar en "localhost:8500/servidor"
    private void peticionServidor(PrintWriter flujoSalida){    
        String html = "<html><head><title>Servidor Web</title> <head>"
                       + "<body><h1>Que es un servidor web</h1> <p>Un servidor web es un software que forma parte del servidor</p>"
                       + "<p>Tiene como mision principal devolver informacion (paginas) cuando recibe peticiones por parte de los usuarios.</p>" +
                       "\n" +
                       "<p>En otras palabras, es el software que permite que los usuarios que quieren ver una pagina web en su navegador puedan hacerlo.</p>"
                       + "<button type=\"button\"><a href = "+"http://localhost:8500"+">Volver</a></button></body></html>";
                       flujoSalida.println("HTTP/1.1 200 OK");
                       flujoSalida.println("Content-Type:text/html; charset=ISO-8859-1 ");
                       flujoSalida.println("Content-Length: "+html.length() + 1);
                       flujoSalida.println("\n");
                       flujoSalida.println(html);
    }
    
    //Método para entrar en "localhost:8500/sockets"
    private void peticionSockets(PrintWriter flujoSalida){
        String html = "<html><head><title>Sockets</title> <head>"
                       + "<body><h1>Que son los sockets</h1> <p>Los sockets sirven para conectar el procesador a la placa base y, por lo tanto, al resto de los componentes.</p>"
                       + "<p>Son lugares delicados y hay que andar con mucha precaucion a la hora de instalar el procesador en el, tanto si es AMD como si es Intel.</p>"
                       + "<p>Una vez instalado, los pines haran la oportuna conexion y proporcionaran el medio por el cual se comunica el procesador con la placa base y con todo lo que en ella haya instalado.</p>"
                       + "<button type=\"button\"><a href = "+"http://localhost:8500"+">Volver</a></button></body></html>";
                       flujoSalida.println("HTTP/1.1 200 OK");
                       flujoSalida.println("Content-Type:text/html; charset=ISO-8859-1 ");
                       flujoSalida.println("Content-Length: "+html.length() + 1);
                       flujoSalida.println("\n");
                       flujoSalida.println(html);
    }
    
    //Método para entrar en "localhost:8500/lenguajes"
    private void peticionLenguajes(PrintWriter flujoSalida){
        String html = "<html><head><title>Lenguajes de Programacion mas usados</title> <head>"
                       + "<body><h1>Lenguajes de programacion mas usados</h1>"
                       + "<TABLE BORDER="+"2"+">"
                       + "<TR>"
                       + "<TH>Nombre</TH> <TH>Front-End o Back-End</TH> <TH>Cantidad de gente utilzandolo</TH>"
                       + "</TR>"
                       + "<TR>"
                       + "<TD>JavaScript</TD> <TD>Principalmente Front-End</TD> <TD>12,1 Millones de Usuarios</TD>"
                       + "</TR>"
                       + "<TR>"
                       + "<TD>Python</TD> <TD>Back-End</TD> <TD>10,1 Millones de Usuarios</TD>"
                       + "</TR>"
                       + "<TR>"
                       + "<TD>Java</TD> <TD>Ambos</TD> <TD>+9 Millones de Usuarios</TD>"
                       + "</TR>"
                       + "</TABLE>"
                       + "<br>"
                       + "<button type=\"button\"><a href = "+"http://localhost:8500"+">Volver</a></button></body></html>";
                       flujoSalida.println("HTTP/1.1 200 OK");
                       flujoSalida.println("Content-Type:text/html; charset=ISO-8859-1 ");
                       flujoSalida.println("Content-Length: "+html.length() + 1);
                       flujoSalida.println("\n");
                       flujoSalida.println(html);
    }
    
    //Método para entrar en "localhost:8500/Java"
    private void peticionJava(PrintWriter flujoSalida){
        String html = "<html><head><title>Trabajos en Java</title> <head>"
                       + "<body><h1>Diferentes trabajos relacionados con Java</h1>"
                       + "<TABLE BORDER="+"2"+">"
                       + "<TR>"
                       + "<TH>Campo de Trabajo</TH> <TH>Aplicaciones</TH>"
                       + "</TR>" 
                       + "<TR>"
                       + "<TD>Productividad y Utilidades</TD> <TD>Hojas de calculo y procesadores de texto</TD>"
                       + "</TR>"
                       + "<TR>"
                       + "<TD>Entretenimiento</TD> <TD>Videojuegos</TD>"
                       + "</TR>"
                       + "<TR>"
                       + "<TD>Comunicacion</TD> <TD>WhatsApp, Telegram...</TD>"
                       + "</TR>"
                       + "</TABLE>"
                       + "<br>"
                       + "<button type=\"button\"><a href = "+"http://localhost:8500"+">Volver</a></button></body></html>";
                       flujoSalida.println("HTTP/1.1 200 OK");
                       flujoSalida.println("Content-Type:text/html; charset=ISO-8859-1 ");
                       flujoSalida.println("Content-Length: "+html.length() + 1);
                       flujoSalida.println("\n");
                       flujoSalida.println(html);
    }
    
    //Método que nos salta una página de error
    private void error(PrintWriter flujoSalida){
        String html = "<html><head><title>Error</title> <head>"
                       + "<body><h1>Página de error</h1> <p>Página no encontrada</p></body></html>";
                       flujoSalida.println("HTTP/1.1 200 OK");
                       flujoSalida.println("Content-Type:text/html; charset=ISO-8859-1 ");
                       flujoSalida.println("Content-Length: "+html.length() + 1);
                       flujoSalida.println("\n");
                       flujoSalida.println(html);
    }
    
    
    //Inicializamos los hilos para el funcionamiento concurrente
    public static void main(String[] args) {
        try {
               ServerSocket servidor = new ServerSocket(PUERTO);
            while(true){
                System.out.println("Esperando clientes...");
                Socket socketCliente = servidor.accept();
                new Practica41(socketCliente).start();
            }
        }catch (IOException ex) {
               ex.getMessage();
        }
    }
    
}
