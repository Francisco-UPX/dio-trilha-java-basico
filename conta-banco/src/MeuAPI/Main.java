package MeuAPI;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        User francisco = new User(
            "Francisco",
            18,
            Arrays.asList(
                new Rotina("Academia"),
                new Rotina("Trabalho"),
                new Rotina("Faculdade")
            ),
            Arrays.asList(
                new Escolaridade("Facens", "ADS"),
                new Escolaridade("ETEC Rubens de Farias e Souza", "Mecânica"),
                new Escolaridade("Escola Pública", "")
            ),
            Arrays.asList(
                new OqueGosta("Video-Game"),
                new OqueGosta("Basquete"),
                new OqueGosta("Tecnologia"),
                new OqueGosta("Festas")
            ),
            Arrays.asList(
                new ArtistasFav("Jotapê"),
                new ArtistasFav("BXD Neo"),
                new ArtistasFav("Veigh"),
                new ArtistasFav("Teto")
            )
        );

        // Exemplo de saída
        System.out.println("Usuário: " + francisco.getNome() + ", " + francisco.getIdade() + " anos");
        System.out.println("Rotina: " + francisco.getRotinas().get(0).getAtividade());
        System.out.println("Primeira Escolaridade: " + francisco.getEscolaridade().get(0).getInstituicao());
        System.out.println("Gosta de: " + francisco.getOqueGosta().get(0).getInteresse());
        System.out.println("Artista Favorito: " + francisco.getArtistasFav().get(0).getNome());
    }
}
