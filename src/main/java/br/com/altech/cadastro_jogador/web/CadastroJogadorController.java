package br.com.altech.cadastro_jogador.web;

import br.com.altech.cadastro_jogador.model.Jogador;
import br.com.altech.cadastro_jogador.service.JogadorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cadastro-jogador")
public class CadastroJogadorController {

    private final JogadorService jogadorService;

    public CadastroJogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }
    @PostMapping
    public String cadastrarJogador(@ModelAttribute Jogador jogador){
        try {
            jogadorService.registrarJogador(jogador);
return "redirect:cadastro-jogador";
        } catch (JsonProcessingException e) {
            return "redirect:cadastro-jogador";
        }
    }

}
