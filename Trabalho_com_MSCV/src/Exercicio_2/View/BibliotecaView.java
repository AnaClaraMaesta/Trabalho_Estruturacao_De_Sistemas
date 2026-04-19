package Exercicio_2.View;

import Exercicio_2.Controller.AlunoController;
import Exercicio_2.Controller.EmprestimoController;
import Exercicio_2.Controller.LivroController;
import Exercicio_2.Controller.MultaController;
import Exercicio_2.Service.AlunoService;
import Exercicio_2.Service.EmprestimoService;
import Exercicio_2.Service.LivroService;
import Exercicio_2.Service.MultaService;

import java.util.Scanner;

public class BibliotecaView {
    //service
    private Scanner scan = new Scanner(System.in);
    private AlunoService alunoService = new AlunoService();
    private LivroService livroService = new LivroService();
    private MultaService multaService = new MultaService();
    private EmprestimoService emprestimoService = new EmprestimoService(alunoService, livroService, multaService);

    //controller
    private AlunoController alunoController = new AlunoController(alunoService);
    private LivroController livroController = new LivroController(livroService);
    private EmprestimoController emprestimoController = new EmprestimoController(emprestimoService);
    private MultaController multaController = new MultaController(multaService);

    public void bibliotecaMenu() {
        int opcao = -1;

        do {
            System.out.println("==========SISTEMA BIBLIOTECA==========");
            System.out.println("1 - Gerenciamento Aluno");
            System.out.println("2 - Gerenciamento Livro");
            System.out.println("3 - Gerenciamento Emprestimo");
            System.out.println("4 - Gerenciamento Multa");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            try {
                opcao = Integer.parseInt(scan.nextLine());
            } catch (Exception e) {
                System.out.println("Opção inválida");
                continue;
            }

            switch (opcao) {
                case 1 -> menuAluno();
                case 2 -> menuLivro();
                case 3 -> menuEmprestimo();
                case 4 -> menuMulta();
                case 0 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida");
            }

        } while (opcao != 0);
    }

    private void menuAluno() {
        System.out.println("==========MENU ALUNO==========");
        System.out.println("1 - Cadastrar Aluno");
        System.out.println("2 - Remover Aluno");
        System.out.println("3 - Buscar Aluno");
        System.out.println("4 - Listar Alunos");
        System.out.println("5 - Gerenciar Permissões");
        System.out.print("Opção: ");

        try {
            int opcao = Integer.parseInt(scan.nextLine());
            switch (opcao) {
                case 1 -> alunoController.cadastrarAluno();
                case 2 -> alunoController.removerAluno();
                case 3 -> alunoController.buscarAluno();
                case 4 -> alunoController.listarAlunos();
                case 5 -> menuPermissoes();
                default -> System.out.println("Opção inválida");
            }
        } catch (Exception e) {
            System.out.println("Opção inválida");
        }
    }

    private void menuPermissoes() {
        System.out.println("==========MENU PERMISSÕES==========");
        System.out.println("1 - Bloquear empréstimo");
        System.out.println("2 - Liberar empréstimo");
        System.out.print("Opção: ");

        try {
            int opcao = Integer.parseInt(scan.nextLine());
            switch (opcao) {
                case 1 -> alunoController.tirarPermissao();
                case 2 -> alunoController.permitir();
                default -> System.out.println("Opção inválida");
            }
        } catch (Exception e) {
            System.out.println("Opção inválida");
        }
    }

    private void menuLivro() {
        System.out.println("==========MENU LIVRO==========");
        System.out.println("1 - Cadastrar Livro");
        System.out.println("2 - Remover Livro");
        System.out.println("3 - Buscar Livro");
        System.out.println("4 - Listar Livros");
        System.out.print("Opção: ");

        try {
            int opcao = Integer.parseInt(scan.nextLine());
            switch (opcao) {
                case 1 -> livroController.cadastrarLivro();
                case 2 -> livroController.removerLivro();
                case 3 -> livroController.buscarLivro();
                case 4 -> livroController.listarLivros();
                default -> System.out.println("Opção inválida");
            }
        } catch (Exception e) {
            System.out.println("Opção inválida");
        }
    }

    private void menuEmprestimo() {
        System.out.println("==========MENU EMPRÉSTIMO==========");
        System.out.println("1 - Fazer Empréstimo");
        System.out.println("2 - Devolver Livro");
        System.out.println("3 - Listar Empréstimos em aberto");
        System.out.println("4 - Listar Empréstimos por aluno");
        System.out.print("Opção: ");

        try {
            int opcao = Integer.parseInt(scan.nextLine());
            switch (opcao) {
                case 1 -> emprestimoController.fazerEmprestimo();
                case 2 -> emprestimoController.devolverLivro();
                case 3 -> emprestimoController.listarEmprestimosEmAberto();
                case 4 -> emprestimoController.listarEmprestimoPorAluno();
                default -> System.out.println("Opção inválida");
            }
        } catch (Exception e) {
            System.out.println("Opção inválida");
        }
    }

    private void menuMulta() {
        System.out.println("==========MENU MULTA==========");
        System.out.println("1 - Listar todas as multas");
        System.out.println("2 - Listar multas por aluno");
        System.out.println("3 - Calcular total de multas por aluno");
        System.out.print("Opção: ");

        try {
            int opcao = Integer.parseInt(scan.nextLine());
            switch (opcao) {
                case 1 -> multaController.listarTodasMultas();
                case 2 -> multaController.listarMultasPorAluno();
                case 3 -> multaController.calcularMultasPorAluno();
                default -> System.out.println("Opção inválida");
            }
        } catch (Exception e) {
            System.out.println("Opção inválida");
        }
    }
}