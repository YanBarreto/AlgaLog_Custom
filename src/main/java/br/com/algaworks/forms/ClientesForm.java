package br.com.algaworks.forms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;

import br.com.algaworks.entity.Clientes;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class ClientesForm {
	
	
	@NotBlank @Size(min = 3, max = 100)
	private String razao;
	@NotNull
	private double credito;
	@NotBlank @CNPJ
	private String cnpj;
	@NotBlank @Size(min = 2, max = 30)
	private String responsavel;
	
	
	public Clientes converterForm() {
		return new Clientes(this.razao, this.cnpj, this.responsavel,this.credito);
	}
		
	
}
