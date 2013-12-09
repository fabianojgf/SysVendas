package br.org.sysvendas;

public class PedidoNovo implements Status {

	@Override
	public void registrar(Pedido pedido) {
		pedido.setStatus(new Aceito());
	}

	@Override
	public void pagar(Pedido pedido) {
		throw new IllegalStateException("Esse pedido ainda não foi registrado.");
	}

	@Override
	public void cancelar(Pedido pedido) {
		throw new IllegalStateException("Esse pedido ainda não foi registrado.");
	}

}
