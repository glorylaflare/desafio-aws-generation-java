package org.generation.brazil.grades.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.generation.brazil.grades.dto.ListagemAlunoDTO;
import org.generation.brazil.grades.dto.RespostaCadastroAlunoDTO;
import org.generation.brazil.grades.model.*;
import org.generation.brazil.grades.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
        var page = alunoRepository.findAll(paginacao).map(DadosCompletosAluno::new);
        return ResponseEntity.ok(ListagemAlunoDTO.pegaConteudo(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity listarAlunoPorId(@PathVariable Long id) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        if(alunoOptional.isPresent()) {
            var aluno = alunoOptional.get();
            return ResponseEntity.ok(new DadosCompletosAluno(aluno));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado!");
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizaAluno(@PathVariable Long id, @RequestBody @Valid DadosAtualizaAluno dadosAluno) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        if(alunoOptional.isPresent()) {
            var aluno = alunoOptional.get();
            aluno.atualizaInformacoes(dadosAluno);
            return ResponseEntity.ok(new DadosCompletosAluno(aluno));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado!");
        }
    }
}
