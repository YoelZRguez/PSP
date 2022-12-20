/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author yoelzr
 */
public class Metodos_F {
    Scanner sc = new Scanner (System.in);
    Process p = null;
    ProcessBuilder pb;
    BufferedReader br;
    
    public void abrirBloc(){
        pb = new ProcessBuilder("notepad.exe");
        try{
            
        pb.command();
        p = pb.start();
        p.waitFor();
        System.out.println("Aplicación cerrada con éxito!");
        
        }catch(IOException e){
            e.printStackTrace();
        
        }catch(InterruptedException i){
            i.printStackTrace();
        }
        
    }
    
    public void ipConfig(){
        String nombreProceso = "ipconfig";
        String linea;
        
        pb = new ProcessBuilder (nombreProceso);
        try{
        
        pb.command();
        p = pb.start();
        br = new BufferedReader(
        new InputStreamReader (p.getInputStream()));
        
        while ((linea = br.readLine()) != null){
            System.out.println(linea);
        }
        br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    public void cmdTeclado(){
        String cmd;
        
        System.out.println("Introduce el comando que deseas ejecutar: ");
        cmd = sc.nextLine();
 
        String linea;
        //pb = new ProcessBuilder (cmd);
        Runtime rt = Runtime.getRuntime();
        
        try{
        p = rt.exec(cmd);
        br = new BufferedReader(
        new InputStreamReader (p.getInputStream()));
        
        while ((linea = br.readLine()) != null){
            System.out.println(linea);
        }
        br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
