package model;

import java.time.LocalDate;

public class Midia extends  Item {
    
    private String diretor;

    public Midia(String titulo, LocalDate dataDePublicacao, int exemplaresDisponiveis, String categoria,
            String diretor) {
        super(titulo, dataDePublicacao, exemplaresDisponiveis, categoria);
        this.setDiretor(diretor);
    }


    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        if (diretor != null && !diretor.isEmpty()) {
            this.diretor = diretor;
        } else {
            throw new IllegalArgumentException("Diretor não pode ser nullo/vazio");
        }
       
    }

    //Método emprestar Midia
    public boolean emprestarItem(){
        if(getExemplaresDisponiveis() > 0){
            emprestar();//decrementa um livro
            return true; //livro emprestado com sucesso
        }else{
            System.out.println("ERRO: Não a exemplares dispinveis para o Midia: "+getTitulo());
            return false;// Não ha exemplares disponiveis
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
        return "Informções da Midia:\n"
             + "Título: " + getTitulo() + "\n"
             + "Autor: " + getDiretor() + "\n"
             + "Data de Publicaçao: " + getDataDePublicacao() + "\n"
             + "Categoria: " + getCategoria() + "\n"
             + "Exemplares Disponíveis: " + getExemplaresDisponiveis();
    }
}
