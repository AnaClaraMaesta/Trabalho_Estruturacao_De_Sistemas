package Exercicio_3.Service;

import Exercicio_3.Model.Cliente;
import Exercicio_3.Model.Pedido;
import Exercicio_3.Model.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoService {
    private List<Pedido> pedidos = new ArrayList<>();
    private ClienteService clienteService;
    private ProdutoService produtoService;

    public PedidoService(ClienteService clienteService, ProdutoService produtoService) {
        this.clienteService = clienteService;
        this.produtoService = produtoService;
    }

    public void registrarPedido(String nomeCliente, String nomeProduto, String numeroPedido)
    {
        Cliente cliente = clienteService.buscarCliente(nomeCliente);

        if(cliente == null)
        {
            throw new IllegalArgumentException("Cliente não encontrado");
        }

        Produto produto = produtoService.buscarProduto(nomeProduto);
        if(produto == null)
        {
            throw new IllegalArgumentException("Produto não encontrado");
        }

        if(numeroPedido == null)
        {
            throw new IllegalArgumentException("Informe o numero do Pedido");
        }

        System.out.println("Adicionando pedido...");
        pedidos.add(new Pedido(cliente, produto, numeroPedido));
    }

    public void removerPedido(String numeroPedido) {
        if (numeroPedido == null || numeroPedido.trim().isBlank()) {
            throw new IllegalArgumentException("Informe o número do pedido");
        }
        Pedido pedido = buscarPedido(numeroPedido);
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não encontrado");
        }
        pedidos.remove(pedido);
    }

    public double calcularValorPedido(String numeroPedido)
    {
        if(numeroPedido == null)
        {
            throw new IllegalArgumentException("Informe o numero do Pedido");
        }


        return pedidos.stream().filter(ped -> ped.getNumeroPedido().equalsIgnoreCase(numeroPedido)).mapToDouble(ped ->ped.getProduto().getPreco()).sum();

    }

    public Pedido buscarPedido(String numeroPedido)
    {
        if(numeroPedido == null)
        {
            throw new IllegalArgumentException("Informe o numero do Pedido");
        }

        return pedidos.stream().filter(pedido -> pedido.getNumeroPedido().equalsIgnoreCase(numeroPedido)).findFirst().orElse(null);

    }

    public List<Pedido> listarPedidos()
    {
        if(pedidos.isEmpty())
        {
            throw new IllegalArgumentException("Nenhum pedido registrado");
        }

        return new ArrayList<>(pedidos);
    }
}
