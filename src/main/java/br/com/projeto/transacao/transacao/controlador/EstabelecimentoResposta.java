package br.com.projeto.transacao.transacao.controlador;

import br.com.projeto.transacao.transacao.Estabelecimento;

class EstabelecimentoResposta {

    private final Estabelecimento estabelecimento;

    EstabelecimentoResposta(final Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public String getNome() {
        return estabelecimento.getNome();
    }

    public String getCidade() {
        return estabelecimento.getCidade();
    }

    public String getEndereco() {
        return estabelecimento.getEndereco();
    }

}
