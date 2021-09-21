// SuperClasse de An�ncio contendo atr�butos comuns a todos os an�ncios
//Importando a classe java.util.Random, que vai ser utilizada para gerar o c�digo de cada produto referente ao an�ncio
import java.util.Random; 

public class Announcement {
	//variav�is de inst�ncias
	private String cod; 
	private String title;
	private double value;
	private User advertiser;

	//Construtor
	public Announcement(String title, double value, User advertiser) {
		this.cod = GenerateId(); //o m�todo chama o id
		this.title = title;
		this.value = value;
		this.advertiser = advertiser;
	}

	//M�todos getters e setters
	public User getAdvertiser() {
		return advertiser;
	}

	public void setAdvertiser(User advertiser) {
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

	// M�todo respons�vel por formatar os atributos 'valor' e 'quilometragem'
	public String mascara(String string,String tipo) {

		String valorDecimal = tipo == "dinheiro" ? string.split(",")[1] : "";
		char[] valorInteiro = string.split(",")[0].toCharArray();
		int contador = 1;
		String novoValorInteiro = "";

		for( int i = valorInteiro.length - 1 ; i >= 0 ; i-- ) {
			if( ( contador % 4 ) == 0 ) novoValorInteiro += "." + valorInteiro[i];
			else novoValorInteiro += valorInteiro[i];
			contador++;
		}

		string = "";

		for( int i = novoValorInteiro.toCharArray().length - 1 ; i >= 0 ; i-- )string += novoValorInteiro.toCharArray()[i];

		return tipo == "dinheiro" ? string += "," + valorDecimal : string;
	}


	//M�todo para gerar o id de forma aleat�ria
	public String GenerateId() {
		String cod = "";
		Random random = new Random(); //criando o objeto do tipo Random
		int length = 10; //id com 10 caracteres

		//criando um array de caracteres com as letras do alfabeto e com n�meros de 0 � 9
		char[] characters = {'Q','W','E','R','T','Y','U','I','O','P','A','S','D','F','G','H','J','K','L','Z','X','C','V','B','N','M','0','1','2','3','4','5','6','7','8','9'};

		//um la�o de repeti��o para que seja sorteado 10 caracteres
		for(int i = 0; i < length ; i++)cod += characters[random.nextInt(characters.length)];

		return cod;
	}

	//M�todso toString para mostrar os dados para o usu�rio
	public String toString() {
		return String.format("T�tulo do An�ncio -> %s \nPre�o             -> R$ %s \nC�digo            -> %s \nAnunciante        -> %s \n",title,mascara(String.format("%.2f", value * 1.00),"dinheiro"),cod,advertiser.getName());
	}

}
