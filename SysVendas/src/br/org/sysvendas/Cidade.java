package br.org.sysvendas;

public class Cidade {
	long id;
	String nome;
	
	public Cidade(String nome) {
		super();
		this.nome = nome;
	}
	
	public Cidade(long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
}
