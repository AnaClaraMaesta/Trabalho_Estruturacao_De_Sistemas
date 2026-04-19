package Exercicio_3;

public class Cliente {
    private Pedido pedido;
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Cliente -> "+
                "| Nome: "+nome+
                "| N° Pedido: "+pedido.getNumeroPedido();
    }
}
