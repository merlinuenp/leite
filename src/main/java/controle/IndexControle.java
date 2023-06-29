package controle;

import dao.DaoUsuario;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Usuario;
import util.Util;

@Named
@ViewScoped
public class IndexControle implements Serializable {
    private DaoUsuario daoUsuario;
    private Usuario usuario;
    
    public IndexControle(){
        daoUsuario = new DaoUsuario();
        usuario = new Usuario();
    }
    
    public String autenticar() {
//        Usuario temp = daoUsuario.autenticar(usuario);
//        if (temp == null) {
//            Util.mostrarErro("Usuário ou senha inválidos");
//            return null;
//        }
        return "menu";
    }

    public DaoUsuario getDaoUsuario() {
        return daoUsuario;
    }

    public void setDaoUsuario(DaoUsuario daoUsuario) {
        this.daoUsuario = daoUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
}
