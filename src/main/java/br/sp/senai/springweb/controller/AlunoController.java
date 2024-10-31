package br.sp.senai.springweb.controller;

import br.sp.senai.springweb.model.Aluno;
import br.sp.senai.springweb.model.dto.AlunoDTO;
import br.sp.senai.springweb.repository.AlunoRepository;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;
    
    @GetMapping("/")
    public String index() {
    	return "index";
    }

    @GetMapping("/cadastro")
    public String mostrarCadastro(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "aluno/alunofrm"; // A página de cadastro
    }

    @PostMapping("/gravar")
    public String gravar(@Valid AlunoDTO alunoDTO, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
        	return "/aluno/alunofrm";
        }
    	
    	alunoRepository.save(alunoDTO.toAluno());
        
        return "redirect:/aluno/listar"; // Redireciona para a lista após salvar
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        List<Aluno> alunos = alunoRepository.findAll();
        model.addAttribute("alunos", alunos);
        return "aluno/alunolst"; // A página que lista os alunos
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("aluno", aluno);
        return "aluno/alunofrm"; // Mesma página para edição
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        alunoRepository.deleteById(id);
        return "redirect:/aluno/listar"; // Redireciona para a lista após deletar
    }
}
