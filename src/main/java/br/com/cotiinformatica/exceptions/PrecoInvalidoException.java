package br.com.cotiinformatica.exceptions;

public class PrecoInvalidoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "O preço do produto não pode ser negativo.";
	}
}
