package br.com.projeto.transacao.transacao.kafka.transacao;

public class Estabelecimento {

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

    @Override
    public String toString() {
        return "Estabelecimento{" +
                "nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }

}
