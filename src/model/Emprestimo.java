package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
//Atributos
public class Emprestimo {
    private Cliente cliente;
    private Livro livro;
    private Midia midia;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataDevolucao;
    private List<Emprestimo> listaEmprestimoLivro = new ArrayList<>();
    private List<Emprestimo> listaEmprestimoMidia = new ArrayList<>();

    // Construtor
    public Emprestimo(Cliente cliente, Midia midia ,LocalDate dataEmprestimo) {
        this.setCliente(cliente);
        this.setMidia(midia);
        this.setDataEmprestimo(dataEmprestimo);
        this.getDataPrevistaDevolucao();
        this.listaEmprestimoMidia.add(this);
        Biblioteca.getInstancia().adicionarEmprestimoMidiaLista(this); 
    }

     public Emprestimo(Cliente cliente, Livro livro ,LocalDate dataEmprestimo) {
        this.setCliente(cliente);
        this.setLivro(livro);
        this.setDataEmprestimo(dataEmprestimo);
        this.getDataPrevistaDevolucao();
        this.listaEmprestimoMidia.add(this);
        Biblioteca.getInstancia().adicionarEmprestimoLivroLista(this);
    }

// Getters e Setters        
  
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        if (cliente != null){
            this.cliente = cliente;
        }else{
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        }
    }

     public Livro getLivro() {
        return livro;
    }
    public void setLivro(Livro livro) {
        if(livro != null){
            this.livro = livro;
        }else{
            throw new IllegalArgumentException("Livro não pode ser nulo");
        }
    }
        
    public Midia getMidia() {
        return midia;
    }
    public void setMidia(Midia midia) {
        if(midia != null){
             this.midia = midia;
        }else{
            throw  new IllegalArgumentException("Midia não pode ser nulo");
        }
       
    }
    

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }
    //recebe data de emprestimo setada(set) e ja define a data prevista de devolução(set())
    public void setDataEmprestimo(LocalDate dataEmprestimo) {
       LocalDate dataPrevistaDevolucao;
        if (dataEmprestimo != null){
            this.dataEmprestimo = dataEmprestimo;
            dataPrevistaDevolucao = dataEmprestimo.plusDays(Sistema.getInstancia().getTempoPadraoEmprestimo());//plusDays()soma a quantidade (de dias que esta no getTempoPadrãoEmprestimo())
            this.setDataPrevistaDevolocao(dataPrevistaDevolucao);//ja insere a data de devolução prevista
            

        }else{
            throw new IllegalArgumentException("Data de empréstimo não pode ser nula.");
        }
    }
    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolocao(LocalDate dataPrevistaDevolocao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolocao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        if (dataDevolucao == null) throw new IllegalArgumentException("Data de devolução não pode ser nula.");
        if (dataDevolucao.isBefore(dataEmprestimo)) {
            throw new IllegalArgumentException("Data de devolução não pode ser anterior à data de empréstimo.");
        }
        this.dataDevolucao = dataDevolucao;
    }

    
    public List<Emprestimo> getListaEmprestimoLivro() {
        return listaEmprestimoLivro;
    }

    public List<Emprestimo> getListaEmprestimoMidia() {
        return listaEmprestimoMidia;
    }


    public void realizarEmprestimo(Cliente cliente,Livro livro){


    }  
   

    /**
     * Método que emprestar livro, utiliza os métodos ja existntem em cliente e livro, porem ele ja cria um emprestimo adicionando infromações como data e previção de devolução
     * @param cliente o cliente que ira fazer o emprestimo
     * @param livro o livro que sera emprestado
     */
    public static  void emprestimoItem(Cliente cliente, Livro livro){
        if(cliente.emprestarLivro(livro)){
            livro.emprestarItem();
            LocalDate datahoje = LocalDate.now();//LocalDate.now() pega a data do computador e vai inseir
            Emprestimo emprestimo = new Emprestimo(cliente, livro, datahoje);//pega os paramentros ja passado no método principal e a data de hoje para criar o emprestimo(objeto)
            LocalDate prevista = emprestimo.getDataPrevistaDevolucao();
        }else{
            System.out.println("Emprestimo não realizado");
        }
    }

    /**
     * Método que emprestar midia, utiliza os métodos ja existntem em cliente e midia, porem ele ja cria um emprestimo adicionando infromações como data e previção de devolução
     * @param cliente o cliente que ira fazer o emprestimo
     * @param midia a midia que sera emprestado
     */
    public static void emprestimoItem(Cliente cliente, Midia midia){
        if (cliente.emprestarMidia(midia)) {
            midia.emprestarItem();
            LocalDate dataHoje = LocalDate.now();//LocalDate.now() pega a data do computador e vai inseir
            Emprestimo emprestimo = new Emprestimo(cliente, midia, dataHoje);//pega os paramentros ja passado no método principal e a data de hoje para criar o emprestimo(objeto)
            LocalDate prevista = emprestimo.getDataPrevistaDevolucao();
        } else {
            System.out.println("Emprestimo não realizado");
        }
      }

      /**
       * Método que ira calcular os dias do emprestimo
       *  O método ChronoUnit.DAYS.between, calcula a diferença em dias entre duas datas fornecidas Ele retorna um valor do tipo long, que representa o número de dias entre as duas datas.
       * @param dataEmprestimo data que foi realizado o emprestimo
       * @param dataDevolucao data que foi devolvido
       * @return retornar a direfença entre as duas datas(dias)
       */
    public long calcularDiasEmprestimo(LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        if (dataEmprestimo != null && dataDevolucao != null) {
            return ChronoUnit.DAYS.between(dataEmprestimo, dataDevolucao);
        } else {
            throw new IllegalStateException("Datas de empréstimo e devolução devem estar definidas.");

        }
    }   

    /**
     * Método que retonar uma String informando a data  prevista para devolução
     * @param dataemprestimo data do emprestimo
     * @return data prevista para devolução
     */
    public String dataPrevistaDevolucao(LocalDate dataemprestimo){
        LocalDate dataPrevistaDevolucao = dataemprestimo.plusDays(Sistema.getInstancia().getTempoPadraoEmprestimo());
        return "Data prevista para devolução: "+ dataPrevistaDevolucao;
    }

         
          
    /**
     * Método para calcular multa, faz todo tratamento de erro verificando valores nulos, calcula os dias emprestados, multiplica o pela multa caso tenha multa e retorna o valor da multa
     * @param dataEmprestimo data de realização do emprestimo
     * @param dataDevolucao data de devolução do emprestimo
     * @return retonra o valor da multa caso tenha
     */
    public double calcularMulta(LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        if (Sistema.getInstancia().getMaximoEmprestimos() == null) {
            throw new IllegalArgumentException("Valores do sistema não pode ser nullo");
        }
        if (dataEmprestimo == null) {
            throw new IllegalStateException("Data de empréstimo não foi definida.");
        }
        if (dataDevolucao == null) {
            throw new IllegalArgumentException("Data de devolução não pode ser nula.");
        }

        long dias = calcularDiasEmprestimo(dataEmprestimo, dataDevolucao);
        long diasExcedentes = dias - Sistema.getInstancia().getTempoPadraoEmprestimo();

        if (diasExcedentes > 0) {
            double valorMulta = diasExcedentes * Sistema.getInstancia().getValorMulta();
            System.out.println("Valor da multa: R$ " + valorMulta);
            return valorMulta;
        } else {
            System.out.println("Nenhuma multa. Devolução no prazo.");
            return 0.0;
        }
    }
  
   @Override
    public String toString() {
    return "Informações do Empréstimo:\n"
        + "Cliente: " + cliente.getNome() + "\n"
        + "Livro: " + (livro != null ? livro.getTitulo() : "Não informado") + "\n"
        + "Mídia: " + (midia != null ? midia.getTitulo() : "Não informado") + "\n"
        + "Data do Empréstimo: " + dataEmprestimo + "\n"
        + "Data Prevista de Devolução: " + dataPrevistaDevolucao + "\n"
        + "Data da Devolução: " + (dataDevolucao != null ? dataDevolucao : "Ainda não devolvido");
    }



}
   
   

   
    

   

   
    





