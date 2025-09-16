package br.com.altech.cadastro_jogador.service;

import br.com.altech.cadastro_jogador.model.GRUPOCODINOME;
import br.com.altech.cadastro_jogador.model.Jogador;
import br.com.altech.cadastro_jogador.repository.CodinomeRepository;
import br.com.altech.cadastro_jogador.repository.JogadoresRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService {

    private final CodinomeService codinomeService;
    private final JogadoresRepository jogadoresRepository;

    public JogadorService(CodinomeService codinomeService, JogadoresRepository jogadoresRepository) {
        this.codinomeService = codinomeService;
        this.jogadoresRepository = jogadoresRepository;
    }

    public Jogador registrarJogador(Jogador jogador) throws JsonProcessingException {
       var codinomeEmUso = listaCodinomeEmUso(jogador.grupoCodinome());
       var novoCodinome = codinomeService.gerarCodinome(jogador.grupoCodinome(),codinomeEmUso);
        var novoJogador = new Jogador(jogador.nome(), jogador.codinome(), jogador.telefone(), jogador.email(),jogador.grupoCodinome());
       return jogadoresRepository.salvar(novoJogador);
    }

    private List<String> listaCodinomeEmUso(GRUPOCODINOME grupocodinome) {
        return jogadoresRepository.listaCodinomesPorGrupo(grupocodinome);
    }
}
