package br.com.alura.Forum_Hub.Controller;

import br.com.alura.Forum_Hub.Topicos.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("forum")
public class ForumController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity registarTopico(@RequestBody @Valid DadosTopicos topico, UriComponentsBuilder uriBuilder) {
        var topicos = new Topico(topico);
        repository.save(topicos);

        var uri = uriBuilder.path("/forum/{id}").buildAndExpand(topicos).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topicos));
    }

    @GetMapping
    public ResponseEntity <Page<ListaDeTopicos>> listarTopico(@PageableDefault(size = 10, page = 0, sort = {"dataDeCriacao"}) Pageable paginacao) {
        var page = repository.findAllByVisivelTrue(paginacao).map(ListaDeTopicos::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarTopico(@RequestBody @Valid DadosAtualizacaoTopicos atualizacaoTopico) {
        var topico =repository.getReferenceById(atualizacaoTopico.id());
        topico.atualizarDataEHora();
        topico.atualizarinformacoes(atualizacaoTopico);

        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarTopico(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);
        topico.ocultar();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoTopico> detalharTopico(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }
}