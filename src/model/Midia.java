package model;

import java.time.LocalDate;

/**
 * Classe midia contem todas as inormações sobre a midia
 */
public class Midia extends  Item {
    
    private String diretor;

    public Midia(String titulo, LocalDate dataDePublicacao, int exemplaresDisponiveis, String categoria, String diretor) {
        super(titulo, dataDePublicacao, exemplaresDisponiveis, categoria);
        this.setDiretor(diretor);
        Biblioteca.getInstancia().adicionarMidiaLista(this);
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

    /**
     * Método para verificar se tem exemplares disponveis, caso exista decrementa 1
     * @return retorna true caso tenha sido "emprestada"
     */
    public boolean emprestarItem(){
        if(getExemplaresDisponiveis() > 0){
            emprestar();//decrementa um mídia
            return true; //mídia emprestado com sucesso
        }else{
            throw  new IllegalArgumentException("ERRO: Não a exemplares dispinveis para o Midia: "+getTitulo());
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
