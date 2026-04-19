package Exercicio_2.Controller;

import Exercicio_2.Model.Aluno;
import Exercicio_2.Service.AlunoService;

import java.util.Scanner;

public class AlunoController {
    private Scanner scan = new Scanner(System.in);
    private AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    public void cadastrarAluno(){
        System.out.println("Digite o nome do aluno: ");
        String nome = scan.nextLine();

        try{
            service.registrarAluno(nome);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void removerAluno(){
        System.out.println("Digite o nome do aluno: ");
        String nome = scan.nextLine();

        try{
            service.removerAluno(nome);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void buscarAluno(){
        System.out.println("Digite o nome do aluno: ");
        String nome = scan.nextLine();

        try {
            Aluno aluno = service.buscarAluno(nome);
            if (aluno == null) {
                System.out.println("Aluno não encontrado");
            } else {
                System.out.println(aluno);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void tirarPermissao(){
        System.out.println("Digite o nome do aluno: ");
        String nome = scan.nextLine();

        try{
            service.tirarPermissao(nome);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void permitir(){
        System.out.println("Digite o nome do aluno: ");
        String nome = scan.nextLine();

        try{
            service.colocarPermissao(nome);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void listarAlunos(){
        try{
            service.listarAlunos().forEach(System.out::println);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
