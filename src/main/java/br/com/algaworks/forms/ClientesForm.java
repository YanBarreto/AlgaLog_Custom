package br.com.algaworks.forms;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.algaworks.entity.Clientes;
import br.com.algaworks.repository.ClientesRepository;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class ClientesForm {
	
	private String razao;
	private double credito;
	private String cnpj;
	private String responsavel;
	
	
	public Clientes converterForm() {
		return new Clientes(this.razao, this.cnpj, this.responsavel,this.credito);
	}
		
	
}
