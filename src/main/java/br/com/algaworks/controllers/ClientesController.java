package br.com.algaworks.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.algaworks.entity.Clientes;
import br.com.algaworks.forms.ClientesForm;
import br.com.algaworks.repository.ClientesRepository;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

	
	@Autowired
	ClientesRepository clientesRepository;

	
	
	@GetMapping
	public List<Clientes> listarTodos(){
		List<Clientes> clientes = clientesRepository.findAll();
		return clientes;
	}
	
	
	@GetMapping("/{clienteId}")
	public ResponseEntity<Clientes> encontrarCliente(@PathVariable  Integer clienteId){
		
		var cliente = clientesRepository.findById(clienteId);
		if(cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Clientes> cadastrar(@RequestBody ClientesForm form, UriComponentsBuilder uriComponentsBuilder){
		
		Clientes cliente = form.converterForm();
		clientesRepository.save(cliente);
		URI uri = uriComponentsBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(cliente);
	}
	
	@PutMapping("{clienteId}")
	public ResponseEntity<Clientes> atualizarCliente(@PathVariable Integer clienteId, @RequestBody ClientesForm form){
		
		var cliente = clientesRepository.findById(clienteId);
		
		if(cliente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		var clienteAtualizado = form.converterForm();
		clienteAtualizado.setId(clienteId);
		
		clientesRepository.save(clienteAtualizado);
		
		return ResponseEntity.ok().body(clienteAtualizado);
	}
	
	
	
	@DeleteMapping("{clienteId}")
	public ResponseEntity<Void> apagarCliente(@PathVariable Integer clienteId){
				
		if(clientesRepository.findById(clienteId).isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		clientesRepository.deleteById(clienteId);
		
		return ResponseEntity.noContent().build();
	}
	
}
	

