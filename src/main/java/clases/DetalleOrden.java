/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yovany
 */
@Entity
@Table(name = "DetalleOrden", catalog = "resbar", schema = "")
@XmlRootElement
public class DetalleOrden implements Serializable {

    @EmbeddedId
    protected DetalleOrdenPK detalleOrdenPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad", nullable = false, precision = 8, scale = 2)
    public Double cantidad;
    @JoinColumn(name = "idOrden", referencedColumnName = "idOrden", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    public Orden orden;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    public Producto producto;

    public DetalleOrden() {
    }

    public DetalleOrden(DetalleOrdenPK detalleOrdenPK) {
        this.detalleOrdenPK = detalleOrdenPK;
    }

    public DetalleOrden(DetalleOrdenPK detalleOrdenPK, Double cantidad) {
        this.detalleOrdenPK = detalleOrdenPK;
        this.cantidad = cantidad;
    }

    public DetalleOrdenPK getDetalleOrdenPK() {
        return detalleOrdenPK;
    }

    public void setDetalleOrdenPK(DetalleOrdenPK detalleOrdenPK) {
        this.detalleOrdenPK = detalleOrdenPK;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
