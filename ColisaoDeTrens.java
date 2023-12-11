import java.util.Scanner;

public class ColisaoDeTrens {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            // Solicita as entradas do usuário
            double posicaoA = obterNumero("Digite a posição inicial do trem A (entre 0 e 10000): ", 0, 10000);
            double posicaoB = obterNumero("Digite a posição inicial do trem B (entre 0 e 10000): ", 0, 10000);
            double velocidadeA = obterNumero("Digite a velocidade do trem A (até 300 km/h): ", 0, 300);

            // A velocidade do trem B é negativa para indicar que vai em direção oposta
            double velocidadeB = -obterNumero("Digite a velocidade do trem B (até 300 km/h): ", 0, 300);

            // Calcula o tempo de colisão e a posição final
            double tempoColisao = calcularTempoColisao(posicaoA, posicaoB, velocidadeA, velocidadeB);
            double posicaoFinal = calcularPosicaoFinal(posicaoA, velocidadeA, tempoColisao);

            // Verifica se há colisão e exibe os resultados
            if (tempoColisao > 0) {
                System.out.println("A colisão dos trens acontecerá no KM " + posicaoFinal + " e ocorrerá após " +
                        (tempoColisao * 3600) + " segundos.");
            } else {
                System.out.println("Os trens não irão colidir.");
            }

            // Pergunta ao usuário se deseja executar novamente
            System.out.print("Deseja executar novamente? (s/n): ");
        } while (scanner.next().equalsIgnoreCase("s"));

        System.out.println("FIM DO PROGRAMA");
        scanner.close();
    }

    // Função para obter um número dentro de um intervalo específico
    private static double obterNumero(String mensagem, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double numero;

        do {
            System.out.print(mensagem);
            // Garante que a entrada seja um número válido
            while (!scanner.hasNextDouble()) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
                System.out.print(mensagem);
                scanner.next(); // Limpar o buffer do scanner
            }
            numero = scanner.nextDouble();
        } while (numero < min || numero > max);

        return numero;
    }

    // Calcula o tempo de colisão entre os trens
    private static double calcularTempoColisao(double posicaoA, double posicaoB, double velocidadeA, double velocidadeB) {
        // Se os trens tiverem a mesma velocidade, não vão colidir
        if (velocidadeA == velocidadeB) {
            return -1;
        }

        return (posicaoB - posicaoA) / (velocidadeA - velocidadeB);
    }

    // Calcula a posição final de um trem após um determinado tempo
    private static double calcularPosicaoFinal(double posicaoA, double velocidadeA, double tempo) {
        return posicaoA + (velocidadeA * tempo);
    }
}
