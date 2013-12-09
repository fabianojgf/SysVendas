package poo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marcius
 */
public class NovaSolicitacaoTest {

    @Test
    public void testSolicitar() {
        //Cenário
        NovaSolicitacao instance = montaCenario();

        //Ação
        instance.solicitar();

        //Validação
        assertEquals(new AguardandoChefia(), instance.solicitacao.status);
    }

    @Test(expected = IllegalStateException.class)
    public void testAprovar() throws Exception {
        //Cenário
        NovaSolicitacao instance = montaCenario();

        instance.aprovar();
    }

    @Test(expected = IllegalStateException.class)
    public void testRecusar() throws Exception {
        //Cenário
        NovaSolicitacao instance = montaCenario();

        instance.recusar();
    }

    @Test(expected = IllegalStateException.class)
    public void testRetornar() throws Exception {
        //Cenário
        NovaSolicitacao instance = montaCenario();

        instance.retornar();
    }

    @Test(expected = IllegalStateException.class)
    public void testCancelar() throws Exception {
        NovaSolicitacao instance = montaCenario();
        instance.cancelar();
    }

    private NovaSolicitacao montaCenario(){
        //Cenário
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("JOAO");
        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setFuncionario(funcionario);

        NovaSolicitacao instance = new NovaSolicitacao();
        instance.solicitacao = solicitacao;
        return instance;
    }
}
