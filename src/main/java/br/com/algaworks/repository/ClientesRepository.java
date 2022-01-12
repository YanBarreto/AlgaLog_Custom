package br.com.algaworks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.algaworks.entity.Clientes;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Integer>{

}
