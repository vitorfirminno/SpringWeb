package br.sp.senai.springweb.model.dto;

import br.sp.senai.springweb.model.Aluno;
import br.sp.senai.springweb.model.Avaliacao;

public class AvaliacaoDTO {

    private Long id;
    private String descricao;
    private Float nota;
    private Aluno aluno;

    // Construtor que aceita uma instância de Avaliacao
    public AvaliacaoDTO(Avaliacao avaliacao) {
        this.id = avaliacao.getId();
        this.descricao = avaliacao.getDescricao();
        this.nota = avaliacao.getNota();
        this.aluno = avaliacao.getAluno();
    }

    // Construtor padrão
    public AvaliacaoDTO() {
    }

    // Método para converter AvaliacaoDTO para Avaliacao
    public Avaliacao toAvaliacao() {
        Avaliacao a = new Avaliacao();
        a.setId(this.id);
        a.setDescricao(this.descricao);
        a.setNota(this.nota);
        a.setAluno(this.aluno);
        return a;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
