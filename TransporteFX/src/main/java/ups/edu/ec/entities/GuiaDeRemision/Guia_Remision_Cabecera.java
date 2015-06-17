/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.entities.GuiaDeRemision;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import ups.edu.ec.entities.Abstract.TraAuditoria;
import ups.edu.ec.entities.Facturacion.Ivas;
import ups.edu.ec.entities.RecursosHumanos.Persona;

/**
 *
 * @author Julio Martinez
 */
@Entity
@Table(name = "TRA_GUIA_REMISION_CABECERA")
@SequenceGenerator(name = "TRA_GUIA_REMISION_CABECERA_SEQ", sequenceName = "TRA_GUIA_REMISION_CABECERA_SEQ", initialValue = 1, allocationSize = 1)
public class Guia_Remision_Cabecera extends TraAuditoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRA_GUIA_REMISION_CABECERA_SEQ")
    @Column(name="GRC_ID_PK",nullable = false,unique = true)
    private Long grc_id_pk;

    @Column(name="GRC_NUMERO")
    private Long grc_numero;

    @Temporal(TemporalType.DATE)
    @Column(name="GRC_FECHA_INICIO_TRASLADO")
    private Date grc_fechaInicioTraslado;

    @Column(name="GRC_FECHA_FIN_TRASLADO", length = 20)    
    private String grc_fechaFinTraslado;
    
    @Column(name="GRC_COMPONENTE_VENTA", length = 50)    
    private String grc_componenteVenta;

    @Column(name="GRC_FECHA_EMISION", length = 20)    
    private String grc_fechaEmision;

    @Column(name="GRC_SUBTOTAL", precision = 10, scale = 2)    
    private double grc_subtotal;

    @Column(name="GRC_TOTAL_CON_IVA", precision = 10, scale = 2)
    private double grc_totalConIva;

    @Column(name="GRC_USUARIO",length = 100)    
    private String grc_usuario;

    @Temporal(TemporalType.DATE)
    @Column(name="GRC_FECHA")    
    private Date grc_fecha;
    
    @Column(name="GRC_ESTADO", length = 100)    
    private String grc_estado;

    @ManyToOne
    @JoinColumn(name="LUG_GRC_ORIGEN_FK")    
    private Lugares lug_grc_origen_fk;

    @ManyToOne
    @JoinColumn(name="LUG_GRC_DESTINO_FK")
    private Lugares lug_grc_destino_fk;

    @ManyToOne
    @JoinColumn(name="MTR_GRC_FK")    
    private Motivo_Traslados mtr_grc_fk;

    @ManyToOne
    @JoinColumn(name="TFI_GRC_FK")    
    private Ivas tfi_grc_fk;
    //Relacion GuiaRemisionCabecera_Persona Destino
    @ManyToOne
    @JoinColumn(name="PER_GRCD_FK")    
    private Persona PER_GRCD_FK;
    //Relacion GuiaRemisionCabecera_Persona Origen
    @ManyToOne
    @JoinColumn(name="PER_GRCO_FK")    
    private Persona PER_GRCO_FK;
    
    
    public Long getGrc_id_pk() {
        return grc_id_pk;
    }

    public void setGrc_id_pk(Long grc_id_pk) {
        this.grc_id_pk = grc_id_pk;
    }

    public Long getGrc_numero() {
        return grc_numero;
    }

    public void setGrc_numero(Long grc_numero) {
        this.grc_numero = grc_numero;
    }

    public Date getGrc_fechaInicioTraslado() {
        return grc_fechaInicioTraslado;
    }

    public void setGrc_fechaInicioTraslado(Date grc_fechaInicioTraslado) {
        this.grc_fechaInicioTraslado = grc_fechaInicioTraslado;
    }

    public String getGrc_fechaFinTraslado() {
        return grc_fechaFinTraslado;
    }

    public void setGrc_fechaFinTraslado(String grc_fechaFinTraslado) {
        this.grc_fechaFinTraslado = grc_fechaFinTraslado;
    }

    public String getGrc_componenteVenta() {
        return grc_componenteVenta;
    }

    public void setGrc_componenteVenta(String grc_componenteVenta) {
        this.grc_componenteVenta = grc_componenteVenta;
    }

    public String getGrc_fechaEmision() {
        return grc_fechaEmision;
    }

    public void setGrc_fechaEmision(String grc_fechaEmision) {
        this.grc_fechaEmision = grc_fechaEmision;
    }

    public double getGrc_subtotal() {
        return grc_subtotal;
    }

    public void setGrc_subtotal(double grc_subtotal) {
        this.grc_subtotal = grc_subtotal;
    }

    public double getGrc_totalConIva() {
        return grc_totalConIva;
    }

    public void setGrc_totalConIva(double grc_totalConIva) {
        this.grc_totalConIva = grc_totalConIva;
    }

    public String getGrc_usuario() {
        return grc_usuario;
    }

    public void setGrc_usuario(String grc_usuario) {
        this.grc_usuario = grc_usuario;
    }

    public Date getGrc_fecha() {
        return grc_fecha;
    }

    public void setGrc_fecha(Date grc_fecha) {
        this.grc_fecha = grc_fecha;
    }

    public String getGrc_estado() {
        return grc_estado;
    }

    public void setGrc_estado(String grc_estado) {
        this.grc_estado = grc_estado;
    }

    public Lugares getLug_grc_origen_fk() {
        return lug_grc_origen_fk;
    }

    public void setLug_grc_origen_fk(Lugares lug_grc_origen_fk) {
        this.lug_grc_origen_fk = lug_grc_origen_fk;
    }

    public Lugares getLug_grc_destino_fk() {
        return lug_grc_destino_fk;
    }

    public void setLug_grc_destino_fk(Lugares lug_grc_destino_fk) {
        this.lug_grc_destino_fk = lug_grc_destino_fk;
    }

    public Motivo_Traslados getMtr_grc_fk() {
        return mtr_grc_fk;
    }

    public void setMtr_grc_fk(Motivo_Traslados mtr_grc_fk) {
        this.mtr_grc_fk = mtr_grc_fk;
    }

    public Ivas getTfi_grc_fk() {
        return tfi_grc_fk;
    }

    public void setTfi_grc_fk(Ivas tfi_grc_fk) {
        this.tfi_grc_fk = tfi_grc_fk;
    }

    public Persona getTpe_grc_fk() {
        return PER_GRCD_FK;
    }

    public void setTpe_grc_fk(Persona tpe_grc_fk) {
        this.PER_GRCD_FK = tpe_grc_fk;
    }

    public Persona getPER_GRCD_FK() {
        return PER_GRCD_FK;
    }

    public Persona getPER_GRCO_FK() {
        return PER_GRCO_FK;
    }

    public void setPER_GRCD_FK(Persona PER_GRCD_FK) {
        this.PER_GRCD_FK = PER_GRCD_FK;
    }

    public void setPER_GRCO_FK(Persona PER_GRCO_FK) {
        this.PER_GRCO_FK = PER_GRCO_FK;
    }
       
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grc_id_pk != null ? grc_id_pk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Guia_Remision_Cabecera)) {
            return false;
        }
        Guia_Remision_Cabecera other = (Guia_Remision_Cabecera) object;
        if ((this.grc_id_pk == null && other.grc_id_pk != null) || (this.grc_id_pk != null && !this.grc_id_pk.equals(other.grc_id_pk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ups.edu.ec.entities.GuiaDeRemision.Guia_Remision_Cabecera[ id=" + grc_id_pk + " ]";
    }
    
}