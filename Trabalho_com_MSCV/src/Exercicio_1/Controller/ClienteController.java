package Exercicio_1.Controller;

import Exercicio_1.Service.ClienteService;

import java.util.Scanner;

public class ClienteController {
    private ClienteService service;
    private Scanner scan = new Scanner(System.in);

    public ClienteController(ClienteService clienteService) {
        this.service = clienteService;
    }

    public void cadastrarCliente() {
        System.out.print("Digite o nome do cliente: ");
        String nome = scan.nextLine();
        System.out.print("Digite o numero de telefone: ");
        String telefone = scan.nextLine();

        try{
            service.cadastrarCliente(nome, telefone);
            System.out.println("O cliente foi cadastrado");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void excluirCliente() {
        System.out.print("Nome do cliente que deseja excluir: ");
        String nome = scan.nextLine();

        try{
            service.removerCliente(nome);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void listarClientes(){
        try{
            service.listarClientes().forEach(System.out::println);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
