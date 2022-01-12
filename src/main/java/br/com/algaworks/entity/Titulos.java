package br.com.algaworks.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.algaworks.enums.StatusTitulo;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Titulos {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	private Clientes cliente;
	private double valor;
	private StatusTitulo status;
	

}
