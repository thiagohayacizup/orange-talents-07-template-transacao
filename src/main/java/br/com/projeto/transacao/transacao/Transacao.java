package br.com.projeto.transacao.transacao;

import br.com.projeto.transacao.cartao.Cartao;
import br.com.projeto.transacao.transacao.excessao.CartaoIdNaoEncontradoException;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Transacao {

    public static Builder construtor(){
        return new Builder();
    }

    public static Transacao buscarPorIdCartao( final String cartaoId, final TransacaoRepositorio transacaoRepositorio ){
        return transacaoRepositorio
                .findFirstByCartao_idCartao( cartaoId )
                .orElseThrow( () -> new CartaoIdNaoEncontradoException(
                        String.format("Cartao com id { %s } nao encontrado.", cartaoId )
                ));
    }

    public List<Transacao> buscar10UltimasTransacoes( final TransacaoRepositorio transacaoRepositorio) {
        return transacaoRepositorio
                .findFirst10ByCartao_idCartaoOrderByIdDesc( cartao.getIdCartao() );
    }

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @NotBlank
    private @NotNull String idTransacao;

    @DecimalMin(value = "0.0")
    private @NotNull BigDecimal valor;

    @OneToOne( cascade = CascadeType.PERSIST )
    private @NotNull Estabelecimento estabelecimento;

    @ManyToOne
    private @NotNull Cartao cartao;

    @NotBlank
    private @NotNull String efetivadaEm;

    private Transacao(){}

    private Transacao( final Builder builder ){
        this.idTransacao = builder.idTransacao;
        this.valor = builder.valor;
        this.estabelecimento = builder.estabelecimento;
        this.cartao = builder.cartao;
        this.efetivadaEm = builder.efetivadaEm;
    }

    public static class Builder{
        private String idTransacao;
        private BigDecimal valor;
        private Estabelecimento estabelecimento;
        private Cartao cartao;
        private String efetivadaEm;

        public Builder comIdTransacao(final String idTransacao) {
            this.idTransacao = idTransacao;
            return this;
        }

        public Builder  comValor(final BigDecimal valor) {
            this.valor = valor;
            return this;
        }

        public Builder  comEstabelecimento(final Estabelecimento estabelecimento) {
            this.estabelecimento = estabelecimento;
            return this;
        }

        public Builder  comCartao(final Cartao cartao) {
            this.cartao = cartao;
            return this;
        }

        public Builder comEfetivadaEm(final String efetivadaEm) {
            this.efetivadaEm = efetivadaEm;
            return this;
        }

        public Transacao construir(){
            return new Transacao( this );
        }

    }

    public Transacao salvar( final TransacaoRepositorio transacaoRepositorio ){
        return transacaoRepositorio.save(this);
    }

    public Long getId() {
        return id;
    }

    public String getIdTransacao() {
        return idTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public String getEfetivadaEm() {
        return efetivadaEm;
    }
}
