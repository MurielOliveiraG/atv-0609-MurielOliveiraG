package src;

import java.util.ArrayList;

public class Gerenciador {

    private ArrayList<Produto> produtos;
    private ArrayList<Lista> listas;

    public Gerenciador() {
        produtos = new ArrayList<>();
        listas = new ArrayList<>();
    }

    public Produto buscarProduto(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome)) {
                return produto;
            }
        }
        return null;
    }

    public String cadastrarProduto(String nome, double valor, double peso) {
        Produto produto = buscarProduto(nome);
        if (produto == null) {
            Produto novoproduto = new Produto(nome, valor, peso);
            produtos.add(novoproduto);
            return "Cadastro realizado com sucesso!";
        }
        return "Erro! Produto já cadastrado";
    }

    public String listarProdutos() {
        String strListaProdutos = "";
        for (Produto produto : produtos) {
            strListaProdutos += produto.toString();
        }
        return strListaProdutos;
    }

    public Lista buscarLista(String nome) {
        for (Lista lista : listas) {
            if (lista != null && lista.getNome().contains(nome)) {
                return lista;
            }
        }
        return null;
    }

    public String criarLista(String nome) {
        Lista lista = buscarLista(nome);
        if (lista == null) {
            Lista novaLista = new Lista(nome);
            listas.add(novaLista);
            return "Lista cadastrada com sucesso!";
        }
        return "Erro! Produto já cadastrado.";
    }

    public String adicionarProduto(String nomeProduto, String nomeLista) {
        Lista encontrarLista = buscarLista(nomeLista);
        if (encontrarLista != null) {
            Produto adicionarProduto = buscarProduto(nomeProduto);
            if (adicionarProduto != null) {
                encontrarLista.getProdutos().add(0, adicionarProduto);
                return "Produto adicionado a lista.";
            }
            return "Produto não cadastrado!";
        }
        return "Lista não cadastrada!";
    }

    public String listarLista() {
        String strListarLista = "";
        for (Lista lista : listas) {
            strListarLista += lista.toString();
        }
        return strListarLista;
    }

    public String detalhesLista(String nome) {
        Lista lista = buscarLista(nome);
        if (lista == null) {
            return "Lista não encontrada";
        } else {
            double valor = lista.somarValorProdutos(lista);
            double peso = lista.somarPesoProdutos(lista);
            return lista.toString() + "\nValor total:R$" + valor + "\nPeso Total:" + peso + "KG";
        }
    }

    public String removerProduto(String nomeProduto, String nomeLista) {
        Lista encontrarLista = buscarLista(nomeLista);
        if (encontrarLista != null) {
            Produto removerProduto = buscarProduto(nomeProduto);
            if (removerProduto != null) {
                encontrarLista.getProdutos().remove(removerProduto);
                return "Produto removido da lista.";
            }
            return "O produto digitado não pertence a lista";
        }
        return "Lista não encontrada.";
    }
}
