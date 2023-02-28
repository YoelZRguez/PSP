package Prog;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Prog51 {
    private Scanner sc;
    private Pattern pat = null;
    private Matcher mat = null;
    
    public Prog51(){
        sc = new Scanner (System.in);
    }
    
    private void iniciarPrograma(){
        int opcion=0;
        
        do{
            opcion = menu();
            procesarOpcion(opcion);
        }while(opcion!=0);
    }
    
    private int menu(){
        System.out.println("---------------------------------------------------");
        System.out.println("Introduce la opción que deseas ejecutar:"
                + "\n1. Validar DNI"
                + "\n2. Validar Nº de teléfono"
                + "\n0. Salir");
        int opcion = Integer.parseInt(sc.nextLine());
        System.out.println("---------------------------------------------------");
        return opcion;
    }
    
    private void procesarOpcion(int opcion){
        switch(opcion){
                case 1:
                    validarDNI();
                    break;
                case 2:
                    validarTelefono();
                    break;
                    
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                    
                default:
                    System.out.println("¡Opción no válida!");
                    break;

        }
    }
    
    
    private void validarDNI(){
        System.out.println("Introduce el DNI que deseas comprobar (formato 00000000-A): ");
        System.out.print("> ");
        String dni = sc.nextLine();
        
        pat = Pattern.compile("[0-9]{8}[A-Z]");
        mat = pat.matcher(dni);
        
        if(mat.matches()){
            System.out.println("DNI correcto: "+dni);
        }else{
            System.out.println("DNI incorrecto: "+dni);
        }
    }
    
    private void validarTelefono(){
        System.out.println("Introduce el telefono que deseas comprobar (formato (6/7)00000000): ");
        System.out.print("> ");
        String tel = sc.nextLine();
        
        pat = Pattern.compile("[6-7][0-9]{8}");
        mat = pat.matcher(tel);
        
        if(mat.matches()){
            System.out.println("Teléfono correcto: "+tel);
        }else{
            System.out.println("Teléfono incorrecto: "+tel);
        }
    }
    
    
    public static void main(String [] args){
        Prog51 p = new Prog51();
        p.iniciarPrograma();
    }
}
