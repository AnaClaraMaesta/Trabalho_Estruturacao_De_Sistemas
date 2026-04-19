package Exercicio_1.Controller;

import Exercicio_1.Service.AluguelService;

import java.util.Scanner;

public class AluguelController {
    private Scanner scan = new Scanner(System.in);
    private AluguelService service;

    public AluguelController(AluguelService service) {
        this.service = service;
    }

    public void cadastrarAluguel() {

        System.out.print("Nome do cliente: ");
        String nome = scan.nextLine();

        System.out.print("Horario alugado: ");
        String data = scan.nextLine();

        System.out.print("Valor do aluguel: ");
        try {
            double valorAluguel = Double.parseDouble(scan.nextLine());
            service.cadastrarAluguel(nome, data, valorAluguel);
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void calcularValorAluguel() {
        System.out.print("Nome do cliente: ");
        String nome = scan.nextLine();
        System.out.print("Horario alugado: ");
        String data = scan.nextLine();

        System.out.println("Valor do aluguel: ");
        try {
            double total = service.calcularTotalAluguel(nome, data);
            System.out.println("Total: R$ " + String.format("%.2f", total));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void datasAlugadas() {
        System.out.print("Filtre pela data desejada: ");
        String data = scan.nextLine();

        try {
            service.datasAlugadas(data).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
