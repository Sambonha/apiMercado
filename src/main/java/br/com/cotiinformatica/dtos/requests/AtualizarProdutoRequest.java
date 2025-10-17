package br.com.cotiinformatica.dtos.requests;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtualizarProdutoRequest {
	private String nome;
	private BigDecimal preco;
	private Integer quantidade;
	private String categoria;
}
