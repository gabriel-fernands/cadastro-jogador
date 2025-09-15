package br.com.altech.cadastro_jogador.service;

import br.com.altech.cadastro_jogador.model.GRUPOCODINOME;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CodinomeService {

    private final CodinomeRepositoryFactory codinomeRepositoryFactory;

    public CodinomeService(CodinomeRepositoryFactory codinomeRepositoryFactory) {
        this.codinomeRepositoryFactory = codinomeRepositoryFactory;
    }

    public String gerarCodinome(GRUPOCODINOME grupocodinome, List<String> codinomeEmUso) throws JsonProcessingException {
        var codinomeDisponiveis = listaCodinomeDisponiveis(grupocodinome, codinomeEmUso);

        if (codinomeDisponiveis.isEmpty()) {
            throw new RuntimeException("Não há codinomes disponíveis para o grupo " + grupocodinome.getNome());
        }

        return sortearCodinome(codinomeDisponiveis);
    }

    private String sortearCodinome(List<String> codinomes) {
        return codinomes.get((int) (Math.random() * codinomes.size()));
    }

    private List<String> listaCodinomeDisponiveis(GRUPOCODINOME grupocodinome, List<String> codinomeEmUso) throws JsonProcessingException {
        var codinomes = buscarCodinome(grupocodinome);

        return codinomes.stream()
                .filter(c -> !codinomeEmUso.contains(c))
                .toList();
    }

    private List<String> buscarCodinome(GRUPOCODINOME grupocodinome) throws JsonProcessingException {
        var codinomeRepository = codinomeRepositoryFactory.created(grupocodinome);
        return codinomeRepository.buscarCodinome();
    }
}