import java.util.ArrayList;

// Classe responsável por realizar testes do sistema

public class TesteDeSistema {

	static ArrayList<Announcement> anuncios = new ArrayList<Announcement>();
	static ArrayList<Shipping> fretes = new ArrayList<Shipping>();
	static ArrayList<User> usuarios = new ArrayList<User>();
	static ArrayList<Shopping> vendas = new ArrayList<Shopping>();

	public static void main(String[] args) {

		System.out.println("#######################################\n");
		System.out.println("1 - Testes de Criação de Usuários\n");
		testarNovoUsuario("Mateus","Brasil","07893080531","teu@gmail.com","Amargosa","123456","Admnistrador");
		testarNovoUsuario("Lucas","Alencar","07225925580","lucas@gmail.com","Amargosa","123456","Comum");

		System.out.println("#######################################\n");
		System.out.println("2 - Testes de Criação de Anúncios\n");
		testeNovoAnuncio("Coleção C.S. Lewis", 125.80, "Coleção de Livros de C.S. Lewis",usuarios.get(0));
		testeNovoAnuncio("Coleção Adam Smith", 170.85, "Coleção de Livros de Adam Smith",usuarios.get(1));
		testeNovoAnuncio("Coleção Machado de Assis", 235.50, "Coleção de Livros de Machado de Assis",usuarios.get(0));

		System.out.println("#######################################\n");
		System.out.println("3 - Testes de Listagem dos Anúncios\n");
		testeListarAnuncios();

		System.out.println("#######################################\n");
		System.out.println("4 - Testes de Criação de Fretes\n");
		testeNovoFrete("Correios","10 dias",250,10);
		testeNovoFrete("Mercado livre","5 dias",400,40);
		testeNovoFrete("Sedex","2 dias",500,60);
		testeNovoFrete("FedEx","1 dias",800,100);

		System.out.println("#######################################\n");
		System.out.println("5 - Testes de Listagem dos Fretes\n");
		testeListarFretes();

		System.out.println("#######################################\n");
		System.out.println("6 - Testes de Compras\n");
		testeComprar(anuncios.get(0),usuarios.get(0),usuarios.get(1),fretes.get(1),5);
		testeComprar(anuncios.get(1),usuarios.get(1),usuarios.get(0),fretes.get(2),2);
		testeComprar(anuncios.get(2),usuarios.get(1),usuarios.get(0),fretes.get(0),1);

		System.out.println("#######################################\n");
		System.out.println("7 - Testes de Listagem das Compras\n");
		testeListarVendas();

		System.out.println("#######################################\n");
		System.out.println("8 - Testes de Ver taxas\n");
		testeCalcularTaxas();

	}

	// Método responsável por testar a criação de um novo Anúncio
	public static void testeNovoAnuncio(String title,double value,String bookCollectionName,User usuarioAdm) {
		System.out.println("*** Criando um Anúncio ***\n");
		AnnouncementBookCollection anuncioTeste = new AnnouncementBookCollection(title, value,usuarioAdm, bookCollectionName);
		anuncios.add(anuncioTeste);
		System.out.println(anuncioTeste);
		System.out.println("---------------------------------------\n");
	}

	// Método responsável por testar a criação de um novo Frete
	public static void testeNovoFrete(String company,String termMax,double valueMin,double cost) {
		System.out.println("*** Criando um Frete ***\n");
		Shipping freteTeste = new Shipping(company, termMax, valueMin, cost);
		fretes.add(freteTeste);
		System.out.println(freteTeste);
		System.out.println("---------------------------------------\n");
	}

	public static void testeListarAnuncios() {
		for(int i = 0 ; i < anuncios.size(); i++) {
			System.out.println(anuncios.get(i));
			System.out.println("---------------------------------------\n");
		}
	}

	public static void testarNovoUsuario(String name,String surname,String cpf,String email,String city,String password,String type) {
		System.out.println("*** Criando um Usuário ***");
		User usuario = new User(name, surname, cpf, email, city, password, type);
		usuarios.add(usuario);
		System.out.println(usuario);
		System.out.println("\n---------------------------------------\n");
	}

	public static void testeListarFretes() {
		for(int i = 0 ; i < fretes.size(); i++) {
			System.out.println(fretes.get(i));
			System.out.println("---------------------------------------\n");
		}
	}

	public static void testeComprar(Announcement product,User buyer,User salesman,Shipping shipping,int quantity) {
		System.out.println("*** Realizando uma Compra ***\n");
		Shopping compra = new Shopping(product, buyer, salesman, shipping, quantity);
		vendas.add(compra);
		System.out.println(compra);
		System.out.println("\n---------------------------------------\n");
	}

	public static void testeListarVendas() {
		for(int i = 0 ; i < vendas.size(); i++) {
			System.out.println(vendas.get(i));
			System.out.println("\n---------------------------------------\n");
		}
	}

	// Método responsável por formatar os atributos 'valor' e 'quilometragem'
	public static String mascara(String string,String tipo) {

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

	public static void testeCalcularTaxas() {
		double valorTotal = 0;
		double taxaTotal = 0;
		for(int i = 0; i < vendas.size();i++)valorTotal += vendas.get(i).valorTotal();

		taxaTotal = valorTotal * 0.05;

		System.out.printf("Valor total de vendas -> R$ %s\n",mascara(String.format("%.2f",valorTotal),"dinheiro"));
		System.out.printf("Valor total de taxas  -> R$ %s\n",mascara(String.format("%.2f",taxaTotal),"dinheiro"));
		System.out.println("\n###################################\n");

	}


}
