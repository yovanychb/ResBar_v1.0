/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.resbar.entities;

import java.io.Serializable;

/**
 *
 * @author yovany
 */

public class Orden implements Serializable{
    
    private Integer Numero;
    private Integer Mesa;
    private String Mesero;
    private String Cliente;
    private String Descripcion;
    private Double Total;

    public Orden(){
    }
    
    public Orden(Integer numero, Integer mesa, String mesero, String cliente, String descripcion, Double total){
        this.Numero = numero;
        this.Mesa = mesa;
        this.Mesero = mesero;
        this.Cliente = cliente;
        this.Descripcion = descripcion;
        this.Total = total;
        
        
    }
    
    public Integer getNumero(){
        return Numero;
    }

    public void setNumero(Integer Numero) {
        this.Numero = Numero;
    }

    public Integer getMesa() {
        return Mesa;
    }

    public void setMesa(Integer Mesa) {
        this.Mesa = Mesa;
    }

    public String getMesero() {
        return Mesero;
    }

    public void setMesero(String Mesero) {
        this.Mesero = Mesero;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double Total) {
        this.Total = Total;
    }
    
    
}
