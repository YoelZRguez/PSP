/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea4;

/**
 *
 * @author yoelzr
 */
public class Proceso {
    private String nombre; 
    private String comando;
    private long pid;
    
    
    
    public Proceso(String nombre, String comando, long pid) {
        this.nombre = nombre;
        this.comando = comando;
        this.pid = pid;
    }

    public String getNombre() {
        return nombre;
    }

    public String getComando() {
        return comando;
    }

    public Long getPid() {
        return pid;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }
    
    
    
    

    
    
    
    
    
}
