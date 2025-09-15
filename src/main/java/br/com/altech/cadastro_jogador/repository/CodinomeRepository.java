package br.com.altech.cadastro_jogador.repository;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface CodinomeRepository {

    List<String> buscarCodinome() throws JsonProcessingException;
}
