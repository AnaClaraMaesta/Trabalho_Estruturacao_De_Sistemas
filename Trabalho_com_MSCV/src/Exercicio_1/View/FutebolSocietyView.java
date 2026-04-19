package Exercicio_1.View;

import Exercicio_1.Controller.AluguelController;
import Exercicio_1.Controller.ClienteController;
import Exercicio_1.Controller.HorarioController;
import Exercicio_1.Service.AluguelService;
import Exercicio_1.Service.ClienteService;
import Exercicio_1.Service.HorarioService;

import java.util.Scanner;

public class FutebolSocietyView {
    private Scanner scan = new Scanner(System.in);
    private ClienteService clienteService = new ClienteService();
    private HorarioService horarioService = new HorarioService();
    private AluguelService aluguelService = new AluguelService(clienteService, horarioService);

    private ClienteController clienteController = new ClienteController(clienteService);
    private HorarioController horarioController = new HorarioController(horarioService);
    private AluguelController aluguelController = new AluguelController(aluguelService);


    public void menuInicial(){
        int opcao = -1;

        do{
            System.out.println("==================== FUTEBOL SOCIETY ====================");
            System.out.println("1 - GERENCIAR CLIENTE");
            System.out.println("2 - GERENCIAR ALUGUEL");
            System.out.println("3 - GERENCIAR HORARIO");
            System.out.println("0 - EXIT");

            try {
                opcao = Integer.parseInt(scan.nextLine());
            } catch (Exception e) {
                System.out.println("Opção inválida");
                continue;
            }

            switch (opcao){
                case 1 -> menuCliente();
                case 2 -> menuAluguel();
                case 3 -> menuHorario();
                case 0 -> System.out.println("Saindo do sistema");
                default -> System.out.println("Opcao invalida");
            }

        }while(opcao!=0);

    }

    public void menuCliente(){

        System.out.println("==================== MENU CLIENTE ====================");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Remover Cliente");
        System.out.println("3 - Listar Clientes");
        System.out.print("opcao: ");

        try {

            int opcao = Integer.parseInt(scan.nextLine());

             switch(opcao){
                 case 1 -> clienteController.cadastrarCliente();
                 case 2 -> clienteController.excluirCliente();
                 case 3 -> clienteController.listarClientes();
                 default -> System.out.println("Opcao invalida");
            }
        } catch (Exception e) {
                System.out.println("Opcao invalida");
        }
    }

    public void menuAluguel(){
        System.out.println("===================== MENU ALUGUEL ====================");
        System.out.println("1 - Cadastrar Aluguel");
        System.out.println("2 - Calcular Valor Aluguel");
        System.out.println("3 - Listar datas alugadas");
        System.out.print("opcao: ");

        try {
            int opcao = Integer.parseInt(scan.nextLine());

            switch(opcao){
                case 1 -> aluguelController.cadastrarAluguel();
                case 2 -> aluguelController.calcularValorAluguel();
                case 3 -> aluguelController.datasAlugadas();
                default -> System.out.println("Opcao invalida");
            }
        }catch (Exception e){
            System.out.println("Opcao invalida");
        }
    }

    public void menuHorario(){
        System.out.println("===================== MENU HORARIO ===================");
        System.out.println("1 - Cadastrar Horario");
        System.out.println("2 - Buscar Horario desejado");
        System.out.println("3 - Listar horarios disponíveis");
        System.out.print("opcao: ");

        try {
            int opcao = Integer.parseInt(scan.nextLine());

            switch(opcao){
                case 1 -> horarioController.registrarHorario();
                case 2 -> horarioController.buscarHorario();
                case 3 -> horarioController.horariosDisponiveis();
                default -> System.out.println("Opcao invalida");
            }
        }catch (Exception e){
            System.out.println("Opcao invalida");
        }
    }
}
