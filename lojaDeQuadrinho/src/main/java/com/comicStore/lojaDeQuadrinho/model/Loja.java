package com.comicStore.lojaDeQuadrinho.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "loja")
public class Loja {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_loja;
	
	@Size(max = 50)
	private String nome;
	
	@Size(max = 500)
	private String descricao;
	
	@OneToMany(mappedBy ="loja", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("loja")
	private List<Produto>produto;
	
    @ManyToOne
    @JsonIgnoreProperties("loja")
    private Usuario usuario; // usuario
    
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    	@JoinTable(
    			name = "inscricao",
    			joinColumns = @JoinColumn(name = "loja_id"),
    			inverseJoinColumns = @JoinColumn(name = "usuario_id")		
    			)
    	@JsonIgnoreProperties({"nome","usuario","senha","produto","lojas"})
    	private List<Usuario> usuarios = new ArrayList<>(); // lista de usuarios
    

	public long getId_loja() {
		return id_loja;
	}

	public void setId_loja(long id_loja) {
		this.id_loja = id_loja;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
    
}
