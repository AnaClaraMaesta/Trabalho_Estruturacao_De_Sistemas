package Exercicio_2.Service;

import Exercicio_2.Model.Livro;
import java.util.ArrayList;
import java.util.List;

public class LivroService {
    private List<Livro> livros = new ArrayList<>();

    public void cadastrarLivro(String titulo, String autor, int disponiveis) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Informe o título do livro");
        }
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("Informe o nome do autor");
        }
        if (disponiveis < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa");
        }
        livros.add(new Livro(titulo, autor, disponiveis));
    }

    public Livro buscarLivro(String titulo, String autor) {
        return livros.stream()
                .filter(l -> l.getTitulo().equalsIgnoreCase(titulo)
                        && l.getAutor().equalsIgnoreCase(autor))
                .findFirst()
                .orElse(null);
    }

    public void removerLivro(String titulo, String autor) {
        Livro livro = buscarLivro(titulo, autor);
        if (livro == null) {
            throw new IllegalArgumentException("Livro não encontrado");
        }
        livros.remove(livro);
    }

    public List<Livro> listarLivros() {
        if (livros.isEmpty()) {
            throw new IllegalArgumentException("Nenhum livro encontrado");
        }
        return new ArrayList<>(livros);
    }
}