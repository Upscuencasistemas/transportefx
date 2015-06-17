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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "TRA_BANCOS")
@SequenceGenerator(name = "TRA_BANCOS_SEQ",sequenceName = "TRA_BANCOS_SEQ", initialValue = 1,allocationSize = 1)
public class TraBancos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRA_BANCOS_SEQ")
    @Column(name = "BAN_ID", nullable = false)
    private Long id;
    @Column(name = "BAN_NOMBRE", length = 100)
    private String nombre;
    //ComprobanteCabecera
    @OneToMany(mappedBy= "traBanco",cascade= {CascadeType.REMOVE,CascadeType.REFRESH}, fetch= FetchType.LAZY) 
    private List<TraComprobanteCabecera> comprobanteCabeceraList;
    //ChequeDetalle
    @OneToMany(mappedBy= "banco",cascade= {CascadeType.REMOVE,CascadeType.REFRESH}, fetch= FetchType.LAZY) 
    private List<TraChequeDetalle> chequeDetalleList;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<TraComprobanteCabecera> getComprobanteCabeceraList() {
        return comprobanteCabeceraList;
    }

    public void setComprobanteCabeceraList(List<TraComprobanteCabecera> comprobanteCabeceraList) {
        this.comprobanteCabeceraList = comprobanteCabeceraList;
    }

    public List<TraChequeDetalle> getChequeDetalleList() {
        return chequeDetalleList;
    }

    public void setChequeDetalleList(List<TraChequeDetalle> chequeDetalleList) {
        this.chequeDetalleList = chequeDetalleList;
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
        if (!(object instanceof TraBancos)) {
            return false;
        }
        TraBancos other = (TraBancos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ups.edu.ec.entities.ContabilidadEgresos.TraBancos[ id=" + id + " ]";
    }
    
}
