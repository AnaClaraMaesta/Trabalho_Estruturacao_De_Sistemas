package Exercicio_1;

public class Cliente {
    private String nome;
    private String telefone;

    public Cliente(String nome, String telefone) {
        if (nome == null || nome.trim().isBlank()) {
            throw new IllegalArgumentException("Informe um nome válido");
        }
        this.nome = nome;

        String telLimpo = telefone.replaceAll("[^0-9]", "");
        if (telLimpo.length() < 7 || telLimpo.length() > 15) {
            throw new IllegalArgumentException("Informe um telefone válido (7 a 15 dígitos)");
        }
        this.telefone = telLimpo;
    }

    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }

    @Override
    public String toString() {
        return "Cliente: " + nome + " | Telefone: " + telefone;
    }
}