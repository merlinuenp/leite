package dao;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Producao;
import modelo.Vaca;
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
    
    public List<Producao> buscarPorVaca(Vaca vaca){
        manager = JpaUtil.getEntityManager();
        TypedQuery<Producao> query = 
                (TypedQuery<Producao>) manager.createQuery("SELECT p FROM Producao p WHERE p.vaca = :vaca ");
        query.setParameter("vaca", vaca);
        List<Producao> lista = query.getResultList();
        manager.close(); 
        return lista; 
    }
    
}
