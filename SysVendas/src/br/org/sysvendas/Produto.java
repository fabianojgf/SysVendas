package br.org.sysvendas;

public class Produto {
	private long id;
	private String descricao;
	private double preco;
	
	public Produto(String descricao, double preco) {
		super();
		this.descricao = descricao;
		this.preco = preco;
	}
	
	public Produto(long id, String descricao, double preco) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
	}

	public long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getPreco() {
		return preco;
	}

}
