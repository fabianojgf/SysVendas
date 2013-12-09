package br.org.sysvendas;

public class Pago implements Status {

	@Override
	public void registrar(Pedido pedido) {
		throw new IllegalStateException("Esse pedido já foi registrado.");
	}

	@Override
	public void pagar(Pedido pedido) {
		throw new IllegalStateException("Esse pedido já foi pago.");

	}

	@Override
	public void cancelar(Pedido pedido) {
		pedido.setStatus(new Cancelado());
	}

}
