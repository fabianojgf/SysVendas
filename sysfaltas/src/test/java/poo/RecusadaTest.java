package poo;

import org.junit.Test;

/**
 *
 * @author Marcius
 */
public class RecusadaTest {

    @Test(expected = IllegalStateException.class)
    public void testSolicitar() throws Exception {
        Recusada instance = new Recusada();
        instance.solicitar();
    }

    @Test(expected = IllegalStateException.class)
    public void testAprovar() throws Exception {
        Recusada instance = new Recusada();
        instance.aprovar();
    }

    @Test(expected = IllegalStateException.class)
    public void testRecusar() throws Exception {
        Recusada instance = new Recusada();
        instance.recusar();
    }

    @Test(expected = IllegalStateException.class)
    public void testRetornar() throws Exception  {
        Recusada instance = new Recusada();
        instance.retornar();
    }

    @Test(expected = IllegalStateException.class)
    public void testCancelar() throws Exception  {
        Recusada instance = new Recusada();
        instance.cancelar();
    }
}
