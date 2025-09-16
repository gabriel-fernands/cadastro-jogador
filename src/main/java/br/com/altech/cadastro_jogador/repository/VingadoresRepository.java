package br.com.altech.cadastro_jogador.repository;

import br.com.altech.cadastro_jogador.model.GRUPOCODINOME;
import br.com.altech.cadastro_jogador.web.VingadoresDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

import java.util.List;

public class VingadoresRepository implements CodinomeRepository{
    @Override
    public List<String> buscarCodinome() throws JsonProcessingException {
        var codinomes = RestClient.builder()
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN_VALUE)
                .baseUrl(GRUPOCODINOME.VINGADORES.getUri())
                .build()
                .get()
                .retrieve()
                .body(String.class);
        ObjectMapper objectMapper = new ObjectMapper();
       var vingadores = objectMapper.readValue(codinomes, VingadoresDTO.class);
       return vingadores.getCodinomes();
    }
}
