package br.sp.senai.springweb.repository;

import org.springframework.stereotype.Repository;

import br.sp.senai.springweb.model.Professor;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProfessorRepository 
	extends JpaRepository<Professor, Long>{
	
}

