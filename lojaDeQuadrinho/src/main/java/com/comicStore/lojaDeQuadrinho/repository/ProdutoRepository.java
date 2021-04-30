package com.comicStore.lojaDeQuadrinho.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.comicStore.lojaDeQuadrinho.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	public List<Produto> findAllByTituloContainingIgnoreCase(String titulo);

	public List<Produto> findAllByPrecoLessThanEqual(double preco);

	public List<Produto> findAllByPrecoGreaterThanEqual(double preco);

	@Query(value = "SELECT * FROM produto WHERE preco = :preco", nativeQuery = true)
	public List<Produto> findAllByPreco(@Param("preco") double preco);
}
