package com.comicStore.lojaDeQuadrinho.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "editora")
public class Editora {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_editora;

	@Size(max = 30)
	private String nomeEditora;

	@OneToMany(mappedBy = "editora", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("editora")
	private List<Produto> produto;

	public long getId_editora() {
		return id_editora;
	}

	public void setId_editora(long id_editora) {
		this.id_editora = id_editora;
	}

	public String getNomeEditora() {
		return nomeEditora;
	}

	public void setNomeEditora(String nomeEditora) {
		this.nomeEditora = nomeEditora;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

}
