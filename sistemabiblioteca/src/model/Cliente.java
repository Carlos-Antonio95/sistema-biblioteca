package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private int cpf;
    private String endereço;
    private int telefone;
    private String email;
    private int quantidadelivros = 0;
    private List<String> livrosEmprestados = new ArrayList<>();
    private Livro livro;
    private Midia midia;

    // Construtor
    public Cliente(String nome, int cpf, String endereço, int telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereço = endereço;
        this.telefone = telefone;
        this.email = email;
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    // Método para emprestar um livro
    public void emprestarLivro(String livro) {
        if (livrosEmprestados.contains(livro)) {
            System.out.println("Erro: O livro \"" + livro + "\" já foi emprestado para " + nome + ".");
        } else {
            livrosEmprestados.add(livro);
            System.out.println("O livro \"" + livro + "\" foi emprestado para " + nome + ".");
            quantidadelivros++;
        }
    }

    // Método para devolver um livro
    public void devolverLivro(String livro) {
        if (!livrosEmprestados.contains(livro)) {
            System.out.println("Erro: O livro \"" + livro + "\" não está emprestado para " + nome + ".");
        } else {
            livrosEmprestados.remove(livro);
            System.out.println("O livro \"" + livro + "\" foi devolvido por " + nome + ".");
            quantidadelivros--;
        }
    }

    // Método para listar os livros emprestados
    public void listarLivrosEmprestados() {
        if (livrosEmprestados.isEmpty()) {
            System.out.println(nome + " não possui livros emprestados.");
        } else {
            System.out.println("Livros emprestados por " + nome + ": " + livrosEmprestados);
        }
    }

    @Override
    public String toString() {
        return "Cliente nome=" + nome + ", \ncpf=" + cpf + ", \nendereço=" + endereço + ", \ntelefone=" + telefone
                + ", \nemail=" + email + "\nquantidadelivros=" + quantidadelivros + ", \nlivrosEmprestados=" + livrosEmprestados;
    }
}
