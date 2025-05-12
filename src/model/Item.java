package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Item implements itemBiblioteca{
    //Atributos
    private String titulo;
    private LocalDate dataDePublicacao;
    private int exemplaresDisponiveis;
    private String categoria;
    private static List<String> livrosDisponiveis = new ArrayList<>();

    //Contrutor
    public Item(String titulo, LocalDate dataDePublicacao, int exemplaresDisponiveis, String categoria ){
        this.setTitulo(titulo);
        this.setDataDePublicacao(dataDePublicacao);
        this.setExemplaresDisponiveis(exemplaresDisponiveis);
        this.setCategoria(categoria);
        this.livrosDisponiveis.add(titulo);//adiciona o titulo do livro a lista
    }

   //Métodos acessores 

   public List<String> getLvivrosDisponveis(){
        return livrosDisponiveis;
   }
   
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if(titulo != null && !titulo.isEmpty()){
            this.titulo = titulo;
        }else{
            throw new IllegalArgumentException("Titulo não pode ser nulo");
        }
        
    }

    public LocalDate getDataDePublicacao() {
        return dataDePublicacao;
    }

    //verifica se a data de publicação passada no parametro é igual ou inferior a data atual
    public void setDataDePublicacao(LocalDate dataDePublicacao) {
        if(dataDePublicacao.isEqual(LocalDate.now()) || dataDePublicacao.isBefore(LocalDate.now())){
            this.dataDePublicacao = dataDePublicacao;
        }else{
            throw new IllegalArgumentException("Data de publicação não pode ser superior a data de "+ LocalDate.now());
        }
        
    }
    public int getExemplaresDisponiveis() {
        return exemplaresDisponiveis;
        //
    }

    //impede que exemplares disponveis sejam vazios
    public void setExemplaresDisponiveis(int exemplaresDisponiveis) {
        if(exemplaresDisponiveis >= 0){
            this.exemplaresDisponiveis = exemplaresDisponiveis;
        }else{
            throw  new IllegalArgumentException("Quantidade exemplares disponveis não pode ser negativo");
        }
       
    }

    public String getCategoria() {
        return categoria;
    }

    //Impede que seja setada uma categoria nulla/vazia
    public void setCategoria(String categoria) {
        if (categoria != null && !categoria.isEmpty()) {
            this.categoria = categoria;
        } else {
            throw new IllegalArgumentException("Categoria não pode ser nullo");
        }
        
    }

     //Métodos abstratos serão implementados nas classes filhas
     @Override
     public abstract void devolver();
     @Override
     public abstract void emprestar();

     @Override
     public String toString() {
        return "Item [titulo=" + titulo + ", dataDePublicacao=" + dataDePublicacao + ", exemplaresDisponiveis="
                + exemplaresDisponiveis + ", categoria=" + categoria + "]";
     }

 

}