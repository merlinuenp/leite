package dao;

import java.util.Date;
import modelo.Producao;
import modelo.Vaca;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author José
 */
public class DaoTest {

    public DaoTest() {
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
//    public void testInserirVaca() {
//        Vaca vaca = new Vaca();
//        vaca.setNome("Mumu");
//        vaca.setRaca("Holandesa");
//        Dao<Vaca> dao = new Dao(Vaca.class);
//        dao.inserir(vaca);
//    }
//    @Test
//    public void testInserirUsuario() {
//        Usuario novo = new Usuario();
//        novo.setNome("Rigby");
//        novo.setLogin("rigby");
//        novo.setSenha("1234");
//        Dao<Usuario> dao = new Dao(Usuario.class);
//        dao.inserir(novo);
//    }
//    @Test
//    public void testListarUsuarios(){
//        Dao<Usuario> dao = new Dao(Usuario.class); 
//        List<Usuario> lista = dao.listarTodos(); 
//        for(Usuario u : lista){
//            System.out.println("Nome: " + u.getNome());
//        }
//    }
//    
    
    
    @Test 
    public void testInserirProducao(){
        Dao<Vaca> daoVaca = new Dao(Vaca.class);
        Vaca vaca = daoVaca.buscarPorCodigo(1);
        
        Producao producao = new Producao();
        producao.setDataProducao(new Date());
        producao.setVaca(vaca);
        producao.setQuantidade(7.0);
        
        Dao<Producao> daoProducao = new Dao(Producao.class);
        daoProducao.inserir(producao);
        
    }
   
}
