package br.com.alura.Forum_Hub.Topicos;

public record ListaDeTopicos(
        Long id,
        String titulo,
        String mensagem,
        String dataDeCriacao,
        String status,
        String autor,
        String curso
) {
    public ListaDeTopicos(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), String.valueOf(topico.getDataDeCriacao()), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }
}
