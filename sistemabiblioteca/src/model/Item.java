package model;

import java.time.LocalDate;

public abstract class Item implements itemBiblioteca{
    private String titulo;
    private LocalDate dataDePublicacao;
    private int exemplaresDisponiveis;
    private String categoria;



    public abstract void devolver();
    public abstract void emprestar();

}
