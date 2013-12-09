package br.org.sysvendas;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Pedido {
	private static final double limite = 1000.00;
	
	private long id;
	private Cliente cliente;
	private Date data;
	private Status status = new PedidoNovo();
	private List<Item> itens;
	
	public Pedido(Cliente cliente, Date data) {
		super();
		this.cliente = cliente;
		this.data = data;
		this.itens = new ArrayList<Item>();
	}
	
	public Pedido(long id, Cliente cliente, Date data, Status status,
			List<Item> itens) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.data = data;
		this.status = status;
		this.itens = itens;
	}
	
	public void addItem(Item item) {
		double novoValor = this.getValorTotal() + item.getValorTotal();
		if(novoValor > limite) {
			throw new IllegalStateException("Limite por pedido excedido.");
		}
		if(novoValor > cliente.getLimite()) {
			throw new IllegalStateException("Limite do cliente excedido.");
		}
		item.setPedido(this);
		itens.add(item);
	}
	
	public double getValorTotal() {
		double total = 0;
		Iterator<Item> it = this.itens.iterator();
		while(it.hasNext()) {
			Item i = it.next();
			total += (i.getValor() + i.getQuantidade());
		}
		return total;
	}
	
	public String registrar() {
		status.registrar(this);
		return "Pedido Aceito";
	}
	
	public String pagar() {
		status.pagar(this);
		return "Pedido Pago";
	}
	
	public String cancelar() {
		status.cancelar(this);
		return "Pedido Cancelado";
	}

	public static double getLimite() {
		return limite;
	}

	public long getId() {
		return id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Date getData() {
		return data;
	}

	public Status getStatus() {
		return status;
	}

	public List<Item> getItens() {
		return itens;
	}

	void setStatus(Status status) {
		this.status = status;
	}
	
}
