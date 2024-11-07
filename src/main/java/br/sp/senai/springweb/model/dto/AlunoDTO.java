package br.sp.senai.springweb.model.dto;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.validator.constraints.br.CPF;

import br.sp.senai.springweb.model.Aluno;
import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;

public class AlunoDTO {
	
	private Long id;
	@Nonnull
	@NotBlank
	private String nome;
	
	@CPF
	private String cpf;
	
	
	private Set<AvaliacaoDTO> avaliacoes = new HashSet<>();
	
	
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
	
	
	
	public Set<AvaliacaoDTO> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(Set<AvaliacaoDTO> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public Aluno toAluno() {
		Aluno a = new Aluno();
		a.setId(this.id);
		a.setNome(this.nome);
		a.setCpf(this.cpf);
		return a;
	}

}
