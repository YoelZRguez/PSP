/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
Crear un programa en Java con las siguientes opciones:
1.
Mostrar dirección IP.
2.
Mostrar máscara de subred.
3.
Mostrar puerta de enlace.
0. Salir.
 */
public class Prog15 {
    private Scanner sc;
    private Runtime rt;
    Process p;
    
    public Prog15(){
        sc = new Scanner (System.in);
        rt = Runtime.getRuntime();
    }
    
    private void iniciarPrograma(){
        int opcion = 0;
        System.out.println("Bienvenido al programa 1.5");
        do{
          menu();
          opcion = elegirOpcion();
          procesarOpcion(opcion);
        }while(opcion != 0);
    }
    
    private void menu(){
        System.out.println("--------------------------------------------------");
        System.out.println("Introduce la opción que deseas ejecutar: "
                + "\n1. Mostrar dirección IP."
                + "\n2. Mostrar máscara de subred."
                + "\n3. Mostrar puerta de enlace."
                + "\n0. Salir");
        System.out.println("--------------------------------------------------");
    }

    private int elegirOpcion (){
        int opcion = Integer.parseInt(sc.nextLine());
        return opcion;
    }
    
    private void procesarOpcion(int opcion){
        switch (opcion){
            
            case 1: 
                mostrarIp();
                break;
                
            case 2: 
                mostrarMascara();
                break;
                
            case 3: 
                mostrarPuerta();
                break;
                
            case 0: 
                System.out.println("Saliendo del programa...");
                break;
                
                
            default: 
                System.out.println("Opcion "+opcion+ "inavalida");
                break;
        }
    }
    
    private void mostrarIp(){
        String linea = null;
        String filtro = "Direcc";
        boolean adaptador = false;
        int contador = 0;
           
        try{
                
            p = rt.exec("cmd.exe /c ipconfig");
            BufferedReader br = new BufferedReader (new InputStreamReader(p.getInputStream()));
            linea = br.readLine();
            System.out.println("Dirección IP:");
        while(linea != null){
            linea.trim();
            if(linea.equals("Adaptador de Ethernet Ethernet:")){
                adaptador = true;
            }
            if(linea.contains(filtro) && adaptador){
                linea = (String) linea.subSequence(47,(linea.length()));
                linea = linea.trim();
                adaptador = false;
                System.out.println(linea); 
            }
                    
                        
                
                    linea = br.readLine();

        }
        }catch(IOException e){
                e.printStackTrace();
            }
        
        
    }
    
    private void mostrarMascara(){
        String linea = null;
        String filtro = "subred";
        boolean adaptador = false;
        int contador = 0;
           
        try{
                
                p = rt.exec("cmd.exe /c ipconfig");
                BufferedReader br = new BufferedReader (new InputStreamReader(p.getInputStream()));
                linea = br.readLine();
                System.out.println("Máscara de subred: ");
            while(linea != null){
                linea.trim();
                if(linea.equals("Adaptador de Ethernet Ethernet:")){
                    adaptador = true;
                }
                if(linea.contains(filtro) && adaptador){
                    linea = (String) linea.subSequence(47,(linea.length()));
                    linea = linea.trim();
                    adaptador = false;
                    System.out.println(linea); 
                    }
                    
                        
                
                    linea = br.readLine();

            }
        }catch(IOException e){
                e.printStackTrace();
            }
        
        
    }
    
    private void mostrarPuerta(){
        String linea = null;
        String filtro = "Puerta";
        boolean adaptador = false;
           
        try{
                
                p = rt.exec("cmd.exe /c ipconfig");
                BufferedReader br = new BufferedReader (new InputStreamReader(p.getInputStream()));
                linea = br.readLine();
                System.out.println("Puerta de enlace: ");
            while(linea != null){
                linea.trim();
                if(linea.equals("Adaptador de Ethernet Ethernet:")){
                    adaptador = true;
                }
                if(linea.contains(filtro) && adaptador){
                    linea = (String) linea.subSequence(47,(linea.length()));
                    linea = linea.trim();
                    adaptador = false;
                    System.out.println(linea); 
                    }
                    
                        
                
                    linea = br.readLine();

            }
        }catch(IOException e){
                e.printStackTrace();
            }
    }
    
    
    public static void main(String [] args){
        Prog15 p = new Prog15();
        p.iniciarPrograma();
    }
}
