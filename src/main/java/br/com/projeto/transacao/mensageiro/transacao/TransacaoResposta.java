package br.com.projeto.transacao.mensageiro.transacao;

import java.math.BigDecimal;

public class TransacaoResposta {

    private String id;

    private BigDecimal valor;

    private EstabelecimentoResposta estabelecimento;

    private CartaoResposta cartao;

    private String efetivadaEm;

    public void setId(final String id) {
        this.id = id;
    }

    public void setValor(final BigDecimal valor) {
        this.valor = valor;
    }

    public void setEstabelecimento(final EstabelecimentoResposta estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public void setCartao(final CartaoResposta cartao) {
        this.cartao = cartao;
    }

    public void setEfetivadaEm(final String efetivadaEm) {
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoResposta getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoResposta getCartao() {
        return cartao;
    }

    public String getEfetivadaEm() {
        return efetivadaEm;
    }

}
