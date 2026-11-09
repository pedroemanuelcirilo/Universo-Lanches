package Projeto;
import java.util.HashMap;
import java.util.Map;

public class UniversoLanches {
    private Map<String, Cliente> clientes;
    private Map<String, Produto> estoque;

    public UniversoLanches(){
        this.clientes = new HashMap<>();
        this.estoque = new HashMap<>();
    }

    public boolean adicionaCliente(String nome, String email, String residencia){
        if (!clientes.containsKey(email)) {
            Cliente cliente = new Cliente(nome, email, residencia);
            clientes.put(email, cliente);
            return true;
        }
        return false;
    }

    public String adicionaPedido(String email, int quantidade, String nome, String local){
        if(clientes.containsKey(email) && estoque.containsKey(nome)){
            int quant = estoque.get(nome).getQuantidade();
            if (quant > 0 && quantidade <= quant) {
                Pedido pedido = new Pedido(quantidade, estoque.get(nome), local);
                clientes.get(email).adicionaPedido(pedido);
                estoque.get(nome).adicionaQuantidade(-quantidade);
                return "PEDIDO ADICIONADO";
            }
            return "NÃO POSSUI O SUFUCIENTE NO ESTOQUE";
        }
        return "CLIENTE OU PRODUTO NÃO EXISTE";

    }

    public String adicionaProduto(String nome, double preco, int quantidade, double valor_compra){
        if(!estoque.containsKey(nome)){
            Produto produto = new Produto(nome, preco, quantidade, valor_compra);
            estoque.put(nome, produto);
            return String.format("PRODUTO ADICIONADO, GASTO: R$%.2f", quantidade * valor_compra);
        }
        return "PRODUTO JÁ ESTÁ NO ESTOQUE";
    }

    public String compraProduto(int quantidade, String nome_produto){
        if (quantidade <= 0)
            return "QUANTIDADE INVÁLIDA";

        if (estoque.containsKey(nome_produto)){
            estoque.get(nome_produto).adicionaQuantidade(quantidade);
            double preco = estoque.get(nome_produto).getPreco_compra();
            return String.format("%d %s comprado(s) com o valor de R$%.2f", quantidade, nome_produto, preco * quantidade );
        }
        return "PRODUTO NÃO ESTÁ NO ESTOQUE";
    }

    public String mudaPreco(String nome, double preco){
        if(estoque.containsKey(nome)){
            estoque.get(nome).setPreco(preco);
            return "PREÇO ALTERADO";
        }
        return "PRODUTO NÃO ESTA NO ESTOQUE";
    }

    public String tiraPedido(String email, String nome){
        if (clientes.containsKey(email) && estoque.containsKey(nome)){
            clientes.get(email).tiraPedido(nome);
            return "PEDIDO REMOVIDO";
        }
        return "PEDIDO NÃO LISTADO";
    }

    public String mostraCarrinho(String email){
        if (clientes.containsKey(email))
            return clientes.get(email).getCarrinho();
        return "CLIENTE NÃO CADASTRADO";
    }

    public String mostraEstoque(){
        String saida = "%-----------------------------------------%\n";
        for (Map.Entry<String, Produto> pro : estoque.entrySet()){
            saida += pro.getValue().toString() + "\n";
        }
        saida += "%-----------------------------------------%";
        return saida;
    }
}

