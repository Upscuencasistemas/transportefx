/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.entities.Facturacion;

import ups.edu.ec.entities.Abstract.TraAuditoria;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import ups.edu.ec.entities.RecursosHumanos.LiquidacionDetalle;

/**
 *
 * @author carlitosc
 */

// TABLA: TRA_FACTURA_IVAS
@Entity
@Table(name = "TRA_FACTURA_IVAS")
@SequenceGenerator(name = "TRA_FACTURA_IVAS_SEQ", sequenceName = "TRA_FACTURA_IVAS_SEQ", initialValue = 1, allocationSize = 1)

public class Ivas extends TraAuditoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRA_FACTURA_IVA_SEQ")
    @Column(name = "FIV_ID_PK", nullable = false, unique = true)
    private Long traFacturaIvasID;

    @Column(name = "FIV_VALOR", nullable = false, precision = 2, length = 2)
    private int traFacturaIvasValor;
    
    // Relaciones PRIMARY KEY
    // Relacion FacturaIvas_FacturaCabecera
    @OneToMany(mappedBy = "FIV_FCA_FK", fetch = FetchType.LAZY)
    public List<Cabecera> traFacturaCabeceraList;
    
     //Relacion Ivas_LiquidacionDetalle
    @OneToMany(mappedBy = "IVA_LDE_FK", fetch = FetchType.LAZY)
    public List<LiquidacionDetalle>  ivasliqdetlist;
    
    public List<Cabecera> getTraFacturaCabeceraList() {
        return traFacturaCabeceraList;
    }

    public void setTraFacturaCabeceraList(List<Cabecera> traFacturaCabeceraList) {
        this.traFacturaCabeceraList = traFacturaCabeceraList;
    }

    public int getTraFacturaIvasValor() {
        return traFacturaIvasValor;
    }

    public void setTraFacturaIvasValor(int traFacturaIvasValor) {
        this.traFacturaIvasValor = traFacturaIvasValor;
    }
    
    public Long getTraFacturaIvasID() {
        return traFacturaIvasID;
    }

    public void setTraFacturaIvasID(Long traFacturaIvasID) {
        this.traFacturaIvasID = traFacturaIvasID;
    }

    public List<LiquidacionDetalle> getIvasliqdetlist() {
        return ivasliqdetlist;
    }

    public void setIvasliqdetlist(List<LiquidacionDetalle> ivasliqdetlist) {
        this.ivasliqdetlist = ivasliqdetlist;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (traFacturaIvasID != null ? traFacturaIvasID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the traFacturaIvasID fields are not set
        if (!(object instanceof Ivas)) {
            return false;
        }
        Ivas other = (Ivas) object;
        if ((this.traFacturaIvasID == null && other.traFacturaIvasID != null) || (this.traFacturaIvasID != null && !this.traFacturaIvasID.equals(other.traFacturaIvasID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ups.edu.ec.entities.FACTURACION.TraFacturaIvas[ id=" + traFacturaIvasID + " ]";
    }
    
}
