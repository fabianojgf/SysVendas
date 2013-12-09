package poo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marcius
 */
public class AguardandoChefiaTest {

    @Test(expected = IllegalStateException.class)
    public void testSolicitar() throws Exception {
        AguardandoChefia instance = montaCenario();
        instance.solicitar();
    }
    
    public void testAprovar() throws Exception {
        AguardandoChefia instance = montaCenario();
        instance.aprovar();
        assertEquals(new AguardandoRH(), instance.solicitacao.status);
    }
    
    public void testRecusar() throws Exception {
        AguardandoChefia instance = montaCenario();
        instance.recusar();
        assertEquals(new Recusada(), instance.solicitacao.status);
    }

    @Test(expected = IllegalStateException.class)
    public void testRetornar() throws Exception {
        AguardandoChefia instance = montaCenario();
        instance.retornar();
    }

    public void testCancelar() throws Exception {
        AguardandoChefia instance = montaCenario();
        instance.cancelar();
        assertEquals(new Cancelada(), instance.solicitacao.status);
    }
    
    private AguardandoChefia montaCenario(){
        //Cenário
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("JOAO");
        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setFuncionario(funcionario);

        AguardandoChefia instance = new AguardandoChefia();
        instance.solicitacao = solicitacao;
        return instance;
    }
}
