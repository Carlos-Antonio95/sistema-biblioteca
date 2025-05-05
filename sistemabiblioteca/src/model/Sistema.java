package model;

public class  Sistema implements Configuravel {
    
    private int tempoPadraoEmprestimo;
	private int maximoEmprestimos;
	private double valorMulta;
	
	public void setTempoPadraoEmprestimo(int diasMaximoEmprestimo) {
		if(diasMaximoEmprestimo <= 0) {
			throw new IllegalArgumentException("O tempo padrão de empréstimo deve ser maior que zero");
	}else {
		this.tempoPadraoEmprestimo = diasMaximoEmprestimo;
	}
		
		
    }
	
	public int getTempoPadraoEmprestimo() {
	   return tempoPadraoEmprestimo;	
	}
	
	public void setMaximoEmprestimos(int qtdTotalEmprestimo) {
		if(qtdTotalEmprestimo <= 0) {
			throw new IllegalArgumentException("A quantidade máxima de empréstimo deve ser maior que zero");
	}else {
		this.maximoEmprestimos = qtdTotalEmprestimo;
		
	}
		
	
		
	}
	
	public int getMaximoEmprestimos() {
		   return maximoEmprestimos;	
	
	}
	
	public void setValorMulta(double valorMulta) {
		if(valorMulta <= 0) {
			throw new IllegalArgumentException("O valor deve ser maior que 0");
			
	    }else {
		    this.valorMulta = valorMulta;
		
	    }
	}	
	
	public double getValorMulta() {
		return valorMulta;	
	}
	
    @Override
	public int definirTempoPadraoEmprestimo(int dias) {
		this.setTempoPadraoEmprestimo(dias);
		int qtdDia = this.getTempoPadraoEmprestimo();
		return qtdDia;
		
    }
	@Override
	public int definirMaximoEmprestimo(int qtdLivros) {
		this.setMaximoEmprestimos(qtdLivros);
		int novoQtdLivros = this.getMaximoEmprestimos();
		return novoQtdLivros;
		
    }
    @Override
	public double definirValorMulta(double valor ) {
		this.setValorMulta(valor);
		double novoValorMulta = this.getValorMulta();
		return novoValorMulta;	
	
  }	
}


