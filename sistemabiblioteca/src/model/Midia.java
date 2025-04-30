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
            throw new IllegalArgumentException("Diretor n�o pode ser nullo/vazio");
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
        return "Informa��es da Midia:\n"
             + "T�tulo: " + getTitulo() + "\n"
             + "Autor: " + getDiretor() + "\n"
             + "Data de Publica��o: " + getDataDePublicacao() + "\n"
             + "Categoria: " + getCategoria() + "\n"
             + "Exemplares Dispon�veis: " + getExemplaresDisponiveis();
    }
}
