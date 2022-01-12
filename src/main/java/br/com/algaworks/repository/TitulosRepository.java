package br.com.algaworks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.algaworks.entity.Titulos;

@Repository
public interface TitulosRepository extends JpaRepository<Titulos, Integer> {

}
