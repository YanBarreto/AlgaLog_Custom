package br.com.algaworks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.algaworks.entity.Pedidos;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Integer> {

}
