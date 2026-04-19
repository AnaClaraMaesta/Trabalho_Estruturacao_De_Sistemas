package Exercicio_2.Controller;

import Exercicio_2.Model.Livro;
import Exercicio_2.Service.LivroService;

import java.util.Scanner;

public class LivroController {
    private Scanner scan = new Scanner(System.in);
    private LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    public void cadastrarLivro() {
        System.out.print("Titulo: ");
        String titulo = scan.nextLine();
        System.out.print("Autor: ");
        String autor = scan.nextLine();
        System.out.print("Quantidade em estoque: ");
        try {
            int quantidade = Integer.parseInt(scan.nextLine());
            service.cadastrarLivro(titulo, autor, quantidade);
            System.out.println("Livro cadastrado com sucesso!");
        } catch (NumberFormatException e) {
            System.out.println("Quantidade inválida");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void removerLivro() {
        System.out.print("Titulo: ");
        String titulo = scan.nextLine();
        System.out.print("Autor: ");
        String autor = scan.nextLine();
        try {
            service.removerLivro(titulo, autor);
            System.out.println("Livro removido com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void buscarLivro() {
        System.out.print("Titulo: ");
        String titulo = scan.nextLine();
        System.out.print("Autor: ");
        String autor = scan.nextLine();
        try {
            Livro livro = service.buscarLivro(titulo, autor);
            if (livro == null) {
                System.out.println("Livro não encontrado");
            } else {
                System.out.println(livro);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void listarLivros() {
        try {
            service.listarLivros().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
