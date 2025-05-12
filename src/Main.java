import java.time.LocalDate;
import java.util.*;
import model.Biblioteca;
import model.Cliente;
import model.Emprestimo;
import model.Livro;
import model.Midia;
import model.Sistema;
public class Main {

    public static void main(String[] agrs){
        Sistema sistema  = Sistema.getInstancia();
        sistema.definirMaximoEmprestimo(3);
        sistema.definirTempoPadraoEmprestimo(5);
        sistema.definirValorMulta(5.0);
        List<Emprestimo> emprestimos = new ArrayList<>();
        Biblioteca biblioteca = new Biblioteca();
        List <Livro> livros = new ArrayList<>();
        List <Midia> midias = new ArrayList<>();
       // List<Emprestimo> emprestimos = new ArrayList<>();
       // List <Emprestimo> emprestimos = new ArrayList<>();
        Cliente cliente = new Cliente("Carlso Antonio", 123, "Teste", 312, "Texte");
        livros.add(new Livro("Java para doidos", LocalDate.of(2024,01,01), 5, "Teste", "Novo"));
        livros.add(new Livro("Javinha", LocalDate.of(2024,01,01), 5, "Teste", "Novo"));
         livros.add(new Livro("Python na veia", LocalDate.of(2024,01,01), 5, "Teste", "Novo"));
         livros.add(new Livro("Python ", LocalDate.of(2024,01,01), 5, "Teste", "Novo"));
         midias.add(new Midia("titsdasdaulo", LocalDate.of(2024,01,01), 2, "categoria", "diretor"));
           midias.add(new Midia("testeee", LocalDate.of(2024,01,01), 2, "categoria", "diretor"));

         emprestimos.add(new Emprestimo(cliente, midias.get(0), LocalDate.now()));
         emprestimos.add(new Emprestimo(cliente, midias.get(1), LocalDate.now()));
         Biblioteca.getInstancia().listarTodosOsClientes();
         emprestimos.get(0).devolverItem(cliente,emprestimos.get(0), midias.get(0), LocalDate.of(2025, 5, 21));
         //Biblioteca.getInstancia().emprestarItem(cliente, midias.get(0));



         //emprestimos.add(new Emprestimo(cliente, livros.get(0),LocalDate.now()));
         //System.out.println(emprestimos.get(0).devolverItem(cliente, emprestimos.get(0), midias.get(0)));
        // System.out.println(midias.get(0).getExemplaresDisponiveis());
        Biblioteca.getInstancia().listarTodosOsClientes();
        //Biblioteca.getInstancia().listarTodosOsLivros();
        Biblioteca.getInstancia().listarTodosEmprestimoMidia();
       // Biblioteca.getInstancia().emprestarItem(cliente, midias.get(0));
        //Biblioteca.getInstancia().listarTodasAsMidias();
        //System.out.println(emprestimos.getDataPrevistaDevolucao());
      // Biblioteca.getInstancia().listaTodosEmprestimoLivro();
       //System.out.println(livros.get(0).getExemplaresDisponiveis());
      // System.out.println(midias.get(0).getExemplaresDisponiveis());
       //System.out.println(emprestimos.get(0).devolverItem(cliente, emprestimos.get(0), midias.get(0)));
       //System.out.println(midias.get(0).getExemplaresDisponiveis());
      // Biblioteca.getInstancia().listarTodosEmprestimoMidia();


      
       
        
       

    }
}
