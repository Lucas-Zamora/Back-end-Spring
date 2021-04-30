package com.teste.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.teste.model.ContatoModel;

public interface ContatoRepository extends JpaRepository<ContatoModel, Long> {

}
