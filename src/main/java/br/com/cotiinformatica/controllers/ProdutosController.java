package br.com.cotiinformatica.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.requests.AtualizarProdutoRequest;
import br.com.cotiinformatica.dtos.requests.CriarProdutoRequest;
import br.com.cotiinformatica.exceptions.EstoqueNaoZeradoException;
import br.com.cotiinformatica.exceptions.PrecoInvalidoException;
import br.com.cotiinformatica.exceptions.ProdutoJaCadastradoException;
import br.com.cotiinformatica.services.ProdutoService;

@RestController
@RequestMapping("api/v1/produtos")
public class ProdutosController {

	@Autowired
	private ProdutoService produtoService;

	@PostMapping("criar")
	public ResponseEntity<?> criarProduto(@RequestBody CriarProdutoRequest request) {
		try {
			var response = produtoService.criarProduto(request);
			return ResponseEntity.ok().body(response);

		} catch (ProdutoJaCadastradoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@PutMapping("atualizar/{id}")
	public ResponseEntity<?> atualizarProduto(@PathVariable UUID id, @RequestBody AtualizarProdutoRequest request) {
		try {
			var response = produtoService.atualizarProduto(id, request);
			return ResponseEntity.ok().body(response);
		} catch (PrecoInvalidoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("Erro ao atualizar produto.");
		}
	}

	@DeleteMapping("excluir/{id}")
	public ResponseEntity<?> excluirProduto(@PathVariable UUID id) {
		try {
			produtoService.excluirProduto(id);
			return ResponseEntity.ok().body("Produto excluído com sucesso.");

		} catch (EstoqueNaoZeradoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());

		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("Erro ao excluir o produto.");
		}

	}

	@GetMapping("consultar")
	public ResponseEntity<?> consultarProdutos() {
		try {
			var produtos = produtoService.consultarProdutos();
			return ResponseEntity.ok().body(produtos);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("Erro ao consultar produtos.");
		}
	}
}
