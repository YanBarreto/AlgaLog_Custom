package br.com.algaworks.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.algaworks.entity.Clientes;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Integer>{

	Optional<Clientes> findById(Integer id);

}
