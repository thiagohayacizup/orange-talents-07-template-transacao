package br.com.projeto.transacao.transacao;

import br.com.projeto.transacao.cartao.Cartao;
import br.com.projeto.transacao.cartao.CartaoRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.Optional;

class TransacaoTest {

    @Test
    @DisplayName("Criacao da transacao")
    void transacaoCriada(){
        final TransacaoRepositorio mock = Mockito.mock(TransacaoRepositorio.class);
        final CartaoRepositorio cartaoRepositorioMock = Mockito.mock(CartaoRepositorio.class);
        final Transacao transacao = Transacao.construtor()
                .comIdTransacao("1234567")
                .comValor( BigDecimal.TEN )
                .comEstabelecimento(
                        Estabelecimento.of("ola", "como", "vai")
                )
                .comCartao(
                        Cartao.create("abcdefgh", "email@dominio.com", cartaoRepositorioMock)
                )
                .comEfetivadaEm("2021-01-03")
                .construir();

        Mockito.when( mock.save( Mockito.any() ) ).thenReturn( transacao );
        Mockito.when( cartaoRepositorioMock.findByIdCartao( Mockito.anyString() ) ).thenReturn( Optional.empty() );

        final Transacao salvar = transacao.salvar(mock);
        final Estabelecimento estabelecimento = salvar.getEstabelecimento();
        final Cartao cartao = salvar.getCartao();

        Assertions.assertEquals("1234567", salvar.getIdTransacao() );
        Assertions.assertEquals(BigDecimal.TEN, salvar.getValor() );
        Assertions.assertEquals("ola", estabelecimento.getNome());
        Assertions.assertEquals("como", estabelecimento.getCidade());
        Assertions.assertEquals("vai", estabelecimento.getEndereco());
        Assertions.assertEquals("abcdefgh", cartao.getIdCartao());
        Assertions.assertEquals("email@dominio.com", cartao.getEmail());
        Assertions.assertEquals("2021-01-03", salvar.getEfetivadaEm());

    }

    @Test
    @DisplayName("Criacao da transacao com cartao existente")
    void transacaoCriadaCartaoExistente(){
        final TransacaoRepositorio mock = Mockito.mock(TransacaoRepositorio.class);
        final CartaoRepositorio cartaoRepositorioMock = Mockito.mock(CartaoRepositorio.class);
        final Cartao cartao = Cartao.create("abcdefgh", "email@dominio.com", cartaoRepositorioMock);
        final Transacao transacao = Transacao.construtor()
                .comIdTransacao("1234567")
                .comValor( BigDecimal.TEN )
                .comEstabelecimento(
                        Estabelecimento.of("ola", "como", "vai")
                )
                .comCartao( cartao )
                .comEfetivadaEm("2021-01-03")
                .construir();

        Mockito.when( mock.save( Mockito.any() ) ).thenReturn( transacao );
        Mockito.when( cartaoRepositorioMock.findByIdCartao( Mockito.anyString() ) ).thenReturn( Optional.of( cartao ) );

        final Transacao salvar = transacao.salvar(mock);
        final Estabelecimento estabelecimento = salvar.getEstabelecimento();
        final Cartao cartaoResposta = salvar.getCartao();

        Assertions.assertEquals("1234567", salvar.getIdTransacao() );
        Assertions.assertEquals(BigDecimal.TEN, salvar.getValor() );
        Assertions.assertEquals("ola", estabelecimento.getNome());
        Assertions.assertEquals("como", estabelecimento.getCidade());
        Assertions.assertEquals("vai", estabelecimento.getEndereco());
        Assertions.assertEquals("abcdefgh", cartaoResposta.getIdCartao());
        Assertions.assertEquals("email@dominio.com", cartaoResposta.getEmail());
        Assertions.assertEquals("2021-01-03", salvar.getEfetivadaEm());

    }

}
