package IphoneAppJava;

public class Call {
    private String destino;
    private boolean ativa;

    public Call(String destino) {
        this.destino = destino;
        this.ativa = true;
    }

    public String getDestino() { return destino; }
    public boolean isAtiva() { return ativa; }
    public void encerrar() { this.ativa = false; }
}
