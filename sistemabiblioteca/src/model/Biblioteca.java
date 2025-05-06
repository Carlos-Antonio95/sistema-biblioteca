package model;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Cliente> listaClientes = new ArrayList<>();
    private List<Livro> listaLivros = new ArrayList<>();
    private List<Midia> listaMidias = new ArrayList<>();

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Livro> getListaLivros() {
        return listaLivros;
    }

    public void setListaLivros(List<Livro> listaLivros) {
        this.listaLivros = listaLivros;
    }

    public List<Midia> getListaMidias() {
        return listaMidias;
    }

    public void setListaMidias(List<Midia> listaMidias) {
        this.listaMidias = listaMidias;
    }

    //adiciona o novo livro a lista de livros
    public void adicionarLivrosLista(Livro livro){
        listaLivros.add(livro);
    }

    public void adicionarClientesLista(Cliente cliente){
        listaClientes.add(cliente);
    }

    public void adicionarMidiaLista(Midia midia){
        listaMidias.add(midia);
    }

    public void listarTodosOsLivros() {
        if (listaLivros.isEmpty()) {
            System.out.println("Não há livros cadastrados na biblioteca.");
        } else {
            System.out.println("=== Lista de Livros Cadastrados ===");
            for (Livro livro : listaLivros) {
                System.out.println(livro); // chama o toString() da classe Livro
                System.out.println("----------------------------------");
            }
        }
    }

    public void listarTodosAsMidias() {
        if (listaClientes.isEmpty()) {
            System.out.println("Não há Midias cadastrados na biblioteca.");
        } else {
            System.out.println("=== Lista de Midias Cadastrados ===");
            for (Midia midia : listaMidias) {
                System.out.println(midia); // chama o toString() da classe midia
                System.out.println("----------------------------------");
            }
        }
    }


    public void listarTodosOsClientes() {
        if (listaClientes.isEmpty()) {
            System.out.println("Não há Cleintes cadastrados na biblioteca.");
        } else {
            System.out.println("=== Lista de Clientes Cadastrados ===");
            for (Cliente cliente : listaClientes) {
                System.out.println(cliente); // chama o toString() da ciente 
                System.out.println("----------------------------------");
            }
        }
    }
    
    //Método emprestatar livro
    public void emprestarItem(Cliente cliente, Livro livro){
        if (livro.emprestarItem()) {//Verifica se o livro disponvel se tiver realiza o emprestimo
            cliente.emprestarLivro(livro);//chama o método de emprestar 
            
        }
    }

    //Método emprestar Midia
    public void emprestarItem(Cliente cliente, Midia midia){
        if (midia.emprestarItem()) {//Verifica se o livro disponvel se tiver realiza o emprestimo
            cliente.emprestarMidia(midia);//chama o método de emprestar 
            
        }
    } 

    public void devolverItem(Cliente cliente, Livro livro){
        livro.devolver();
        cliente.devolverLivro(livro);
    }

    public void devolverItem(Cliente cliente, Midia midia){
        midia.devolver();
        cliente.devolverMdia(midia);
    }
}


