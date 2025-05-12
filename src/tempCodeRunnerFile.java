import java.time.LocalDate;
import java.util.*;
import model.Biblioteca;
import model.Cliente;
import model.Emprestimo;
import model.Livro;
import model.Sistema;
public class Main {

    public static void main(String[] agrs){
        Sistema sistema  = Sistema.getInstancia();
        sistema.definirMaximoEmprestimo(3);
        sistema.definirTempoPadraoEmprestimo(5);
        sistema.definirValorMulta(5.0);
        Biblioteca biblioteca = new Biblioteca();
        List <Livro> livros = new ArrayList<>();
        Emprestimo emprestimos = null;
       // List <Emprestimo> emprestimos = new ArrayList<>();
        Cliente cliente = new Cliente("Carlso Antonio", 123, "Teste", 312, "Texte");
        livros.add(new Livro("Java para doidos", LocalDate.of(2024,01,01), 5, "Teste", "Novo"));
        //livros.add(new Livro("Javinha", LocalDate.of(2024,01,01), 5, "Teste", "Novo"));
        // livros.add(new Livro("Python na veia", LocalDate.of(2024,01,01), 5, "Teste", "Novo"));
        // livros.add(new Livro("Python ", LocalDate.of(2024,01,01), 5, "Teste", "Novo"));
        emprestimos.emprestimoItem(cliente, livros.get(0));
        //emprestimos.emprestimoItem(cliente, livros.get(0));
       // System.out.println(emprestimos.emprestimoLivro(cliente, livros.get(1)));
      //  System.out.println(emprestimos.emprestimoLivro(cliente, livros.get(2)));
 
        
       // emprestimos.add(new Emprestimo(cliente, livros.get(0), LocalDate.of(2025, 10, 23)));
       // for (Emprestimo emprestimo : emprestimos) {
          //  System.out.println(emprestimo);
       // }
        Biblioteca.getInstancia().listarTodosOsClientes();
        Biblioteca.getInstancia().listarTodosOsLivros();
        Biblioteca.getInstancia().listaTodosEmprestimoLivro();
      //  System.out.println(emprestimos.getDataPrevistaDevolucao());
        
        
        
       

    }
}
