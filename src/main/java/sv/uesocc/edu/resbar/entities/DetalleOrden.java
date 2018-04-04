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
public class DetalleOrden implements Serializable{
    private Integer cantidad;
    private String producto;

    public DetalleOrden(){
        
    }
    
    public DetalleOrden(String producto, Integer cantidad){
        this.producto = producto;
        this.cantidad = cantidad;
    }
    
    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
    
    
    
}
