import java.time.LocalDate;
import java.util.*;

import model.Biblioteca;
import model.Cliente;
import model.Livro;
public class Main {

    public static void main(String[] agrs){
        Biblioteca biblioteca = new Biblioteca();
        List <Livro> livros = new ArrayList<>();
        Cliente cliente = new Cliente("Carlso Antonio", 123, "Teste", 312, "Texte");
        biblioteca.adicionarClientesLista(cliente);
        livros.add(new Livro("Java para doidos", LocalDate.of(2024,01,01), 5, "Teste", "Novo"));
        //biblioteca.adicionarLivrosLista(livros.get(0));
        //System.out.println(livros.get(0).getExemplaresDisponiveis());
       // livros.get(0).devolver();
        ////System.out.println(livros.get(0).getExemplaresDisponiveis());
        //livros.get(0).emprestarItem();
        System.out.println(livros.get(0).getExemplaresDisponiveis());
        biblioteca.emprestarItem(cliente, livros.get(0));
       
        
        
        
       

    }
}
