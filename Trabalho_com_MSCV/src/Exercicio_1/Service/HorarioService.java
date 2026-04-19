package Exercicio_1.Service;

import Exercicio_1.Model.HorarioQuadra;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HorarioService {
    private List<HorarioQuadra> horarios = new ArrayList<>();

    public void registrarHorario(String dataInformada){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime data;

        try{
            data = LocalDateTime.parse(dataInformada,formatter);
        }catch(Exception e){
            throw new IllegalArgumentException("Formato inválido. Use: dd/MM/yyyy HH:mm");
        }

        if(data.isBefore(LocalDateTime.now())){
            throw new IllegalStateException("Esta data já passou, informe uma data válida");
        }
        if(buscarHorario(dataInformada) != null){
            throw new IllegalArgumentException("Horário não disponível");
        }

        horarios.add(new HorarioQuadra(data));
    }

    public HorarioQuadra buscarHorario(String dataInformada){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime data;

        try{
            data = LocalDateTime.parse(dataInformada,formatter);
        }catch(Exception e){
            throw new IllegalArgumentException("Formato inválido. Use: dd/MM/yyyy HH:mm");
        }

        return horarios.stream()
                .filter(h -> h.getHorario().equals(data))
                .findFirst()
                .orElse(null);
    }

    public List<HorarioQuadra> horariosDisponiveis(){
        List<HorarioQuadra> disponiveis = horarios.stream().filter(HorarioQuadra::getIsDisponivel)
                .collect(Collectors.toList());

        if(disponiveis.isEmpty()){
            throw new IllegalStateException("Nenhum horario disponível");
        }

        return disponiveis;
    }
}
