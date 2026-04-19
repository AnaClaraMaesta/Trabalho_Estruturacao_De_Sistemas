package Exercicio_3.Controller;

import Exercicio_3.Service.ProdutoService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProdutoController {
    private Scanner scan = new Scanner(System.in);
    private ProdutoService service;

    public ProdutoController(ProdutoService produtoService) {
        this.service = produtoService;
    }

    public void registrarProduto()
    {
        System.out.println("Digite o nome do produto: ");
        String nome = scan.nextLine();
        System.out.println("Digite uma descrição para o produto: ");
        String descricao = scan.nextLine();
        System.out.println("Digite o valor do produto: ");
        try{
            double valor = Double.parseDouble(scan.nextLine());
            service.registrarProduto(nome, descricao, valor);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void removerProduto()
    {
        System.out.println("Digite o nome do produto: ");
        String nome = scan.nextLine();

        try{
            service.removerProduto(nome);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void buscarProduto()
    {
        System.out.println("Digite o nome do produto: ");
        String nome = scan.nextLine();

        try{
            service.buscarProduto(nome);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void listarProdutos()
    {
        try{
            service.listarProdutos();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
