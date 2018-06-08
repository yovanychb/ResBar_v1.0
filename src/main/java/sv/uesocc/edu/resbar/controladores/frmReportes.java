/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.resbar.controladores;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import clases.Orden;

/**
 *
 * @author yovany
 */
@Named(value = "frmReportes")
@ViewScoped
public class frmReportes implements Serializable{

    private String titulo;
    private Orden orden;
    private List<Orden> ordenes;

    @PostConstruct
    public void init() {
        orden = new Orden();
        ordenes = new ArrayList<Orden>();
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }

    public List<Orden> getOrdenes() {
        ordenes = new ArrayList<Orden>();
        for (int i = 0; i < 10; i++) {
//            ordenes.add(new Orden(i, i, "Mesero " + i, "Cliente " + i, "descripcion", 10.0));
        }
        return ordenes;
    }
     public void undirect() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("../inicio.html");
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

}
