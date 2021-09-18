// Classe que representa uma Data com dia, mês e ano

public class Date {
	private int year;
	private int month;
	private int day;
	
	
	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
		DateException.validarData(year, month, day);
	    this.month = month;
	    this.day   = day;
	    this.year  = year;
	}

	public String toString()
	{ 
		return String.format("%s/%s/%d", (day < 10 ? "0" + day : day), (month < 10 ? "0" + month : month), year); 
	}
}
