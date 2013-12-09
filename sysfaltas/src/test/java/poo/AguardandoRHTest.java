package poo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marcius
 */
public class AguardandoRHTest {

    @Test(expected = IllegalStateException.class)
    public void testSolicitar() throws Exception {
        AguardandoRH instance = montaCenario();
        instance.solicitar();
    }

    public void testAprovar() throws Exception {
        AguardandoRH instance = montaCenario();
        instance.aprovar();
        assertEquals(new Aprovada(), instance.solicitacao.status);
    }

    public void testRecusar() throws Exception {
        AguardandoRH instance = montaCenario();
        instance.recusar();
        assertEquals(new Recusada(), instance.solicitacao.status);
    }

    public void testRetornar() throws Exception {
        AguardandoRH instance = montaCenario();
        instance.retornar();
        assertEquals(new AguardandoChefia(), instance.solicitacao.status);
    }

    public void testCancelar() throws Exception {
        AguardandoRH instance = montaCenario();
        instance.cancelar();
        assertEquals(new Cancelada(), instance.solicitacao.status);
    }

    private AguardandoRH montaCenario() {
        //Cenário
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("JOAO");
        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setFuncionario(funcionario);

        AguardandoRH instance = new AguardandoRH();
        instance.solicitacao = solicitacao;
        return instance;
    }

}
