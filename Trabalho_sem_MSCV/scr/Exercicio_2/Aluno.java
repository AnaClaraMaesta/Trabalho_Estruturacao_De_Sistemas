package Exercicio_2;

public class Aluno {

        private String nome;
        private boolean podeEmprestar;

    public Aluno(String nome) {
            this.nome = nome;
            this.podeEmprestar = true;
        }

    public String getNome() {
        return nome;
    }

    public boolean getPodeEmprestar() {
        return podeEmprestar;
    }


    public void setPodeEmprestar(boolean podeEmprestar) {
        this.podeEmprestar = podeEmprestar;
    }

    @Override
    public String toString() { return "Estudante: " + nome + " | Permissão: " + (podeEmprestar ? "sim" : "nao"); }
}


