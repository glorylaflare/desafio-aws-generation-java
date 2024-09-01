package org.generation.brazil.grades.model;

public record DadosAtualizaAluno(String nomeAluno,
                                 Integer idadeAluno,
                                 Double notaPrimeiroSemestre,
                                 Double notaSegundoSemestre,
                                 String nomeProfessor,
                                 Integer numeroDaSala) {
}
