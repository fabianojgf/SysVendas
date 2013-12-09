package br.org.sysvendas;

public interface Status {
	public void registrar(Pedido pedido);
	public void pagar(Pedido pedido);
	public void cancelar(Pedido pedido);
}
