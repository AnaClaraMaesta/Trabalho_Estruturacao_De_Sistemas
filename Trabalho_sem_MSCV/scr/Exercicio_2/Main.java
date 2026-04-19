package Exercicio_2;

import Exercicio_1.Cliente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;

public class Main {
    private List<Aluno> alunos = new ArrayList<>();
    private List<Livro> livros = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();
    private List<Multa> multas = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    static void main(String[] args) {
        new Main().menuInicial();
    }

    public void menuInicial() {
        int opcao = -1;
        do {
            System.out.println("========= BIBLIOTECA =========");
            System.out.println("1 - Gerenciar Alunos");
            System.out.println("2 - Gerenciar Livros");
            System.out.println("3 - Gerenciar Emprestimos");
            System.out.println("4 - Gerenciar Multas");
            System.out.println("0 - Sair");
            try {
                opcao = Integer.parseInt(scan.nextLine());
                switch (opcao) {
                    case 1 -> menuAluno();
                    case 2 -> menuLivro();
                    case 3 -> menuEmprestimo();
                    case 4 -> menuMultas();
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (opcao != 0);
    }

    private void menuAluno() {
        System.out.println("========= MENU ALUNO =========");
        System.out.println("1 - Cadastrar Aluno");
        System.out.println("2 - Remover Aluno");
        System.out.println("3 - Buscar Aluno");
        System.out.println("4 - Listar Alunos");
        System.out.println("5 - Gerenciar Permissoes");
        int opcao = Integer.parseInt(scan.nextLine());

        switch (opcao) {
            case 1 -> registrarAluno();
            case 2 -> removerAluno();
            case 3 -> {
                Aluno aluno = buscarAluno();
                System.out.println(aluno != null ? aluno : "Aluno não cadastrado.");
            }
            case 4 -> alunos.forEach(System.out::println);
            case 5 -> gerenciarPermissoes();
            default -> System.out.println("Opcao invalida");
        }
    }

    private void menuLivro() {
        System.out.println("========= MENU LIVRO =========");
        System.out.println("1 - Cadastrar Livro");
        System.out.println("2 - Remover Livro");
        System.out.println("3 - Buscar Livro");
        System.out.println("4 - Listar Livros");
        System.out.print("Opção: ");

        try{
            int opcao = Integer.parseInt(scan.nextLine());

            switch (opcao) {
                case 1 -> cadastrarLivro();
                case 2 -> removerLivro();
                case 3 -> {
                    Livro livro = buscarLivro();
                    System.out.println(livro != null ? livro : "Livro não cadastrado");
                }
                case 4 -> livros.forEach(System.out::println);
                default -> System.out.println("Opcao invalida");
            }
        }catch (Exception e){
            System.out.println("Opcao invalida");
        }

    }

    private void menuEmprestimo(){
        System.out.println("========= MENU EMPRESTIMO =========");
        System.out.println("1 - Fazer Emprestimo");
        System.out.println("2 - Devolver Livro");
        System.out.println("3 - Listar Empréstimos em aberto");
        System.out.println("4 - Listar Empréstimos por aluno");
        System.out.print("Opção: ");

        try{
            int opcao = Integer.parseInt(scan.nextLine());

            switch (opcao) {
                case 1 -> fazerEmprestimo();
                case 2 -> devolverLivro();
                case 3 -> emprestimos.stream().filter(e -> !e.getDevolvido()).forEach(System.out::println);
                case 4 -> porAluno();

            }
        }catch (Exception e){
            System.out.println("Opcao invalida");
        }
    }

    private void menuMultas(){
        System.out.println("========= MENU MULTAS =========");
        System.out.println("1 - Listar todas as multas");
        System.out.println("2 - Listar multas por aluno");
        System.out.println("3 - Calcular total de multas por aluno");
        System.out.print("Opção: ");

        try{
            int opcao = Integer.parseInt(scan.nextLine());

            switch (opcao) {
                case 1 -> multas.forEach(System.out::println);
                case 2 -> multasPorAluno();
                case 3 -> calcularMultasAluno();
            }
        }catch (Exception e){
            System.out.println("Opcao invalida");
        }
    }

    private void registrarAluno() {
        System.out.println("Digite o nome do aluno: ");
        String nome = scan.nextLine();

        try{
            alunos.add(new Aluno(nome));
            System.out.println("Aluno registrado com sucesso!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void removerAluno() {
        System.out.println("Digite o nome do aluno: ");
        String nome = scan.nextLine();
        try{
            alunos.remove(new Aluno(nome));
            System.out.println("Aluno removido com sucesso!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private Aluno buscarAluno() {
        System.out.println("Digite o nome do aluno: ");
        String nome = scan.nextLine();
        return alunos.stream().filter(aluno -> aluno.getNome().equals(nome)).findFirst().orElse(null);
    }

    private void gerenciarPermissoes() {
        System.out.println("==========MENU PERMISSÕES==========");
        System.out.println("1 - Bloquear empréstimo");
        System.out.println("2 - Liberar empréstimo");
        System.out.print("Opção: ");

        try {
            int opcao = Integer.parseInt(scan.nextLine());
            Aluno aluno;

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do aluno para bloquear: ");
                    aluno = buscarAluno();
                    if (aluno != null) {
                        aluno.setPodeEmprestar(false);
                        System.out.println("Permissão mudada para FALSE (Bloqueado)");
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;

                case 2:
                    System.out.println("Digite o nome do aluno para liberar: ");
                    aluno = buscarAluno();
                    if (aluno != null) {
                        aluno.setPodeEmprestar(true);
                        System.out.println("Permissão mudada para TRUE (Liberado)");
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;

                default:
                    System.out.println("Opção inválida");
            }
        } catch (Exception e) {
            System.out.println("Erro ao processar opção.");
        }
    }

    private void cadastrarLivro() {
        System.out.println("Digite o titulo do livro: ");
        String titulo = scan.nextLine();
        System.out.println("Digite o auttor do livro: ");
        String autor = scan.nextLine();
        System.out.println("Quantos exemplares tem disponiveis: ");
        int disponiveis = scan.nextInt();

        try{
            livros.add(new Livro(titulo, autor, disponiveis));
            System.out.println("Livro cadastrado com sucesso!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void removerLivro() {
        System.out.println("Digite o titulo do livro: ");
        String titulo = scan.nextLine();
        System.out.println("Digite o auttor do livro: ");
        String autor = scan.nextLine();

        try{
            livros.removeIf(l -> l.getTitulo().equals(titulo) && l.getAutor().equals(autor));
            System.out.println("Livro removido com sucesso!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private Livro buscarLivro() {
        System.out.println("Digite o titulo do livro: ");
        String titulo = scan.nextLine();
        System.out.println("Digite o auttor do livro: ");
        String autor = scan.nextLine();

        return livros.stream().filter(livro -> livro.getTitulo().equalsIgnoreCase(titulo) && livro.getAutor().equals(autor)).findFirst().orElse(null);

    }

    private void gerarMulta(Emprestimo emprestimo){
        if(emprestimo.diasDiferenca() <=0){
            throw new IllegalArgumentException("O livro não está atrasado");
        }

        if(emprestimo.temMulta()){
            throw new IllegalArgumentException("Multa já aplicada");
        }

        Multa multa = new Multa(emprestimo);
        emprestimo.setMulta(multa);
        multas.add(multa);
    }

    private void fazerEmprestimo() {
        Aluno aluno = buscarAluno();

        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }
        if (!aluno.getPodeEmprestar()) {
            System.out.println("Aluno nao tem permissao");
            return;
        }

        Livro livro = buscarLivro();

        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }
        if (livro.getQuantidade() <= 0) {
            System.out.println("Não há exemplares disponíveis deste livro.");
            return;
        }

        System.out.print("Data prevista para entrega (dd/MM/yyyy): ");
        String dataInput = scan.nextLine();

        try {
            LocalDate dataDevolucao = LocalDate.parse(dataInput, formatter);

            if (dataDevolucao.isBefore(LocalDate.now())) {
                System.out.println("A data de devolução não pode ser no passado.");
                return;
            }

            emprestimos.add(new Emprestimo(aluno, livro, dataDevolucao));

            livro.setQuantidadeDisponivel(livro.getQuantidade() - 1);
            aluno.setPodeEmprestar(false);

            System.out.println("Empréstimo realizado com sucesso!");

        } catch (Exception e) {
            System.out.println("Formato de data inválido. Use dd/MM/yyyy.");
        }
    }

    private void devolverLivro() {
        System.out.println("Digite o nome do aluno: ");
        String nome = scan.nextLine();
        System.out.println("Digite o titulo do livro: ");
        String titulo = scan.nextLine();
        System.out.println("Digite o autor do livro: ");
        String autor = scan.nextLine();

        Emprestimo emprestimo = emprestimos.stream().filter(e -> e.getAluno().getNome().equalsIgnoreCase(nome)
                && e.getLivro().getTitulo().equalsIgnoreCase(titulo)
                && e.getLivro().getAutor().equalsIgnoreCase(autor) && !e.getDevolvido()).findFirst().
                orElseThrow(() -> new IllegalArgumentException("Empréstimo não encontrado"));


        if(emprestimo.diasDiferenca() > 0){
            Multa multa = new Multa(emprestimo);
            emprestimo.setMulta(multa);
            gerarMulta(emprestimo);
            System.out.println("Atraso de "+ emprestimo.diasDiferenca()+" dias. Multa aplicada de R$ "+multa.calcularValor());
        }

    }

    private List<Emprestimo> porAluno() {
        System.out.println("Digite o nome do aluno: ");
        String nome = scan.nextLine();

        return emprestimos.stream()
                .filter(e -> e.getAluno().getNome().equalsIgnoreCase(nome))
                .collect(Collectors.toList());
    }

    private List<Multa> multasPorAluno() {
        System.out.println("Digite o nome do aluno: ");
        String nome = scan.nextLine();

        return multas.stream().filter(m -> m.getAluno().getNome().equalsIgnoreCase(nome)).collect(Collectors.toList());
    }

    private double calcularMultasAluno() {
        System.out.println("Digite o nome do aluno: ");
        String nome = scan.nextLine();

        return multas.stream().filter(m -> m.getAluno().getNome().equalsIgnoreCase(nome))
                .mapToDouble(Multa::calcularValor).sum();
    }

}