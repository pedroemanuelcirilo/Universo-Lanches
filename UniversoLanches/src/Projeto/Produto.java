package Projeto;

import java.util.Objects;

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;
    private double preco_compra;

    public Produto(String nome, double preco, int quantidade, double preco_compra){
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.preco_compra = preco_compra;
    }

    public String getNome(){
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void adicionaQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco_compra() {
        return preco_compra;
    }

    public void setPreco_compra(double preco_compra) {
        this.preco_compra = preco_compra;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(nome, produto.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }
    @Override
    public String toString(){
        return String.format("Quantidade: %d | %s | Preço de venda: %.2f\nPreço de compra: %.2f", quantidade, nome, preco, preco_compra);
    }
}
