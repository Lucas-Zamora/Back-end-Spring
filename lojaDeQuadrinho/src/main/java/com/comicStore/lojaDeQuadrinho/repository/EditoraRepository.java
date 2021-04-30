package com.comicStore.lojaDeQuadrinho.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.comicStore.lojaDeQuadrinho.model.Editora;

public interface EditoraRepository extends JpaRepository<Editora, Long> 
{
	public List<Editora> findAllByNomeEditoraContainingIgnoreCase (String nomeEditora);
}
