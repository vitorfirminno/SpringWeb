package br.sp.senai.springweb.model;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String cpf;
	
	@OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY) //eager gasoso traz em cascata
	private Set<Avaliacao>  avaliacoes = new HashSet<Avaliacao>();
	
	public Aluno() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Set<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(Set<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	

}
