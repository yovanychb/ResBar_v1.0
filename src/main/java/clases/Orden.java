/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yovany
 */
@Entity
@Table(name = "Orden", catalog = "resbar", schema = "")
@XmlRootElement
public class Orden implements Serializable {

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idOrden", nullable = false)
    public Integer idOrden;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "mesero", nullable = false, length = 100)
    public String mesero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "mesa", nullable = false, length = 100)
    public String mesa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "cliente", nullable = false, length = 100)
    public String cliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date fecha;
    @Size(max = 350)
    @Column(name = "comentario", length = 350)
    public String comentario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total", nullable = false, precision = 10, scale = 4)
    public Double total;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activa", nullable = false)
    public boolean activa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orden")
    public List<DetalleOrden> detalleOrdenList;

    public Orden() {
    }

    public Orden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public Orden(Integer idOrden, String mesero, String mesa, String cliente, Date fecha, Double total, boolean activa) {
        this.idOrden = idOrden;
        this.mesero = mesero;
        this.mesa = mesa;
        this.cliente = cliente;
        this.fecha = fecha;
        this.total = total;
        this.activa = activa;
    }

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public String getMesero() {
        return mesero;
    }

    public void setMesero(String mesero) {
        this.mesero = mesero;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public boolean getActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    @XmlTransient
    public List<DetalleOrden> getDetalleOrdenList() {
        return detalleOrdenList;
    }

    public void setDetalleOrdenList(List<DetalleOrden> detalleOrdenList) {
        this.detalleOrdenList = detalleOrdenList;
    }
}
