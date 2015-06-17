/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.entities.RecursosHumanos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import ups.edu.ec.entities.Abstract.TraAuditoria;
import ups.edu.ec.entities.Facturacion.Ivas;

/**
 *
 * @author maga
 */
@Entity
@Table(name = "TRA_LIQUIDACION_DETALLE")
@SequenceGenerator(name = "TRA_LIQUIDACION_DETALLE_SEQ",sequenceName = "TRA_LIQUIDACION_DETALLE_SEQ",initialValue = 1,allocationSize = 1)

public class LiquidacionDetalle extends TraAuditoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "TRA_LIQUIDACION_DETALLE_SEQ")
    @Column(name = "LDE_ID_PK",nullable = false,unique = true)
    private Long ldeId;
    
    @Column(name = "LDE_SUBTOTAL",precision = 10,scale = 2)
    private double ldeSubtotal;
    
    @Column(name = "LDE_TOTAL",precision = 10,scale = 2)
    private double ldeTotal;
    
    //Realacion liqDetall_liqCabecera
    @JoinColumn(name = "LCA_ID_PK", referencedColumnName = "LCA_ID_PK")
    @ManyToOne(fetch = FetchType.LAZY)
    private LiquidacionCabecera LCA_LDE_FK;
    
    //Relacion LiquidacionDetalle_Ivas
    @JoinColumn(name = "FIV_ID_PK", referencedColumnName = "FIV_ID_PK")
    @ManyToOne(fetch = FetchType.LAZY)
    private Ivas IVA_LDE_FK;
    
    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ldeId != null ? ldeId.hashCode() : 0);
        return hash;
    }

    public void setLdeId(Long ldeId) {
        this.ldeId = ldeId;
    }

    public void setLdeSubtotal(double ldeSubtotal) {
        this.ldeSubtotal = ldeSubtotal;
    }

    public void setLdeTotal(double ldeTotal) {
        this.ldeTotal = ldeTotal;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getLdeId() {
        return ldeId;
    }

    public double getLdeSubtotal() {
        return ldeSubtotal;
    }

    public double getLdeTotal() {
        return ldeTotal;
    }

    public LiquidacionCabecera getLCA_LDE_FK() {
        return LCA_LDE_FK;
    }

    public Ivas getIVA_LDE_FK() {
        return IVA_LDE_FK;
    }

    public void setLCA_LDE_FK(LiquidacionCabecera LCA_LDE_FK) {
        this.LCA_LDE_FK = LCA_LDE_FK;
    }

    public void setIVA_LDE_FK(Ivas IVA_LDE_FK) {
        this.IVA_LDE_FK = IVA_LDE_FK;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the ldeId fields are not set
        if (!(object instanceof LiquidacionDetalle)) {
            return false;
        }
        LiquidacionDetalle other = (LiquidacionDetalle) object;
        if ((this.ldeId == null && other.ldeId != null) || (this.ldeId != null && !this.ldeId.equals(other.ldeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ups.edu.ec.entities.RRHH.TRAN_LIQUIDACION_DETALLE[ id=" + ldeId + " ]";
    }
    
}
