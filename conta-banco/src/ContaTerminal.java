import java.util.Scanner;

public class ContaTerminal {

    public static void main(String[] args) {
        //TODO:Conhecer e importar a classe Scanner
       Scanner sc = new Scanner(System.in);
        int opcao = 0;

        int numeroConta = 0;
        String numeroAgencia = "";
        String nome = "";
        double saldo = 0.0;
        // Exibir mensagem para o usuário
        do {
        System.out.println("Bem-vindo ao Banco Java!");
        System.out.println("1 - Escolha o número da sua conta");
        System.out.println("2 - Escolha o número da sua agência");
        System.out.println("3 - Escolha o seu nome");
        System.err.println("4 - Olhe seu saldo");
        System.out.println("0 - Sair");
        System.out.println("Escolha uma opção: ");
        opcao = sc.nextInt();

        //Obter pelo scanner a opção escolhida pelo usuário
        switch (opcao) {
            case 1:
                System.out.println("Você escolheu o número da sua conta.");
                System.out.print("Digite o número da sua conta: ");
                numeroConta = sc.nextInt();
                System.out.println("Número da conta: " + numeroConta);
                break;

            case 2:
                System.out.println("Você escolheu o número da sua agência.");
                System.out.print("Digite o número da sua agência: ");
                numeroAgencia = sc.next();
                System.out.println("Número da agência: " + numeroAgencia);
                break;

            case 3:
                System.out.println("Você escolheu o seu nome.");
                System.out.print("Digite o seu nome: ");
                nome = sc.next();
                System.out.println("Nome: " + nome);
                break;

            case 4:
                System.out.println("Você escolheu olhar seu saldo.");
                // Aqui você pode adicionar lógica para exibir o saldo
                saldo = 2900.00; // Exemplo de saldo
                System.out.println("Seu saldo é: R$ " + saldo);
                break;

            case 0:
                System.out.println("Saindo do sistema. Até logo!");
                break;

            default:
                System.err.println("Opção inválida! Tente novamente.");
        } 

        } while (opcao != 0);

        //Exibir mensagem da conta criada com sucesso
        System.out.println("Ola," + nome + " obrigado por criar uma conta em nosso banco, sua agência é " + numeroAgencia + " e o número da sua conta é " + numeroConta + ". Seu saldo é de R$ " + saldo + ".");

        // Fechar o scanner
        sc.close();
    }

}
