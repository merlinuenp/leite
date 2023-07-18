package controle;

import dao.Dao;
import dao.DaoVaca;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named; 
import modelo.Vaca;
import util.Util;



@Named
@ViewScoped
public class VacaGerenciarControle implements Serializable {
    private Vaca novaVaca;
    private Dao<Vaca> dao; 
    private List<Vaca> lista; 
    
    @PostConstruct
    public void inicializar(){
        novaVaca = new Vaca(); 
        dao = new Dao(Vaca.class);
        lista = dao.listarTodos(); 
    }
    
    public String salvar(){
        boolean existe = new DaoVaca().jaExiste(novaVaca.getNome()); 
        if (existe){
            Util.mostrarErro("Nome já existe");
            return null; 
        }
        dao.inserir(novaVaca);
        novaVaca = new Vaca();
        lista = dao.listarTodos(); 
        Util.mostrarSucesso("Vaca cadastrada");
        return null; 
    }
    
    public void excluir(Vaca excluida){
        dao.excluir(excluida.getId());
        lista = dao.listarTodos(); 
    }

    public Vaca getNovaVaca() {
        return novaVaca;
    }

    public void setNovaVaca(Vaca novaVaca) {
        this.novaVaca = novaVaca;
    }

    public List<Vaca> getLista() {
        return lista;
    }

    public void setLista(List<Vaca> lista) {
        this.lista = lista;
    }
  
    
}
