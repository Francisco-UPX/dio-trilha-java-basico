package DesafiosDIO;

import java.util.Scanner;

// Classe que representa um Pedido
class Pedido {
    private int id;
    private String cliente;
    private double valorTotal;

    // Construtor
    public Pedido(int id, String cliente, double valorTotal) {
        this.id = id;
        this.cliente = cliente;
        this.valorTotal = valorTotal;
    }

    // Método que retorna o resumo do pedido no formato solicitado
    public String getResumo() {
        return String.format("Pedido #%d - Cliente: %s - Total: R$%.2f", id, cliente, valorTotal);
    }
}

// Classe principal
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha
        String cliente = scanner.nextLine();
        double valorTotal = scanner.nextDouble();

        Pedido pedido = new Pedido(id, cliente, valorTotal);

        // Exibir em uma única linha, conforme especificação
        System.out.println(pedido.getResumo());

        scanner.close();
    }
}
