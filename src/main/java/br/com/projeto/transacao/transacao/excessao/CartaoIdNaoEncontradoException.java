package br.com.projeto.transacao.transacao.excessao;

public class CartaoIdNaoEncontradoException extends RuntimeException {

    public CartaoIdNaoEncontradoException( final String mensagem ){
        super(mensagem);
    }

}
