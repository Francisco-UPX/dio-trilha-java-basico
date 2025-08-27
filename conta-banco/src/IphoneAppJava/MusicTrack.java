package IphoneAppJava;

public class MusicTrack {
    private String titulo;
    private String artista;
    private int duracaoSegundos;

    public MusicTrack(String titulo, String artista, int duracaoSegundos) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracaoSegundos = duracaoSegundos;
    }

    public String getTitulo() { return titulo; }
    public String getArtista() { return artista; }
    public int getDuracaoSegundos() { return duracaoSegundos; }

    @Override
    public String toString() {
        return titulo + " - " + artista + " (" + duracaoSegundos + "s)";
    }
}
