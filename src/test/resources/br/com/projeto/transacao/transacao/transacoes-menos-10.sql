INSERT INTO Cartao(id_cartao, email) VALUES ('abcde1234567-01', 'email@dominio.com');

INSERT INTO Estabelecimento(nome, cidade, endereco) VALUES ('cara palida', 'cidade', 'endereco');

INSERT INTO Transacao( id_transacao, valor, estabelecimento_id, cartao_id, efetivada_em)
VALUES ('1', 50.0, 1, 1, '2021-02-03');
INSERT INTO Transacao( id_transacao, valor, estabelecimento_id, cartao_id, efetivada_em)
VALUES ('2', 50.0, 1, 1, '2021-02-03');