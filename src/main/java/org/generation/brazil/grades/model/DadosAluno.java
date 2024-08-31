package org.generation.brazil.grades.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAluno(
        @NotBlank(message = "Nome do aluno é obrigatório.")
        String nomeAluno,
        @NotNull(message = "Idade do aluno é obrigatória.")
        Integer idadeAluno,
        @NotNull(message = "Nota do primeiro semestre é obrigatória.")
        Double notaPrimeiroSemestre,
        @NotNull(message = "Nota do segundo semestre é obrigatória.")
        Double notaSegundoSemestre,
        String nomeProfessor,
        Integer numeroDaSala) {
}
