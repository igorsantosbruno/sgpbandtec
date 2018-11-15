package br.com.sgp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.sgp.model.Produto;

@Repository
public class ProdutoQueryRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	public List<Produto> buscar(String query) {

		return jdbcTemplate.query(query,
				new BeanPropertyRowMapper<Produto>(Produto.class));
	}
}
