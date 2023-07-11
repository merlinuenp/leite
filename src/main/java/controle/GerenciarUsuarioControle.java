package controle;

import dao.Dao;
import dao.DaoUsuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Usuario;
import util.Util;



@Named
@ViewScoped
public class GerenciarUsuarioControle implements Serializable {
    private Usuario novoUsuario; 
    private Dao<Usuario> dao; 
    private List<Usuario> lista; 
    
    @PostConstruct
    public void inicializar(){
        novoUsuario = new Usuario();
        dao = new Dao(Usuario.class);
        lista = dao.listarTodos(); 
    }
    
    public String salvar(){
        boolean existe = new DaoUsuario().jaExiste(novoUsuario.getLogin()); 
        if (existe){
            Util.mostrarErro("Login já existe");
            return null; 
        }
        dao.inserir(novoUsuario);
        novoUsuario = new Usuario();
        lista = dao.listarTodos(); 
        Util.mostrarSucesso("Usuário cadastrado");
        return null; 
    }
    
    public void excluir(Usuario excluido){
        dao.excluir(excluido.getId());
        lista = dao.listarTodos(); 
    }

    public Usuario getNovoUsuario() {
        return novoUsuario;
    }

    public void setNovoUsuario(Usuario novoUsuario) {
        this.novoUsuario = novoUsuario;
    }

    public List<Usuario> getLista() {
        return lista;
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }
    
    
    
    
}
