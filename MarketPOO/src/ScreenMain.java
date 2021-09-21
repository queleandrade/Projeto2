import java.util.ArrayList;
import java.util.Scanner;

// Classe respons�vel por renderizar todos os menus do projeto

public class ScreenMain extends Screen {

	//cria os objetos protegidos de cada classe referente as telas
	protected ScreenShipping telaFretes = new ScreenShipping(this);
	protected ScreenAnnouncement telaAnuncios = new ScreenAnnouncement(this);
	protected ScreenAdministrator telaAdm = new ScreenAdministrator(this);
	protected ScreenClient telaCliente = new ScreenClient(this);

	//cria os array list das classes anuncios, fretes, usuarios e vendas
	protected ArrayList<Announcement> anuncios = new ArrayList<Announcement>();
	protected ArrayList<Shipping> fretes = new ArrayList<Shipping>();
	protected ArrayList<User> usuarios = new ArrayList<User>();
	protected ArrayList<Shopping> vendas = new ArrayList<Shopping>();

	protected Scanner input = new Scanner(System.in);
	protected int itensPorPagina = 10;
	protected User usuarioAtual;

	// M�todo respons�vel por mostrar na tela as op��es do menu Principal
	public void menuPrincipal(){
		int optionEntrar = -1;
		int optionCadastrar = -1;
		int optionAreaAdm = -1;
		int optionAreaCliente = -1;
		int optionSair = -1;

		int options[];

		System.out.println("*** Menu Principal ***\n");

		System.out.println("Usu�rio        -> " + (usuarioAtual == null ? "NENHUM" : usuarioAtual.getName()));
		System.out.println("Tipo de acesso -> " + (usuarioAtual == null ? "N�O LOGADO\n" : usuarioAtual.getType() + "\n"));

		System.out.println("(1) An�ncios");
		System.out.println("(2) Fretes");

		if(usuarioAtual == null) {
			System.out.println("(3) Entrar");
			System.out.println("(4) Cadastrar-se");
			System.out.println("(5) Fechar Plataforma\n");
			optionEntrar = 3;
			optionCadastrar = 4;
			options = new int[]{1,2,3,4,5};

		}
		else if(usuarioAtual.getType().compareTo("Admnistrador") == 0) {
			System.out.println("(3) �rea do ADM");
			System.out.println("(4) �rea do Cliente");
			System.out.println("(5) Sair");
			System.out.println("(6) Fechar Plataforma\n");
			optionAreaAdm = 3;
			optionAreaCliente = 4;
			optionSair = 5;
			options = new int[]{1,2,3,4,5,6};
		}
		else {
			System.out.println("(3) �rea do Cliente");
			System.out.println("(4) Sair");
			System.out.println("(5) Fechar Plataforma\n");
			optionAreaCliente = 3;
			optionSair = 4;
			options = new int[]{1,2,3,4,5};
		}

		int option = takeIntInPrompt("Digite a op��o desejada -> ","Op��o n�o existente!\n",options,input);

		input.nextLine();

		System.out.println("\n###################################\n");

		if(option == 1) {
			if(anuncios.size() == 0) {
				System.out.println("Info -> Nenhum an�ncio cadastrado\n");
				System.out.println("###################################\n");
				menuPrincipal();
			}
			else telaAnuncios.menuListagem(1);
		}
		else if(option == 2) {
			if(fretes.size() == 0) {
				System.out.println("Info -> Nenhum frete cadastrado\n");
				System.out.println("###################################\n");
				menuPrincipal();
			}
			else telaFretes.menuListagem(1);
		}
		else if(option == optionCadastrar) cadastrar();
		else if(option == optionEntrar)logar();
		else if(option == optionAreaAdm)telaAdm.telaAdm();
		else if(option == optionAreaCliente)telaCliente.telaCliente();
		else if(option == optionSair) {
			usuarioAtual = null;
			menuPrincipal();
		}

	}

	//M�todo responsav�l pelo logindo usu�rio
	public void logar() {
		System.out.println("*** Login ***\n");
		String email = requestString("Digite seu email -> ", "Erro no seu email!\n", input);
		String password = requestString("Digite sua senha -> ", "Erro na sua senha!\n", input);
		boolean findUser = false;
		for(int i = 0; i < usuarios.size() && !findUser; i++) {
			User currentUser = usuarios.get(i);
			if(currentUser.getEmail().compareTo(email) == 0 && currentUser.getPassword().compareTo(password) == 0) {
				usuarioAtual = currentUser;
				findUser = true;
			}
		}
		if(!findUser)System.out.println("\nErro -> Email ou Senha incorreta");
		System.out.println("\n###################################\n");
		menuPrincipal();
	}

	//M�todo responsav�l pelo cadastro do usu�rio
	public void cadastrar() {
		System.out.println("*** Cadastro ***\n");
		String name = requestString("Digite seu nome -> ", "Erro no seu nome!\n", input);
		String surname = requestString("Digite seu sobrenome -> ", "Erro no seu sobrenome!\n", input);
		
		boolean flagCpfValido =  true;
		String cpf = "";
		
		while(flagCpfValido) {
			cpf = requestString("Digite seu CPF -> ", "Erro no seu CPF!\n", input);
			try {
				InfosException.validarCPF(cpf);
				flagCpfValido = false;
			}catch(Exception e) {
				flagCpfValido = true;
				System.out.println("\nErro -> Erro no seu CPF\n");
			}
		}
		
		String email = requestString("Digite seu email -> ", "Erro no seu email!\n", input);
		String city = requestString("Digite sua cidade -> ", "Erro na sua cidade!\n", input);
		String password = requestString("Digite sua senha -> ", "Erro na sua senha!\n", input);
		User newUser = new User(name, surname, cpf, email, city, password, "Comum");
		usuarioAtual = newUser;
		usuarios.add(newUser);
		System.out.println("\n###################################\n");
		menuPrincipal();
	}

	// M�todo respons�vel por encontrar um An�ncio
	public int findAnuncioById(String cod) {
		for(int i = 0; i < anuncios.size(); i++) {
			if(anuncios.get(i).getCod().compareTo(cod) == 0)return i;
		}
		return -1;
	}
	
	public int findFreteById(String cod) {
		for(int i = 0; i < fretes.size(); i++) {
			if(fretes.get(i).getCod().compareTo(cod) == 0)return i;
		}
		return -1;
	}

}
