// Classe que representa uma Data com dia, mês e ano

public class Date {
	private int year;
	private int month;
	private int day;
	private static final int[] daysPerMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
		
		if(month <= 0 || month > 12)throw new IllegalArgumentException("Mês (" + month + ") fora do intervalo 1-12");

	    if(day <= 0 || (day > daysPerMonth[month] && !(month == 2 && day == 29)))throw new IllegalArgumentException("Dia (" + day + ") não existe para esse mês e ano");

	    if(month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))throw new IllegalArgumentException("Dia (" + day + ") não existe para esse mês e ano");
	    
	    if(year < 0 )throw new IllegalArgumentException("Ano não pode ser negativo");
	      
	      this.month = month;
	      this.day   = day;
	      this.year  = year;
	}

	public String toString()
	{ 
		return String.format("%s/%s/%d", (day < 10 ? "0" + day : day), (month < 10 ? "0" + month : month), year); 
	}
}
