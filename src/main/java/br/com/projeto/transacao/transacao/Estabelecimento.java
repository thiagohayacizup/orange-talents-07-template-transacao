package br.com.projeto.transacao.transacao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estabelecimento {

    public static Estabelecimento of( final String nome, final String cidade, final String endereco ){
        return new Estabelecimento( nome, cidade, endereco);
    }

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @NotBlank
    private @NotNull String nome;

    @NotBlank
    private @NotNull String cidade;

    @NotBlank
    private @NotNull String endereco;

    private Estabelecimento(){}

    private Estabelecimento(final String nome, final String cidade, final String endereco) {
        this.nome = nome;
        this.cidade = cidade;
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
