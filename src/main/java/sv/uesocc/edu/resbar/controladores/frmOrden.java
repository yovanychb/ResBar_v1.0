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
import sv.uesocc.edu.resbar.entities.Orden;

/**
 *
 * @author yovany
 */
@Named(value = "frmOrden")
@ViewScoped
public class frmOrden implements Serializable {

    private Orden orden;
    private List<Orden> ordenes;

    @PostConstruct
    public void init() {
        orden = new Orden();
        ordenes = new ArrayList<Orden>();
    }

    public List<Orden> getOrdenes() {
        ordenes = new ArrayList<Orden>();

        for (int i = 0; i < 20; i++) {

            ordenes.add(new Orden(i, i, "Mesero " + i, "Cliente " + i, "descripcion", 0.0));
        }
        return ordenes;
    }

    public void onRowSelect(SelectEvent se) {
        if (se.getObject() != null) {
            try {
                this.orden = (Orden) se.getObject();
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

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }

}
