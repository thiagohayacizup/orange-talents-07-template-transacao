package br.com.projeto.transacao.mensageiro.transacao;

public class EstabelecimentoResposta {

    private String nome;

    private String cidade;

    private String endereco;

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public void setCidade(final String cidade) {
        this.cidade = cidade;
    }

    public void setEndereco(final String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }
}
