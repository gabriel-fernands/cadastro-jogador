package br.com.altech.cadastro_jogador.repository;

import br.com.altech.cadastro_jogador.web.LigaDaJusticaDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.web.client.RestClient;

import java.util.List;

public class LigaDaJusticaRepository implements CodinomeRepository{
    @Override
    public List<String> buscarCodinome() throws JsonProcessingException {
        var codinomes = RestClient.builder()
                .baseUrl("https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/liga_da_justica.xml")
                .build()
                .get()
                .retrieve()
                .body(String.class);

var xmlMapper = new XmlMapper();
var ligaDaJustica = xmlMapper.readValue(codinomes, LigaDaJusticaDTO.class);
return ligaDaJustica.getCodinomes();

    }
}
