package Exercicio_2.Service;

import Exercicio_2.Model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoService {
    private List<Aluno> alunos = new ArrayList<>();

    public void registrarAluno(String nome){
        if(nome==null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("O nome não pode estar em branco");
        }

        if(buscarAluno(nome)!=null){
            throw new IllegalArgumentException("Aluno já cadastrado");
        }

        alunos.add(new Aluno(nome));
    }

    public List<Aluno> listarAlunos(){
        if(alunos.isEmpty()){
            throw new IllegalArgumentException("Nenhum aluno encontrado");
        }
        return new ArrayList<>(alunos);
    }

    public Aluno buscarAluno(String nome){
        return alunos.stream().filter(aluno -> aluno.getNome().equals(nome)).findFirst().orElse(null);
    }

    public void tirarPermissao(String nome){
        Aluno aluno = buscarAluno(nome);

        if(aluno == null){
            throw new IllegalArgumentException("Aluno nao encontrado");
        }

        if(!aluno.getPodeEmprestar()){
            throw new IllegalArgumentException("O aluno já não tem permissão");
        }

        System.out.println("Tirando permissão desse aluno de pegar livros emprestados....");
        aluno.setPodeEmprestar(false);
    }

    public void colocarPermissao(String nome){
        Aluno aluno = buscarAluno(nome);
        if(aluno == null){
            throw new IllegalArgumentException("Aluno nao encontrado");
        }
        if(aluno.getPodeEmprestar()){
           throw new IllegalArgumentException("O aluno já tem permissão");
        }

        System.out.println("Colocando permissao para esse aluno...");
        aluno.setPodeEmprestar(true);
    }

    public void removerAluno(String nome){
        Aluno aluno = buscarAluno(nome);

        if(aluno == null){
            throw new IllegalArgumentException("Aluno nao encontrado");
        }
        alunos.remove(aluno);
    }
}
