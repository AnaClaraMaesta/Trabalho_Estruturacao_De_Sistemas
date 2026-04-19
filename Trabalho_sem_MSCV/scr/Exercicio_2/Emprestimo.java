package Exercicio_2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo implements Interface{
    private Aluno aluno;
    private Livro livro;
    private LocalDate dataEntregaPrevista;
    private boolean devolvido = false;
    private Multa multa;

    public Emprestimo(Aluno aluno, Livro livro, LocalDate dataEntregaPrevista){
        this.aluno = aluno;
        this.livro = livro;
        this.dataEntregaPrevista = dataEntregaPrevista;
        this.devolvido = false;
        this.multa = null;
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

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }

    public boolean getDevolvido(){
        return devolvido;
    }

    public Multa getMulta() {
        return multa;
    }

    public void setMulta(Multa multa) {
        this.multa = multa;
    }

    public boolean temMulta(){
        return multa != null;
    }

    @Override
    public long diasDiferenca() {
        return ChronoUnit.DAYS.between(dataEntregaPrevista, LocalDate.now());
    }

    @Override
    public String toString() {
        String status = devolvido ? "Devolvido" : "Emprestado";
        String multaInfo = temMulta() ? "| Multa R$ " + multa.calcularValor() : "| Sem multa";

        return "Emprestimo ->" +
                "| Estudante: " + aluno.getNome() +
                "| Livro: " + livro.getTitulo() +" "+ livro.getAutor() +
                "| Data de entrega prevista: " + dataEntregaPrevista +
                "| Dias até entrega: " + diasDiferenca() +
                "| Status: "+status+
                multaInfo;
    }
}
