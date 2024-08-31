package org.generation.brazil.grades.model;

public record DadosDetalhadosAluno(Long id,
                                   String nomeAluno,
                                   Integer idadeAluno,
                                   Double notaPrimeiroSemestre,
                                   Double notaSegundoSemestre) {

    public DadosDetalhadosAluno(Aluno aluno) {
        this(aluno.getId(), aluno.getNomeAluno(), aluno.getIdadeAluno(), aluno.getNotaPrimeiroSemestre(), aluno.getNotaSegundoSemestre());
    }
}
