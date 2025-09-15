package br.com.altech.cadastro_jogador.service;

import br.com.altech.cadastro_jogador.model.GRUPOCODINOME;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadoService {

    private final CodinomeRepositoryFactory codinomeRepositoryFactory;

    public JogadoService(CodinomeRepositoryFactory codinomeRepositoryFactory) {
        this.codinomeRepositoryFactory = codinomeRepositoryFactory;
    }

    public String gerarCodinome(GRUPOCODINOME grupocodinome, List<String> codinome) throws JsonProcessingException {
        var codinomeDisponiveis = listaCodinomeDisponiveis(grupocodinome,codinome);
        if (codinomeDisponiveis.isEmpty){
            throw new RuntimeException("não há codinomes disponivel para o grupo" + grupocodinome.getNome());
      var codinomeSorteado =  sortearCodinome(codinome);
      return codinomeSorteado;

        }

    }

    private String sortearCodinome(List<String> codinome) {
        return codinome.get((int) (Math.random() * codinome.size()));
    }

    private List<String> listaCodinomeDisponiveis(GRUPOCODINOME grupocodinome, List<String> codinomeEmUso) throws JsonProcessingException {
   var codinomes = buscarCodinome(grupocodinome);

   var codinomeDisponivel = codinomes.stream().filter(codinome -> !codinomeEmUso.contains(codinome))
           .toList();
return  codinomeDisponivel;
    }

    private List<String> buscarCodinome(GRUPOCODINOME grupocodinome) throws JsonProcessingException {
       var codinomeRepository = codinomeRepositoryFactory.created(grupocodinome);
return codinomeRepository.buscarCodinome();
    }
}
