import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Bem-vindo ao sistema de compras com cartão ===");
        System.out.print("Informe o limite do cartão: R$ ");
        double limite = scanner.nextDouble();

        CartaoCredito cartao = new CartaoCredito(limite);

        int sair = 1;
        while (sair != 0){
            System.out.print("\nInforme o nome do produto: ");
            String produto = scanner.next();

            System.out.print("Digite o valor da compra: R$ ");
            double valor = scanner.nextDouble();

            Compras compra = new Compras(produto, valor);
            boolean compraAutorizada = cartao.lancaCompra(compra);

            if (compraAutorizada){
                System.out.println("✅ Compra autorizada!");
            } else {
                System.out.println("❌ Compra negada por saldo insuficiente!");
                break;
            }

            System.out.print("\nDeseja realizar outra compra? (1 = Sim / 0 = Não): ");
            sair = scanner.nextInt();
        }

        System.out.println("Sua compra foi finalizada com sucesso!\n" +
                "Confira os detalhes abaixo:");
        System.out.println("\n======== NOTA FISCAL ========");
        System.out.printf("%-20s %10s\n", "Produto", "Valor (R$)");
        System.out.println("-------------------------------");

        for (Compras c : cartao.getCompras()) {
            System.out.printf("%-20s %10.2f\n", c.getProduto(), c.getValor());
        }

        System.out.println("-------------------------------");
        System.out.printf("%-20s %10.2f\n", "TOTAL", cartao.getLimite() - cartao.getSaldo());
        System.out.printf("%-20s %10.2f\n", "Saldo restante", cartao.getSaldo());
        System.out.println("===============================");
        System.out.println("\n Obrigada pela compra!");


        scanner.close();
    }
}
