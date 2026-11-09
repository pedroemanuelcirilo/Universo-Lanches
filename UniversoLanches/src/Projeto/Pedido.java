package Projeto;

import java.util.Objects;

public class Pedido {
    private int quantidade;
    private Produto produto;
    private String local_entrega;

    public Pedido(int quantidade, Produto produto, String local_entrega){
        this.produto = produto;
        this.local_entrega = local_entrega;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    @Override
    public String toString(){
        return String.format("%d(s) de %s total de: R$%.2f\n||%s||",quantidade, produto.getNome(), produto.getPreco() * quantidade, local_entrega);

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(produto, pedido.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(produto);
    }
}
