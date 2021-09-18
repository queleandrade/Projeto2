public class DateException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public DateException(String msg) {
		super(msg);
	}

	// M�todo criado para tratar erro no CPF
	public static void validarData(int year, int month, int day) {
		int[] daysPerMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		if(month <= 0 || month > 12)throw new DateException("M�s (" + month + ") fora do intervalo 1-12");

	    if(day <= 0 || (day > daysPerMonth[month] && !(month == 2 && day == 29)))throw new DateException("Dia (" + day + ") n�o existe para esse m�s e ano");

	    if(month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))throw new DateException("Dia (" + day + ") n�o existe para esse m�s e ano");
	    
	    if(year < 0 )throw new DateException("Ano n�o pode ser negativo");
	}

}
