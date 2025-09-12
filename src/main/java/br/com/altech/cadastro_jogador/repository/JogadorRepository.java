package br.com.altech.cadastro_jogador.repository;

import br.com.altech.cadastro_jogador.model.Jogador;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class JogadorRepository {

    private final JdbcClient jdbcClient;

    public JogadorRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }
    public Jogador salvar(Jogador jogador){
         jdbcClient.sql("""
        
        INSERT INTO JOGADORES(nome,email,telefone,codinome,grupo_codinome)
        VALUES(:nome,:email,:telefone,:codinome,:grupo_codinome)
        """)
                .param("nome", jogador.nome())
                .param("email", jogador.email())
                .param("telefone", jogador.telefone())
                .param("codinome", jogador.codinome())
                .param("grupoCodinome", jogador.grupoCodinome())
                .update();
        return jogador;
    }
}
