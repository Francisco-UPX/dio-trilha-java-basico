package IphoneAppJava;

public class WebPage {
    private String url;
    private String conteudo; // simplificação

    public WebPage(String url) {
        this.url = url;
        this.conteudo = "Conteúdo simulado de " + url;
    }

    public String getUrl() { return url; }
    public String getConteudo() { return conteudo; }
    public void atualizar() { this.conteudo = "Conteúdo atualizado de " + url; }
}
