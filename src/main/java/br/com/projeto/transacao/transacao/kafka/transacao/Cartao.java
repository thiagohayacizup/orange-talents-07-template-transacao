package br.com.projeto.transacao.transacao.kafka.transacao;

public class Cartao {

    private String id;

    private String email;

    public void setId(final String id) {
        this.id = id;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cartao{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
