package br.sp.senai.springweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sp.senai.springweb.model.Aluno;

@Repository
public interface AlunoRepository 
	extends JpaRepository<Aluno, Long> {

}
