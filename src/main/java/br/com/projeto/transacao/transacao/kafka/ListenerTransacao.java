package br.com.projeto.transacao.transacao.kafka;

import br.com.projeto.transacao.transacao.kafka.transacao.Transacao;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerTransacao {

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(final Transacao transacao) {
        System.out.println(transacao);
    }

}
