package br.com.algaworks.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.algaworks.entity.Clientes;

@RestController
public class ClientesController {
	
	private Clientes cliente01 = new Clientes(1,"ALGA WORKS","10214293000163","Yan");
	private Clientes cliente02 = new Clientes(2,"ALGA LOGISTICA","10214293000164","Gael");
	
	@GetMapping("/clientes")
	public List<Clientes> listarTodos(){
		return Arrays.asList(cliente01, cliente02);
	}
	
	
	
}
