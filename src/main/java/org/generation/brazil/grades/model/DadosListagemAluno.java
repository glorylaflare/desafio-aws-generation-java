package org.generation.brazil.grades.model;

public record DadosListagemAluno(Long id,
                                 String nomeAluno,
                                 Integer idadeAluno,
                                 Double notaPrimeiroSemestre,
                                 Double notaSegundoSemestre,
                                 String nomeProfessor,
                                 Integer numeroSala) {

    public DadosListagemAluno(Aluno aluno) {
        this(aluno.getId(), aluno.getNomeAluno(), aluno.getIdadeAluno(), aluno.getNotaPrimeiroSemestre(), aluno.getNotaSegundoSemestre(), aluno.getNomeProfessor(), aluno.getNumeroDaSala());
    }
}
