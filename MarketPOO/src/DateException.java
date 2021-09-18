public class DateException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public DateException(String msg) {
		super(msg);
	}

	// Método criado para tratar erro no CPF
	public static void validarData(int year, int month, int day) {
		int[] daysPerMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		if(month <= 0 || month > 12)throw new DateException("Mês (" + month + ") fora do intervalo 1-12");

	    if(day <= 0 || (day > daysPerMonth[month] && !(month == 2 && day == 29)))throw new DateException("Dia (" + day + ") não existe para esse mês e ano");

	    if(month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))throw new DateException("Dia (" + day + ") não existe para esse mês e ano");
	    
	    if(year < 0 )throw new DateException("Ano não pode ser negativo");
	}

}
