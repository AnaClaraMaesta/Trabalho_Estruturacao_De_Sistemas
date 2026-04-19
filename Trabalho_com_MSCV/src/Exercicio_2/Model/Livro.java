package Exercicio_2.Model;

public class Livro {
    private String autor;
    private String titulo;
    private int quantidadeDisponivel;

    public Livro(String titulo,String autor, int quantidadeDisponivel){
        this.titulo = titulo;
        this.autor = autor;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;

    }

    public int getQttdDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    @Override
    public String toString() {
        return "Livro -> Titulo: "+titulo+" Autor: "+autor+" Quantidade disponível: " + quantidadeDisponivel;

    }
}
