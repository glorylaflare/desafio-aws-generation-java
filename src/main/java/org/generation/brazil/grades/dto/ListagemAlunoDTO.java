package org.generation.brazil.grades.dto;

import org.generation.brazil.grades.model.DadosListagemAluno;
import org.springframework.data.domain.Page;

import java.util.List;

public record ListagemAlunoDTO(List<DadosListagemAluno> Alunos) {

    public static ListagemAlunoDTO pegaConteudo(Page<DadosListagemAluno> page) {
        return new ListagemAlunoDTO(page.getContent());
    }
}
