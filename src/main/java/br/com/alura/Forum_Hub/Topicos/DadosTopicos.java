package br.com.alura.Forum_Hub.Topicos;

import jakarta.validation.constraints.NotBlank;

public record DadosTopicos(
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        String dataDeCriacao,
        String status,
        @NotBlank
        String autor,
        @NotBlank
        String curso
) {
}
