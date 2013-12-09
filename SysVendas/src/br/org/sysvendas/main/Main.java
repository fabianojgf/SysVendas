package br.org.sysvendas.main;

import java.util.Date;

import br.org.sysvendas.Cidade;
import br.org.sysvendas.Cliente;
import br.org.sysvendas.Item;
import br.org.sysvendas.Pedido;
import br.org.sysvendas.Produto;

public class Main {

	public static void main(String[] args) {
		Produto p1 = new Produto("Sabonete A", 20.50);
		Produto p2 = new Produto("Sabonete B", 3.50);
		Produto p3 = new Produto("Sabonete C", 80.50);
		Produto p4 = new Produto("Sabonete D", 1.30);
		Produto p5 = new Produto("Sabonete E", 1.98);
		
		Item i1 = new Item(p1, 10, p1.getPreco());
		Item i2 = new Item(p2, 10, p2.getPreco());
		Item i3 = new Item(p3, 10, p3.getPreco());
		Item i4 = new Item(p4, 10, p4.getPreco());
		Item i5 = new Item(p5, 10, p5.getPreco());
		
		Cidade cidade = new Cidade("Fortaleza");
		Cliente cliente = new Cliente("Fabiano", "001100110011", 700.00, cidade);
		
		Pedido pedido = new Pedido(cliente, new Date());
		pedido.addItem(i1);
		pedido.addItem(i2);
		pedido.addItem(i3);
		pedido.addItem(i4);
		pedido.addItem(i5);
		
		System.out.println(pedido.getValorTotal());
		System.out.println(pedido.registrar());
		System.out.println(pedido.registrar());
	}

}
