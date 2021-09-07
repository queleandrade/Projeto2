import java.util.Scanner;

public class Screen {
	// M�todo respons�vel por solicitar um inteiro positivo qualquer para o usu�rio
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
		
	// M�todo respons�vel por solicitar um double para o usu�rio
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
		
	// M�todo respons�vel por solicitar uma String para o usu�rio
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
	
	// M�todo respons�vel por solicitar um valor inteiro dentre as op��es de um menu
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

}
