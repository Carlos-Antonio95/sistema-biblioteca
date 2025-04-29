package model;

import java.time.LocalDate;

public abstract class Item implements itemBiblioteca{
    //Atributos
    private String titulo;
    private LocalDate dataDePublicacao;
    private int exemplaresDisponiveis;
    private String categoria;

    //Contrutor
    public Item(String titulo, LocalDate dataDePublicacao, int exemplaresDisponiveis, String categoria ){
        this.setTitulo(titulo);
        this.dataDePublicacao = dataDePublicacao;
        this.exemplaresDisponiveis = exemplaresDisponiveis;
        this.categoria = categoria;
    }

   //Métodos acessores 
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

    public void setDataDePublicacao(LocalDate dataDePublicacao) {
        this.dataDePublicacao = dataDePublicacao;
    }
    public int getExemplaresDisponiveis() {
        return exemplaresDisponiveis;
    }

    public void setExemplaresDisponiveis(int exemplaresDisponiveis) {
        this.exemplaresDisponiveis = exemplaresDisponiveis;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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
