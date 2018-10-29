package br.com.sgp.webservice;

import java.util.List;

import br.com.sgp.model.ReservaProduto;
import br.com.sgp.model.TipoProduto;
import br.com.sgp.repository.ReservaProdutoRepository;
import br.com.sgp.repository.TipoProdutoRepository;
import br.com.sgp.util.ProdutoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.sgp.model.Produto;
import br.com.sgp.repository.ProdutoQueryRepository;
import br.com.sgp.repository.ProdutoRepository;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/sgp")
public class SgpWebService {

    //TODO: verificar paginação, cancelar/reservar "N" produtos.

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoQueryRepository produtoQueryRepository;

    @Autowired
    private ReservaProdutoRepository reservaProdutoRepository;

    @Autowired
    private TipoProdutoRepository tipoProdutoRepository;

    //Lista todos os produtos
    @GetMapping("get_produtos")
    public List<Produto> getProdutos() {

        return produtoRepository.findAll();
    }

    //Retorna produtos para alimentar homepage
    @GetMapping("get_produtos_para_home")
    public List<Produto> getProdutosParaHome() {

        return produtoQueryRepository.buscarProdutoParaHome();
    }

    //Insere novo produto
    @PostMapping("post_produto")
    public void postProduto(Produto produto) {

        produtoRepository.save(produto);
    }

    //Atualiza produtos
    @PostMapping("update_produto")
    public void updateProduto(@RequestParam("file") MultipartFile file, Produto produto) {

        ProdutoUtil produtoUtil = new ProdutoUtil();

        produto.setBackground(produtoUtil.converterBase64(file));

        produtoRepository.save(produto);
    }

    //Deleta produtos
    @PostMapping("delete_produto")
    public void deleteProduto(Produto produto) {

        produtoRepository.delete(produto);
    }

    //Retorna lista de produtos filtrados por tipo
    @PostMapping("post_produto_tipo")
    public List<Produto> postProdutoTipo(String[] tipos) {

        ProdutoUtil produtoUtil = new ProdutoUtil();

        String query = produtoUtil.construirQueryBuscarPorTipo(tipos);

        return produtoQueryRepository.buscarPorTipo(query);
    }

    //Retorna todas as reservas do sistema
    @GetMapping("get_reservas")
    public List<ReservaProduto> getReservas() {

        return reservaProdutoRepository.findAll();
    }

    //Retorna os tipos de produtos
    @GetMapping("get_tipos")
    public List<TipoProduto> getTipo() {

        return tipoProdutoRepository.findAll();
    }

    //Retorna lista de reserva de um usuário
    @GetMapping("get_usuario_reservas")
    public List<ReservaProduto> getUsuarioReservas(@RequestParam("id_usuario") long idUsuario) {
    	
        return reservaProdutoRepository.buscarReservas(idUsuario);
    }

    //Cancela reserva
    @PostMapping("post_cancelar_reserva")
    public void postCancelarReserva(long id) {

        ReservaProduto reservaParaCancelar = reservaProdutoRepository.findById(id);

        long idParaAtualizar = reservaParaCancelar.getProductId();

        reservaProdutoRepository.delete(reservaParaCancelar);

        Produto produtoParaDevolver = produtoRepository.findById(idParaAtualizar);

        int quantidadeAtualizada = produtoParaDevolver.getQuantity() + 1;

        produtoParaDevolver.setQuantity(quantidadeAtualizada);

        produtoRepository.save(produtoParaDevolver);

    }

    //Realiza reserva
    @PostMapping("post_reservar")
    public void postReserva(ReservaProduto reserva) {

        int quantidade = reserva.getQuantity();
        long idProduto = reserva.getProductId();

        reservaProdutoRepository.save(reserva);

        Produto produtoParaAtualizar = produtoRepository.findById(idProduto);

        int quantidadeAtualizada = produtoParaAtualizar.getQuantity() - quantidade;

        produtoParaAtualizar.setQuantity(quantidadeAtualizada);

        produtoRepository.save(produtoParaAtualizar);

    }
}
