package IphoneAppJava;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String nome;
    private List<MusicTrack> faixas = new ArrayList<>();

    public Playlist(String nome) { this.nome = nome; }
    public void adicionar(MusicTrack track) { faixas.add(track); }
    public List<MusicTrack> getFaixas() { return faixas; }
}
