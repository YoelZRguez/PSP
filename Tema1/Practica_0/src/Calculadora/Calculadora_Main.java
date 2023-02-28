/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package Calculadora;

import io.Escritor;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author YoelZR
 */
public class Calculadora_Main {
    public static void main(String [] args){
    Escritor w = new Escritor ("Resultados.txt");
    Scanner entrada = new Scanner (System.in);
    double num1, num2, total = 0,media, resultado;
    int repeticiones, opcion;
    boolean nValido = false;
    
        //Pedimos cantidad de operaciones que desea realizar.
        w.resetearFichero();
        do{
        System.out.print("Introduzca el numero de operaciones que desea realizar(1-5): ");
        repeticiones = entrada.nextInt();
        
        if (repeticiones <=0 || repeticiones > 5){
            System.out.print("Numero no valido\n");
            nValido = false;
        }
        else{
            nValido = true;
        }
        
        }while (nValido != true);
        

        
        Calculadora operaciones;
        double resultados[] = new double [repeticiones];
        int i = 0;
        
        //Menú con bucles do while anidados
        //Si no introduce una opcion valida se le mandará volver a introducirla
        do{
            do{
            System.out.println("------------------------------------------------");
            System.out.println("\nIntroduzca la operacion que desea realizar: "
                    + "\n 1. Suma"
                    + "\n 2. Resta"
                    + "\n 3. Multiplicacion"
                    + "\n 4. Division");
            System.out.println("------------------------------------------------");
            opcion = entrada.nextInt();
            
            }while(opcion <=0 && opcion >4);

            
            switch (opcion){
                case 1: 
                    System.out.print("Operando 1 (Suma):");
                    num1 = entrada.nextDouble();
                    System.out.print("Operando 2 (Suma):");
                    num2 = entrada.nextDouble();
                    operaciones = new Calculadora(num1, num2);
                    resultado = operaciones.Suma(num1,num2);
                    System.out.println("El resultado de la suma es: "+resultado);
                    resultados[i] = resultado;
                    total+=resultado;
                    break;
                    
                case 2: 
                    System.out.print("Operando 1 (Resta):");
                    num1 = entrada.nextDouble();
                    System.out.print("Operando 2 (Resta):");
                    num2 = entrada.nextDouble();
                    operaciones = new Calculadora(num1, num2);
                    resultado = operaciones.Resta(num1,num2);
                    System.out.println("El resultado de la resta es: "+resultado);
                    resultados[i] = resultado;
                    total+=resultado;
                    break;
                    
                case 3: 
                    System.out.print("Operando 1 (Multiplicacion):");
                    num1 = entrada.nextDouble();
                    System.out.print("Operando 2 (Multiplicacion):");
                    num2 = entrada.nextDouble();
                    operaciones = new Calculadora(num1, num2);
                    resultado = operaciones.Multiplicacion(num1,num2);
                    System.out.println("El resultado de la multiplicacion es: "+resultado);
                    resultados[i] = resultado;
                    total+=resultado;
                    break;
                    
                case 4: 
                    do{
                    System.out.print("Operando 1 (Division):");
                    num1 = entrada.nextDouble();
                    System.out.print("Operando 2 (Division):");
                    num2 = entrada.nextDouble();
                    if(num2 ==0){
                        System.out.println("Operando 2 no valido");
                    }
                    }while(num2 == 0);
                    operaciones = new Calculadora(num1, num2);
                    resultado = operaciones.Division(num1,num2);
                    resultados[i] = resultado;
                    System.out.println("El resultado de la division es: "+resultado);
                    total+=resultado;
                    break;
            
                    
                default : 
                    
                    break;
            }
            
            if (opcion <= 0 || opcion >4){
                System.out.println("Opcion no valida");
            }
            
            else{
            i++;
            }
            
        }while(i<repeticiones);
        
        for(int e = 0; e < resultados.length; e++){
            w.escribirLinea(String.valueOf(resultados[e]));
        }
        
        media = total / repeticiones;
        System.out.println("---------------------------------------------------- ");
        
        System.out.println("La media de los resultados es: "+media);
     
        for (int j = 0; j<resultados.length; j++){
            System.out.println(resultados[j]);
        }
    }
}
