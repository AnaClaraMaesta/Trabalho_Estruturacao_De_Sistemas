package Exercicio_1.Service;

import Exercicio_1.Model.Aluguel;
import Exercicio_1.Model.Cliente;
import Exercicio_1.Model.HorarioQuadra;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AluguelService {
    private List<Aluguel> alugueis = new ArrayList<>();
    private ClienteService clienteService;
    private HorarioService horarioService;

    public AluguelService(ClienteService clienteService, HorarioService horarioService) {
        this.clienteService = clienteService;
        this.horarioService = horarioService;
    }

    public void cadastrarAluguel(String nomeCliente, String data, Double valor){
        Cliente cliente = clienteService.buscarPorNome(nomeCliente);

        if(cliente == null){
            throw new IllegalArgumentException("Cliente nao encontrado");
        }

        HorarioQuadra horario = horarioService.buscarHorario(data);

        if(horario == null){
            throw new IllegalArgumentException("Horario nao encontrada");
        }

        if(!horario.getIsDisponivel()){
            throw new IllegalArgumentException("Horário não disponível");
        }

        horario.setDisponivel(false);
        alugueis.add(new Aluguel(cliente, valor, horario));
    }

    public Double calcularTotalAluguel(String nomeCliente, String data) {
        Cliente cliente = clienteService.buscarPorNome(nomeCliente);
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não encontrado");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        return alugueis.stream()
                .filter(a -> a.getCliente().equals(cliente))
                .filter(a -> a.getHorario().getHorario().format(formatter).equals(data))
                .mapToDouble(Aluguel::getValor)
                .sum();
    }

    public List<Aluguel> datasAlugadas(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        List<Aluguel> porDias = alugueis.stream()
                .filter(a -> a.getHorario().getHorario().format(formatter).equals(data))
                .collect(Collectors.toList());

        if (porDias.isEmpty()) {
            throw new IllegalArgumentException("Nenhum aluguel encontrado nessa data");
        }

        return porDias;
    }

}
