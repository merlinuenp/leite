package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Producao implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name="vaca", referencedColumnName = "id")
    private Vaca vaca; 
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date dataProducao; 
    
    @Column(columnDefinition="Decimal(10,2) default '0.00'")
    private Double quantidade; 

    public Producao() { }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Vaca getVaca() {
        return vaca;
    }

    public void setVaca(Vaca vaca) {
        this.vaca = vaca;
    }

    public Date getDataProducao() {
        return dataProducao;
    }

    public void setDataProducao(Date dataProducao) {
        this.dataProducao = dataProducao;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.vaca);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producao other = (Producao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.vaca, other.vaca);
    }
    
    
    
    
    
}
