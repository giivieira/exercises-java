import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraGeometrica {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            exibirMenu();
            int escolha = Escolher(scanner);

            switch (escolha) {
                case 1:
                    calcularAreaQuadrado(scanner);
                    break;
                case 2:
                    calcularAreaCirculo(scanner);
                    break;
                case 3:
                    calcularAreaTriangulo(scanner);
                    break;
                case 4:
                    System.out.println("Obrigada por testar a Calculadora Geométrica da Giovanna. Até a próxima!!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\nCalculadora Geométrica");
        System.out.println("1. Calcular Área do Quadrado");
        System.out.println("2. Calcular Área do Círculo");
        System.out.println("3. Calcular Área do Triângulo");
        System.out.println("4. Sair");
    }

    private static int Escolher(Scanner scanner) {
        int escolha = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Escolha uma opção: ");
                escolha = scanner.nextInt();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println(" Por favor, insira um número inteiro.");

            }
        }

        return escolha;
    }

    private static void calcularAreaQuadrado(Scanner scanner) {
        try {
            System.out.print("Digite o comprimento do lado do quadrado: ");
            double lado = scanner.nextDouble();
            double resultado = lado * lado;
            System.out.println("Resultado: " + String.format("%.2f", resultado));
        } catch (InputMismatchException e) {
            System.out.println("Por favor, insira um número válido.");

        }
    }

    private static void calcularAreaCirculo(Scanner scanner) {
        try {
            System.out.print("Digite o raio do círculo: ");
            double raio = scanner.nextDouble();
            double resultado = Math.PI * Math.pow(raio, 2);
            System.out.println("Resultado: " + String.format("%.2f", resultado));
        } catch (InputMismatchException e) {
            System.out.println("Por favor, insira um número válido.");

        }
    }

    private static void calcularAreaTriangulo(Scanner scanner) {
        try {
            System.out.print("Digite o comprimento da base do triângulo: ");
            double base = scanner.nextDouble();
            System.out.print("Digite a altura do triângulo: ");
            double altura = scanner.nextDouble();
            double resultado = (base * altura) / 2;
            System.out.println("Resultado: " + String.format("%.2f", resultado));
        } catch (InputMismatchException e) {
            System.out.println(" Por favor, insira um número válido.");

        }
    }
}
