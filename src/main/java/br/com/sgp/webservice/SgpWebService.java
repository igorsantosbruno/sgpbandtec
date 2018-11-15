	package br.com.sgp.webservice;

import java.util.List;

import br.com.sgp.model.ReservaProduto;
import br.com.sgp.model.TipoProduto;
import br.com.sgp.model.query.ProdutoQuery;
import br.com.sgp.model.query.ReservaQuery;
import br.com.sgp.model.request.GetProdutos;
import br.com.sgp.model.request.ReservaRequest;
import br.com.sgp.model.request.ReservaUsuarioRequest;
import br.com.sgp.repository.ReservaProdutoRepository;
import br.com.sgp.repository.ReservaQueryRepository;
import br.com.sgp.repository.TipoProdutoRepository;
import br.com.sgp.request.SgcRequest;
import br.com.sgp.util.ProdutoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import br.com.sgp.model.Produto;
import br.com.sgp.repository.ProdutoQueryRepository;
import br.com.sgp.repository.ProdutoRepository;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/sgp")
public class SgpWebService {


    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoQueryRepository produtoQueryRepository;

    @Autowired
    private ReservaProdutoRepository reservaProdutoRepository;

    @Autowired
    private TipoProdutoRepository tipoProdutoRepository;
    
    @Autowired
    private ReservaQueryRepository reservaQueryRepository;

    //Lista todos os produtos
    @GetMapping("/get_produtos")
    public GetProdutos getProdutos(Pageable pageable) {
        GetProdutos getProdutos = new GetProdutos(produtoRepository.findAll(pageable), tipoProdutoRepository.findAll());

        return getProdutos;
    }

    //Retorna produtos para alimentar homepage
    @GetMapping("/get_produtos_para_home")
    public List<Produto> getProdutosParaHome() {
    	
    	ProdutoQuery produtoQuery = new ProdutoQuery();
    	return this.produtoQueryRepository.buscar(produtoQuery.getBuscarProdutoParaHome());
    }
    
    @GetMapping("/get_produtos_global")
    public List<Produto> getProdutosGlobal(@RequestParam("param") String param) {
    	
    	ProdutoQuery produtoQuery = new ProdutoQuery();
    	return this.produtoQueryRepository.buscar(produtoQuery.
    			getBuscarProdutosGlobal().replaceAll("param1", param));
    }

    //Insere novo produto
    @PostMapping("/post_produto")
    public void postProduto(@RequestParam("file") MultipartFile file, Produto produto) {

        ProdutoUtil produtoUtil = new ProdutoUtil();

        produto.setBackground(produtoUtil.converterBase64(file));

        produtoRepository.save(produto);
        SgcRequest sgcRequest = new SgcRequest();
        sgcRequest.postSgcConteudo(1);
    }

    //Atualiza produtos
    @PostMapping("/update_produto")
    public void updateProduto(@RequestParam("file") MultipartFile file, Produto produto) {

        ProdutoUtil produtoUtil = new ProdutoUtil();

        if (produto.getisUnique() == 0) {
            produto.setQuantity(produto.getP() + produto.getM() + produto.getG() + produto.getGg());
        }

        produto.setBackground(produtoUtil.converterBase64(file));

        produtoRepository.save(produto);
    }

    //Deleta produtos
    @PostMapping("/delete_produto")
    public void deleteProduto(Produto produto) {

        produtoRepository.delete(produto);
    }

    //Retorna lista de produtos filtrados por tipo
    @PostMapping("post_produto_tipo")
    public List<Produto> postProdutoTipo(String[] tipos) {

        ProdutoUtil produtoUtil = new ProdutoUtil();

        String query = produtoUtil.construirQueryBuscarPorTipo(tipos);

        return produtoQueryRepository.buscar(query);
    }

    //Retorna todas as reservas do sistema
    @GetMapping("/get_reservas")
    public List<ReservaRequest> getReservas() {
    	
    	ReservaQuery reservaQuery = new ReservaQuery();
        return reservaQueryRepository.buscarTodos(reservaQuery.getBuscarReservas());
    }

    //Retorna os tipos de produtos
    @GetMapping("get_tipos")
    public List<TipoProduto> getTipo() {

        return tipoProdutoRepository.findAll();
    }

    //Retorna lista de reserva de um usuário
    @GetMapping("/get_usuario_reservas")
    public List<ReservaUsuarioRequest> getUsuarioReservas(@RequestParam("id_usuario") long idUsuario) {
    	
    	ReservaQuery reservaQuery = new ReservaQuery();
        return this.reservaQueryRepository.buscar(reservaQuery.getBuscarUsuarioReservas() + idUsuario);
    }

    //Cancela reserva
    @PostMapping("/post_cancelar_reserva")
    public void postCancelarReserva(long id) {

        ReservaProduto reservaParaCancelar = reservaProdutoRepository.findById(id);

        Produto produtoParaDevolver = produtoRepository.findById(reservaParaCancelar.getProductId());

        produtoParaDevolver.setP(produtoParaDevolver.getP() + reservaParaCancelar.getP());
        produtoParaDevolver.setM(produtoParaDevolver.getM() + reservaParaCancelar.getM());
        produtoParaDevolver.setG(produtoParaDevolver.getG() + reservaParaCancelar.getG());
        produtoParaDevolver.setGg(produtoParaDevolver.getGg() + reservaParaCancelar.getGg());
        produtoParaDevolver.setisUnique(produtoParaDevolver.getisUnique() + reservaParaCancelar.getIsUnique());

        produtoParaDevolver.setQuantity(produtoParaDevolver.getQuantity() + reservaParaCancelar.getQuantity());

        reservaParaCancelar.setReservedStatus(1);

        reservaProdutoRepository.save(reservaParaCancelar);

        produtoRepository.save(produtoParaDevolver);

    }

    //Realiza reserva
    @PostMapping("/post_reservar")
    public void postReserva(@RequestBody ReservaProduto reserva) {
    	
        Produto produtoParaAtualizar = produtoRepository.findById(reserva.getProductId());
        
        produtoParaAtualizar.setP(produtoParaAtualizar.getP() - reserva.getP());
        produtoParaAtualizar.setM(produtoParaAtualizar.getM() - reserva.getM());
        produtoParaAtualizar.setG(produtoParaAtualizar.getG() - reserva.getG());
        produtoParaAtualizar.setGg(produtoParaAtualizar.getGg() - reserva.getGg());
        produtoParaAtualizar.setisUnique(produtoParaAtualizar.getisUnique() - reserva.getIsUnique());
        
        int quantidadeTotal = 
        		produtoParaAtualizar.getP() + produtoParaAtualizar.getM() + 
        		produtoParaAtualizar.getG() + produtoParaAtualizar.getGg() + produtoParaAtualizar.getisUnique();
        
        produtoParaAtualizar.setQuantity(quantidadeTotal);
        
        ProdutoUtil util = new ProdutoUtil();
        
        reserva.setReservedDate(util.ajustarDataReservaProduto(reserva.getReservedDate(), 1));
        reserva.setLimitDate(util.ajustarDataReservaProduto(reserva.getReservedDate(), 3));
        
        reservaProdutoRepository.save(reserva);

        produtoRepository.save(produtoParaAtualizar);

    }

    //Realiza baixa
    @PostMapping("/post_realiza_baixa")
    public void postRealizaBaixa(ReservaProduto reservaProduto) {

        reservaProdutoRepository.delete(reservaProduto);

    }


    @PostMapping("/post_insere_tipo")
    public  void postInsereTipo(TipoProduto tipoProduto){

        tipoProdutoRepository.save(tipoProduto);
    }
}
