package br.com.altech.cadastro_jogador.model;

public enum GRUPOCODINOME {

    VINGADORES("Vingadores",
            "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/vingadores.json"),
    LIGA_DA_JUSTICA("Liga da Justiça",
            "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/liga_da_justica.xml");



    private String nome;
    private String uri;

    GRUPOCODINOME(String nome, String uri) {
        this.nome = nome;
        this.uri = uri;
    }

    public String getNome() {
        return nome;
    }

    public String getUri() {
        return uri;
    }
}
