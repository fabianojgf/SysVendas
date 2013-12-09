package poo;

import org.junit.Test;

/**
 *
 * @author Marcius
 */
public class CanceladaTest {
    
 @Test(expected = IllegalStateException.class)
    public void testSolicitar() throws Exception {
        Cancelada instance = new Cancelada();
        instance.solicitar();
    }

    @Test(expected = IllegalStateException.class)
    public void testAprovar() throws Exception {
        Cancelada instance = new Cancelada();
        instance.aprovar();
    }

    @Test(expected = IllegalStateException.class)
    public void testRecusar() throws Exception {
        Cancelada instance = new Cancelada();
        instance.recusar();
    }

    @Test(expected = IllegalStateException.class)
    public void testRetornar() throws Exception {
        Cancelada instance = new Cancelada();
        instance.retornar();
    }
    
    @Test(expected = IllegalStateException.class)
    public void testCancelar() throws Exception {
        Cancelada instance = new Cancelada();
        instance.cancelar();
    }
}
