// SuperClasse de Anúncio contendo atríbutos comuns a todos os anúncios
//Importando a classe java.util.Random, que vai ser utilizada para gerar o código de cada produto referente ao anúncio
import java.util.Random; 

public class Announcement {
	//variavéis de instâncias
	private String cod; 
	private String title;
	private double value;
	private User advertiser;

	//Construtor
	public Announcement(String title, double value, User advertiser) {
		this.cod = GenerateId(); //o método chama o id
		this.title = title;
		this.value = value;
		this.advertiser = advertiser;
	}

	//Métodos getters e setters
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

	// Método responsável por formatar os atributos 'valor' e 'quilometragem'
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


	//Método para gerar o id de forma aleatória
	public String GenerateId() {
		String cod = "";
		Random random = new Random(); //criando o objeto do tipo Random
		int length = 10; //id com 10 caracteres

		//criando um array de caracteres com as letras do alfabeto e com números de 0 à 9
		char[] characters = {'Q','W','E','R','T','Y','U','I','O','P','A','S','D','F','G','H','J','K','L','Z','X','C','V','B','N','M','0','1','2','3','4','5','6','7','8','9'};

		//um laço de repetição para que seja sorteado 10 caracteres
		for(int i = 0; i < length ; i++)cod += characters[random.nextInt(characters.length)];

		return cod;
	}

	//Métodso toString para mostrar os dados para o usuário
	public String toString() {
		return String.format("Título do Anúncio -> %s \nPreço             -> R$ %s \nCódigo            -> %s \nAnunciante        -> %s \n",title,mascara(String.format("%.2f", value * 1.00),"dinheiro"),cod,advertiser.getName());
	}

}
