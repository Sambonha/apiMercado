package br.com.cotiinformatica.entities;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column
	private UUID id;

	@Column(length = 150, nullable = false, unique = true)
	private String nome;

	@Column(precision = 10, scale = 2, nullable = false)
	private BigDecimal preco;

	@Column(nullable = false)
	private Integer quantidade;

	@Column(length = 100, nullable = false)
	private String categoria;
}
