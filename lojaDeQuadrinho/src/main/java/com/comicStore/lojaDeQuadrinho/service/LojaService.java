package com.comicStore.lojaDeQuadrinho.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comicStore.lojaDeQuadrinho.model.Loja;
import com.comicStore.lojaDeQuadrinho.model.Usuario;
import com.comicStore.lojaDeQuadrinho.repository.LojaRepository;
import com.comicStore.lojaDeQuadrinho.repository.UsuarioRepository;

@Service
public class LojaService {

	@Autowired
	private LojaRepository lojaRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Loja cadastroUsuarioLoja(long id_loja, long id_usuario) {
		Optional<Usuario> usuarioExistente = usuarioRepository.findById(id_usuario);
		Optional<Loja> lojaExistente = lojaRepository.findById(id_loja);

		if (usuarioExistente.isPresent() && lojaExistente.isPresent()) {

			lojaExistente.get().getUsuarios().add(usuarioExistente.get());

			lojaRepository.save(lojaExistente.get());

			return lojaRepository.save(lojaExistente.get());

		}

		return null;
	}

}
