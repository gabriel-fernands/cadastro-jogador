package br.com.altech.cadastro_jogador.web;

import java.util.List;

public record VingadodesDTO(List<Codinome> vingadores) implements CodinomeDTO {
    @Override
    public List<String> getCodinomes() {
        return vingadores.stream().map(Codinome::codinome).toList();
    }

    record Codinome(String codinome){

    }
}
