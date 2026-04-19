package Exercicio_1.Controller;

import Exercicio_1.Model.HorarioQuadra;
import Exercicio_1.Service.HorarioService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class HorarioController {
    private Scanner scan = new Scanner(System.in);
    private HorarioService service;

    public HorarioController(HorarioService service) {
        this.service = service;
    }

    public void registrarHorario() {
        System.out.println("Data desejada: ");
        String data = scan.nextLine();

        try{
            service.registrarHorario(data);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void buscarHorario(){
        System.out.println("Data desejada: ");
        String data = scan.nextLine();
        try{
            service.buscarHorario(data);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void horariosDisponiveis(){
        try{
            service.horariosDisponiveis().forEach(System.out::println);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
