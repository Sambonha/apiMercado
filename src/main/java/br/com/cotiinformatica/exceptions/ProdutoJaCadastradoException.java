package br.com.cotiinformatica.exceptions;

public class ProdutoJaCadastradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Produto já cadastrado.";
	}
}
