package br.com.projeto.transacao.transacao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.ResourceUtils;

import java.nio.file.Files;

@ActiveProfiles( value = "test" )
@SpringBootTest
@AutoConfigureMockMvc
class TransacaoIntegrationTest {

    private static final String TRANSACAO_ENDPOINT = "/transacao/cartao-id";

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Cartao nao encontrado")
    void cartaoNaoEncontrado() throws Exception{
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .get(TRANSACAO_ENDPOINT + "/abc")
                                .contentType( MediaType.APPLICATION_JSON )
                ).andDo( MockMvcResultHandlers.print() )
                .andExpect( MockMvcResultMatchers.status().isNotFound() )
                .andExpect( MockMvcResultMatchers.jsonPath("$.codigo").value(404) )
                .andExpect( MockMvcResultMatchers.jsonPath("$.mensagem").value("Cartao com id { abc } nao encontrado.") );
    }

    @Test
    @DisplayName("Transacoes obtidas com sucesso")
    @Sql(scripts = "transacoes.sql")
    void transacoesObtidasComSucesso() throws Exception{
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .get(TRANSACAO_ENDPOINT + "/abcde1234567-00")
                                .contentType( MediaType.APPLICATION_JSON )
                ).andDo( MockMvcResultHandlers.print() )
                .andExpect( MockMvcResultMatchers.status().isOk() )
                .andExpect( MockMvcResultMatchers.jsonPath("$").isArray() )
                .andExpect( MockMvcResultMatchers.content().json(
                        Files.readString(
                                ResourceUtils
                                        .getFile("classpath:br/com/projeto/transacao/transacao/transacao-resposta.json")
                                        .toPath()
                        )
                ));
    }

    @Test
    @DisplayName("Transacoes obtidas com sucesso menos que 10")
    @Sql(scripts = "transacoes-menos-10.sql")
    void menosQue10TransacoesObtidasSucesso() throws Exception{
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .get(TRANSACAO_ENDPOINT + "/abcde1234567-01")
                                .contentType( MediaType.APPLICATION_JSON )
                ).andDo( MockMvcResultHandlers.print() )
                .andExpect( MockMvcResultMatchers.status().isOk() )
                .andExpect( MockMvcResultMatchers.jsonPath("$").isArray() )
                .andExpect( MockMvcResultMatchers.content().json(
                        Files.readString(
                                ResourceUtils
                                        .getFile("classpath:br/com/projeto/transacao/transacao/transacao-resposta-menos-10.json")
                                        .toPath()
                        )
                ));
    }

}
