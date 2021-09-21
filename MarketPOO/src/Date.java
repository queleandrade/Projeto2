// Classe que representa uma Data com dia, mês e ano

public class Date {
	//variavéis de instância
	private int year;
	private int month;
	private int day;
	
	//construtor
	//verifica se a data é valida através da classe DateException e o método validarData, sendo valido atribui ao mês, dia e ano
	public Date(int year, int month, int day) {
		DateException.validarData(year, month, day); 
	    this.month = month; 
	    this.day   = day;
	    this.year  = year;
	}

	//Método toString exibe os dados para o usuário
	//Tem um for que acrescenta o número zero na frente do dia e mês caso for menor que 10
	public String toString()
	{ 
		return String.format("%s/%s/%d", (day < 10 ? "0" + day : day), (month < 10 ? "0" + month : month), year); 
	}
}
