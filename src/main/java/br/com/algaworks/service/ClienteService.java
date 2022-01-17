package br.com.algaworks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.algaworks.entity.Clientes;
import br.com.algaworks.exception.CnpjExistenteException;
import br.com.algaworks.repository.ClientesRepository;


@Service
public class ClienteService {
	
	@Autowired
	ClientesRepository clienteRepository;
	
	
	public Clientes salvar(Clientes cliente) {
		
		var clienteDto = clienteRepository.findByCnpj(cliente.getCnpj());
		
		if(clienteDto.isEmpty()) {
			clienteRepository.save(cliente);
			return cliente;
		}
		else if (cliente.equals(clienteDto.get())) {
			System.out.println("Encontrou");
			cliente.setId(clienteDto.get().getId());
			clienteRepository.save(cliente);
			return cliente;
			
		}
		else {
			throw new CnpjExistenteException();
		}
		
	}
	
	

}
