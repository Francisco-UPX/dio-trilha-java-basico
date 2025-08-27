package com.example.iphone;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private List<MusicTrack> faixas = new ArrayList<>();

    public Playlist(String nome) { }
    public void adicionar(MusicTrack track) { faixas.add(track); }
    public List<MusicTrack> getFaixas() { return faixas; }
}
