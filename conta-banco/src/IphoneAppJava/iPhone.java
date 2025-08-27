package IphoneAppJava;

import java.util.ArrayList;
import java.util.List;

public class iPhone implements ReprodutorMusical, AparelhoTelefonico, Navegador {
    private List<MusicTrack> library = new ArrayList<>();
    private Playlist playlist = new Playlist("Padrão");

    private List<BrowserTab> tabs = new ArrayList<>();
    private BrowserTab currentTab = null;

    private Call callActive = null;
    private VoiceMail voiceMail = new VoiceMail();

    // ReprodutorMusical
    @Override
    public void tocar(MusicTrack track) {
        if (!library.contains(track)) library.add(track);
        System.out.println("Tocando: " + track);
    }

    @Override
    public void pausar() { System.out.println("Playback pausado"); }

    @Override
    public void parar() { System.out.println("Playback parado"); }

    @Override
    public void adicionarNaPlaylist(MusicTrack track) { 
        playlist.adicionar(track); 
        System.out.println("Adicionado à playlist: " + track); 
    }

    // AparelhoTelefonico
    @Override
    public void ligar(String destino) {
        if (callActive != null && callActive.isAtiva()) {
            System.out.println("Já existe uma chamada ativa para: " + callActive.getDestino());
            return;
        }
        callActive = new Call(destino);
        System.out.println("Ligando para " + destino + "...");
    }

    @Override
    public void encerrar() {
        if (callActive != null && callActive.isAtiva()) {
            callActive.encerrar();
            System.out.println("Chamada encerrada: " + callActive.getDestino());
            callActive = null;
        } else {
            System.out.println("Nenhuma chamada ativa para encerrar.");
        }
    }

    @Override
    public void iniciarCorreioVoz() {
        voiceMail.gravarMensagem("Mensagem de correio de voz capturada em " + java.time.Instant.now());
        System.out.println("Correio de voz iniciado. Total de mensagens: " + voiceMail.getMensagens().size());
    }

    // Navegador
    @Override
    public void exibirPagina(String url) {
        WebPage page = new WebPage(url);
        if (currentTab == null) {
            currentTab = new BrowserTab(page);
            tabs.add(currentTab);
        } else {
            currentTab.setPagina(page);
        }
        System.out.println("Exibindo: " + page.getUrl());
    }

    @Override
    public void adicionarNovaAba(String url) {
        BrowserTab tab = new BrowserTab(new WebPage(url));
        tabs.add(tab);
        currentTab = tab;
        System.out.println("Nova aba aberta: " + url);
    }

    @Override
    public void atualizarPagina() {
        if (currentTab == null) {
            System.out.println("Nenhuma aba ativa para atualizar.");
            return;
        }
        currentTab.getPagina().atualizar();
        System.out.println("Página atualizada: " + currentTab.getPagina().getUrl());
    }

    // métodos utilitários
    public Playlist getPlaylist() { return playlist; }
    public List<BrowserTab> getTabs() { return tabs; }
    public VoiceMail getVoiceMail() { return voiceMail; }
}
