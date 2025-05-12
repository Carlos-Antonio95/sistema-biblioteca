package model;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

     // Singleton
    private static final Biblioteca instancia = new Biblioteca();
    public static Biblioteca getInstancia() { return instancia; }

    private List<Cliente> listaClientes = new ArrayList<>();
    private List<Livro> listaLivros = new ArrayList<>();
    private List<Midia> listaMidias = new ArrayList<>();
    private List<Emprestimo> listaEmprestimosLivros = new ArrayList<>();
    private List<Emprestimo> listaEmprestimosMidia  = new ArrayList<>();

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

    
    public List<Emprestimo> getListaEmprestimosLivros() {
        return listaEmprestimosLivros;
    }

    public void setListaEmprestimosLivros(List<Emprestimo> listaEmprestimosLivros) {
        this.listaEmprestimosLivros = listaEmprestimosLivros;
    }

    public List<Emprestimo> getListaEmprestimosMidia() {
        return listaEmprestimosMidia;
    }

    public void setListaEmprestimosMidia(List<Emprestimo> listaEmprestimosMidia) {
        this.listaEmprestimosMidia = listaEmprestimosMidia;
    }

    // Adiciona Cliente, Livro ou Mídia
    public void adicionarClientesLista(Cliente c) { listaClientes.add(c); }
    public void adicionarLivrosLista(Livro l)     { listaLivros.add(l); }
    public void adicionarMidiaLista(Midia m)      { listaMidias.add(m); }

    // Adiciona empréstimos
    public void adicionarEmprestimoLivroLista(Emprestimo e) { listaEmprestimosLivros.add(e); }
    public void adicionarEmprestimoMidiaLista(Emprestimo e) { listaEmprestimosMidia.add(e); }



    
    // Listagens
    public void listarTodosOsClientes() {
        if (listaClientes.isEmpty()) {
            System.out.println("Não há Clientes cadastrados na biblioteca.");
        } else {
            System.out.println("=== Lista de Clientes Cadastrados ===");
            for (Cliente c : listaClientes) {
                System.out.println(c);
                System.out.println("----------------------------------");
            }
        }
    }

    public void listarTodosOsLivros() {
        if (listaLivros.isEmpty()) {
            System.out.println("Não há livros cadastrados na biblioteca.");
        } else {
            System.out.println("=== Lista de Livros Cadastrados ===");
            for (Livro l : listaLivros) {
                System.out.println(l);
                System.out.println("----------------------------------");
            }
        }
    }

    public void listarTodasAsMidias() {
        if (listaMidias.isEmpty()) {
            System.out.println("Não há mídias cadastradas na biblioteca.");
        } else {
            System.out.println("=== Lista de Mídias Cadastradas ===");
            for (Midia m : listaMidias) {
                System.out.println(m);
                System.out.println("----------------------------------");
            }
        }
    }

    public void listaTodosEmprestimoLivro() {
        if (listaEmprestimosLivros.isEmpty()) {
            System.out.println("Não há empréstimos de livro na biblioteca.");
        } else {
            System.out.println("=== Empréstimos de Livros ===");
            for (Emprestimo e : listaEmprestimosLivros) {
                System.out.println(e);
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
        cliente.devolverMidia(midia);
    }

}


