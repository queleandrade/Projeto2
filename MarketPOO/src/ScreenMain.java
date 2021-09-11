import java.util.ArrayList;
import java.util.Scanner;

// Classe responsável por renderizar todos os menus do projeto

public class ScreenMain extends Screen {
	protected ScreenShipping telaFretes = new ScreenShipping(this);
	protected ScreenAnnouncement telaAnuncios = new ScreenAnnouncement(this);
	protected ArrayList<Announcement> anuncios = new ArrayList<Announcement>();
	protected ArrayList<Shipping> fretes = new ArrayList<Shipping>();
	protected Scanner input = new Scanner(System.in);
	protected int itensPorPagina = 10;
	protected User usuarioAtual;
	protected ArrayList<User> usuarios = new ArrayList<User>();
	protected ArrayList<Shopping> sales = new ArrayList<Shopping>();

	// Método responsável por mostrar na tela as opções do menu Principal
	public void menuPrincipal(){
		int options[];
		User firstUser = new User("Mateus", "Brasil", "07893080531", "teu@gmail.com", "Amargosa", "123456", "Administrador");
		usuarios.add(firstUser);
		System.out.println("*** Menu Principal ***\n");
		
		System.out.println("Usuário        -> " + (usuarioAtual == null ? "NENHUM" : usuarioAtual.getName()));
		System.out.println("Tipo de acesso -> " + (usuarioAtual == null ? "NÃO LOGADO\n" : usuarioAtual.getType() + "\n"));
		
		System.out.println("(1) Anúncios");
		System.out.println("(2) Fretes");
		System.out.println("(3) Área do ADM");
		System.out.println("(4) Área do Cliente");
		System.out.println("(5) " + (usuarioAtual == null ? "Entrar" : "Sair"));
		if(usuarioAtual == null) {
			System.out.println("(6) Cadastrar-se");
			System.out.println("(7) Fechar Plataforma\n");
		}
		else {
			System.out.println("(6) Fechar Plataforma\n");
		}

		options = usuarioAtual == null ? new int[]{1,2,3,4,5,6,7} : new int[]{1,2,3,4,5,6} ;
		
		int option = takeIntInPrompt("Digite a opção desejada -> ","Opção não existente!\n",options,input);

		input.nextLine();

		System.out.println("\n###################################\n");

		if(option == 1) telaAnuncios.menuListagem(1);
		else if(option == 2) telaFretes.menuListagem(1);
		else if(option == 6 && usuarioAtual == null) cadastrar();
		else if(option == 5 && usuarioAtual != null) {
			usuarioAtual = null;
			menuPrincipal();
		}
		else if(option == 5 && usuarioAtual == null)logar();
		
	}
	
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

	public void cadastrar() {
		System.out.println("*** Cadastro ***\n");
		String name = requestString("Digite seu nome -> ", "Erro no seu nome!\n", input);
		String surname = requestString("Digite seu sobrenome -> ", "Erro no seu sobrenome!\n", input);
		String cpf = requestString("Digite seu CPF -> ", "Erro no seu CPF!\n", input);
		String email = requestString("Digite seu email -> ", "Erro no seu email!\n", input);
		String city = requestString("Digite sua cidade -> ", "Erro na sua cidade!\n", input);
		String password = requestString("Digite sua senha -> ", "Erro na sua senha!\n", input);
		User newUser = new User(name, surname, cpf, email, city, password, "Comum");
		usuarioAtual = newUser;
		usuarios.add(newUser);
		System.out.println("\n###################################\n");
		menuPrincipal();
	}

}
