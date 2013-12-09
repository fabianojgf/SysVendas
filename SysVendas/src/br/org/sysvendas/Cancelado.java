package br.org.sysvendas;

public class Cancelado implements Status {

	@Override
	public void registrar(Pedido pedido) {
		throw new IllegalStateException("Esse pedido está cancelado.");
	}

	@Override
	public void pagar(Pedido pedido) {
		throw new IllegalStateException("Esse pedido está cancelado.");
	}

	@Override
	public void cancelar(Pedido pedido) {
		throw new IllegalStateException("Esse pedido já foi cancelado.");
	}

}
