package Exercicio_3.Service;

import Exercicio_3.Model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoService {
    List<Produto> produtos = new ArrayList<>();

    public void registrarProduto(String nome, String descricao, double preco)
    {
        if(nome==null||nome.trim().isEmpty()){
            throw new IllegalArgumentException("Informe o nome do produto");
        }

        if(descricao==null||descricao.trim().isEmpty()){
            throw new IllegalArgumentException("Informe uma descricao para o produto");
        }

        if(preco<0){
            throw new IllegalArgumentException("Informe um valor válido");
        }

        produtos.add(new Produto(nome,descricao,preco));
    }

    public void removerProduto(String nome)
    {
        if(nome==null||nome.trim().isEmpty()){
            throw new IllegalArgumentException("Informe o nome do produto");
        }

        produtos.removeIf(produto -> produto.getNome().equalsIgnoreCase(nome));
    }


    public List<Produto> listarProdutos()
    {
        if(produtos.isEmpty()){
            throw new IllegalArgumentException("Nenhum produto cadastrado");
        }

        return new ArrayList<>(produtos);
    }

    public Produto buscarProduto(String nome)
    {
        if(nome==null||nome.trim().isEmpty()){
            throw new IllegalArgumentException("Informe o nome do produto");
        }

        return produtos.stream().filter(produto -> produto.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
    }
}
