package controle;

import dao.DaoProducao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Producao;


@Named
@ViewScoped
public class ProducaoDiariaControle implements Serializable {
    private Date dia; 
    private List<Producao> lista;
    private Double total; 
    private DaoProducao daoProducao; 

    public ProducaoDiariaControle(){
        dia = new Date();
        lista = new ArrayList();
        total = 0.0;
        daoProducao = new DaoProducao(); 
    }
    
    public void buscarProducaoDiaria(){
        lista = daoProducao.buscarPorData(dia);
        total = 0.0;
        for (int i=0; i < lista.size(); i++){
            total = total + lista.get(i).getQuantidade();
        }       
    }
    
    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public List<Producao> getLista() {
        return lista;
    }

    public void setLista(List<Producao> lista) {
        this.lista = lista;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    
    
}



