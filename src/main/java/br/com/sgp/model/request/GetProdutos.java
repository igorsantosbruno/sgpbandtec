package br.com.sgp.model.request;

import br.com.sgp.model.Produto;
import br.com.sgp.model.TipoProduto;
import org.springframework.data.domain.Page;

import java.util.List;

public class GetProdutos {

private Page<Produto> produto;
private List<TipoProduto> tipo;

    public GetProdutos(Page<Produto> produto, List<TipoProduto> tipo) {
        this.produto = produto;
        this.tipo = tipo;
    }

    public Page<Produto> getProduto() {
        return produto;
    }

    public void setProduto(Page<Produto> produto) {
        this.produto = produto;
    }

    public List<TipoProduto> getTipo() {
        return tipo;
    }

    public void setTipo(List<TipoProduto> tipo) {
        this.tipo = tipo;
    }
}
