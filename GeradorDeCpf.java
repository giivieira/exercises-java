import java.util.Scanner;

public class GeradorDeCpf {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("****** GERADOR DE CPF ******");
        System.out.print("Digite os 9 primeiros dígitos do CPF: ");
        String cpfUsuario = scanner.next();

        // Verifica se a entrada do usuário é válida
        if (!validarEntradaCPF(cpfUsuario)) {
            System.out.println("Entrada inválida. Por favor, digite novamente.");
        } else {
            // Corrige e exibe o CPF
            String cpfCorrigido = corrigirCPF(cpfUsuario);
            System.out.println("CPF corrigido: " + cpfCorrigido);
        }
    }

    // Função para validar a entrada do CPF do usuário
    private static boolean validarEntradaCPF(String cpf) {
        return cpf.length() == 9 && cpf.matches("\\d+");
    }

    // Função para corrigir o CPF adicionando os dois últimos dígitos verificadores
    private static String corrigirCPF(String cpf) {
        int[] pesos = {10, 11};
        String cpfCorrigido = cpf;

        // Calcula os dois dígitos verificadores e os adiciona ao CPF
        for (int x = 0; x < 2; x++) {
            int soma = 0;
            int peso = pesos[x];

            for (int i = 0; i < cpfCorrigido.length(); i++) {
                soma += (cpfCorrigido.charAt(i) - '0') * peso;
                peso--;
            }

            int digitos = (soma % 11 < 2) ? 0 : (11 - soma % 11);
            cpfCorrigido += digitos;
        }

        return cpfCorrigido;
    }
}
