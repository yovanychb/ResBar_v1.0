/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.resbar.controladores;

import clases.Categoria;
import clases.Orden;
import clases.Producto;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import manejadores.ManejadorCategorias;
import manejadores.ManejadorOrdenes;
import org.primefaces.event.SelectEvent;

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
    private List<Orden> filtro;
    private Double efectivo;
    private Double cambio;
    private int idOrden;
    private List<Categoria> categorias;
    private List<Categoria> modificar;
    private Messages msg = new Messages();
    private boolean btnCobrar = false;

    @PostConstruct
    public void init() {
        orden = new Orden();
        ordenes = new ArrayList<Orden>();
        try {
            ordenes = ManejadorOrdenes.ObtenerActivas();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        filtro = new ArrayList<Orden>();
        filtro = ordenes;
    }

    public List<Orden> getOrdenes() {
        try {
            ordenes = ManejadorOrdenes.ObtenerActivas();
            filtro = ordenes;
            return ordenes;
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            return Collections.EMPTY_LIST;
        }

    }

    public void onRowSelect(SelectEvent se) {
        if (se.getObject() != null) {
            try {
                orden = (Orden) se.getObject();
                idOrden = orden.idOrden;

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
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
        return formateador.format(ahora);
    }
    
    public String hora(){
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("hh:mm a");
        return formateador.format(ahora);
    }
    public void cobrar() {
        try {
            if (efectivo >= orden.total) {
                orden.activa = false;
                ManejadorOrdenes.Actualizar(orden);
            } else {

            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);

        }
    }

    public void cambio() {
        if (efectivo == null) {
            cambio = 0.00;
            btnCobrar = false;
        } else {
            if (efectivo >= orden.total) {
                btnCobrar = true;
            } else {
                btnCobrar = false;
            }
            cambio = efectivo - orden.total;
        }
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

    public Double getCambio() {
        return cambio;
    }

    public void setCambio(Double cambio) {
        this.cambio = cambio;
    }

    public Producto getProd() {
        return prod;
    }

    public void setProd(Producto prod) {
        this.prod = prod;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public Double getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(Double efectivo) {
        this.efectivo = efectivo;
    }

    public List<Categoria> getCategorias() {
        try {
            return ManejadorCategorias.Obtener(true);
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            return Collections.EMPTY_LIST;
        }

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

    public List<Orden> getFiltro() {
        return filtro;
    }

    public void setFiltro(List<Orden> filtro) {
        this.filtro = filtro;
    }

    public Messages getMsg() {
        return msg;
    }

    public void setMsg(Messages msg) {
        this.msg = msg;
    }

    public boolean isBtnCobrar() {
        return btnCobrar;
    }

    public void setBtnCobrar(boolean btnCobrar) {
        this.btnCobrar = btnCobrar;
    }
}
