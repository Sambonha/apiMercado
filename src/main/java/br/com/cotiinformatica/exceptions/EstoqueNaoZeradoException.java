package br.com.cotiinformatica.exceptions;

public class EstoqueNaoZeradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "O estoque do produto deve estar zerado para exclusão.";
	}

}
