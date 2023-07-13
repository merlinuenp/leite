package controle;

import dao.Dao;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Producao;
import modelo.Vaca;
import util.Util;

@Named
@ViewScoped
public class ProducaoGerenciar implements Serializable {

    List<Vaca> vacas;
    Dao<Vaca> daoVaca;
    Dao<Producao> daoProducao;
    Producao novaProducao;

    @PostConstruct
    public void inicializar() {
        daoVaca = new Dao(Vaca.class);
        daoProducao = new Dao(Producao.class);
        vacas = daoVaca.listarTodos();
        novaProducao = new Producao();
        novaProducao.setDataProducao(new Date());
    }

    public void salvarProducao() {
        daoProducao.inserir(novaProducao);
        novaProducao = new Producao();
        novaProducao.setDataProducao(new Date());
        Util.mostrarSucesso("Produção cadastrada");
    }

    public List<Vaca> getVacas() {
        return vacas;
    }

    public void setVacas(List<Vaca> vacas) {
        this.vacas = vacas;
    }

    public Producao getNovaProducao() {
        return novaProducao;
    }

    public void setNovaProducao(Producao novaProducao) {
        this.novaProducao = novaProducao;
    }

}
