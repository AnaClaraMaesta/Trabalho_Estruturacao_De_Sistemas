package Exercicio_2.Service;

import Exercicio_2.Model.Emprestimo;
import Exercicio_2.Model.Multa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MultaService {
    private List<Multa> multas = new ArrayList<>();

    public void gerarMulta(Emprestimo emprestimo){
        if(emprestimo.diasDeDiferenca() <=0){
            throw new IllegalArgumentException("O livro não está atrasado");
        }

        if(emprestimo.temMulta()){
            throw new IllegalArgumentException("Multa já aplicada");
        }

        Multa multa = new Multa(emprestimo);
        emprestimo.setMulta(multa);
        multas.add(multa);
    }

    public List<Multa> listarMultasPorAluno(String nome) {
        List<Multa> multasPorAluno = multas.stream().filter(m->m.getAluno().getNome().equalsIgnoreCase(nome)).collect(Collectors.toList());

        if(multasPorAluno.isEmpty()){
            throw new IllegalArgumentException("Nenhuma multa encontrada");
        }

        return multasPorAluno;
    }

    public double calcularValorPorAluno(String nome){
        return multas.stream().filter(m -> m.getAluno().getNome().equalsIgnoreCase(nome))
                .mapToDouble(Multa::calcularValor).sum();
    }

    public List<Multa> listarTodasMultas(){
        if(multas.isEmpty()){
            throw new IllegalArgumentException("Nenhuma multa encontrada");
        }

        return new ArrayList<>(multas);
    }
}
