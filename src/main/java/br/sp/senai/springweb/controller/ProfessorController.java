package br.sp.senai.springweb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.sp.senai.springweb.model.Professor;
import br.sp.senai.springweb.model.dto.ProfessorDTO;
import br.sp.senai.springweb.repository.ProfessorRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/professor")
public class ProfessorController {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@GetMapping("/cadastro")
	public String mostrarCadastro(Model model) {
		model.addAttribute("professorDTO", new ProfessorDTO());
		return "professor/professorForms";
	}
	
	@PostMapping("/gravar")
	public String gravar(@Valid ProfessorDTO professor, BindingResult bindingResult) {
	
		if (bindingResult.hasErrors()) {
		
			return "/professor/professorForms";
		}
		
		
		professorRepository.save(professor.toProfessor());
		return "redirect:/professor/listar";
	}
	
	@GetMapping("/listar")
	public String listarProfessores(Model model) {
	    List<Professor> professores = professorRepository.findAll();
	    model.addAttribute("professores", professores);
	    return "professor/professorLst";
	}
	
	  @GetMapping("/editar/{id}")
	    public String editar(@PathVariable Long id, ProfessorDTO professorDto ) {
	        Optional<Professor> tmp = professorRepository.findById(id);
	        if (tmp.isPresent()) {
				Professor p = tmp.get();
				
				professorDto.setId(id);
				professorDto.setNome(p.getNome());
				professorDto.setCpf(p.getCpf());
			}
	        return "professor/professorForms"; 
	    }
	
	  @GetMapping("/deletar/{id}")
	    public String deletar(@PathVariable Long id) {
	        professorRepository.deleteById(id);
	        return "redirect:/professor/listar"; // Redireciona para a lista após deletar
	    }
}
