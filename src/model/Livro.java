package model;

import java.time.LocalDate;
import model.Biblioteca;

public class Livro extends Item {

    private String autor;

    public Livro(String titulo, LocalDate dataDePublicacao, int exemplaresDisponiveis, String categoria, String autor) {
        super(titulo, dataDePublicacao, exemplaresDisponiveis, categoria);
        this.setAutor(autor);
        Biblioteca.getInstancia().adicionarLivrosLista(this);
        
    }




    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor != null && !autor.isEmpty()) {
            this.autor = autor;
        } else {
            throw new IllegalArgumentException("Autor não pode ser nullo/vazio");
        }
        
    }

    /**
     * Método verefica se existem exemplares disponveis, caso exista ele decrementa em 1
     * @return returna verdadero se "emprestar"
     */
    public boolean emprestarItem(){
        if(getExemplaresDisponiveis() > 0){
            emprestar();//decrementa um livro
            return true; //livro emprestado com sucesso
        }else{
            throw new IllegalArgumentException("ERRO: Não a exemplares dispinveis para o livro: "+getTitulo());
        }
    }


    @Override
    public void devolver() {
        this.setExemplaresDisponiveis(getExemplaresDisponiveis() + 1);
    }

   
    @Override
    public void emprestar() {
       this.setExemplaresDisponiveis(getExemplaresDisponiveis()- 1);
    }

    @Override
    public String toString() {
        return "Informações do Livro:\n"
             + "Título: " + getTitulo() + "\n"
             + "Autor: " + getAutor() + "\n"
             + "Data de Publicação: " + getDataDePublicacao() + "\n"
             + "Categoria: " + getCategoria() + "\n"
             + "Exemplares Disponíveis: " + getExemplaresDisponiveis();
    }
}
