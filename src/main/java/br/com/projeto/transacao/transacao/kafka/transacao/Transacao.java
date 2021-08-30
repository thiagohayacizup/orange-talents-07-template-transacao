package br.com.projeto.transacao.transacao.kafka.transacao;

import java.math.BigDecimal;

public class Transacao {

    private String id;

    private BigDecimal valor;

    private Estabelecimento estabelecimento;

    private Cartao cartao;

    private String efetivadaEm;

    public void setId(final String id) {
        this.id = id;
    }

    public void setValor(final BigDecimal valor) {
        this.valor = valor;
    }

    public void setEstabelecimento(final Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public void setCartao(final Cartao cartao) {
        this.cartao = cartao;
    }

    public void setEfetivadaEm(final String efetivadaEm) {
        this.efetivadaEm = efetivadaEm;
    }

    @Override
    public String toString() {
        return "Transacao{\n" +
                "    id='" + id + "\',\n" +
                "    valor=" + valor + ",\n" +
                "    estabelecimento=" + estabelecimento.toString() + ",\n" +
                "    cartao=" + cartao.toString() + ",\n" +
                "    efetivadaEm=" + efetivadaEm + "\n" +
                '}';
    }

}
