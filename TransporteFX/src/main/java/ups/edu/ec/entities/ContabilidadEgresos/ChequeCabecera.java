/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.entities.ContabilidadEgresos;

import java.io.Serializable;
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
import ups.edu.ec.entities.ContabilidadIngresos.IngresosCabecera;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "TRA_CHEQUE_CABECERA")
@SequenceGenerator(name = "TRA_CHEQUE_CABECERA_SEQ",sequenceName = "TRA_CHEQUE_CABECERA_SEQ", initialValue = 1,allocationSize = 1)
public class ChequeCabecera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRA_CHEQUE_CABECERA_SEQ")
    @Column(name = "CCA_ID", nullable = false)
    private Long id;
    @Column(name = "CCA_EFECTIVO")
    private double efectivo;
    @Column(name = "CCA_TOTAL_RECAUDADO")
    private double totalRecaudado;
    //chequedetalle
    @OneToMany(mappedBy= "chequeCabecera",cascade= {CascadeType.REMOVE,CascadeType.REFRESH}, fetch= FetchType.LAZY) 
    private List<ChequeDetalle> chequeDetalleList;
    //ingresocabecera
    @ManyToOne                      
    @JoinColumn(name="ICA_ID")  
    private IngresosCabecera ingresoCabecera;
  
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(double efectivo) {
        this.efectivo = efectivo;
    }

    public double getTotalRecaudado() {
        return totalRecaudado;
    }

    public void setTotalRecaudado(double totalRecaudado) {
        this.totalRecaudado = totalRecaudado;
    }

    public List<ChequeDetalle> getChequeDetalleList() {
        return chequeDetalleList;
    }

    public void setChequeDetalleList(List<ChequeDetalle> chequeDetalleList) {
        this.chequeDetalleList = chequeDetalleList;
    }

    public IngresosCabecera getIngresoCabecera() {
        return ingresoCabecera;
    }

    public void setIngresoCabecera(IngresosCabecera ingresoCabecera) {
        this.ingresoCabecera = ingresoCabecera;
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
        if (!(object instanceof ChequeCabecera)) {
            return false;
        }
        ChequeCabecera other = (ChequeCabecera) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ups.edu.ec.entities.ContabilidadEgresos.TraChequeCabecera[ id=" + id + " ]";
    }
    
}
