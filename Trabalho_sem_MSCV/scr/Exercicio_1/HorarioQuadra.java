package Exercicio_1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HorarioQuadra {
    private LocalDateTime horario;
    private boolean isDisponivel;

    public HorarioQuadra(LocalDateTime horario) {
        if (horario == null){ throw new IllegalStateException("Horario não pode estar vazio");}
        this.horario = horario;
        this.isDisponivel = true;
    }

    public LocalDateTime getHorario() { return horario; }
    public boolean getIsDisponivel() { return isDisponivel; }
    public void setDisponivel(boolean disponivel) { isDisponivel = disponivel; }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "Horario: " + horario.format(formatter) + " | Disponível: " + (isDisponivel ? "SIM" : "NÃO");
    }
}