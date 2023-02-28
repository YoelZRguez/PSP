package Prog;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;


public class Prog52 {
    private Scanner sc;
    private Pattern pat = null;
    private Matcher mat = null;
    private File f;
    private BufferedWriter bw;
    private SecretKey clave = null;
    
    public Prog52(){
        sc = new Scanner (System.in);
    }
    
    private void iniciarPrograma(){
        int opcion=0;
        clave = generarClave();
        do{
            opcion = menu();
            procesarOpcion(opcion);
        }while(opcion!=0);
    }
    
    private int menu(){
        System.out.println("---------------------------------------------------");
        System.out.println("Introduce la opción que deseas ejecutar:"
                + "\n1. Crear Fichero"
                + "\n2. Encriptar"
                + "\n3. Desencriptar"
                + "\n0. Salir");
        int opcion = Integer.parseInt(sc.nextLine());
        System.out.println("---------------------------------------------------");
        return opcion;
    }
    
    private void procesarOpcion(int opcion){
        String fichero ="";
        switch(opcion){
                case 1:
                    crearFichero();
                    break;
                case 2:
                    encriptarFichero();
                    break;
                    
                case 3:
                    desencriptarFichero(fichero);
                    break;
                    
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                    
                default:
                    System.out.println("¡Opción no válida!");
                    break;

        }
    }
    
    
    private void crearFichero(){
        try {
        System.out.println("------------------------------------------------");
        System.out.println("Introduce el nombre del fichero a crear: ");
        System.out.print("> ");
        String fichero = sc.nextLine();
        
        System.out.println("------------------------------------------------");
        System.out.println("Introduce el texto que deseas introducir en el fichero: ");
        System.out.print("> ");
        String texto = sc.nextLine();
        System.out.println("------------------------------------------------");
        
        f = new File(fichero);
        f.createNewFile();
        bw = new BufferedWriter(new FileWriter(f));
        bw.write(texto);
            System.out.println("Fichero creado correctamente");
        bw.close();
        } catch (IOException ex) {
            System.out.println("No se ha podido crear el fichero");
        }
 
    }

    private void encriptarFichero(){
        try{
            System.out.println("Introduce el fichero que deseas encriptar: ");
            System.out.println("> ");
            String desencriptado = sc.nextLine();
            
            System.out.println("Introduce el nombre del fichero encriptado resultante: ");
            System.out.println("> ");
            String encriptado = sc.nextLine();
            
            FileInputStream fis = null;
            FileOutputStream fos = null;
            int bytesLeidos;
            byte[] buffer = new byte[1000];
            byte[] bufferCifrado;
            
            Cipher cifrador = Cipher.getInstance("DES");
            cifrador.init(Cipher.ENCRYPT_MODE, clave);
            fis = new FileInputStream(desencriptado);
            fos = new FileOutputStream(encriptado);
            bytesLeidos = fis.read(buffer,0,1000);
            
            while(bytesLeidos!= -1 ){
                bufferCifrado = cifrador.update(buffer,0,bytesLeidos);
                fos.write(bufferCifrado);
                bytesLeidos = fis.read(buffer,0,1000);
            }
            
            bufferCifrado = cifrador.doFinal();
            fos.write(bufferCifrado);
            fis.close();
            fos.close();
        }catch(Exception e){
            
        }

    }
    private void desencriptarFichero(String fichero){
        try{
            
            System.out.println("Introduce el fichero que deseas desencriptar: ");
            System.out.println("> ");
            String encriptado = sc.nextLine();
            
            System.out.println("Introduce el nombre del fichero desencriptado resultante: ");
            System.out.println("> ");
            String desencriptado = sc.nextLine();
            
            FileInputStream fis = null;
            FileOutputStream fos = null;
            int bytesLeidos;
            byte[] buffer = new byte[1000];
            byte[] bufferDescifrado;
            
            Cipher cifrador = Cipher.getInstance("DES");
            cifrador.init(Cipher.DECRYPT_MODE, clave);
            fis = new FileInputStream(encriptado);
            fos = new FileOutputStream(desencriptado);
            bytesLeidos = fis.read(buffer,0,1000);
            
            while(bytesLeidos!= -1 ){
                bufferDescifrado = cifrador.update(buffer,0,bytesLeidos);
                fos.write(bufferDescifrado);
                bytesLeidos = fis.read(buffer,0,1000);
            }
            
            bufferDescifrado = cifrador.doFinal();
            fos.write(bufferDescifrado);
            fis.close();
            fos.close();
        }catch(Exception e){
            
        }
    }    
    
    private SecretKey generarClave(){
        SecretKey clave = null;
        try{
            KeyGenerator keyGen = KeyGenerator.getInstance("DES");
            keyGen.init(56);
            clave = keyGen.generateKey();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return clave;
    }
    
    
    public static void main(String [] args){
        Prog52 p = new Prog52();
        p.iniciarPrograma();
    }
    
}