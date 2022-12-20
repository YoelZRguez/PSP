/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej1;

/**
 *
 * @author yoelzr
 */
public class Proceso {
    private String descripcion; 
    private String comando;
    private long pid;
    private int tipo;
    
    
    
    public Proceso(String comando, String descripcion,int tipo, long pid) {
        this.descripcion = descripcion;
        this.comando = comando;
        this.pid = pid;
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public String getComando() {
        return comando;
    }

    public Long getPid() {
        return pid;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    

    public void setPid(Long pid) {
        this.pid = pid;
    }
    
    
    
    

    
    
    
    
    
}