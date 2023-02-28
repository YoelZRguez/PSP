/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calculadora;
import java.io.*;

public class Calculadora {
    private double num1;
    private double num2;
    private double resultado;

    public Calculadora(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public Calculadora (double resultado){
        this.resultado = resultado;
    }


    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public double Suma(double num1, double num2){
    double suma = num1 + num2;
    return suma;
    
    }
    
    public double Resta(double num1, double num2){
    double resta = num1 - num2;
    return resta;
    
    }
    
    public double Multiplicacion(double num1, double num2){
    double mult = num1 * num2;
    return mult;
    
    }
    
    public double Division(double num1, double num2){
    double div = num1 / num2;
    return div;
    
    }
}
