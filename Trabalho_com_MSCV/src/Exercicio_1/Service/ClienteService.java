package Exercicio_1.Service;

import Exercicio_1.Model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    private List<Cliente> clientes = new ArrayList<>();

    public void cadastrarCliente(String nome, String telefone){

        if(nome == null || nome.trim().isBlank()){
            throw new IllegalArgumentException("Informe um nome válido");
        }

        if(telefone == null || telefone.trim().isBlank()){
            throw new IllegalArgumentException("Informe um telefone válido");
        }

        telefone = telefone.replaceAll("[^0-9]", "");
        char[] cont = telefone.toCharArray();

        if(cont.length < 7 || cont.length > 15){
            throw new IllegalArgumentException("Informe um telefone válido. O telefone precisa possuir todos os dígitos. " +
                    "Exemplo: (xx) x xxxx-xxxx");
        }

        clientes.add(new Cliente(nome, telefone));

    }

    public Cliente buscarPorNome(String nome){
        return clientes.stream().filter
                (cliente -> cliente.getNome().equalsIgnoreCase(nome))
                .findFirst().orElse(null);
    }

    public List<Cliente> listarClientes(){
        if(clientes.isEmpty()){
           throw new IllegalArgumentException("Nenhum cliente encontrado");
        }
        return new ArrayList<>(clientes);
    }

    public void removerCliente(String nome){
        Cliente cliente = buscarPorNome(nome);

        if(cliente == null){
            throw new IllegalArgumentException("Cliente nao encontrado");
        }
        System.out.println("Removendo cliente");
        clientes.remove(cliente);
    }

}
