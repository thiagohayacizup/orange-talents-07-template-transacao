package br.com.projeto.transacao.transacao.controlador;

import br.com.projeto.transacao.transacao.Transacao;

import java.math.BigDecimal;

class TransacaoResposta {

    private final Transacao transacao;

    TransacaoResposta(final Transacao transacao) {
        this.transacao = transacao;
    }

    public Long getId(){ return transacao.getId(); }

    public String getIdTransacao() {
        return transacao.getIdTransacao();
    }

    public BigDecimal getValor() {
        return transacao.getValor();
    }

    public EstabelecimentoResposta getEstabelecimento() {
        return new EstabelecimentoResposta( transacao.getEstabelecimento() );
    }

    public CartaoResposta getCartao() {
        return new CartaoResposta( transacao.getCartao() );
    }

    public String getEfetivadaEm() {
        return transacao.getEfetivadaEm();
    }

}
