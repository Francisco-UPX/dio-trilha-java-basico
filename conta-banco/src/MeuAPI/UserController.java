package MeuAPI;

import java.util.Arrays;
public class UserController {

   
    public User getUser() {
        return new User(
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
    }
}

