package Exercicio_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    private Scanner scan = new Scanner(System.in);
    private List<Cliente> clientes = new ArrayList<Cliente>();
    private List<Produto> produtos = new ArrayList<Produto>();
    private List<Pedido> pedidos = new ArrayList<>();

    void main() {
        new Main().menuInicial();
    }

    private void menuInicial()
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

    private void menuCliente(){
        System.out.println("================= MENU CLIENTE =================");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Remover Cliente");
        System.out.println("3 - Buscar Cliente");
        System.out.println("4 - Listar Clientes");
        System.out.println("Opcao: ");

        try {
            int opcao = Integer.parseInt(scan.nextLine());
            switch (opcao){
                case 1 -> cadastrarCliente();
                case 2 -> removerCliente();
                case 3 -> {
                    String nome = scan.nextLine();
                    Cliente cliente = buscarCliente(nome);
                    System.out.println(cliente != null ? cliente : "Cliente nao cadastrado");
                }
                case 4 -> clientes.forEach(System.out::println);

                default -> System.out.println("Opcao invalida");
            }
        }catch(Exception e){
            System.out.println("Opcao invalida");
        }
    }

    private void menuProduto(){
        System.out.println("================= MENU PRODUTO ================");
        System.out.println("1 - Cadastrar Produto");
        System.out.println("2 - Remover Produto");
        System.out.println("3 - Buscar Produto");
        System.out.println("4 - Listar Produtos");
        System.out.println("Opcao: ");

        try {
            int opcao = Integer.parseInt(scan.nextLine());

            switch (opcao){
                case 1 -> cadastrarProduto();
                case 2 -> removerProduto();
                case 3 -> {
                    System.out.println("Digite o produto: ");
                    String nome = scan.nextLine();

                    Produto produto = buscarProduto(nome);
                    System.out.println(produto != null ? produto : "Produto nao cadastrado");

                }
                case 4 -> produtos.forEach(System.out::println);
                default -> System.out.println("Opcao invalida");
            }
        }catch(Exception e){
            System.out.println("Opcao invalida");
        }
    }

    private void menuPedidos(){
        System.out.println("================= MENU PEDIDOS ================");
        System.out.println("1 - Registrar Pedido");
        System.out.println("2 - Remover Pedido");
        System.out.println("3 - Calcular Valor do Pedido");
        System.out.println("4 - Buscar Pedido");
        System.out.println("5 - Listar Pedidos");
        System.out.println("Opcao: ");

        try{
            int opcao = Integer.parseInt(scan.nextLine());

            switch (opcao){
                case 1 -> registrarPedido();
                case 2 -> removerPedido();
                case 3 -> {
                    System.out.println("Digite n° do pedido: ");
                    String numeroPedido = scan.nextLine();
                    Pedido pedido = buscarPedido(numeroPedido);
                    System.out.println(pedido != null ? pedido : "Pedido nao cadastrado");
                }
                case 4 -> pedidos.forEach(System.out::println);
                default -> System.out.println("Opcao invalida");
            }
        }catch(Exception e){
            System.out.println("Opcao invalida");
        }
    }

    private void cadastrarCliente(){
        System.out.println("Digite o nome do cliente: ");
        String nome = scan.nextLine();

        if(nome==null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("O nome não pode estar em branco");
        }
        if(buscarCliente(nome) != null){
            throw new IllegalArgumentException("Cliente já cadastrado");
        }

        clientes.add(new Cliente(nome));
    }

    private void removerCliente(){
        System.out.println("Digite o nome do cliente: ");
        String nome = scan.nextLine();

        Cliente cliente = buscarCliente(nome);
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não encontrado");
        }
        clientes.remove(cliente);
    }

    private Cliente buscarCliente(String nome){
        return clientes.stream().filter(cliente -> cliente.getNome().equals(nome)).findFirst().orElse(null);

    }

    private void cadastrarProduto(){
        System.out.println("Digite o nome do produto: ");
        String nome = scan.nextLine();
        System.out.println("Digite a descricao do produto: ");
        String descricao = scan.nextLine();
        System.out.println("Digite o valor do produto: ");
        double valor = scan.nextDouble();

        try{
            produtos.add(new Produto(nome, descricao, valor));
            System.out.println("Produto adicionado com sucesso!");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void removerProduto(){
        System.out.println("Digite o nome do produto: ");
        String nome = scan.nextLine();
        try{
            produtos.removeIf(produto -> produto.getNome().equals(nome));
            System.out.println("Produto removido com sucesso!");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    private Produto buscarProduto(String nome){
        return produtos.stream().filter(p -> p.getNome().equals(nome)).findFirst().orElse(null);
    }

    private void registrarPedido(){
        System.out.println("Digite o nome do cliente: ");
        String nome = scan.nextLine();
        Cliente cliente = buscarCliente(nome);
        if(cliente == null){
            throw new IllegalArgumentException("Cliente nao encontrado");
        }

        System.out.println("Digite o nome do produto: ");
        String nomeProduto = scan.nextLine();
        Produto produto = buscarProduto(nomeProduto);
        if(produto == null){
            throw new IllegalArgumentException("Produto nao encontrado");
        }

        System.out.println("Digite n° do pedido: ");
        String numeropedido = scan.nextLine();

        pedidos.add(new Pedido(cliente, produto, numeropedido));
    }

    private void removerPedido(){
        System.out.println("Digite n° do pedido: ");
        String numeropedido = scan.nextLine();

        try{
            pedidos.removeIf(pedido -> pedido.getNumeroPedido().equals(numeropedido));
            System.out.println("Pedido removido com sucesso!");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    private Pedido buscarPedido(String numeroPedido){
        return  pedidos.stream().filter(p -> p.getNumeroPedido().equals(numeroPedido)).findFirst().orElse(null);
    }



}