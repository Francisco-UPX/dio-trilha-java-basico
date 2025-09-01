package MeuAPI;

import java.util.List;

public class User {
    private String nome;
    private int idade;
    private List<Rotina> rotinas;
    private List<Escolaridade> escolaridade;
    private List<OqueGosta> oqueGosta;
    private List<ArtistasFav> artistasFav;

    public User(String nome, int idade, List<Rotina> rotinas, 
                List<Escolaridade> escolaridade, List<OqueGosta> oqueGosta, 
                List<ArtistasFav> artistasFav) {
        this.nome = nome;
        this.idade = idade;
        this.rotinas = rotinas;
        this.escolaridade = escolaridade;
        this.oqueGosta = oqueGosta;
        this.artistasFav = artistasFav;
    }

    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public List<Rotina> getRotinas() { return rotinas; }
    public List<Escolaridade> getEscolaridade() { return escolaridade; }
    public List<OqueGosta> getOqueGosta() { return oqueGosta; }
    public List<ArtistasFav> getArtistasFav() { return artistasFav; }
}
