package MeuAPI;

public class Escolaridade {
    private String instituicao;
    private String curso;

    public Escolaridade(String instituicao, String curso) {
        this.instituicao = instituicao;
        this.curso = curso;
    }

    public String getInstituicao() { return instituicao; }
    public String getCurso() { return curso; }
}