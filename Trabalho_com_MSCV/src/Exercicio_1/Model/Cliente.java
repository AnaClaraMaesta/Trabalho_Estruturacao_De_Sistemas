package Exercicio_1.Model;

public class Cliente {
    private String nome;
    private String telefone;

    public Cliente(String nome, String telefone){

        if(nome == null || nome.trim().isBlank()){
            throw new IllegalArgumentException("Informe um nome válido");
        }

        this.nome = nome;

        if(telefone == null || telefone.trim().isBlank()){
            throw new IllegalArgumentException("Informe um telefone válido");
        }

        this.telefone = telefone;

    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    //N é obrigatório, mas informa pro IDEA entender que eu quero os valores do objeto e nao a posicao deles na memoria

    @Override
    public String toString(){
        return "Cliente: nome: "+ getNome() + " | Telefone: "+ getTelefone();
    }
}
