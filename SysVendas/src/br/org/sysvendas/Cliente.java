package br.org.sysvendas;

public class Cliente {
	private long id;
	private String nome;
	private String cpf;
	private double limite;
	private Cidade cidade;
	
	public Cliente(String nome, String cpf, double limite,
			Cidade cidade) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.limite = limite;
		this.cidade = cidade;
	}
	
	public Cliente(long id, String nome, String cpf, double limite,
			Cidade cidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.limite = limite;
		this.cidade = cidade;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public double getLimite() {
		return limite;
	}

	public Cidade getCidade() {
		return cidade;
	}
	
}
