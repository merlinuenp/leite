
package dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import modelo.Vaca;
import util.JpaUtil;

/**
 *
 * @author José 
 * Métodos adicionais específicos de Vaca que não existem na classe genérica Dao.java
 */

public class DaoVaca implements Serializable{
    EntityManager manager;
    
    
    // não permite duas vacas com o mesmo nome
    public boolean jaExiste(String nome) {
        Vaca temp = null;
        boolean existe = false; 
        manager = JpaUtil.getEntityManager();
        String sql = "SELECT v FROM Vaca v WHERE v.nome = :nome";
        TypedQuery<Vaca> query = manager.createQuery(sql, Vaca.class);
        query.setParameter("nome", nome);
        try {
            temp = query.getSingleResult();
            existe = true; 
        } catch (Exception e) {  
            temp = null; 
        } finally {
            manager.close();
        }
        return existe;
    }
    
    public Vaca buscarPorNome(String nome){
        EntityManager manager = JpaUtil.getEntityManager();
        TypedQuery<Vaca> query = 
                (TypedQuery<Vaca>) manager.createQuery("SELECT v FROM Vaca v WHERE v.nome = :nome ");
        query.setParameter("nome", nome);
        try {
            if (query.getSingleResult() != null) {
                return query.getSingleResult();
            } else {
                return null;
            }
        } catch (NoResultException e) {
            return null;
        } 
    }
    
}
