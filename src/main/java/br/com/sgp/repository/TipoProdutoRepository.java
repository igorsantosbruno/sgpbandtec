package br.com.sgp.repository;

import br.com.sgp.model.TipoProduto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TipoProdutoRepository extends CrudRepository<TipoProduto, Long> {

    TipoProduto findById(long id);

    List<TipoProduto> findAll();
}
