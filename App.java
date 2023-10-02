package src;

import java.util.Scanner;

public class App {
    private static Scanner teclado = new Scanner(System.in);
    private static Gerenciador gerenciador = new Gerenciador();

    private static String menu() {
        String str = "";
        str += "1 - Cadastrar produtos\n";
        str += "2 - Visualizar produtos\n";
        str += "3 - Cadastrar lista de produtos\n";
        str += "4 - Adicionar produtos a uma lista\n";
        str += "5 - Visualizar listas de produtos\n";
        str += "6 - Remover produto da lista\n";
        str += "7 - Visualizar lista\n";

        str += "0 - Sair\n";

        return str;
    }

    private static void cadastrarProduto() {

        String nome;
        double valor, peso;
        int condicao = 1;

        System.out.println("---Cadastro de Produto---");

        do {
            System.out.println("Digite o nome do produto: ");
            nome = teclado.nextLine();
            System.out.println("Digite o valor do produto: ");
            valor = teclado.nextDouble();
            System.out.println("Digite o peso do produto(KG): ");
            peso = teclado.nextDouble();

            System.out.println(gerenciador.cadastrarProduto(nome, valor, peso));

            System.out.println("--Deseja cadastrar um novo produto?");
            System.out.println("Digite 1 p/ sim ou 2 p/ não");
            condicao = teclado.nextInt();
            teclado.nextLine();
        } while (condicao == 1);
    }

    private static void cadastrarLista() {
        String nomeLista;
        int condicao = 1;
        System.out.println("---Cadastro de Lista---");
        do {
            System.out.println("Qual o nome da nova lista?");
            nomeLista = teclado.nextLine();

            System.out.println(gerenciador.criarLista(nomeLista));

            System.out.println("Deseja cadastrar uma nova lista?");
            System.out.println("Digite 1 p/ sim ou 2 p/ não");
            condicao = teclado.nextInt();
            teclado.nextLine();
        } while (condicao == 1);
    }

    private static void adicionarProdutos() {
        String nomeLista, nomeProduto;
        int condicao = 1;
        do {
            System.out.println("Qual lista você deseja adicionar produtos?");
            nomeLista = teclado.nextLine();
            System.out.println("Qual produto você deseja adicionar a essa lista?");
            nomeProduto = teclado.nextLine();

            System.out.println(gerenciador.adicionarProduto(nomeProduto, nomeLista));

            System.out.println("Deseja adicionar um novo produto?");
            System.out.println("Digite 1 p/ sim ou 2 p/ não");
            condicao = teclado.nextInt();
        } while (condicao == 1);
    }

    private static void removerProdutoLista() {
        String nomeLista, nomeProduto;
        int condicao = 1;

        do {
            System.out.println("Qual lista você deseja remover produtos?");
            nomeLista = teclado.nextLine();
            System.out.println("Qual produto você deseja remover dessa lista?");
            nomeProduto = teclado.nextLine();

            System.out.println(gerenciador.removerProduto(nomeProduto, nomeLista));

            System.out.println("Deseja cadastrar uma nova lista?");
            System.out.println("Digite 1 p/ sim ou 2 p/ não");
            condicao = teclado.nextInt();
        } while (condicao == 1);
    }

    private static void printarProdutos() {
        System.out.println(gerenciador.listarProdutos());
    }

    private static void printarListas() {
        System.out.println(gerenciador.listarLista());
    }

    private static void visualizarDetalhesLista() {
        System.out.println("Digite o nome da lista a ser visualizada: ");
        String nome = teclado.nextLine();
        System.out.println(gerenciador.detalhesLista(nome));
    }

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int resultado;

        do {
            System.out.println(menu());
            resultado = teclado.nextInt();
            teclado.nextLine();

            switch (resultado) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    printarProdutos();
                    break;
                case 3:
                    cadastrarLista();
                    break;
                case 4:
                    adicionarProdutos();
                    break;
                case 5:
                    printarListas();
                    break;
                case 6:
                    removerProdutoLista();
                    break;
                case 7:
                    visualizarDetalhesLista();
            }

        } while (resultado != 0);

    }
}

/* git config --global user.name "MurielOliveiraG" */
/* git config --global user.email "murieldeoliveiragabriel@gmail.com" */