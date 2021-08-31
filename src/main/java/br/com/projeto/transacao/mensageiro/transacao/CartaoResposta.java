package br.com.projeto.transacao.mensageiro.transacao;

public class CartaoResposta {

    private String id;

    private String email;

    public void setId(final String id) {
        this.id = id;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
