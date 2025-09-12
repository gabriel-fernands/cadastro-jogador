package br.com.altech.cadastro_jogador.model;

public record Jogador(
        String nome,
        String email,
        String telefone,
        String codinome,
        GRUPOCODINOME grupoCodinome
) {
}
