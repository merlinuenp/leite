package controle;

import dao.Dao;
import dao.DaoProducao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Producao;
import modelo.Vaca;

@Named
@ViewScoped 

public class ProducaoPorVacaControle implements Serializable{
    private Vaca vacaSelecionada; 
    private List<Vaca> listaVacas;
    private List<Producao> listaProducao; 
    private Dao<Vaca> daoVaca;
    private DaoProducao daoProducao; 
    private double total; 
    
    public ProducaoPorVacaControle(){
        vacaSelecionada = new Vaca();        
        daoVaca = new Dao(Vaca.class);
        daoProducao = new DaoProducao();
        listaVacas = daoVaca.listarTodos(); 
        listaProducao = new ArrayList();    
        total = 0.0; 
    }
    
    public void buscar(){
        listaProducao = daoProducao.buscarPorVaca(vacaSelecionada);
        total = 0.0;
        for (int i=0; i < listaProducao.size(); i++){
            total = total + listaProducao.get(i).getQuantidade();
        }       
    }

    public Vaca getVacaSelecionada() {
        return vacaSelecionada;
    }

    public void setVacaSelecionada(Vaca vacaSelecionada) {
        this.vacaSelecionada = vacaSelecionada;
    }

    public List<Vaca> getListaVacas() {
        return listaVacas;
    }

    public void setListaVacas(List<Vaca> listaVacas) {
        this.listaVacas = listaVacas;
    }

    public List<Producao> getListaProducao() {
        return listaProducao;
    }

    public void setListaProducao(List<Producao> listaProducao) {
        this.listaProducao = listaProducao;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
}