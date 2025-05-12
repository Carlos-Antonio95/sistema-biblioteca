package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe cliente, contem todas as informações sobre o cliente, como nome,cpf, listas dos livros e midias emprestados, como também lista com apenas os nomes dos titulos
 */
public class Cliente {
    private String nome;
    private int cpf;
    private String endereço;
    private int telefone;
    private String email;
    private List<Livro> livrosEmprestados = new ArrayList<>();
    private List<Midia> midiasEmprestadas = new ArrayList<>();
    private List<String> nomesLivros = new ArrayList<>();
    private List<String> nomesMidias = new ArrayList<>();

    public List<String> getNomesLivros() {
        return nomesLivros;
    }

    // Construtor registra automaticamente na biblioteca singleton
    public Cliente(String nome, int cpf, String endereço, int telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereço = endereço;
        this.telefone = telefone;
        this.email = email;
        Biblioteca.getInstancia().adicionarClientesLista(this);
    }

    /**
     * Método para emprestar livro, verifica se respeita as regras do sistema sobre quantidade maxima de emprestimos e se o livro ja não esta emprestado para o mesmo, caso tudo esteja ok realiza emprestimo
     * @param livro livro que sera emprestado
     * @return retorna um true caso ocorra o emprestimo
     */
    public boolean  emprestarLivro(Livro livro) {
        int max = Sistema.getInstancia().getMaximoEmprestimos();
        if (livrosEmprestados.size() >= max) {
            throw new IllegalArgumentException(
                "Cliente atingiu o limite de empréstimos permitidos de: " + max
            );
        }
        if (livrosEmprestados.contains(livro)) {
           System.out.println( "Erro: O livro \"" + livro.getTitulo() + "\" já foi emprestado para " + nome + ".");
           return false;
        } else {
            livrosEmprestados.add(livro);
            nomesLivros.add(livro.getTitulo());
            System.out.println("O livro \"" + livro.getTitulo() + "\" foi emprestado para " + nome + ".");
            return true;
        }
    }

    /**
     * Método para emprestar midia, verifica se respeita as regras do sistema sobre quantidade maxima de emprestimos e se o midia ja não esta emprestado para o mesmo, caso tudo esteja ok realiza emprestimo
     * @param midia midia que sera emprestado
     * @return retorna um true caso ocorra o emprestimo
     */
    public boolean emprestarMidia(Midia midia) {
        int max = Sistema.getInstancia().getMaximoEmprestimos();
        if (midiasEmprestadas.size() >= max) {
            throw new IllegalArgumentException(
                "Cliente atingiu o limite de empréstimos permitidos de: " + max
            );
        }if (midiasEmprestadas.contains(midia)) {
            System.out.println( "Erro: A mídia \"" + midia.getTitulo() + "\" já foi emprestada para " + nome + ".");
            return false;
        }if (midia.emprestarItem()){
            midiasEmprestadas.add(midia);
            nomesMidias.add(midia.getTitulo());
           System.out.println( "A mídia \"" + midia.getTitulo() + "\" foi emprestada para " + nome + ".");
          return true;
        }
        return  false;
    }
    /**
     * Método para devolver livro, retira o livro da lista de livros emprestados
     * @param livro livro que sera retirado
     */
    public void devolverLivro(Livro livro) {
        if (!livrosEmprestados.contains(livro)) {
            System.out.println("Erro: O livro \"" + livro + "\" não está emprestado para " + nome + ".");
        } else {
            livrosEmprestados.remove(livro);
            System.out.println("O livro \"" + livro + "\" foi devolvido por " + nome + ".");
        }
    }

    /**
     * Método para devovler midia, retira a midia da lista de emprestados
     * @param midia midia que sera devolvida
     */
    public void devolverMidia(Midia midia) {
        if (!livrosEmprestados.contains(midia)) {
            System.out.println("Erro: A midia \"" + midia + "\" não está emprestada para " + nome + ".");
        } else {
            livrosEmprestados.remove(midia);
            System.out.println("A midia \"" + midia + "\" foi devolvida por " + nome + ".");

        }
    }

    // Lista sempre a própria lista (nunca null)
    public List<Livro> listarLivrosEmprestados() {
        if (livrosEmprestados.isEmpty()) {
            System.out.println(nome + " não possui livros emprestados.");
        }
        return livrosEmprestados;
    }

    // toString
    @Override
    public String toString() {
        return "Informações do Cliente:\n" +
               "Nome: " + getNome() + "\n"+
               "Cpf: " + getCpf() + "\n" +
               "Endereço: " + getEndereço() + "\n"+
               "Telefone: " + getTelefone() + "\n" +
               "Email: " + getEmail() + "\n"+
               "LivrosEmprestados: " + livrosEmprestados.size() +" "+
               "Titulo: "+getNomesLivros()+" \n"+
               "MidiasEmprestadas: " + midiasEmprestadas.size()+" "+
               "Titulo: "+getNomesMidias()+" \n";
    }

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

    public List<Livro> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public void setLivrosEmprestados(List<Livro> livrosEmprestados) {
        this.livrosEmprestados = livrosEmprestados;
    }

    public List<Midia> getMidiasEmprestadas() {
        return midiasEmprestadas;
    }

    public void setMidiasEmprestadas(List<Midia> midiasEmprestadas) {
        this.midiasEmprestadas = midiasEmprestadas;
    }

    public List<String> getNomesMidias() {
        return nomesMidias;
    }
}
