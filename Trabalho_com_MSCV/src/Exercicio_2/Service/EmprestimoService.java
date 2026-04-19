package Exercicio_2.Service;

import Exercicio_2.Model.Aluno;
import Exercicio_2.Model.Emprestimo;
import Exercicio_2.Model.Livro;
import Exercicio_2.Model.Multa;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmprestimoService {
    private List<Emprestimo> emprestimos = new ArrayList<>();
    private AlunoService alunoService;
    private LivroService livroService;
    private MultaService multaService;

    public EmprestimoService(AlunoService alunoService, LivroService livroService, MultaService multaService) {
        this.alunoService = alunoService;
        this.livroService = livroService;
        this.multaService = multaService;
    }

    public AlunoService getAlunoService() {
        return alunoService;
    }

    public LivroService getLivroService() {
        return livroService;
    }

    public MultaService getMultaService() {
        return multaService;
    }

    public void fazerEmprestimo(String nome, String titulo, String autor, String dataEntregaPrevista){
        Aluno aluno = alunoService.buscarAluno(nome);

        if(aluno == null){
            throw new IllegalArgumentException("Aluno não encontrado");
        }

        if(!aluno.getPodeEmprestar()){
            throw new IllegalStateException("Aluno já possui um livro emprestado");
        }

        Livro livro = livroService.buscarLivro(titulo, autor);

        if(livro == null){
            throw new IllegalArgumentException("Livro não registrado");
        }
        if(livro.getQttdDisponivel() == 0){
            throw new IllegalStateException("Nenhum exemplar disponível");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataPrevista;

        try{
            dataPrevista = LocalDate.parse(dataEntregaPrevista, formatter);
        }catch (Exception e){
            throw new IllegalArgumentException("Data inválida, use: dd/MM/yyyy");
        }

        if(dataPrevista.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("A data deve ser futura");
        }

        livro.setQuantidadeDisponivel(livro.getQttdDisponivel()-1);
        alunoService.tirarPermissao(nome);
        emprestimos.add(new Emprestimo(aluno, livro, dataPrevista));

    }

    public void devolverLivro(String nome, String titulo, String autor){
        Emprestimo emprestimo = emprestimos.stream().filter(e -> e.getAluno().getNome().equalsIgnoreCase(nome)
                && e.getLivro().getTitulo().equalsIgnoreCase(titulo)
                && e.getLivro().getAutor().equalsIgnoreCase(autor) && !e.getDevolvido()).findFirst().
                orElseThrow(() -> new IllegalArgumentException("Empréstimo não encontrado"));

        if(emprestimo.diasDeDiferenca() > 0){
            Multa multa = new Multa(emprestimo);
            emprestimo.setMulta(multa);
            multaService.gerarMulta(emprestimo);
            System.out.println("Atraso de "+ emprestimo.diasDeDiferenca()+" dias. Multa aplicada de R$ "+multa.calcularValor());
        }

        emprestimo.setDevolvido(true);
        emprestimo.getLivro().setQuantidadeDisponivel(emprestimo.getLivro().getQttdDisponivel()+ 1);
        alunoService.colocarPermissao(nome);
    }

    public List<Emprestimo> listarEmprestimosEmAberto() {
        List<Emprestimo> emAberto = emprestimos.stream()
                .filter(e -> !e.getDevolvido())
                .collect(Collectors.toList());
        if (emAberto.isEmpty()) {
            throw new IllegalStateException("Nenhum empréstimo em aberto");
        }
        return emAberto;
    }

    public List<Emprestimo> listarEmprestimosPorAluno(String nomeAluno) {
        Aluno aluno = alunoService.buscarAluno(nomeAluno);
        if (aluno == null) {
            throw new IllegalArgumentException("Aluno não encontrado");
        }
        return emprestimos.stream()
                .filter(e -> e.getAluno().getNome().equalsIgnoreCase(nomeAluno) && !e.getDevolvido())
                .collect(Collectors.toList());
    }
}
