package org.generation.brazil.grades.model;

public record DadosCompletosAluno(Long id,
                                  String nomeAluno,
                                  Integer idadeAluno,
                                  Double notaPrimeiroSemestre,
                                  Double notaSegundoSemestre,
                                  String nomeProfessor,
                                  Integer numeroDaSala) {

    public DadosCompletosAluno(Aluno aluno) {
        this(aluno.getId(), aluno.getNomeAluno(), aluno.getIdadeAluno(), aluno.getNotaPrimeiroSemestre(), aluno.getNotaSegundoSemestre(), aluno.getNomeProfessor(), aluno.getNumeroDaSala());
    }
}
