package Exercicio_3.Controller;

import Exercicio_3.Model.Pedido;
import Exercicio_3.Service.PedidoService;

import java.util.Scanner;

public class PedidoController {
    private Scanner scan = new Scanner(System.in);
    private PedidoService service;

    public PedidoController(PedidoService pedidoService) {
        this.service = pedidoService;
    }

    public void registrarPedido()
    {
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scan.nextLine();

        System.out.print("N° do pedido: ");
        String numeroPedido = scan.nextLine();

        boolean continuar = true;

        while (continuar)
        {
            System.out.print("Digite o produto: ");
            String produto = scan.nextLine();

            try {
                service.registrarPedido(nomeCliente, produto, numeroPedido);
                System.out.println("Produto adicionado ao pedido!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.print("Deseja acrescentar outro produto? 1- Sim | 2- Não: ");
            try {
                int choice = Integer.parseInt(scan.nextLine());
                if (choice != 1) {
                    continuar = false;
                }
            } catch (Exception e) {
                System.out.println("Opção inválida");
                continuar = false;
            }
        }
    }

    public void calcularValorPedido() {
        System.out.print("Informe o N° do Pedido: ");
        String numeroPedido = scan.nextLine();
        try {
            double total = service.calcularValorPedido(numeroPedido);
            System.out.println("Total: R$ " + String.format("%.2f", total));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void buscarPedido() {
        System.out.print("Informe o N° do Pedido: ");
        String numeroPedido = scan.nextLine();
        try {
            Pedido pedido = service.buscarPedido(numeroPedido);
            if (pedido == null) {
                System.out.println("Pedido não encontrado");
            } else {
                System.out.println(pedido);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void listarPedidos() {
        try {
            service.listarPedidos().forEach(p -> {
                System.out.println(p);
                double total = service.calcularValorPedido(p.getNumeroPedido());
                System.out.println("Total do pedido #" + p.getNumeroPedido() + ": R$ " + String.format("%.2f", total));
                System.out.println("==============");
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void removerPedido() {
        System.out.print("Informe o N° do Pedido: ");
        String numeroPedido = scan.nextLine();
        try {
            service.removerPedido(numeroPedido);
            System.out.println("Pedido removido com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
