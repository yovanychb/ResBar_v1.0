/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.resbar.controladores;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
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
@Named(value = "frmOrden")
@ViewScoped
public class frmOrden implements Serializable {

    private Orden orden;
    private Producto prod;
    private List<Orden> ordenes;
    private List<Orden> inicial;
    private List<Orden> filtro;
    private Double efectivo;
    private int numero;
    private List<Categoria> categorias;
    private List<Categoria> modificar;


    @PostConstruct
    public void init() {
        orden = new Orden();
        ordenes = new ArrayList<Orden>();
        inicial = new ArrayList<Orden>();
    }

    public List<Orden> getOrdenes() {
        ordenes = new ArrayList<Orden>();
        if (inicial.isEmpty()) {
            for (int i = 0; i < 20; i++) {
                ordenes.add(new Orden(i, i, "Mesero " + i, "Cliente " + i, "descripcion", 0.0));
            }
            inicial= ordenes;
        }else{
            ordenes = inicial;
        }
        return ordenes;
    }

    public void onRowSelect(SelectEvent se) {
        if (se.getObject() != null) {
            try {
                orden = (Orden) se.getObject();
                numero = orden.getNumero();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
    }

    public void nueva() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("pages/nuevaOrden.jsf");
    }

    public String fecha() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
        return formateador.format(ahora);
    }

    
    public void remove() {
        ordenes.remove(orden);
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }

    public List<Orden> getFiltro() {
        return filtro;
    }

    public void setFiltro(List<Orden> filtro) {
        this.filtro = filtro;
    }
    
     public Producto getProd() {
        return prod;
    }

    public void setProd(Producto prod) {
        this.prod = prod;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Double getEfectivo() {
        return efectivo;
    }

    public List<Orden> getInicial() {
        return inicial;
    }

    public void setInicial(List<Orden> inicial) {
        this.inicial = inicial;
    }

    public void setEfectivo(Double efectivo) {
        this.efectivo = efectivo;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
    
    public List<Categoria> getModificar() {
        return modificar;
    }

    public void setModificar(List<Categoria> modificar) {
        this.modificar = modificar;
    }
}
