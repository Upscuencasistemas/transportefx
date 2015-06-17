/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.entities.RecursosHumanos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
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
import javax.persistence.UniqueConstraint;
import ups.edu.ec.entities.Abstract.TraAuditoria;
import ups.edu.ec.entities.ContabilidadEgresos.ComprobanteCabecera;
import ups.edu.ec.entities.ContabilidadIngresos.IngresosCabecera;
import ups.edu.ec.entities.Facturacion.Cabecera;
import ups.edu.ec.entities.GuiaDeRemision.Guia_Remision_Cabecera;
import ups.edu.ec.entities.HojaDeRuta.Hoja_Ruta_Cabecera;

/**
 *
 * @author maga
 */
@Entity
@Table(name = "TRA_PERSONA",uniqueConstraints = {
@UniqueConstraint(columnNames = "PER_CEDULA")})
@SequenceGenerator(name = "TRA_PERSONA_SEQ",sequenceName = "TRA_PERSONA_SEQ",initialValue = 1,allocationSize = 1)
public class Persona extends TraAuditoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "TRA_PERSONA_SEQ")
    @Column(name = "PER_ID_PK",nullable = false,unique = true)
    private Long perId;
    
    @Basic(optional = false)
    @Column(name = "PER_CEDULA",nullable = false,length = 10,unique = true)    
    private String perCedula;
    
    @Column(name = "PER_NOMBRE",length = 200)
    private String perNombre;
    
    @Column(name = "PER_APELLIDO",length = 200)
    private String perApellido;
    
    @Column(name = "PER_FECHA_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date perFechaNac;
    
    @Column(name = "PER_DIRECCION",length = 400)
    private String perDireccion;
    
    @Column(name = "PER_CELULAR",nullable = false,length = 10)
    private String perCelular;
    
    @Column(name = "PER_TELEFONO",length = 10)
    private String perTelefono;
    
    //Relacion Persona_tipoPersona
    @JoinColumn(name = "TPE_ID_PK",referencedColumnName = "TPE_ID_PK")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoPersona TPE_PER_FK;
    
    //Realacion Persona_liqCabecera
    @OneToMany(mappedBy = "PER_LCA_FK", fetch = FetchType.LAZY) 
    private List<LiquidacionCabecera> lqcalist;
   
    //Relacion Persona_FacturaCabecera
    @OneToMany(mappedBy = "PER_FCA_FK", fetch = FetchType.LAZY) 
    private List<Cabecera> factcablist;
    
    //Relacion Persona_HojaRutaCabecera
    @OneToMany(mappedBy = "PER_HRC_FK", fetch = FetchType.LAZY) 
    private List<Hoja_Ruta_Cabecera> hojrutaCablist;
    
    //Relacion Persona_GuiaRemisionCabecera Origen
    @OneToMany(mappedBy = "PER_GRCO_FK", fetch = FetchType.LAZY)
    private List<Guia_Remision_Cabecera> guiReCabOrilist;
    
    //Relacion Persona_GuiaRemisionCabecera Destino
    @OneToMany(mappedBy = "PER_GRCD_FK", fetch = FetchType.LAZY)
    private List<Guia_Remision_Cabecera> guiReCabDeslist;
    
    
    //Relacion Persona_ComprobanteEgresoCabecera BEN
    @OneToMany(mappedBy = "PER_CECAB_FK", fetch = FetchType.LAZY)
    private List<ComprobanteCabecera> perComCabEgBenlist;
    
    //Relacion Persona_ComprobanteEgresoCabecera TRA
    @OneToMany(mappedBy = "PER_CECAT_FK", fetch = FetchType.LAZY)
    private List<ComprobanteCabecera> perComCabEgTralist;
    
    //Relacion Persona_IngresoCabeceras
    @OneToMany(mappedBy = "PER_ICA_FK",fetch = FetchType.LAZY)
    private List<IngresosCabecera> perInfCablist;     
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perId != null ? perId.hashCode() : 0);
        return hash;
    }

    public void setPerId(Long perId) {
        this.perId = perId;
    }

    public void setPerCedula(String perCedula) {
        this.perCedula = perCedula;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    public void setPerApellido(String perApellido) {
        this.perApellido = perApellido;
    }

    public void setPerFechaNac(Date perFechaNac) {
        this.perFechaNac = perFechaNac;
    }

    public void setPerDireccion(String perDireccion) {
        this.perDireccion = perDireccion;
    }

    public void setPerCelular(String perCelular) {
        this.perCelular = perCelular;
    }

    public void setPerTelefono(String perTelefono) {
        this.perTelefono = perTelefono;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getPerId() {
        return perId;
    }

    public String getPerCedula() {
        return perCedula;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public String getPerApellido() {
        return perApellido;
    }

    public Date getPerFechaNac() {
        return perFechaNac;
    }

    public String getPerDireccion() {
        return perDireccion;
    }

    public String getPerCelular() {
        return perCelular;
    }

    public String getPerTelefono() {
        return perTelefono;
    }

    public TipoPersona getTPE_PER_FK() {
        return TPE_PER_FK;
    }

    public List<LiquidacionCabecera> getLqcalist() {
        return lqcalist;
    }

    public List<Cabecera> getFactcablist() {
        return factcablist;
    }

    public List<Hoja_Ruta_Cabecera> getHojrutaCablist() {
        return hojrutaCablist;
    }

    public List<Guia_Remision_Cabecera> getGuiReCabOrilist() {
        return guiReCabOrilist;
    }

    public List<Guia_Remision_Cabecera> getGuiReCabDeslist() {
        return guiReCabDeslist;
    }

    public List<ComprobanteCabecera> getPerComCabEgBenlist() {
        return perComCabEgBenlist;
    }

    public List<ComprobanteCabecera> getPerComCabEgTralist() {
        return perComCabEgTralist;
    }

    public List<IngresosCabecera> getPerInfCablist() {
        return perInfCablist;
    }

    public void setTPE_PER_FK(TipoPersona TPE_PER_FK) {
        this.TPE_PER_FK = TPE_PER_FK;
    }

    public void setLqcalist(List<LiquidacionCabecera> lqcalist) {
        this.lqcalist = lqcalist;
    }

    public void setFactcablist(List<Cabecera> factcablist) {
        this.factcablist = factcablist;
    }

    public void setHojrutaCablist(List<Hoja_Ruta_Cabecera> hojrutaCablist) {
        this.hojrutaCablist = hojrutaCablist;
    }

    public void setGuiReCabOrilist(List<Guia_Remision_Cabecera> guiReCabOrilist) {
        this.guiReCabOrilist = guiReCabOrilist;
    }

    public void setGuiReCabDeslist(List<Guia_Remision_Cabecera> guiReCabDeslist) {
        this.guiReCabDeslist = guiReCabDeslist;
    }

    public void setPerComCabEgBenlist(List<ComprobanteCabecera> perComCabEgBenlist) {
        this.perComCabEgBenlist = perComCabEgBenlist;
    }

    public void setPerComCabEgTralist(List<ComprobanteCabecera> perComCabEgTralist) {
        this.perComCabEgTralist = perComCabEgTralist;
    }

    public void setPerInfCablist(List<IngresosCabecera> perInfCablist) {
        this.perInfCablist = perInfCablist;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the perId fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.perId == null && other.perId != null) || (this.perId != null && !this.perId.equals(other.perId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ups.edu.ec.entities.RRHH.TRAN_PERSONA[ id=" + perId + " ]";
    }
    
}
