package IphoneAppJava;

import java.util.ArrayList;
import java.util.List;

public class VoiceMail {
    private List<String> mensagens = new ArrayList<>();

    public void gravarMensagem(String mensagem) { mensagens.add(mensagem); }
    public List<String> getMensagens() { return mensagens; }
}
