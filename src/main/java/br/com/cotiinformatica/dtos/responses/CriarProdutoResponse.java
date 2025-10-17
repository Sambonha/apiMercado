package br.com.cotiinformatica.dtos.responses;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CriarProdutoResponse {

	private UUID id;
	private String nome;
	private BigDecimal preco;
	private Integer quantidade;
	private String categoria;
}
