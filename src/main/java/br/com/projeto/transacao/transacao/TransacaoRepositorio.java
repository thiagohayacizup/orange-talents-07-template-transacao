package br.com.projeto.transacao.transacao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransacaoRepositorio extends JpaRepository<Transacao, Long> {

    Optional<Transacao> findFirstByCartao_idCartao( final String cartaoId );

    List<Transacao> findFirst10ByCartao_idCartaoOrderByIdDesc( final String cartaoId );

}