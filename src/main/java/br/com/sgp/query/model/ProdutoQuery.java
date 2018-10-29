package br.com.sgp.query.model;

public class ProdutoQuery {

    private final String buscarProdutoParaHome;
    private final String buscarPorTipo;

    public String getBuscarPorTipo() {
        return buscarPorTipo;
    }

    public ProdutoQuery() {
        this.buscarPorTipo = "SELECT A.titulo AS title, A.background AS background, A.descricao AS description, A.id AS id, A.valor AS price," +
                "A.quantidade AS quantity FROM produto AS A  INNER JOIN tipo_produto AS B ON A.id_tipo = B.id WHERE B.descricao =";

        this.buscarProdutoParaHome = "SELECT titulo AS title, background AS background, descricao AS description FROM produto";
    }

    public String getBuscarProdutoParaHome() {

        return this.buscarProdutoParaHome;
    }

}
