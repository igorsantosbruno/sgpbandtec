package br.com.sgp.model.query;

public class ReservaQuery {
	
	private final String buscarUsuarioReservas;
	private final String buscarReservas;
	
	public ReservaQuery() {
		
		this.buscarUsuarioReservas = "SELECT " + 
				"				A.titulo AS name," + 
				"				A.valor AS price," + 
				"				A.background AS img," + 
				"				B.id AS reserveId," + 
				"				B.data_limite AS expiresAt " + 
				"                FROM produto AS A INNER JOIN reserva_produto AS B ON A.id = B.id_produto "+ 
				"                WHERE B.id_usuario=";
		
		this.buscarReservas = "SELECT " + 
				"				A.titulo AS name," + 
				"				A.valor AS price," + 
				"				A.background AS img," + 
				"				B.id AS reserveId," + 
				"				B.data_limite AS expiresAt," + 
				"                C.nome AS reservedBy " + 
				"                FROM produto AS A " + 
				"                INNER JOIN reserva_produto AS B ON A.id = B.id_produto " + 
				"                INNER JOIN usuario AS C ON B.id_usuario = C.id;";
	}

	public String getBuscarUsuarioReservas() {
		return buscarUsuarioReservas;
	}

	public String getBuscarReservas() {
		return buscarReservas;
	}
}
