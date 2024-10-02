import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArvoreBinaria arvore = new ArvoreBinaria();

        while (true) {
            try {
                System.out.println("\nEscolha uma opção:");
                System.out.println("1. Decodificar Morse");
                System.out.println("2. Codificar para Morse");
                System.out.println("3. Exibir a árvore");
                System.out.println("4. Sair");
                System.out.print("Opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o código Morse: ");
                        String morseInput = scanner.nextLine();
                        System.out.println("Resultado: " + arvore.decodeMorse(morseInput));
                        break;

                    case 2:
                        System.out.print("Digite a palavra para Morse: ");
                        String wordInput = scanner.nextLine();
                        System.out.println("Resultado: " +arvore.encodeMorse(wordInput));
                        break;

                    case 3:
                        arvore.printTree();
                        break;

                    case 4:
                        System.out.println("Encerrando o programa.");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
                scanner.nextLine();
            }
        }
    }
}
