package Exercicio_2.Controller;

import Exercicio_2.Service.EmprestimoService;

import java.util.Scanner;

public class EmprestimoController {
    private Scanner scan = new Scanner(System.in);
    private EmprestimoService service;

    public EmprestimoController(EmprestimoService emprestimoService) {
        this.service = emprestimoService;
    }

    public void fazerEmprestimo(){
        System.out.println("Nome do aluno: ");
        String nome = scan.nextLine();
        System.out.println("Titulo do livro: ");
        String titulo = scan.nextLine();
        System.out.println("Autor: ");
        String autor = scan.nextLine();
        System.out.println("Data de entrega: ");
        String dataEntrega = scan.nextLine();

        try{
            service.fazerEmprestimo(nome, titulo, autor, dataEntrega);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void devolverLivro(){
        System.out.println("Nome do aluno: ");
        String nome = scan.nextLine();
        System.out.println("Titulo do livro: ");
        String titulo = scan.nextLine();
        System.out.println("Autor: ");
        String autor = scan.nextLine();

        try{
            service.devolverLivro(nome, titulo, autor);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void listarEmprestimosEmAberto(){
        try{
            service.listarEmprestimosEmAberto().forEach(System.out::println);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void listarEmprestimoPorAluno(){
        System.out.println("Digite o nome do aluno: ");
        String nome = scan.nextLine();

        try{
            service.listarEmprestimosPorAluno(nome).forEach(System.out::println);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
