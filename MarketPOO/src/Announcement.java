// SuperClasse de Anúncio contendo atríbutos comuns a todos os anúncios

import java.util.Random;

public class Announcement {
	private String cod;
	private String title;
	private double value;
	private User advertiser;

	public User getAdvertiser() {
		return advertiser;
	}

	public void setAdvertiser(User advertiser) {
		this.advertiser = advertiser;
	}

	public Announcement(String title, double value, User advertiser) {
		this.cod = GenerateId();
		this.title = title;
		this.value = value;
		this.advertiser = advertiser;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String id) {
		this.cod = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String GenerateId() {
		String cod = "";
		Random random = new Random();
		int length = 10;

		char[] characters = {'Q','W','E','R','T','Y','U','I','O','P','A','S','D','F','G','H','J','K','L','Z','X','C','V','B','N','M','0','1','2','3','4','5','6','7','8','9'};

		for(int i = 0; i < length ; i++)cod += characters[random.nextInt(characters.length)];

		return cod;
	}

	public String toString() {
		return String.format("Título do Anúncio -> %s \nPreço             -> R$ %.2f \nCódigo            -> %s \nAnunciante        -> %s \n",title,value,cod,advertiser.getName());
	}

}
