package dao;

import java.util.List;
import modelo.Producao;
import modelo.Vaca;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Usuário
 */
public class DaoProducaoTest {
    
    public DaoProducaoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

//    @Test
//    public void testBuscarProducaoPorData() {
//        List<Producao> lista = new DaoProducao().buscarPorData(new Date()); 
//        for (Producao p : lista){
//            System.out.println(p.getVaca() + " - " + p.getQuantidade());
//        }
//    }
    
//    @Test
//    public void testBuscarPorVaca(){
//        DaoVaca daoVaca = new DaoVaca();
//        Vaca v = daoVaca.buscarPorNome("Mumuzinha");
//        List<Producao> lista = new DaoProducao().buscarPorVaca(v);
//        for (Producao p : lista){
//            System.out.println(p.getDataProducao() + " - " + p.getQuantidade());
//        }
//        
//    }
    
    
}
