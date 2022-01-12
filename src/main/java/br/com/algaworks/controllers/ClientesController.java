package br.com.algaworks.controllers;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	//private Clientes cliente01 = new Clientes(1,"ALGA WORKS","10214293000163","Yan");
	//private Clientes cliente02 = new Clientes(2,"ALGA LOGISTICA","10214293000164","Gael");
	
	@Autowired
	ClientesRepository clientesRepository;
	
	
	@GetMapping
	public List<Clientes> listarTodos(){
			
		List<Clientes> clientes = clientesRepository.findAll();
		return clientes;
	}
	
	@PostMapping
	public ResponseEntity<Clientes> cadastrar(@RequestBody ClientesForm form, UriComponentsBuilder uriComponentsBuilder){
		
		Clientes cliente = form.converterForm();
		clientesRepository.save(cliente);
		URI uri = uriComponentsBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(cliente);
				
	
	}
}
	

