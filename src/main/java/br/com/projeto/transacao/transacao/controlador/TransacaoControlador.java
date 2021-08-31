package br.com.projeto.transacao.transacao.controlador;

import br.com.projeto.transacao.transacao.Transacao;
import br.com.projeto.transacao.transacao.TransacaoRepositorio;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
class TransacaoControlador {

    private final TransacaoRepositorio transacaoRepositorio;

    TransacaoControlador(final TransacaoRepositorio transacaoRepositorio) {
        this.transacaoRepositorio = transacaoRepositorio;
    }

    @GetMapping("/transacao/cartao-id/{cartao}")
    @ResponseStatus( HttpStatus.OK )
    public @ResponseBody List<TransacaoResposta> obterTransacoes(@PathVariable("cartao") final String cartaoId ){
        return Transacao
                .buscarPorIdCartao( cartaoId, transacaoRepositorio )
                .buscar10UltimasTransacoes( transacaoRepositorio )
                .stream()
                .map(TransacaoResposta::new)
                .collect(Collectors.toList());
    }

}
