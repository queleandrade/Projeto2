//DateException subclasse de RuntimeException com o objetivo de lan�ar exe��es com mensagem de detalhe especificada

public class DateException extends RuntimeException{
	
	private static final long serialVersionUID = 1L; //identificador de vers�o universal para uma classe Serializable

	//construtor da classed DateException
	public DateException(String msg) {
		super(msg); //referenciando a classe pai
	}

	// M�todo criado para tratar erro no CPF
	public static void validarData(int year, int month, int day) {
		int[] daysPerMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};//os dias referentes ao m�s
		
		//throws DateException para verificar uma data inv�lida
		
		//verifica se o m�s est� no intervalo de Janeiro � dezembro (1 � 12) e valida
		if(month <= 0 || month > 12)throw new DateException("M�s (" + month + ") fora do intervalo 1-12"); 
		
		//verifica se o dia est� dentro do intervalo de dia de cada m�s e valida
	    if(day <= 0 || (day > daysPerMonth[month] && !(month == 2 && day == 29)))throw new DateException("Dia (" + day + ") n�o existe para esse m�s e ano");

	    //verifica se o ano � v�lido
	    if(month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))throw new DateException("Dia (" + day + ") n�o existe para esse m�s e ano");
	    
	    //verifica se o ano � negativo e lan�a a mensagem
	    if(year < 0 )throw new DateException("Ano n�o pode ser negativo");
	}

}
