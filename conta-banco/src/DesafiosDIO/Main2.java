package DesafiosDIO;

import java.util.Scanner;

class ContaBancaria {
    private int numero;
    private String titular;
    private double saldo;

    // Construtor
    public ContaBancaria(int numero, String titular, double saldoInicial) {
        this.numero = numero;
        this.titular = titular;
        setSaldo(saldoInicial); // usa o setter para aplicar a validação
    }

    // Getter e Setter do saldo com validação
    public double getSaldo() {
        return saldo;
    }

    private void setSaldo(double saldo) {
        if (saldo < 0) {
            System.out.println("Erro: O saldo nao pode ser negativo.");
            this.saldo = -1; // marca inválido
        } else {
            this.saldo = saldo;
        }
    }

    // Depósito com validação
    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: O valor do deposito deve ser positivo.");
            return;
        }
        saldo += valor;
    }

    // Método para exibir os dados da conta
    public void exibirConta() {
        if (saldo >= 0) {
            System.out.printf("Conta #%d - Titular: %s - Saldo: R$%.2f%n", numero, titular, saldo);
        }
    }
}

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numero = scanner.nextInt();
        scanner.nextLine(); // consumir quebra de linha

        String titular = scanner.nextLine();

        double saldoInicial = scanner.nextDouble();

        ContaBancaria conta = new ContaBancaria(numero, titular, saldoInicial);

        // Se o saldo inicial foi inválido, encerra o programa
        if (conta.getSaldo() < 0) {
            scanner.close();
            return;
        }

        double deposito = scanner.nextDouble();

        conta.depositar(deposito);

        // Só exibe se o depósito for válido
        if (deposito > 0) {
            conta.exibirConta();
        }

        scanner.close();
    }
}
