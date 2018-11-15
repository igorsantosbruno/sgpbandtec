package br.com.sgp.model.query;

public class ProdutoQuery {

    private final String buscarProdutoParaHome;
    private final String buscarPorTipo;
    private final String buscarProdutosGlobal;

    public ProdutoQuery() {
        this.buscarPorTipo = "SELECT A.titulo AS title,"
        		+ "A.background AS background,"
        		+ "A.descricao AS description,"
        		+ "A.id AS id, "
        		+ "A.valor AS price," 
        		+ "A.quantidade AS quantity "
                + "FROM produto AS A  INNER JOIN tipo_produto AS B ON A.id_tipo = B.id WHERE B.descricao =";

        this.buscarProdutoParaHome = "SELECT "
        		+ "id as id,"
        		+ "titulo AS title,"
        		+ "background AS background,"
        		+ "descricao AS description FROM produto";
        
        this.buscarProdutosGlobal = "SELECT id AS id,"
				+ "titulo AS title,"
				+ "background AS background,"
				+ "descricao AS description FROM produto "
				+ "WHERE titulo LIKE '%param1%' OR descricao LIKE '%param1%'";
    }

    public String getBuscarProdutoParaHome() {

        return this.buscarProdutoParaHome;
    }
    
    public String getBuscarPorTipo() {
    	
        return this.buscarPorTipo;
    }
    
    public String getBuscarProdutosGlobal() {
    	
    	return this.buscarProdutosGlobal;
    }
}
