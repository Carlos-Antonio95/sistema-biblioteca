package model;

import java.time.LocalDate;
//Atributos
public class Emprestimo {
    private String cliente;
    private String item;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolocao;
    private LocalDate dataDevolucao;
// Construtor
    public Emprestimo(String cliente, LocalDate dataDevolucao, LocalDate dataEmprestimo, LocalDate dataPrevistaDevolocao, String item) {
        this.cliente = cliente;
        this.dataDevolucao = dataDevolucao;
        this.dataEmprestimo = dataEmprestimo;
        this.dataPrevistaDevolocao = dataPrevistaDevolocao;
        this.item = item;

// Getters e Setters        
    }
    public String getCliente() {
        return cliente;
    }
    public void setCliente(String cliente) {
        if (cliente != null && !cliente.isEmpty()){
            this.cliente = cliente;
        }else{
            throw new IllegalArgumentException("Clinte não pode ser nulo");
        }
    }
    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        if (item != null && !item.isEmpty()){
            this.item = item;
        }else{
            throw new IllegalArgumentException("Item não pode ser nulo");
        }
    }
    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }
    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
    public LocalDate getDataPrevistaDevolocao() {
        return dataPrevistaDevolocao;
    }
    public void setDataPrevistaDevolocao(LocalDate dataPrevistaDevolocao) {
        this.dataPrevistaDevolocao = dataPrevistaDevolocao;
    }
    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }
    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    //toString
    @Override
    public String toString() {
        return "Emprestimo [cliente=" + cliente + ", item=" + item + ", dataEmprestimo=" + dataEmprestimo
                + ", dataPrevistaDevolocao=" + dataPrevistaDevolocao + ", dataDevolucao=" + dataDevolucao + "]";
    }
    
    

    

   
   

   
    

   

   
    




}
