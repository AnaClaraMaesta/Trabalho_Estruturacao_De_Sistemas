package Exercicio_2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Multa implements Interface{

    private double valorPorDia = 0.50;
    private LocalDate dataEntregaPrevista;
    private Aluno aluno;
    private Livro livro;
    private Emprestimo emprestimo;

    public Multa(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
        this.aluno = emprestimo.getAluno();
        this.livro = emprestimo.getLivro();
        this.dataEntregaPrevista = emprestimo.getDataEntregaPrevista();
    }

    public double getValorPorDia() {
        return valorPorDia;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Livro getLivro() {
        return livro;
    }

    public LocalDate getDataEntregaPrevista() {
        return dataEntregaPrevista;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    @Override
    public long diasDiferenca(){
        return ChronoUnit.DAYS.between(dataEntregaPrevista, LocalDate.now());
    }

    public Double calcularValor(){
        return diasDiferenca()*valorPorDia;
    }


    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return  "Multa -> " +
                "| Estudante: " + aluno.getNome() +
                "| Livro: " + livro.getTitulo() +" " +livro.getAutor() +
                "| Data de entrega prevista: " + dataEntregaPrevista.format(formatter)+
                "| Dias de atraso: "+diasDiferenca()+
                "| Valor R$ "+calcularValor();
    }
}
