package src;
import java.util.ArrayList;

public class Lista {
    
    private String nome;
    private ArrayList <Produto> produtos;

    public Lista(String nome){
       this.nome = nome;
       this.produtos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }


    public String toString(){
        String strListaProdutos = "";
        strListaProdutos += getProdutos().toString();
        return "\nLista: " +nome+ "\nProdutos: " + strListaProdutos + "\n";
    }

    public double somarValorProdutos(Lista lista) {
        double somaValor = 0;
        ArrayList<Produto> produtos = lista.getProdutos();
        for (Produto produto : produtos) {
            somaValor += produto.getValor();
        }
        return somaValor;
    }

    public double somarPesoProdutos(Lista lista) {
        double somaPeso = 0;
        ArrayList<Produto> produtos = lista.getProdutos();
        for (Produto produto : produtos) {
            somaPeso += produto.getPeso();
        }
        return somaPeso;
    }
}



