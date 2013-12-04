package poo;

import org.junit.Test;

import poo.Aprovada;


/**
 *
 * @author Microsoft
 */
public class AprovadaTest {

    @Test(expected = IllegalStateException.class)
    public void testSolicitar() throws Exception {
        Aprovada instance = new Aprovada();
        instance.solicitar();
    }

    @Test(expected = IllegalStateException.class)
    public void testAprovar() throws Exception {
        Aprovada instance = new Aprovada();
        instance.aprovar();
    }

    @Test(expected = IllegalStateException.class)
    public void testRecusar() throws Exception {
        Aprovada instance = new Aprovada();
        instance.recusar();
    }

    @Test(expected = IllegalStateException.class)
    public void testRetornar() throws Exception {
        Aprovada instance = new Aprovada();
        instance.retornar();
    }

}
