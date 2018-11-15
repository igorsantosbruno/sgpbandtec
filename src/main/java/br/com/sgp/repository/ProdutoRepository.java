package br.com.sgp.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import br.com.sgp.model.Produto;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Long> {

	Page<Produto> findAll(Pageable pageable);
	
	@Query("SELECT p FROM Produto p WHERE p.id = :id")
	Produto findById(@Param("id") long id);
}
