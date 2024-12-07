package br.com.alura.Forum_Hub.Topicos;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "Topico")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean visivel;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataDeCriacao;
    private String status;
    private String autor;
    private String curso;


    public Topico(DadosTopicos topicos) {
        this.visivel = true;
        this.titulo = topicos.titulo();
        this.mensagem = topicos.mensagem();
        this.dataDeCriacao = LocalDateTime.now();
        this.status = topicos.status();
        this.autor = topicos.autor();
        this.curso = topicos.curso();
    }

    public void atualizarinformacoes(@Valid DadosAtualizacaoTopicos atualizacaoTopico) {
        if (atualizacaoTopico.titulo() != null){
            this.titulo = atualizacaoTopico.titulo();
        }
        if (atualizacaoTopico.mensagem() != null){
            this.mensagem = atualizacaoTopico.mensagem();
        }
    }

    public void ocultar() {
        this.visivel = false;
    }

    public void atualizarDataEHora() {
        this.dataDeCriacao = LocalDateTime.now();
    }
}
