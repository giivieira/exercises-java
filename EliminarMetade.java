import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EliminarMetade {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> listaNomes = new ArrayList<>();

        System.out.println("******* ELIMINAR METADE ******");

        System.out.print("Quantidade de pessoas que serão adicionadas: ");
        int numeroPessoas = scanner.nextInt();
        scanner.nextLine();

        // Preenche a lista de nomes com base na entrada do usuário
        preencherListaNomes(numeroPessoas, listaNomes, scanner);

        // Realiza o sorteio da metade dos nomes
        ArrayList<String> sorteados = sortearMetade(listaNomes);

        // Exibe os nomes sorteados
        System.out.println("Nomes sorteados: " + sorteados);
    }

    // Função para preencher a lista de nomes com base na entrada do usuário
    private static void preencherListaNomes(int numeroPessoas, ArrayList<String> listaNomes, Scanner scanner) {
        for (int i = 1; i <= numeroPessoas; i++) {
            System.out.printf("Digite o %sº nome: ", i);
            String nome = scanner.nextLine();
            listaNomes.add(nome);
        }
    }

    // Função para sortear a metade dos nomes da lista
    private static ArrayList<String> sortearMetade(ArrayList<String> listaNomes) {
        Collections.shuffle(listaNomes); // Embaralha a lista
        int numeroDiv = (listaNomes.size() + 1) / 2;

        return new ArrayList<>(listaNomes.subList(0, numeroDiv));
    }
}
