package br.com.projeto.transacao.transacao.controlador;

import br.com.projeto.transacao.cartao.Cartao;

class CartaoResposta {

    private final Cartao cartao;

    CartaoResposta(final Cartao cartao) {
        this.cartao = cartao;
    }

    public String getId() {
        return cartao.getIdCartao();
    }

    public String getEmail() {
        return cartao.getEmail();
    }

}
