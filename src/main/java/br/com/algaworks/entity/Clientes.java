package br.com.algaworks.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Clientes {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String razao;
	private double credito;
	private String cnpj;
	private String responsavel;
	
	public Clientes(String razao, String cnpj, String responsavel, double credito) {
		this.razao = razao;
		this.credito = credito;
		this.cnpj = cnpj;
		this.responsavel = responsavel;
	}
	
	public Clientes() {
		
	}
	
	

}
