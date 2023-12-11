import java.util.Scanner;

public class ListaDePrimos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("****** NÚMEROS PRIMOS ******");

        int numero;
        do {
            // Solicita ao usuário que digite um número válido
            System.out.print("Digite um número: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Só é valido inserir valores numéricos, tente novamente.");
                scanner.next(); // Limpa o buffer do scanner
                System.out.print("Digite um número: ");
            }

            numero = scanner.nextInt();

            if (numero <= 0) {
                System.out.println("Número inválido. Insira outro.");
            }

        } while (numero <= 0);

        System.out.println("Lista de números primos até " + numero + ":");
        // Chama a função para verificar e imprimir números primos até o número informado
        imprimirNumerosPrimos(numero);
    }

    // Função para verificar e imprimir números primos até o número fornecido
    public static void imprimirNumerosPrimos(int numero) {
        for (int i = 2; i <= numero; i++) {
            // Se o número for primo, será feita a impressão
            if (isPrimo(i)) {
                System.out.print(i + " ");
            }
        }
    }

    // Função para verificar se um número é primo
    public static boolean isPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }

        // Verifica se o número é divisível por algum número até a raiz quadrada dele
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false; // Se for divisível, não é primo
            }
        }

        return true; // Se não foi divisível por nenhum número, é primo
    }
}
