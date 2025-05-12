package model;

public interface Configuravel {

    
    public Integer definirTempoPadraoEmprestimo(Integer dias);
    public Integer definirMaximoEmprestimo(Integer quantidade);
    public Double definirValorMulta(Double valorMulta);
}
