package org.generation.brazil.grades.controller;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.generation.brazil.grades.dto.ListagemAlunoDTO;
import org.generation.brazil.grades.dto.RespostaAtualizacaoAlunoDTO;
import org.generation.brazil.grades.dto.RespostaCadastroAlunoDTO;
import org.generation.brazil.grades.model.*;
import org.generation.brazil.grades.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new RespostaCadastroAlunoDTO("Aluno cadastrado com sucesso!", new DadosDetalhadosAluno(aluno)));
    }

    @GetMapping
    public ResponseEntity<ListagemAlunoDTO> listarAlunos(
            @Parameter(hidden = true) Pageable paginacao) {
        var page = alunoRepository.findAll(paginacao).map(DadosCompletosAluno::new);
        return ResponseEntity.status(HttpStatus.OK).body(ListagemAlunoDTO.pegaConteudo(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity listarAlunoPorId(@PathVariable Long id) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        if(alunoOptional.isPresent()) {
            var aluno = alunoOptional.get();
            return ResponseEntity.status(HttpStatus.OK).body(new DadosCompletosAluno(aluno));
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
            return ResponseEntity.status(HttpStatus.OK).body(
                    new RespostaAtualizacaoAlunoDTO("Aluno atualizado com sucesso!", new DadosCompletosAluno(aluno)));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarAluno(@PathVariable Long id) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        if(alunoOptional.isPresent()) {
            alunoRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Aluno deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado!");
        }
    }
}
