package br.com.projeto.transacao.cartao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartaoRepositorio extends JpaRepository<Cartao, Long> {

    Optional<Cartao> findByIdCartao( final String idCartao );

}
