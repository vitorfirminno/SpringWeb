package br.sp.senai.springweb.model.dto;

import org.hibernate.validator.constraints.br.CPF;

import br.sp.senai.springweb.model.Professor;
import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ProfessorDTO {
	private Long id;	
	
	@Nonnull
	@NotBlank
	private String nome;
	
	//@Pattern(regexp = "[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?[0-9]{2}", message = "CPF Inválido")
	@CPF
	private String cpf;
	
	/*@Size(min = 0, max = 10000)
	private Float salario;*/
	
	public ProfessorDTO() {
		
	}

	public ProfessorDTO(Long id, String nome, String cpf) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public Long getId() {
		return this.id;
		}
		
		public void setId(Long id) {
			this.id = id;
		}
		
		public String getNome() {
			return this.nome;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public String getCpf() {
			return this.cpf;
		}
		
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
	
	public Professor toProfessor() {
		Professor p = new Professor();
		p.setId(this.id);
		p.setNome(this.nome);
		p.setCpf(this.cpf);
		return p;
		
	}

}
