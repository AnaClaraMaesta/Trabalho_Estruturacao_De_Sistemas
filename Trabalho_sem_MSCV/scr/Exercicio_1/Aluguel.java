package Exercicio_1;

public class Aluguel {
    private Cliente cliente;
    private HorarioQuadra horario;
    private Double valor;

    public Aluguel(Cliente cliente, HorarioQuadra horario, Double valor) {
        if (valor == null || valor < 0) {
            throw new IllegalArgumentException("O valor não pode ser negativo nem nulo");
        }
        this.cliente = cliente;
        this.horario = horario;
        this.valor = valor;
        this.horario.setDisponivel(false);
    }

    public Cliente getCliente() { return cliente; }
    public HorarioQuadra getHorario() { return horario; }
    public Double getValor() { return valor; }

    @Override
    public String toString() {
        return "ALUGUEL -> Cliente: " + cliente.getNome() + " | " + horario.getHorario() + " | Valor: R$ " + valor;
    }
}