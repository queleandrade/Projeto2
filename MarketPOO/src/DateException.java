//DateException subclasse de RuntimeException com o objetivo de lançar exeções com mensagem de detalhe especificada

public class DateException extends RuntimeException{
	
	private static final long serialVersionUID = 1L; //identificador de versão universal para uma classe Serializable

	//construtor da classed DateException
	public DateException(String msg) {
		super(msg); //referenciando a classe pai
	}

	// Método criado para tratar erro no CPF
	public static void validarData(int year, int month, int day) {
		int[] daysPerMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};//os dias referentes ao mês
		
		//throws DateException para verificar uma data inválida
		
		//verifica se o mês está no intervalo de Janeiro à dezembro (1 à 12) e valida
		if(month <= 0 || month > 12)throw new DateException("Mês (" + month + ") fora do intervalo 1-12"); 
		
		//verifica se o dia está dentro do intervalo de dia de cada mês e valida
	    if(day <= 0 || (day > daysPerMonth[month] && !(month == 2 && day == 29)))throw new DateException("Dia (" + day + ") não existe para esse mês e ano");

	    //verifica se o ano é válido
	    if(month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))throw new DateException("Dia (" + day + ") não existe para esse mês e ano");
	    
	    //verifica se o ano é negativo e lança a mensagem
	    if(year < 0 )throw new DateException("Ano não pode ser negativo");
	}

}
