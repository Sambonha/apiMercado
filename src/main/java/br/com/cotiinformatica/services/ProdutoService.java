package br.com.cotiinformatica.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.dtos.requests.AtualizarProdutoRequest;
import br.com.cotiinformatica.dtos.requests.CriarProdutoRequest;
import br.com.cotiinformatica.dtos.responses.CriarProdutoResponse;
import br.com.cotiinformatica.entities.Produto;
import br.com.cotiinformatica.exceptions.EstoqueNaoZeradoException;
import br.com.cotiinformatica.exceptions.PrecoInvalidoException;
import br.com.cotiinformatica.exceptions.ProdutoJaCadastradoException;
import br.com.cotiinformatica.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public CriarProdutoResponse criarProduto(CriarProdutoRequest request) {
		var produto = new Produto();

		if (produtoRepository.find(request.getNome()) != null) {
			throw new ProdutoJaCadastradoException();
		}

		if (request.getPreco().compareTo(BigDecimal.ZERO) < 0) {
			throw new PrecoInvalidoException();
		}

		produto.setNome(request.getNome());
		produto.setPreco(request.getPreco());
		produto.setQuantidade(request.getQuantidade());
		produto.setCategoria(request.getCategoria());

		produtoRepository.save(produto);

		var response = new CriarProdutoResponse();

		response.setId(produto.getId());
		response.setNome(produto.getNome());
		response.setPreco(produto.getPreco());
		response.setQuantidade(produto.getQuantidade());
		response.setCategoria(produto.getCategoria());

		return response;

	}

	public CriarProdutoResponse atualizarProduto(UUID id, AtualizarProdutoRequest request) {
		var produto = produtoRepository.findById(id)
		.orElseThrow(() -> new RuntimeException("Produto não encontrado."));

		if (request.getPreco().compareTo(BigDecimal.ZERO) < 0) {
			throw new PrecoInvalidoException();
		}

		produto.setNome(request.getNome());
		produto.setPreco(request.getPreco());
		produto.setQuantidade(request.getQuantidade());
		produto.setCategoria(request.getCategoria());

		produtoRepository.save(produto);

		var response = new CriarProdutoResponse();
		response.setId(produto.getId());
		response.setNome(produto.getNome());
		response.setPreco(produto.getPreco());
		response.setQuantidade(produto.getQuantidade());
		response.setCategoria(produto.getCategoria());

		return response;
	}

	public void excluirProduto(UUID id) {
		var produto = produtoRepository.findById(id)
		.orElseThrow(() -> new RuntimeException("Produto não encontrado."));

		if (produto.getQuantidade() > 0) {
			throw new EstoqueNaoZeradoException();
		}
		produtoRepository.delete(produto);
	}

	public List<CriarProdutoResponse> consultarProdutos() {
		var produtos = produtoRepository.findAll();

		return produtos.stream().map(p -> {
			var response = new CriarProdutoResponse();
			response.setId(p.getId());
			response.setNome(p.getNome());
			response.setPreco(p.getPreco());
			response.setQuantidade(p.getQuantidade());
			response.setCategoria(p.getCategoria());
			return response;
		}).toList();
	}

}
