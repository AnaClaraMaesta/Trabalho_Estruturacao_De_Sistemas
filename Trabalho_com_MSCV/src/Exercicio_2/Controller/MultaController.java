package Exercicio_2.Controller;

import Exercicio_2.Model.Emprestimo;
import Exercicio_2.Service.MultaService;

import java.util.Scanner;

public class MultaController {
    private Scanner scan = new Scanner(System.in);
    private MultaService service;

    public MultaController(MultaService multaService) {
        this.service = multaService;
    }

    public void listarMultasPorAluno(){
        System.out.println("Digite o nome do aluno: ");
        String nome = scan.nextLine();

        try{
            service.listarMultasPorAluno(nome);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void listarTodasMultas(){
        try{
            service.listarTodasMultas();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void calcularMultasPorAluno(){
        System.out.println("Digite o nome do aluno: ");
        String nome = scan.nextLine();

        try{
            service.calcularValorPorAluno(nome);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
