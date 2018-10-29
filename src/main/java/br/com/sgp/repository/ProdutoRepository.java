package br.com.sgp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.sgp.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
	
	List<Produto> findAll();

	Produto findById (long id);
}
