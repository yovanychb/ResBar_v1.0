/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.resbar.controladores;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.event.SelectEvent;
import sv.uesocc.edu.resbar.entities.Categoria;
import sv.uesocc.edu.resbar.entities.Orden;
import sv.uesocc.edu.resbar.entities.Producto;

/**
 *
 * @author yovany
 */
@Named(value = "frmproductos")
@ViewScoped
public class frmProductos implements Serializable {

    private Producto producto;
    private Orden cuenta;
    private Categoria cate;
    private List<Categoria> cats;
    private List<Producto> productos = new ArrayList<Producto>();
    private List<Producto> lista;
    private List<Producto> detalle = new ArrayList<Producto>();
    private List<Producto> filtro;
   

    @PostConstruct
    public void init() {
        cuenta = new Orden();
        producto = new Producto();
        productos = new ArrayList<Producto>();
        lista = new ArrayList<Producto>();
        

    }

    public List<Producto> getProductos() {
        productos = new ArrayList<Producto>();
        if (lista.isEmpty()) {
            for (int i = 0; i < 20; i++) {
                productos.add(new Producto(i, "Producto " + i, 1.05, 0));
            }
            lista = productos;
        } else {
            productos = lista;
        }
        return productos;
    }

    public void onRowSelect(SelectEvent se) {
        if (se.getObject() != null) {
            try {
                this.producto = (Producto) se.getObject();
                producto.setCantidad(producto.getCantidad() + 1);
                lista.set(producto.getCodigo(), producto);
                detalle.remove(producto);
                detalle.add(producto);
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
    }

    public void redirect() throws IOException {
        try {
            //if (cuenta.getMesa().toString().isEmpty() || cuenta.getMesero().isEmpty() || cuenta.getCliente().isEmpty()) {
            if (cuenta.getMesa()==null) {
                addMessage("Error", "No se ha asignado una mesa a la orden");
            } else {
                FacesContext.getCurrentInstance().getExternalContext().redirect("productos.jsf");
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }

    }
    
    public void focus(){
        
    }

    public void undirect() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("nuevaOrden.jsf");
    }

    public void dashboard() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("../index.jsf");
    }
    
    public void home() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("../inicio.html");
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<Producto> detalle) {
        this.detalle = detalle;
    }

    public List<Producto> getLista() {
        return lista;
    }

    public void setLista(List<Producto> lista) {
        this.lista = lista;
    }

    public List<Producto> getFiltro() {
        return filtro;
    }

    public void setFiltro(List<Producto> filtro) {
        this.filtro = filtro;
    }

    public Orden getCuenta() {
        return cuenta;
    }

    public void setCuenta(Orden cuenta) {
        this.cuenta = cuenta;
    }

    public Categoria getCate() {
        return cate;
    }

    public void setCate(Categoria cate) {
        this.cate= cate;
    }

    public List<Categoria> getCats() {
        cats = new ArrayList<Categoria>();
        cats.add(new Categoria(1,"Bebidas frias"));
        cats.add(new Categoria(2,"Bebidas calientes"));
        cats.add(new Categoria(3,"Postres"));
        cats.add(new Categoria(4,"Sopas"));
        cats.add(new Categoria(5,"Entradas"));
        cats.add(new Categoria(6,"Aperitivos"));
        cats.add(new Categoria(7,"Ensaladas"));
        return cats;
    }

    public void setCats(List<Categoria> cats) {
        this.cats = cats;
    }
    
    
}
