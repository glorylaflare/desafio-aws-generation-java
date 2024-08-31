package org.generation.brazil.grades.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Aluno")
@Table(name = "alunos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomeAluno;
    private int idadeAluno;
    private double notaPrimeiroSemestre;
    private double notaSegundoSemestre;
    private String nomeProfessor;
    private int numeroDaSala;
}
