package br.com.altech.cadastro_jogador.service;

import br.com.altech.cadastro_jogador.model.GRUPOCODINOME;
import br.com.altech.cadastro_jogador.repository.CodinomeRepository;
import br.com.altech.cadastro_jogador.repository.LigaDaJusticaRepository;
import br.com.altech.cadastro_jogador.repository.VingadoresRepository;
import org.springframework.stereotype.Component;

@Component
public class CodinomeRepositoryFactory {

    private final LigaDaJusticaRepository ligaDaJusticaRepository;
    private final VingadoresRepository vingadoresRepository;

    public CodinomeRepositoryFactory(LigaDaJusticaRepository ligaDaJusticaRepository, VingadoresRepository vingadoresRepository) {
        this.ligaDaJusticaRepository = ligaDaJusticaRepository;
        this.vingadoresRepository = vingadoresRepository;
    }
    public CodinomeRepository created(GRUPOCODINOME grupocodinome){
        return switch (grupocodinome){
            case LIGA_DA_JUSTICA -> ligaDaJusticaRepository;
            case VINGADORES -> vingadoresRepository;
        };
    }
}
