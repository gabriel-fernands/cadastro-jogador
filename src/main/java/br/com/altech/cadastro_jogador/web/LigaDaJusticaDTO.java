package br.com.altech.cadastro_jogador.web;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;
@JacksonXmlRootElement(localName = "liga_da_justica")
public record LigaDaJusticaDTO(@JacksonXmlProperty(localName = "codinomes") CodinomeDTO codinomeDTO ) implements CodinomeDTO {
    @Override
    public List<String> getCodinomes() {
        return codinomeDTO.codinomes();
    }
    record CodinomeDTO(@JacksonXmlElementWrapper(useWrapping = false) @JacksonXmlProperty(localName = "codinome") List<String> codinomes){

    }
}
