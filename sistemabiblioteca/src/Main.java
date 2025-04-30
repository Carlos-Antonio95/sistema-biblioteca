import model.Livro;
import java.time.LocalDate;
import java.util.*;
public class Main {

    public static void main(String[] agrs){
        List <Livro> livros = new ArrayList<>();
        livros.add(new Livro("Java para doidos", LocalDate.of(2024,01,01), 5, "Teste", "Novo"));
        System.out.println(livros.get(0).getExemplaresDisponiveis());
        livros.get(0).devolver();
        System.out.println(livros.get(0).getExemplaresDisponiveis());
        System.out.println(livros.get(0));
       

    }
}
