package br.com.alura.Forum_Hub.Topicos;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTopicos(

        @NotNull
        Long id,
        String titulo,
        String mensagem
) {
}
