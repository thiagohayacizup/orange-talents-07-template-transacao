package br.com.projeto.transacao.cartao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cartao {

    public static Cartao of( final String idCartao, final String email, final CartaoRepositorio cartaoRepositorio ){
        return cartaoRepositorio
                .findByIdCartao( idCartao )
                .orElseGet( () -> new Cartao( idCartao, email ).salvar(cartaoRepositorio));
    }

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @NotBlank
    private @NotNull String idCartao;

    @NotBlank
    private @NotNull String email;

    private Cartao(){}

    private Cartao(final String idCartao, final String email) {
        this.idCartao = idCartao;
        this.email = email;
    }

    public String getIdCartao() {
        return idCartao;
    }

    public String getEmail() {
        return email;
    }

    private Cartao salvar( final CartaoRepositorio cartaoRepositorio ){
        return cartaoRepositorio.save(this);
    }

}
