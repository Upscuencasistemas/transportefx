/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.entities.RecursosHumanos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import ups.edu.ec.entities.Abstract.TraAuditoria;
import ups.edu.ec.entities.GuiaDeRemision.Lugares;

/**
 *
 * @author maga
 */
@Entity
@Table(name = "TRA_LIQUIDACION_CABECERA")
@SequenceGenerator(name = "TRA_LCA_SEQ",sequenceName = "TRA_LCA_SEQ",initialValue = 1,allocationSize = 1)

public class LiquidacionCabecera extends TraAuditoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "TRA_LCA_SEQ")
    @Column(name = "LCA_ID_PK",nullable = false,unique = true)
    private Long lcaId;
    
    @Column(name = "LCA_SENORES",length = 200)
    private String lcaSenores;
    
    @Column(name = "LCA_DIRECCION",length = 400)
    private String lcaDireccion;
    
    @Column(name = "LCA_FECHA_EMISION")
    @Temporal(TemporalType.DATE)
    private Date lcaFechaE;
    
    @Column(name = "LCA_USUARIO",length = 200)
    private String lcaUsuario;
    
    @Column(name = "LCA_FECHA")
    @Temporal(TemporalType.DATE)
    private Date lcaFecha;
    
    @Column(name = "LCA_ESTADDO",length = 10)
    private String lcaEstado;
    
    //Relacion liqCabecera_liqDetalle
    @OneToMany(mappedBy = "LCA_LDE_FK", fetch = FetchType.LAZY)
    public List<LiquidacionDetalle> liqDetalleList;
    
    //Relacion liqCabecera_Persona
    @JoinColumn(name = "PER_ID_PK",referencedColumnName = "PER_ID_PK")
    @ManyToOne(fetch = FetchType.LAZY)
    private Persona PER_LCA_FK;
    
    //Relacion liqCabecera_lugares
    @JoinColumn(name = "LUG_ID_PK",referencedColumnName = "LUG_ID_PK")
    @ManyToOne(fetch = FetchType.LAZY)
    private Lugares LUG_LCA_FK;
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lcaId != null ? lcaId.hashCode() : 0);
        return hash;
    }

    public void setLcaId(Long lcaId) {
        this.lcaId = lcaId;
    }

    public void setLcaSenores(String lcaSenores) {
        this.lcaSenores = lcaSenores;
    }

    public void setLcaDireccion(String lcaDireccion) {
        this.lcaDireccion = lcaDireccion;
    }

    public void setLcaFechaE(Date lcaFechaE) {
        this.lcaFechaE = lcaFechaE;
    }

    public void setLcaUsuario(String lcaUsuario) {
        this.lcaUsuario = lcaUsuario;
    }

    public void setLcaFecha(Date lcaFecha) {
        this.lcaFecha = lcaFecha;
    }

    public void setLcaEstado(String lcaEstado) {
        this.lcaEstado = lcaEstado;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getLcaId() {
        return lcaId;
    }

    public String getLcaSenores() {
        return lcaSenores;
    }

    public String getLcaDireccion() {
        return lcaDireccion;
    }

    public Date getLcaFechaE() {
        return lcaFechaE;
    }

    public String getLcaUsuario() {
        return lcaUsuario;
    }

    public Date getLcaFecha() {
        return lcaFecha;
    }

    public String getLcaEstado() {
        return lcaEstado;
    }

    public List<LiquidacionDetalle> getLiqDetalleList() {
        return liqDetalleList;
    }

    public Persona getPER_LCA_FK() {
        return PER_LCA_FK;
    }

    public Lugares getLUG_LCA_FK() {
        return LUG_LCA_FK;
    }

    public void setLiqDetalleList(List<LiquidacionDetalle> liqDetalleList) {
        this.liqDetalleList = liqDetalleList;
    }

    public void setPER_LCA_FK(Persona PER_LCA_FK) {
        this.PER_LCA_FK = PER_LCA_FK;
    }

    public void setLUG_LCA_FK(Lugares LUG_LCA_FK) {
        this.LUG_LCA_FK = LUG_LCA_FK;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LiquidacionCabecera)) {
            return false;
        }
        LiquidacionCabecera other = (LiquidacionCabecera) object;
        if ((this.lcaId == null && other.lcaId != null) || (this.lcaId != null && !this.lcaId.equals(other.lcaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ups.edu.ec.entities.RRHH.TRAN_LIQUIDACION_CABECERA[ id=" + lcaId + " ]";
    }
    
}
