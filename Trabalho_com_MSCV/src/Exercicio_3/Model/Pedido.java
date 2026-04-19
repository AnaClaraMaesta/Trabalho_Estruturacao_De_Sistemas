package Exercicio_3.Model;

public class Pedido {
    private Cliente cliente;
    private Produto produto;
    private final String numeroPedido;

    public Pedido(Cliente cliente, Produto produto, String numeroPedido) {
        this.cliente = cliente;
        this.produto = produto;
        this.numeroPedido = numeroPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public String getNumeroPedido() {
        return numeroPedido;
    }


    @Override
    public String toString() {
        return "Pedido -> " +
                " | N°: " + numeroPedido +
                " | Cliente: " + cliente.getNome() +
                " | Produto: " + produto.getNome() +
                " | Preço unitário: R$ " + String.format("%.2f", produto.getPreco());
    }
}
