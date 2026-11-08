package Projeto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Cliente {
    private String nome;
    private String email;
    private String residencia;
    private ArrayList<Pedido> carrinho;

    public Cliente(String nome, String email, String residencia){
        this.nome = nome;
        this.email = email;
        this.residencia = residencia;
        this.carrinho = new ArrayList<>();
    }

    public void adicionaPedido(Pedido pedido){
        carrinho.add(pedido);
    }

    public void tiraPedido(Pedido pedido){
        carrinho.remove(pedido);
    }

    public String getResidencia() {
        return residencia;
    }

    public String getCarrinho(){
        Iterator<Pedido> it = carrinho.iterator();
        String saida = "%-----------------------------------------%\n";
        while (it.hasNext()){
            saida += it.next().toString() + "\n";
        }
        saida += "%-----------------------------------------%";
        return saida;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(email, cliente.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }
}
