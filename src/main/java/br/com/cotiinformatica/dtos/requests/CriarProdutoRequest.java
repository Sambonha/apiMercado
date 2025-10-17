package br.com.cotiinformatica.dtos.requests;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CriarProdutoRequest {
	private String nome;
	private BigDecimal preco;
	private Integer quantidade;
	private String categoria;

}
