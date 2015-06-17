/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import ups.edu.ec.entities.Abstract.TraAuditoria;

/**
 *
 * @author maga
 */
@Entity
@Table(name = "TRA_LIQUIDACION_FECHA_CABECERA")
@SequenceGenerator(name = "TRA_LIQUIDACION_FECHA_CABECERA_SEQ",sequenceName = "TRA_LIQUIDACION_FECHA_CABECERA_SEQ",initialValue = 1,allocationSize = 1)

public class LiquidacionFechaCabecera extends TraAuditoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "TRA_LIQUIDACION_FECHA_CABECERA_SEQ")
    @Column(name = "LFC_ID_PK",insertable = false,unique = true)
    private Long lfcId;
    
    @Column(name = "LFC_FECHA")
    @Temporal(TemporalType.DATE)
    private Date lfcFecha;
    
    @Column(name = "LFC_FECHA_ACT")
    @Temporal(TemporalType.DATE)
    private Date lfcFechaAct;
    
    @Column(name = "LFC_PERSONA",length = 300)
    private String lfcPersona;
    
    @Column(name = "LFC_NUMERO",precision = 10)
    private int lfcNumero;
    
    @Column(name = "LFC_SALDO_COBRADO",precision = 10, scale = 2)
    private double lfcSaldoCob;
    
    @Column(name = "LFC_SALDO_PAGADO",precision = 10, scale = 2)
    private double lfcSaldoPag;
    
    @Column(name = "LFC_TOTAL_FLETE",precision = 10, scale = 2)
    private double lfcTotalFlete;        
    
    @Column(name = "LFC_RETENCION",precision = 10, scale = 2)
    private double lfcRetencion;
    
    @Column(name = "LFC_COBRO_RUTA",precision = 10, scale = 2)
    private double lfcCobroRut;
    
    @Column(name = "LFC_COBRO_CUENCA",precision = 10, scale = 2)
    private double lfcCobroCuenca;
    
    @Column(name = "LFC_TOTAL_PAGO",precision = 10, scale = 2)
    private double lfcTotalPag;
    
    @Column(name = "LFC_LIDUIDACION1",precision = 8, scale = 2)
    private double lfcLiquidacion1;
    
    @Column(name = "LFC_LIDUIDACION2",precision = 8, scale = 2)
    private double lfcLiquidacion2;
    
    @Column(name = "LFC_DESCUENTO1",length = 10)
    private String lfcDescuento1;
    
    @Column(name = "LFC_DESCUENTO2",length = 10)
    private String lfcDescuento2;
    
    @Column(name = "LFC_ESTADO",length = 10)
    private String lfcEstado;
    
    //Relacion liqfechaCabezera_liqfechaDetalle
    @OneToMany(mappedBy = "LFC_LFD_FK", fetch = FetchType.LAZY)
    public List<LiquidacionFechaDetalle> liqfecDetlist;
    

    public Long getId() {
        return lfcId;
    }

    public void setId(Long id) {
        this.lfcId = id;
    }

    public Long getLfcId() {
        return lfcId;
    }

    public Date getLfcFecha() {
        return lfcFecha;
    }

    public Date getLfcFechaAct() {
        return lfcFechaAct;
    }

    public String getLfcPersona() {
        return lfcPersona;
    }

    public int getLfcNumero() {
        return lfcNumero;
    }

    public double getLfcSaldoCob() {
        return lfcSaldoCob;
    }

    public double getLfcSaldoPag() {
        return lfcSaldoPag;
    }

    public double getLfcTotalFlete() {
        return lfcTotalFlete;
    }

    public double getLfcRetencion() {
        return lfcRetencion;
    }

    public double getLfcCobroRut() {
        return lfcCobroRut;
    }

    public double getLfcCobroCuenca() {
        return lfcCobroCuenca;
    }

    public double getLfcTotalPag() {
        return lfcTotalPag;
    }

    public double getLfcLiquidacion1() {
        return lfcLiquidacion1;
    }

    public double getLfcLiquidacion2() {
        return lfcLiquidacion2;
    }

    public String getLfcDescuento1() {
        return lfcDescuento1;
    }

    public String getLfcDescuento2() {
        return lfcDescuento2;
    }

    public String getLfcEstado() {
        return lfcEstado;
    }

    public List<LiquidacionFechaDetalle> getLiqfecDetlist() {
        return liqfecDetlist;
    }

    public void setLfcId(Long lfcId) {
        this.lfcId = lfcId;
    }

    public void setLfcFecha(Date lfcFecha) {
        this.lfcFecha = lfcFecha;
    }

    public void setLfcFechaAct(Date lfcFechaAct) {
        this.lfcFechaAct = lfcFechaAct;
    }

    public void setLfcPersona(String lfcPersona) {
        this.lfcPersona = lfcPersona;
    }

    public void setLfcNumero(int lfcNumero) {
        this.lfcNumero = lfcNumero;
    }

    public void setLfcSaldoCob(double lfcSaldoCob) {
        this.lfcSaldoCob = lfcSaldoCob;
    }

    public void setLfcSaldoPag(double lfcSaldoPag) {
        this.lfcSaldoPag = lfcSaldoPag;
    }

    public void setLfcTotalFlete(double lfcTotalFlete) {
        this.lfcTotalFlete = lfcTotalFlete;
    }

    public void setLfcRetencion(double lfcRetencion) {
        this.lfcRetencion = lfcRetencion;
    }

    public void setLfcCobroRut(double lfcCobroRut) {
        this.lfcCobroRut = lfcCobroRut;
    }

    public void setLfcCobroCuenca(double lfcCobroCuenca) {
        this.lfcCobroCuenca = lfcCobroCuenca;
    }

    public void setLfcTotalPag(double lfcTotalPag) {
        this.lfcTotalPag = lfcTotalPag;
    }

    public void setLfcLiquidacion1(double lfcLiquidacion1) {
        this.lfcLiquidacion1 = lfcLiquidacion1;
    }

    public void setLfcLiquidacion2(double lfcLiquidacion2) {
        this.lfcLiquidacion2 = lfcLiquidacion2;
    }

    public void setLfcDescuento1(String lfcDescuento1) {
        this.lfcDescuento1 = lfcDescuento1;
    }

    public void setLfcDescuento2(String lfcDescuento2) {
        this.lfcDescuento2 = lfcDescuento2;
    }

    public void setLfcEstado(String lfcEstado) {
        this.lfcEstado = lfcEstado;
    }

    public void setLiqfecDetlist(List<LiquidacionFechaDetalle> liqfecDetlist) {
        this.liqfecDetlist = liqfecDetlist;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lfcId != null ? lfcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the lfcId fields are not set
        if (!(object instanceof LiquidacionFechaCabecera)) {
            return false;
        }
        LiquidacionFechaCabecera other = (LiquidacionFechaCabecera) object;
        if ((this.lfcId == null && other.lfcId != null) || (this.lfcId != null && !this.lfcId.equals(other.lfcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ups.edu.ec.entities.RecursosHumanos.LiquidacionFechaCabecera[ id=" + lfcId + " ]";
    }
    
}
