package Exercicio_1.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Aluguel {
    private Cliente cliente;
    private HorarioQuadra horario;
    private Double valor;

    public Aluguel(Cliente cliente, Double valor, HorarioQuadra horario) {
        if(valor == null || valor < 0){
            throw new IllegalArgumentException("O valor näo pode ser negativo nem nulo");
        }
        this.horario = horario;
        this.cliente = cliente;
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public HorarioQuadra getHorario() {
        return horario;
    }

    public Double getValor() {
        return valor;
    }

    @Override
    public String toString(){
        return "Cliente: "+cliente.getNome()+" Horario: "+horario.getHorario()+" Valor: "+getValor();
    }

}
