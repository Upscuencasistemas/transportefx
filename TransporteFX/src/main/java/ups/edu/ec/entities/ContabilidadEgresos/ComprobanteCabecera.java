/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.entities.ContabilidadEgresos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import ups.edu.ec.entities.RecursosHumanos.Persona;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "TRA_COMPROBANTE_EGRESO_CABECERA")
@SequenceGenerator(name = "TRA_COMPROBANTE_EGRESO_CABECERA_SEQ",sequenceName = "TRA_COMPROBANTE_EGRESO_CABECERA_SEQ", initialValue = 1,allocationSize = 1)
public class ComprobanteCabecera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRA_COMPROBANTE_EGRESO_CABECERA_SEQ")
    @Column(name = "CEC_ID", nullable = false)
    private Long id;
    @Column(name = "CEC_FECHA")
    @Temporal (TemporalType.DATE)
    private Date fecha;
    @Column(name = "CEC_NUMERO_CHEQUE",length = 100)
    private String numCheque;
    @Column(name = "CEC_NUMERO")
    private int numeroEgreso;
    @Column(name = "CEC_SON",length = 100)
    private String son;
    @Column(name = "CEC_VALOR")
    private double valor;
    @Column(name = "CEC_OBSERVACIONES",length = 100)
    private String observaciones;
    @Column(name = "CEC_USUARIO", length = 100)
    private String usuario;
    @Column(name = "CEC_FECHAS")
    @Temporal (TemporalType.DATE)
    private Date fechas;
    @Column(name = "CEC_ESTADO", length = 100)
    private String estado;
    //Bancos
    @ManyToOne                      
    @JoinColumn(name="BAN_ID")  
    private Bancos traBanco;
    //CompprobanteDetalle
    @OneToMany(mappedBy= "comprobanteCabecera",cascade= {CascadeType.REMOVE,CascadeType.REFRESH}, fetch= FetchType.LAZY) 
    private List<ComprobanteDetalle> comprobanteDetalleList;
    //Relacion Egresos/ComprobanteCabecera_Persona BEN
    @JoinColumn(name = "PER_ID_PK",referencedColumnName = "PER_ID_PK")
    @ManyToOne(fetch = FetchType.LAZY)
    private Persona PER_CECAB_FK;
    
    //Relacion Egresos/ComprobanteCabecera_Persona TRA
    @ManyToOne(fetch = FetchType.LAZY)
    private Persona PER_CECAT_FK;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNumeroEgreso() {
        return numeroEgreso;
    }

    public void setNumeroEgreso(int numeroEgreso) {
        this.numeroEgreso = numeroEgreso;
    }

    public String getNumCheque() {
        return numCheque;
    }

    public void setNumCheque(String numCheque) {
        this.numCheque = numCheque;
    }

    public String getSon() {
        return son;
    }

    public void setSon(String son) {
        this.son = son;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFechas() {
        return fechas;
    }

    public void setFechas(Date fechas) {
        this.fechas = fechas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Bancos getTraBanco() {
        return traBanco;
    }

    public void setTraBanco(Bancos traBanco) {
        this.traBanco = traBanco;
    }

    public List<ComprobanteDetalle> getComprobanteDetalleList() {
        return comprobanteDetalleList;
    }

    public void setComprobanteDetalleList(List<ComprobanteDetalle> comprobanteDetalleList) {
        this.comprobanteDetalleList = comprobanteDetalleList;
    }

    public Persona getPER_CECAB_FK() {
        return PER_CECAB_FK;
    }

    public Persona getPER_CECAT_FK() {
        return PER_CECAT_FK;
    }

    public void setPER_CECAB_FK(Persona PER_CECAB_FK) {
        this.PER_CECAB_FK = PER_CECAB_FK;
    }

    public void setPER_CECAT_FK(Persona PER_CECAT_FK) {
        this.PER_CECAT_FK = PER_CECAT_FK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComprobanteCabecera)) {
            return false;
        }
        ComprobanteCabecera other = (ComprobanteCabecera) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ups.edu.ec.entities.ContabilidadEgresos.TraComprobanteCabecera[ id=" + id + " ]";
    }
    
}
