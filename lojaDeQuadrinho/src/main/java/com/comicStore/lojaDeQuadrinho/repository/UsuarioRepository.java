package com.comicStore.lojaDeQuadrinho.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.comicStore.lojaDeQuadrinho.model.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Long>
{
	public List<Usuario> findAllByNomeContainingIgnoreCase (String nome);
}
