import java.util.ArrayList;
import java.util.Scanner;

public class Screen {
	protected ArrayList<Announcement> anuncios = new ArrayList<Announcement>();
	protected ArrayList<Shipping> fretes = new ArrayList<Shipping>();
	protected Scanner input = new Scanner(System.in);
	protected int itensPorPagina = 10;
	
	// Método responsável por solicitar um inteiro positivo qualquer para o usuário
	public int requestInt(String question,String msgError) {
		System.out.print(question);
		int value = -1;
			
		try {
			value = input.nextInt();
			if(value <= 0) {
				System.out.printf("\nErro -> %s\n",msgError);
				value = requestInt(question,msgError);
			}
		}catch(Exception e) {
			System.out.printf("\nErro -> %s\n",msgError);
			input.nextLine();
			value = requestInt(question,msgError);
		}
			
		return value;
	}
		
	// Método responsável por solicitar um double para o usuário
	public double requestDouble(String question,String msgError) {
		System.out.print(question);
		double value = -1;
			
		try {
			value = input.nextDouble();
			if(value <= 0) {
				System.out.printf("\nErro -> %s\n",msgError);
				value = requestDouble(question,msgError);
			}
		}catch(Exception e) {
			System.out.printf("\nErro -> %s\n",msgError);
			input.nextLine();
			value = requestDouble(question,msgError);
		}
			
		return value;
	}
		
	// Método responsável por solicitar uma String para o usuário
	public String requestString(String question,String msgError) {
		System.out.print(question);
		String value = "";
			
		try {
			value = input.nextLine();
			if(value == "") {
				System.out.printf("\nErro -> %s\n",msgError);
				value = requestString(question,msgError);
			}
		}catch(Exception e) {
			System.out.printf("\nErro -> %s\n",msgError);
			input.nextLine();
			value = requestString(question,msgError);
		}
			
		return value;
	}
	
	// Método responsável por adicionar um novo Anúncio no ArrayList 'anuncios'
	public void addAnuncio(Announcement item) {
		anuncios.add(item);
	}

	// Método responsável por adicionar um novo Frete no ArrayList 'fretes'
	public void addFrete(Shipping item) {
		fretes.add(item);
	}
		
	// Método responsável por solicitar um valor inteiro dentre as opções de um menu
	public int takeIntInPrompt(String question,String msgError,int options[]) {
		System.out.print(question);
		int value = -1;
			
		try {
			value = input.nextInt();
			boolean isValid = false;
			for(int i = 0; i < options.length;i++) if(options[i] == value)isValid = true;
			if(!isValid) {
				System.out.printf("\nErro -> %s\n",msgError);
				value = takeIntInPrompt(question,msgError,options);
			}
				
		}catch(Exception e) {
			System.out.printf("\nErro -> %s\n",msgError);
			input.nextLine();
			value = takeIntInPrompt(question,msgError,options);
		}
			
		return value;
	}

}
