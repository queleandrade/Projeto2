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
	protected ArrayList<User> usuarios;
	private ArrayList<Shopping> sales;

	// Método responsável por mostrar na tela as opções do menu Principal
	public void menuPrincipal(){
		int options[];
				
		System.out.println("*** Menu Principal ***\n");
		
		System.out.println("Usuário        -> " + (usuarioAtual == null ? "NENHUM" : usuarioAtual.getName()));
		System.out.println("Tipo de acesso -> " + (usuarioAtual == null ? "NÃO LOGADO\n" : usuarioAtual.getType() + "\n"));
		
		System.out.println("(1) Anúncios");
		System.out.println("(2) Fretes");
		System.out.println("(3) Área do ADM");
		System.out.println("(4) Área do Cliente");
		System.out.println("(5) " + (usuarioAtual == null ? "Entrar" : "Sair"));
		System.out.println("(6) Cadastrar-se");
		System.out.println("(7) Fechar Plataforma\n");

		options = new int[]{1,2,3,4,5,6,7};
		
		int option = takeIntInPrompt("Digite a opção desejada -> ","Opção não existente!\n",options,input);

		input.nextLine();

		System.out.println("\n###################################\n");

		if(option == 1) telaAnuncios.menuListagem(1);
		else if(option == 2) telaFretes.menuListagem(1);
		
	}
	
	public void menuLogin() {

	}

	private void logar() {

	}

	private void deslogar() {

	}

}
