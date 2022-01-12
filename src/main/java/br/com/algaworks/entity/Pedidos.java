package br.com.algaworks.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Pedidos {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numeroPedido;
	private double valorTotal;
	private int quantidadeItens;
	@ManyToOne
	private Clientes cliente;
	
}


