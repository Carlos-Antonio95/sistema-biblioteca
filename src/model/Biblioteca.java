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

    /**
     * Método para adicionar Clientes a Lista
     * @param c o cliente
     */
    public void adicionarClientesLista(Cliente c) { listaClientes.add(c); }
    /**
     * Método para adicionar livros a lista
     * @param l o livro
     */
    public void adicionarLivrosLista(Livro l)     { listaLivros.add(l); }
    /**
     * Método para adiocnar midia a lista
     * @param m a midia
     */
    public void adicionarMidiaLista(Midia m)      { listaMidias.add(m); }

  
    /**
     * Método para adicionar emprestimos realizado de livros
     * @param e o emprestimo(o objeto em si)
     */
    public void adicionarEmprestimoLivroLista(Emprestimo e) { listaEmprestimosLivros.add(e); }
    /**
     * Método para adicionar emprestimos realizados de midias
     * @param e o emprestimo(o objeto em si)
     */
    public void adicionarEmprestimoMidiaLista(Emprestimo e) { listaEmprestimosMidia.add(e); }



    
    /**
     * Método que vai listar todos os clientes que existem na lista
     * Vai printar o toString()
     */
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

    /**
     * Método que vai listar todos os livros que existem
     * Vai printar o toString();
     */
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

    /**
     * Método que vai listar todos as midias que existem
     * Vai printar o toString()
     */
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

    /**
     * Método que vai listar todos os emprestimos de livros
     * printa os emprestimos -> toString() = de emprestimo
     */
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

    /**
     * Método que vai listar todos os emprestimos de midia
     * printa os emprestimos -> toString() = de  emprestimo
     */
    public void listarTodosEmprestimoMidia(){
        if(listaEmprestimosMidia.isEmpty()){
            System.out.println("Não há empréstimos de midia na biblioteca.");
        }else{
            System.out.println("=== Empréstimos de Midias ===");
            for (Emprestimo e : listaEmprestimosMidia) {
                System.out.println(e);
                System.out.println("----------------------------------");
                
            }
        }
    }

    
    //Método emprestatar livro ta em construção ainda
    public void emprestarItem(Cliente cliente, Livro livro){
        if (livro.emprestarItem()) {//Verifica se o livro disponvel se tiver realiza o emprestimo
            cliente.emprestarLivro(livro);//chama o método de emprestar 
            
        }
    }

    //Método emprestar Midia ta em construção ainda
    public void emprestarItem(Cliente cliente, Midia midia){
        if (midia.emprestarItem()) {//Verifica se o livro disponvel se tiver realiza o emprestimo
            cliente.emprestarMidia(midia);//chama o método de emprestar 
            
        }
    } 

    //ta em construção ainda
    public void devolverItem(Cliente cliente, Livro livro){
        livro.devolver();
        cliente.devolverLivro(livro);
    }

    //ta em contrução ainda
    public void devolverItem(Cliente cliente, Midia midia){
        midia.devolver();
        cliente.devolverMidia(midia);
    }

}


