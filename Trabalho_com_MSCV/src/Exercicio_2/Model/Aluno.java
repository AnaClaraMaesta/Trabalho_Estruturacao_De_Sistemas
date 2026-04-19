package Exercicio_2.Model;

public class Aluno {
    private String nome;
    private boolean podeEmprestar;

    public Aluno(String nome){
        this.nome = nome;
        this.podeEmprestar = true;
    }

    public String getNome() {
        return nome;
    }

    public void setPodeEmprestar(boolean podeEmprestar) {
        this.podeEmprestar = podeEmprestar;
    }

    public boolean getPodeEmprestar() {
        return podeEmprestar;
    }

    @Override
    public String toString() {
        return "Estudante -> Nome: "+nome+" Pode pegar emprestado: "+podeEmprestar;
    }
}
