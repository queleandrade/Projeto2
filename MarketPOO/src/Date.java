// Classe que representa uma Data com dia, m�s e ano

public class Date {
	//variav�is de inst�ncia
	private int year;
	private int month;
	private int day;
	
	//construtor
	//verifica se a data � valida atrav�s da classe DateException e o m�todo validarData, sendo valido atribui ao m�s, dia e ano
	public Date(int year, int month, int day) {
		DateException.validarData(year, month, day); 
	    this.month = month; 
	    this.day   = day;
	    this.year  = year;
	}

	//M�todo toString exibe os dados para o usu�rio
	//Tem um for que acrescenta o n�mero zero na frente do dia e m�s caso for menor que 10
	public String toString()
	{ 
		return String.format("%s/%s/%d", (day < 10 ? "0" + day : day), (month < 10 ? "0" + month : month), year); 
	}
}
