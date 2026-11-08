package Projeto;
import java.util.Scanner;

public class MainUniversoLanches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UniversoLanches uni = new UniversoLanches();
        String opcao;

        do {
            opcao = menu(scanner);
            comando(scanner, opcao, uni);
        } while (!opcao.equals("S"));
    }

    private static String menu(Scanner scanner){
        String menu = "\n(L)Adiciona cliente\n" +
                    "(P)Fazer o pedido\n" +
                    "(C)Carrinho do cliente\n" +
                    "(E)Consultar estoque\n" +
                    "(Q)Canselar pedido\n" +
                    "(A)Adicionar ao estoque\n" +
                    "(M)Mudar Preço do lanche\n" +
                    "($)Comprar produtos\n" +
                    "(S)Sair\n\n" +
                    "Opção> ";

        System.out.print(menu);
        String opcao = scanner.nextLine().toUpperCase();
        return opcao;
    }

    private static void comando(Scanner scanner, String opcao, UniversoLanches uni){
    switch(opcao){
        case "L":
            adicionaCliente(scanner, uni);
            break;
        case "P":
            fazPedido(scanner, uni);
            break;
        case "C":
            mostraCarrinho(scanner, uni);
            break;
        case "E":
            consultaEstoque(scanner, uni);
            break;
        case "Q":
            cancelaPedido(scanner, uni);
            break;
        case"A":
            adicionaEstoque(scanner, uni);
            break;
        case "M":
            mudaPreco(scanner, uni);
            break;
        case "$":
            comprarProdutos(scanner, uni);
            break;
        case "S":
            break;
        default:
            System.out.println("Opção inválida");
            break;
        }
    }

    private static void adicionaCliente(Scanner scanner, UniversoLanches uni){
        System.out.print("Nome do cliente> ");
        String nome = scanner.nextLine();
        System.out.print("Email> ");
        String email = scanner.nextLine();
        System.out.print("Residencia> ");
        String residencia = scanner.nextLine();

        if (uni.adicionaCliente(nome, email, residencia))
            System.out.println("CLIENTE CADASTRADO");
    }

    private static void fazPedido(Scanner scanner, UniversoLanches uni){
        System.out.print("Email> ");
        String email = scanner.nextLine();
        System.out.print("Quantidade> ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome do lanche> ");
        String nome = scanner.nextLine();
        System.out.print("Local de entrega> ");
        String local = scanner.nextLine();

        System.out.println(uni.adicionaPedido(email, quantidade, nome, local));
    }

    private static void mostraCarrinho(Scanner scanner, UniversoLanches uni){
        System.out.print("Email> ");
        String email = scanner.nextLine();
        System.out.println(uni.mostraCarrinho(email));
    }

    private static void consultaEstoque(Scanner scanner, UniversoLanches uni){
        System.out.println(uni.mostraEstoque());
    }

    private static void cancelaPedido(Scanner scanner, UniversoLanches uni){
        System.out.print("Email> ");
        String email = scanner.nextLine();
        System.out.print("Qunatidade> ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome do produto> ");
        String nome = scanner.nextLine();
        System.out.print("Local de entrega> ");
        String local = scanner.nextLine();

        System.out.println(uni.tiraPedido(email, quantidade, nome, local));
    }

    private static void adicionaEstoque(Scanner scanner, UniversoLanches uni){
        System.out.print("Nome> ");
        String nome = scanner.nextLine();
        System.out.print("Preço de venda> ");
        double precoV = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Quantidade> ");
        int quant = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Preço de compra> ");
        double precoC = scanner.nextDouble();
        scanner.nextLine();

        System.out.println(uni.adicionaProduto(nome, precoV, quant, precoC));
    }

    private static void mudaPreco(Scanner scanner, UniversoLanches uni){
        System.out.print("Nome do produto> ");
        String nome = scanner.nextLine();
        System.out.print("Preço novo");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        System.out.println(uni.mudaPreco(nome, preco));
    }

    private static void comprarProdutos(Scanner scanner, UniversoLanches uni){
        System.out.print("Nome> ");
        String nome = scanner.nextLine();
        System.out.print("Quantidade> ");
        int quant = scanner.nextInt();
        scanner.nextLine();

        System.out.println(uni.compraProduto(quant, nome));
    }
}

