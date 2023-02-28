package pkg4_servicios_en_red;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Prog41 {
    Scanner sc = new Scanner(System.in);
    InetAddress objetoExterno1;
    InetAddress equipoLan;
    
    public static void main(String[] args) {
        Prog41 m = new Prog41();
        m.iniciarPrograma();
    }
    
    private void menu(){
        System.out.println("---------------------------------------");
        System.out.println("¿Qué opción deseas ejecutar?"
                + "\n1. Mostrar IP equipo en LAN"
                + "\n2. Introducir sitio web -> Devolverá su IP"
                + "\n0. Salir");
        System.out.print("> ");
        
        
    }
    
    private int procesarOpcion(){
        int opcion = Integer.parseInt(sc.nextLine());
        System.out.println("---------------------------------------");
        return opcion;
    }
    
    private void registrarOpcion(int opcion){
        switch(opcion){ 
            case 1:
                mostrarIPLan();
                break;
                
            case 2:
                mostrarIPWeb();
                break;
                
            case 0: 
                System.out.println("Finalizando el programa...");
                break;
                
            default:
                System.out.println("Opción no disponible");
                break;
        
        }
    }
    
    private void mostrarIPLan(){
        try {
            equipoLan = InetAddress.getLocalHost();
            System.out.println("Nombre equipo en LAN: "+equipoLan.getHostName());
            System.out.println("IP equipo en LAN: "+equipoLan.getHostAddress());
            
        } catch (UnknownHostException ex) {
            System.out.println("Host no encontrado");
        }
    }
    
    private void mostrarIPWeb(){
        try {
        System.out.println("Introduce la web de la que deseas saber su IP: ");
        System.out.print("> ");
        String web = sc.nextLine();
        objetoExterno1 = InetAddress.getByName(web);
        System.out.println("Ip de la web '"+web+"' : "+objetoExterno1.getHostAddress());
        } catch (UnknownHostException ex) {
            System.out.println("No se puede realizar la conexión con el sitio web");
        }
    }
    
    private void iniciarPrograma(){
        int opcion = 0;
        do{
            menu();
            opcion = procesarOpcion();
            registrarOpcion(opcion);
        }while(opcion != 0);
    }
    
}

