/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica_1_1;

/**
 *
 * @author yoelzr
 */
public class Proceso {
    //Creación de variables propias de la clase
    private String comando;
    private long pid;

    
    //Creamos el construcor de la clase
    public Proceso(String comando, long pid) {
        this.comando = comando;
        this.pid = pid;
    }
    
    //Creacion de getters, los cuales nos devuelven los valores de PID y comando
    public String getComando() {
        return comando;
    }

    public long getPid() {
        return pid;
    }

    //Creación de setter de PID, para modificarlo en el posterior
    public void setPid(long pid) {
        this.pid = pid;
    }
    
    //Creamos la clase toString para que nos muestre lo que deseemos al mostrar los procesos
    public String toString(){
         return "Comando: "+getComando()+"\tPID: "+getPid();
        }
    
}
