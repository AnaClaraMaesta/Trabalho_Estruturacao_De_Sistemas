package Exercicio_1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private List<Cliente> listaClientes = new ArrayList<>();
    private List<Aluguel> listaAluguel = new ArrayList<>();
    private List<HorarioQuadra> listaHorarioQuadra = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    static void main(String[] args) {
        new Main().menuInicial();
    }

    public void menuInicial() {
        int opcao = -1;
        do {
            System.out.println("==================== FUTEBOL SOCIETY ====================");
            System.out.println("1 - GERENCIAR CLIENTE");
            System.out.println("2 - GERENCIAR HORÁRIOS");
            System.out.println("3 - GERENCIAR ALUGUEL");
            System.out.println("0 - SAIR");
            System.out.print("Opção: ");

            try {
                opcao = Integer.parseInt(scan.nextLine());
                switch (opcao) {
                    case 1 -> menuCliente();
                    case 2 -> menuHorario();
                    case 3 -> menuAluguel();
                    case 0 -> System.out.println("Encerrando sistema...");
                    default -> System.out.println("Opção inválida");
                }
            } catch (Exception e) {
                System.out.println("Erro: Opção inválida");
            }
        } while (opcao != 0);
    }

    private void menuCliente() {
        System.out.println("======== MENU CLIENT========");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Remover Cliente");
        System.out.println("3 - Buscar Clientes");
        System.out.println("4 - Listar clientes");

        int opcao = Integer.parseInt(scan.nextLine());

        switch (opcao) {
            case 1 -> registrarCliente();
            case 2 -> removerCliente();
            case 3 -> {
                Cliente cliente = buscarCliente();
                System.out.println(cliente != null ? cliente : "Cliente não encontrado.");
            }
            case 4 -> listarClientes();
        }
    }

    private void menuHorario() {
        System.out.println("======== MENU HORÁRIO ========");
        System.out.println("1 - Cadastrar Horario");
        System.out.println("2 - Listar Horarios");
        System.out.println("3 - Listar Disponíveis");
        System.out.println("4 - Checar ocupacao por data");

        int opcao = Integer.parseInt(scan.nextLine());
        switch (opcao) {
            case 1 -> registrarHorario();
            case 2 -> listarHorarios();
            case 3 -> listarHorariosDisponiveis();
            case 4 -> listarHorariosPorData();
        }
    }

    private void menuAluguel() {
        System.out.println("======== MENU ALUGUEL ========");
        System.out.println("1 - Registrar Aluguel");
        System.out.println("2 - Calcular Valor aluguel");
        System.out.println("3 - Listar Alugueis");
        int opcao = Integer.parseInt(scan.nextLine());

        switch (opcao) {
            case 1 -> cadastrarAluguel();
            case 2 -> calcularValorAluguel();
            case 3 -> listarAlugueis();
        }
    }

    private void registrarCliente() {
        System.out.print("Nome: "); String n = scan.nextLine();
        System.out.print("Telefone: "); String t = scan.nextLine();
        try {
            listaClientes.add(new Cliente(n, t));
            System.out.println("Cliente cadastrado!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void removerCliente() {
        System.out.print("Nome do cliente: ");
        String n = scan.nextLine();
        if (listaClientes.removeIf(c -> c.getNome().equalsIgnoreCase(n))) {
            System.out.println("Cliente removido com sucesso!");
        } else { System.out.println("Cliente não encontrado."); }
    }

    private Cliente buscarCliente() {
        System.out.print("Nome do cliente: ");
        String n = scan.nextLine();
        return listaClientes.stream().filter(c -> c.getNome().equalsIgnoreCase(n)).findFirst().orElse(null);
    }

    private void listarClientes() {

        if (listaClientes.isEmpty()) {
            System.out.println("Nenhum cliente.");
        }
        else {
            listaClientes.forEach(System.out::println);
        }
    }

    private void registrarHorario() {
        System.out.print("Data e Hora (dd/MM/yyyy HH:mm): ");

        try {
            LocalDateTime data = LocalDateTime.parse(scan.nextLine(), formatter);
            listaHorarioQuadra.add(new HorarioQuadra(data));
            System.out.println("Horário cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Formato inválido, tente novamente");
        }
    }

    private void listarHorarios() {
        if (listaHorarioQuadra.isEmpty()){
            System.out.println("Nenhum horário cadastrado.");
        }
        else {
            for (int i=0; i<listaHorarioQuadra.size(); i++)
                System.out.println(i+1 + " - " + listaHorarioQuadra.get(i));
        }
    }

    private void listarHorariosDisponiveis() {
        listaHorarioQuadra.stream().filter(HorarioQuadra::getIsDisponivel).forEach(System.out::println);
    }

    private void listarHorariosPorData() {
        System.out.print("Data (dd/MM/yyyy): ");
        String data = scan.nextLine();
        listaAluguel.stream()
                .filter(a -> a.getHorario().getHorario().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).equals(data))
                .forEach(a -> System.out.println("Hora: " + a.getHorario().getHorario().format(DateTimeFormatter.ofPattern("HH:mm")) + " | Cliente: " + a.getCliente().getNome()));
    }

    private void cadastrarAluguel() {
        Cliente cliente = buscarCliente();

        if (cliente == null) {
            return;
        }

        listarHorarios();

        System.out.print("Numero do horário: ");
        int numero = Integer.parseInt(scan.nextLine());
        System.out.print("Valor: ");
        double valor = Double.parseDouble(scan.nextLine());

        try {
            listaAluguel.add(new Aluguel(cliente, listaHorarioQuadra.get(numero), valor));
            System.out.println("Aluguel cadastrado com sucesso!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void listarAlugueis() {
        if (listaAluguel.isEmpty()) {
            System.out.println("Sem aluguéis.");
        }
        else {
            listaAluguel.forEach(System.out::println);
        }
    }

    private void calcularValorAluguel() {
        System.out.print("Data (dd/MM/yyyy): ");
        String data = scan.nextLine();

        double total = listaAluguel.stream()
                .filter(a -> a.getHorario().getHorario().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).equals(data))
                .mapToDouble(Aluguel::getValor).sum();

        System.out.println("Total do aluguel: R$ " + total);
    }
}