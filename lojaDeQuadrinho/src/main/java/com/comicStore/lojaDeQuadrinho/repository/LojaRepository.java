package com.comicStore.lojaDeQuadrinho.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.comicStore.lojaDeQuadrinho.model.Loja;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Long> {
	public List<Loja> findAllByNomeContainingIgnoreCase (String nome);
}
