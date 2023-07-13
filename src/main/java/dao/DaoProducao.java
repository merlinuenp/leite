package dao;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import modelo.Producao;
import util.JpaUtil;

/**
 *
 * @author Usuário
 */
public class DaoProducao {
    EntityManager manager;
    
    
    public List<Producao> buscarPorData(Date data){
        manager = JpaUtil.getEntityManager();
        TypedQuery<Producao> query = 
                (TypedQuery<Producao>) manager.createQuery("SELECT p FROM Producao p WHERE p.dataProducao = :data ");
        query.setParameter("data", data);
        List<Producao> lista = query.getResultList();
        manager.close(); 
        return lista; 
    }
    
    
}
