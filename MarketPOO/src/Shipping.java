// Classe de Fretes

import java.util.Random;

public class Shipping {
	//Variavéis de instâncias
	private String cod;
	private String company;
	private String termMax;
	private double valueMin;
	private double cost;
	
	//Construtor
	public Shipping(String company, String termMax, double valueMin, double cost) {
		this.cod = GenerateCod();
		this.company = company;
		this.termMax = termMax;
		this.valueMin = valueMin;
		this.cost = cost;
	}

	// Gera um código de 10 caracteres
	public String GenerateCod() {
		String cod = "";
		Random random = new Random();
		int length = 10;
		
		char[] characters = {'Q','W','E','R','T','Y','U','I','O','P','A','S','D','F','G','H','J','K','L','Z','X','C','V','B','N','M','0','1','2','3','4','5','6','7','8','9'};
		
		for(int i = 0; i < length ; i++)cod += characters[random.nextInt(characters.length)];
		
		return cod;
	}
	
	//Método getters e setters
	public String getCod() {
		return cod;
	}

	public void setCod(String id) {
		this.cod = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTermMax() {
		return termMax;
	}

	public void setTermMax(String termMax) {
		this.termMax = termMax;
	}

	public double getValueMin() {
		return valueMin;
	}

	public void setValueMin(double valueMin) {
		this.valueMin = valueMin;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	//Método para exibir os dados para o usuário
	public String toString() {
		return String.format("Código         -> %s \nEmpresa        -> %s \nPrazo máximo   -> %s \nValor mínimo   -> R$ %.2f \nCusto do frete -> R$ %.2f\nTipo           -> Frete\n",cod,company,termMax,valueMin,cost);
	}
	
}
