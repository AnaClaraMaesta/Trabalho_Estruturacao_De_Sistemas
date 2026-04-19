package Exercicio_2;

class Livro {
    private String titulo;
    private String autor;
    private int quantidadeDisponivel;

    public Livro(String titulo, String autor, int quantidadeDisponivel) {
        if (titulo == null || titulo.trim().isEmpty())
        {
            throw new IllegalArgumentException("Título inválido");
        }

        if (quantidadeDisponivel < 0)
        {
            throw new IllegalArgumentException("Quantidade não pode ser negativa");
        }

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

    public int getQuantidade() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    @Override
    public String toString() { return "Livro: " + titulo + " | Autor: " + autor + " | Disponiveis: " + quantidadeDisponivel; }
}