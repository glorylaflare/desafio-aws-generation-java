CREATE TABLE alunos (
    id BIGSERIAL PRIMARY KEY,
    nome_aluno VARCHAR(255) NOT NULL,
    idade_aluno INTEGER NOT NULL,
    nota_primeiro_semestre DECIMAL(4,2) NOT NULL,
    nota_segundo_semestre DECIMAL(4,2) NOT NULL,
    nome_professor VARCHAR(255) NOT NULL,
    numero_da_sala INTEGER NOT NULL
);