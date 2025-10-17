package br.com.cotiinformatica.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.cotiinformatica.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, UUID> {

	@Query("""
			SELECT p FROM Produto p
			WHERE p.nome LIKE :pNome
			""")
	Produto find(@Param("pNome") String nome);

}
