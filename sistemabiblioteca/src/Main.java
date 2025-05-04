import java.time.LocalDate;
import java.util.*;
import model.Livro;
public class Main {

    public static void main(String[] agrs){
        List <Livro> livros = new ArrayList<>();
        livros.add(new Livro("Java para doidos", LocalDate.of(2024,01,01), 0, "Teste", "Novo"));
        System.out.println(livros.get(0).getExemplaresDisponiveis());
       // livros.get(0).devolver();
        System.out.println(livros.get(0).getExemplaresDisponiveis());
        livros.get(0).emprestarItem();
        System.out.println(livros.get(0).getExemplaresDisponiveis());
        
        
        
       

    }
}
