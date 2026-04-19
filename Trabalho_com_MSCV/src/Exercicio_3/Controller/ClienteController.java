package Exercicio_3.Controller;

import Exercicio_3.Model.Cliente;
import Exercicio_3.Service.ClienteService;

import java.util.Scanner;

public class ClienteController {
    private Scanner scan = new Scanner(System.in);
    private ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    public void cadastrarCliente(){
        System.out.println("Digite o nome do cliente: ");
        String nome = scan.nextLine();

        try{
            service.cadastrarCliente(nome);
            System.out.println("Cliente cadastrado com sucesso!");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void removerCliente(){
        System.out.println("Digite o nome do cliente: ");
        String nome = scan.nextLine();

        try{
            service.removerCliente(nome);
            System.out.println("Cliente removido com sucesso!");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void buscarCliente() {
        System.out.print("Digite o nome do cliente: ");
        String nome = scan.nextLine();
        try {
            Cliente cliente = service.buscarCliente(nome);
            if (cliente == null) {
                System.out.println("Cliente não encontrado");
            } else {
                System.out.println(cliente);
            }
        } catch (Exception e) {
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
