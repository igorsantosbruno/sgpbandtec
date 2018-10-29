package br.com.sgp.repository;

import br.com.sgp.model.ReservaProduto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservaProdutoRepository extends CrudRepository<ReservaProduto,Long> {

    ReservaProduto findById(long id);

    List<ReservaProduto> findAll();

    @Query("SELECT r FROM ReservaProduto r WHERE r.userId = :idUsuario")
    List<ReservaProduto> buscarReservas(@Param("idUsuario") long idUsuario);
}


