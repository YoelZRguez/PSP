package pkg4_servicios_en_red;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;


public class Prog42 {
    Scanner sc = new Scanner(System.in);
    
    public static void main(String [] args){
        Prog42 m = new Prog42();
        m.iniciarPrograma();
    }
    
    private void iniciarPrograma(){
        String url;
        url = pedirUrl();
        mostrarInformación(url);
        escribirHtml(url);
    }
    
    private String pedirUrl(){
        System.out.println("Introduce la URL para mostrar la información: ");
        System.out.print("> ");
        String url = sc.nextLine();
        
        return url;
    }
    
    private void mostrarInformación(String url){
        try {
            URL web = new URL(url);

            System.out.println("Protocolo: "+web.getProtocol());
            System.out.println("Host: "+web.getHost());
            System.out.println("Puerto: "+web.getPort());
            System.out.println("Puerto (por defecto): "+web.getDefaultPort());
            System.out.println("Fichero: "+web.getFile());
            System.out.println("Referencia: "+web.getRef());
            
        } catch (MalformedURLException ex) {
            System.out.println("No existe la URL indicada");
        }
    }
    
    private void escribirHtml(String url){
        
        try {
            
            URL web = new URL(url);
            URLConnection urlConnection = web.openConnection();
            
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new FileWriter("archivo.html", true));
            
            String linea;
                while((linea = br.readLine()) != null){
                bw.write(linea);
            }
                bw.close();
                br.close();
                    } catch (MalformedURLException ex) {
            System.out.println("No existe la URL introducida");
        } catch (IOException ex) {
            System.out.println("No se puede realizar la operación");
        }
        
    }
}
