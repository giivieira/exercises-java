import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("****** SEQUÊNCIA DE FIBONACCI ******");

        System.out.print("Digite um número: ");
        int n = scanner.nextInt();

        System.out.println("Os primeiros " + n + " números da Sequência de Fibonacci são:");

        for (int i = 0; i < n; i++) {
            // Chama a função para calcular e imprimir os números da sequência
            int resultado = calcularFibonacci(i);
            System.out.print(resultado + " ");
        }
    }

    // Função para calcular o número na posição da Sequência de Fibonacci
    public static int calcularFibonacci(int numero) {
        if (numero <= 1) {
            return numero;
        } else {
            // Utiliza recursividade para calcular os números da sequência
            return calcularFibonacci(numero - 1) + calcularFibonacci(numero - 2);
        }
    }
}
