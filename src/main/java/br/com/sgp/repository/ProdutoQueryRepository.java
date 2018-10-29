package br.com.sgp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.sgp.model.Produto;
import br.com.sgp.query.model.ProdutoQuery;

@Repository
public class ProdutoQueryRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Produto> buscarProdutoParaHome() {
		
		ProdutoQuery produtoQuery = new ProdutoQuery();
		return jdbcTemplate.query(produtoQuery.getBuscarProdutoParaHome(),
				new BeanPropertyRowMapper<Produto>(Produto.class));
	}

	public List<Produto> buscarPorTipo(String query) {

		return jdbcTemplate.query(query,
				new BeanPropertyRowMapper<Produto>(Produto.class));
	}
}
