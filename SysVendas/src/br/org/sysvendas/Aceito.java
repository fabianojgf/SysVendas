package br.org.sysvendas;

public class Aceito implements Status {

	@Override
	public void registrar(Pedido pedido) {
		throw new IllegalStateException("Esse pedido já foi registrado.");
	}

	@Override
	public void pagar(Pedido pedido) {
		pedido.setStatus(new Pago());
	}

	@Override
	public void cancelar(Pedido pedido) {
		pedido.setStatus(new Cancelado());
	}

}
