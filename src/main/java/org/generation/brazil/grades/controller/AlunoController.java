package org.generation.brazil.grades.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.generation.brazil.grades.dto.ListagemAlunoDTO;
import org.generation.brazil.grades.dto.RespostaCadastroAlunoDTO;
import org.generation.brazil.grades.model.Aluno;
import org.generation.brazil.grades.model.DadosAluno;
import org.generation.brazil.grades.model.DadosDetalhadosAluno;
import org.generation.brazil.grades.model.DadosListagemAluno;
import org.generation.brazil.grades.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarAluno(@RequestBody @Valid DadosAluno alunos) {
        var aluno = new Aluno(alunos);
        alunoRepository.save(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(new RespostaCadastroAlunoDTO("Aluno cadastrado com sucesso!", new DadosDetalhadosAluno(aluno)));
    }

    @GetMapping
    public ResponseEntity<ListagemAlunoDTO> listarAlunos(
            @PageableDefault(direction = Sort.Direction.ASC) Pageable paginacao) {
        var page = alunoRepository.findAll(paginacao).map(DadosListagemAluno::new);
        return ResponseEntity.ok(ListagemAlunoDTO.pegaConteudo(page));
    }
}
