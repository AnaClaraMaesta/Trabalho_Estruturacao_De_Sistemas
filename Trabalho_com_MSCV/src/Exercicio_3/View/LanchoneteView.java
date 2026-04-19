package Exercicio_3.View;

import Exercicio_3.Controller.ClienteController;
import Exercicio_3.Controller.PedidoController;
import Exercicio_3.Controller.ProdutoController;
import Exercicio_3.Service.ClienteService;
import Exercicio_3.Service.PedidoService;
import Exercicio_3.Service.ProdutoService;

import java.sql.SQLOutput;
import java.util.Scanner;

public class LanchoneteView {
    private Scanner scan = new Scanner(System.in);
    private ClienteService clienteService = new ClienteService();
    private ProdutoService produtoService = new ProdutoService();
    private PedidoService pedidoService = new PedidoService(clienteService, produtoService);

    private ClienteController clienteController = new ClienteController(clienteService);
    private ProdutoController produtoController = new ProdutoController(produtoService);
    private PedidoController pedidoController = new PedidoController(pedidoService);

    public void menuInicial()
    {
        int opcao = -1;

        do
        {
            System.out.println("================= MENU LANCHONETE =================");
            System.out.println("1 - GERENCIAR CLIENTE");
            System.out.println("2 - GERENCIAR PRODUTOS");
            System.out.println("3 - GERENCIAR PEDIDOS");
            System.out.println("0 - EXIT");
            System.out.print("Opção: ");

            try{
                opcao = Integer.parseInt(scan.nextLine());

                switch (opcao){
                    case 1 -> menuCliente();
                    case 2 -> menuProduto();
                    case 3 -> menuPedidos();
                    case 0 -> System.out.println("Encerrando sistema....");
                    default -> System.out.println("Opcao invalida");
                }
            }catch(Exception e){

            }


        }while(opcao !=0);
    }

    public void menuCliente()
    {
        System.out.println("================= MENU CLIENTE =================");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Remover Cliente");
        System.out.println("3 - Buscar Cliente");
        System.out.println("4 - Listar Clientes");
        System.out.println("Opcao: ");
        try
        {
            int opcao = Integer.parseInt(scan.nextLine());
            switch (opcao){
                case 1 -> clienteController.cadastrarCliente();
                case 2 -> clienteController.removerCliente();
                case 3 -> clienteController.buscarCliente();
                case 4 -> clienteController.listarClientes();
                default -> System.out.println("Opcao invalida");
            }
        } catch (Exception e) {
            System.out.println("Opcao invalida");
        }
    }

    public void menuProduto()
    {
        System.out.println("================= MENU PRODUTO ================");
        System.out.println("1 - Cadastrar Produto");
        System.out.println("2 - Remover Produto");
        System.out.println("3 - Buscar Produto");
        System.out.println("4 - Listar Produtos");
        System.out.println("Opcao: ");

        try
        {
            int opcao = Integer.parseInt(scan.nextLine());

            switch (opcao){
                case 1 -> produtoController.registrarProduto();
                case 2 -> produtoController.removerProduto();
                case 3 -> produtoController.buscarProduto();
                case 4 -> produtoController.listarProdutos();
                default -> System.out.println("Opcao invalida");
            }
        }catch(Exception e){
            System.out.println("Opcao invalida");
        }
    }

    public void menuPedidos()
    {
        System.out.println("================= MENU PEDIDOS ================");
        System.out.println("1 - Registrar Pedido");
        System.out.println("2 - Remover Pedido");
        System.out.println("3 - Calcular Valor do Pedido");
        System.out.println("4 - Buscar Pedido");
        System.out.println("5 - Listar Pedidos");
        System.out.println("Opcao: ");
        try
        {
            int opcao = Integer.parseInt(scan.nextLine());

            switch (opcao){
                case 1 -> pedidoController.registrarPedido();
                case 2 -> pedidoController.removerPedido();
                case 3 -> pedidoController.calcularValorPedido();
                case 4 -> pedidoController.buscarPedido();
                case 5 -> pedidoController.listarPedidos();
                default -> System.out.println("Opcao invalida");
            }
        }catch(Exception e){
            System.out.println("Opcao invalida");
        }
    }
}
