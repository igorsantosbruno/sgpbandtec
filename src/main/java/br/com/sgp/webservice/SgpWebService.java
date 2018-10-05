package br.com.sgp.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgp.model.Produto;
import br.com.sgp.repository.ProdutoRepository;

@RestController
@RequestMapping("/sgp")
public class SgpWebService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("get_produtos")
	public List<Produto> getProdutos() {
		
		return produtoRepository.findAll();
	}
}
