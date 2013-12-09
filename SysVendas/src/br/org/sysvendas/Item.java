package br.org.sysvendas;

public class Item {
	long id;
	Pedido pedido;
	Produto produto;
	int quantidade;
	double valor;
	
	public Item(long id, Pedido pedido, Produto produto, int quantidade,
			double valor) {
		super();
		this.id = id;
		this.pedido = pedido;
		this.produto = produto;
		this.quantidade = quantidade;
		this.valor = valor;
	}
	
	public Item(Produto produto, int quantidade,
			double valor) {
		super();
		this.produto = produto;
		this.quantidade = quantidade;
		this.valor = valor;
	}
	
	public double getValorTotal() {
		return (valor * quantidade);
	}

	public long getId() {
		return id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
}
