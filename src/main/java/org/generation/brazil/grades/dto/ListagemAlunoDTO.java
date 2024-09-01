package org.generation.brazil.grades.dto;

import org.generation.brazil.grades.model.DadosCompletosAluno;
import org.springframework.data.domain.Page;

import java.util.List;

public record ListagemAlunoDTO(List<DadosCompletosAluno> Alunos) {

    public static ListagemAlunoDTO pegaConteudo(Page<DadosCompletosAluno> page) {
        return new ListagemAlunoDTO(page.getContent());
    }
}
