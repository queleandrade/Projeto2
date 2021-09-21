//Classe Screen 
import java.util.Scanner;

public class Screen {

	// Método responsável por solicitar um inteiro positivo qualquer para o usuário
	public int requestInt(String question,String msgError,Scanner input) {
		System.out.print(question);
		int value = -1;

		try {
			value = input.nextInt();
			if(value <= 0) {
				System.out.printf("\nErro -> %s\n",msgError);
				value = requestInt(question,msgError,input);
			}
		}catch(Exception e) {
			System.out.printf("\nErro -> %s\n",msgError);
			input.nextLine();
			value = requestInt(question,msgError,input);
		}

		return value;
	}

	// Método responsável por solicitar um double para o usuário
	public double requestDouble(String question,String msgError,Scanner input) {
		System.out.print(question);
		double value = -1;

		try {
			value = input.nextDouble();
			if(value <= 0) {
				System.out.printf("\nErro -> %s\n",msgError);
				value = requestDouble(question,msgError,input);
			}
		}catch(Exception e) {
			System.out.printf("\nErro -> %s\n",msgError);
			input.nextLine();
			value = requestDouble(question,msgError,input);
		}

		return value;
	}

	// Método responsável por solicitar uma String para o usuário
	public String requestString(String question,String msgError,Scanner input) {
		System.out.print(question);
		String value = "";

		try {
			value = input.nextLine();
			if(value == "") {
				System.out.printf("\nErro -> %s\n",msgError);
				value = requestString(question,msgError,input);
			}
		}catch(Exception e) {
			System.out.printf("\nErro -> %s\n",msgError);
			input.nextLine();
			value = requestString(question,msgError,input);
		}

		return value;
	}

	// Método responsável por solicitar um valor inteiro dentre as opções de um menu
	public int takeIntInPrompt(String question,String msgError,int options[],Scanner input) {
		System.out.print(question);
		int value = -1;

		try {
			value = input.nextInt();
			boolean isValid = false;
			for(int i = 0; i < options.length;i++) if(options[i] == value)isValid = true;
			if(!isValid) {
				System.out.printf("\nErro -> %s\n",msgError);
				value = takeIntInPrompt(question,msgError,options,input);
			}

		}catch(Exception e) {
			System.out.printf("\nErro -> %s\n",msgError);
			input.nextLine();
			value = takeIntInPrompt(question,msgError,options,input);
		}

		return value;
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

}
