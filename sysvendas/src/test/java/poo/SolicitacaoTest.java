package poo;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

import poo.AguardandoChefia;
import poo.AguardandoRH;
import poo.Aprovada;
import poo.Funcionario;
import poo.NovaSolicitacao;
import poo.Recusada;
import poo.Solicitacao;
import poo.Status;


/**
 * Exemplo de demonstração de um teste O diagrama de atividades pode ajudar aqui
 *
 * @author Marcius
 */
public class SolicitacaoTest {

    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void solicitacaoEhValida() {
        Solicitacao solicitacao = new Solicitacao();

        Set<ConstraintViolation<Solicitacao>> constraintViolations = validator.validateProperty(solicitacao, "funcionario");

        assertEquals(1, constraintViolations.size());
        assertEquals("não pode ser nulo", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Exemplo de demonstração de uma teste
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testSolicitar() throws Exception {
        Solicitacao solicitacao = montaCenario();

        //Ação
        solicitacao.solicitar();

        //Validação
        Status statusEsperado = new AguardandoChefia();
        assertEquals(statusEsperado, solicitacao.status);
    }

    private Solicitacao montaCenario() {
        //Cenário
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("JOAO");
        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setFuncionario(funcionario);
        return solicitacao;
    }

    @Test
    public void testHappyDay() throws Exception {
        Solicitacao solicitacao = montaCenario();

        //Ação
        Status result1 = solicitacao.status;
        solicitacao.solicitar();
        Status result2 = solicitacao.status;
        solicitacao.aprovar();
        Status result3 = solicitacao.status;
        solicitacao.aprovar();
        Status result4 = solicitacao.status;

        //Validação
        assertEquals(new NovaSolicitacao(), result1);
        assertEquals(new AguardandoChefia(), result2);
        assertEquals(new AguardandoRH(), result3);
        assertEquals(new Aprovada(), result4);
    }

    @Test
    public void testSolicitacaoRecusadaPelaChefia() throws Exception {
        Solicitacao solicitacao = montaCenario();

        //Ação
        solicitacao.solicitar();
        solicitacao.recusar();

        //validação
        assertEquals(new Recusada(), solicitacao.status);
    }

    @Test
    public void testSolicitacaoRecusadaPeloRH() throws Exception {
        Solicitacao solicitacao = montaCenario();
        solicitacao.solicitar();
        solicitacao.aprovar();

        //Ação
        solicitacao.recusar();

        //validação
        assertEquals(new Recusada(), solicitacao.status);
    }

    @Test(expected = IllegalStateException.class)
    public void testSolicitacaoNovaNaoPodeSerAprovada() throws Exception {
        Solicitacao solicitacao = montaCenario();

        //Ação/validação
        solicitacao.aprovar();
    }

    @Test(expected = IllegalStateException.class)
    public void testSolicitacaoNovaNaoPodeSerRecusada() throws Exception {
        Solicitacao solicitacao = montaCenario();

        //Ação/validação
        solicitacao.recusar();
    }

    @Test(expected = IllegalStateException.class)
    public void testSolicitacaoAprovadaNaoPodeSerRetornada() throws Exception {
        Solicitacao solicitacao = montaCenario();

        solicitacao.aprovar();
        solicitacao.aprovar();

        //Ação/validação
        solicitacao.retornar("Faltou um documento");
    }

    @Test(expected = IllegalStateException.class)
    public void testSolicitacaoAprovadaNaoPodeSerRecusada() throws Exception {
        Solicitacao solicitacao = montaCenario();

        solicitacao.aprovar();
        solicitacao.aprovar();

        //Ação/validação
        solicitacao.recusar();
    }

    @Test(expected = IllegalStateException.class)
    public void testSolicitacaoRecusadaNaoPodeSerAprovada() throws Exception {
        Solicitacao solicitacao = montaCenario();

        solicitacao.solicitar();
        solicitacao.recusar();

        //Ação/validação
        solicitacao.aprovar();
    }

}
