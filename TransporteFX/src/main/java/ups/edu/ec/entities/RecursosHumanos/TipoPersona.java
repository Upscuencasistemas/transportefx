/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.entities.RecursosHumanos;

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
import javax.persistence.UniqueConstraint;
import ups.edu.ec.entities.Abstract.TraAuditoria;

/**
 *
 * @author maga
 */
@Entity
@Table(name = "TRA_TIPO_PERSONA")
@SequenceGenerator(name = "TRA_TIPO_PERSONA_SEQ",sequenceName = "TRA_TIPO_PERSONA_SEQ",initialValue = 1,allocationSize = 1)

public class TipoPersona extends TraAuditoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "TRA_TIPO_PERSONA_SEQ")
    @Column(name = "TPE_ID_PK",nullable = false,unique = true)
    private Long tpeId;
    
    @Column(name = "TPE_DESCRIPCION",length = 500)
    private String tpeDescripcion;
    
    //Relacion tipoPersona_Persona
    @OneToMany(mappedBy = "TPE_PER_FK", fetch = FetchType.LAZY)
    public List<Persona> personalist;
    

    public Long getId() {
        return tpeId;
    }

    public void setTpeId(Long tpeId) {
        this.tpeId = tpeId;
    }

    public void setTpeDescripcion(String tpeDescripcion) {
        this.tpeDescripcion = tpeDescripcion;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getTpeId() {
        return tpeId;
    }

    public String getTpeDescripcion() {
        return tpeDescripcion;
    }

    public void setId(Long id) {
        this.tpeId = id;
    }

    public List<Persona> getPersonalist() {
        return personalist;
    }

    public void setPersonalist(List<Persona> personalist) {
        this.personalist = personalist;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tpeId != null ? tpeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the tpeId fields are not set
        if (!(object instanceof TipoPersona)) {
            return false;
        }
        TipoPersona other = (TipoPersona) object;
        if ((this.tpeId == null && other.tpeId != null) || (this.tpeId != null && !this.tpeId.equals(other.tpeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ups.edu.ec.entities.RRHH.TRAN_TIPO_PERSONA[ id=" + tpeId + " ]";
    }
    
}
