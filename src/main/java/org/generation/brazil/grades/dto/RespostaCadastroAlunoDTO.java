package org.generation.brazil.grades.dto;

import org.generation.brazil.grades.model.DadosDetalhadosAluno;

public record RespostaCadastroAlunoDTO(String mensagem, DadosDetalhadosAluno dadosDetalhadosAluno) {
}
