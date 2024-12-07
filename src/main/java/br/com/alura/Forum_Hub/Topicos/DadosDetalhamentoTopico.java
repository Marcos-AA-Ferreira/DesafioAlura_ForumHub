package br.com.alura.Forum_Hub.Topicos;

public record DadosDetalhamentoTopico(
        Long id,
        String titulo,
        String mensagem,
        String dataDeCriacao
) {
    public DadosDetalhamentoTopico (Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), String.valueOf(topico.getDataDeCriacao()));
    }
}
