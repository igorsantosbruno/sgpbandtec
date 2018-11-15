package br.com.sgp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.sgp.model.request.ReservaRequest;
import br.com.sgp.model.request.ReservaUsuarioRequest;

@Repository
public class ReservaQueryRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	public List<ReservaUsuarioRequest> buscar(String query) {

		return jdbcTemplate.query(query,
				new BeanPropertyRowMapper<ReservaUsuarioRequest>(ReservaUsuarioRequest.class));
	}
	
	public List<ReservaRequest> buscarTodos(String query) {

		return jdbcTemplate.query(query,
				new BeanPropertyRowMapper<ReservaRequest>(ReservaRequest.class));
	}

}
