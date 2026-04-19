package Exercicio_3.Service;

import Exercicio_3.Model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    List<Cliente> clientes = new ArrayList<>();

    public void cadastrarCliente(String nome) {
        if(nome==null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("O nome não pode estar em branco");
        }
        if(buscarCliente(nome) != null){
            throw new IllegalArgumentException("Cliente já cadastrado");
        }
        clientes.add(new Cliente(nome));
    }

    public void removerCliente(String nome) {
        Cliente cliente = buscarCliente(nome);
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não encontrado");
        }
        clientes.remove(cliente);
    }

    public Cliente buscarCliente(String nome)
    {
        return clientes.stream().filter(c -> c.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
    }

    public List<Cliente> listarClientes()
    {
        if(clientes==null){
            throw new IllegalArgumentException("Nenhum cliente cadastrado");
        }
        return new ArrayList<>(clientes);
    }

}
