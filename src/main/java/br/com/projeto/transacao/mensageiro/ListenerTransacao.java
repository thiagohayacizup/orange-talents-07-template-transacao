package br.com.projeto.transacao.mensageiro;

import br.com.projeto.transacao.cartao.CartaoRepositorio;
import br.com.projeto.transacao.mensageiro.transacao.CartaoResposta;
import br.com.projeto.transacao.mensageiro.transacao.EstabelecimentoResposta;
import br.com.projeto.transacao.mensageiro.transacao.TransacaoResposta;
import br.com.projeto.transacao.cartao.Cartao;
import br.com.projeto.transacao.transacao.Estabelecimento;
import br.com.projeto.transacao.transacao.Transacao;
import br.com.projeto.transacao.transacao.TransacaoRepositorio;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerTransacao {

    private final TransacaoRepositorio transacaoRepositorio;

    private final CartaoRepositorio cartaoRepositorio;

    public ListenerTransacao(final TransacaoRepositorio transacaoRepositorio, final CartaoRepositorio cartaoRepositorio) {
        this.transacaoRepositorio = transacaoRepositorio;
        this.cartaoRepositorio = cartaoRepositorio;
    }

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(final TransacaoResposta transacaoResposta) {
        final EstabelecimentoResposta estabelecimento = transacaoResposta.getEstabelecimento();
        final CartaoResposta cartao = transacaoResposta.getCartao();
        Transacao
                .construtor()
                .comIdTransacao( transacaoResposta.getId() )
                .comValor( transacaoResposta.getValor() )
                .comEstabelecimento(
                        Estabelecimento.of(
                                estabelecimento.getNome(),
                                estabelecimento.getCidade(),
                                estabelecimento.getEndereco()
                        )
                )
                .comCartao(
                        Cartao.create(
                                cartao.getId(),
                                cartao.getEmail(),
                                cartaoRepositorio
                        )
                )
                .comEfetivadaEm( transacaoResposta.getEfetivadaEm() )
                .construir()
                .salvar( transacaoRepositorio );
    }

}
