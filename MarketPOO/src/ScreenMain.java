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
	
	// Método responsável por mostrar na tela as opções do menu Principal
	public void menuPrincipal(){
		System.out.println("*** Menu Principal ***\n");
		System.out.println("(1) Anúncios");
		System.out.println("(2) Fretes");
		System.out.println("(3) Sair\n");
		
		int options[] = {1,2,3};
		
		int option = takeIntInPrompt("Digite a opção desejada -> ","Opção não existente!\n",options,input);
		
		input.nextLine();
		
		System.out.println("\n###################################\n");
		
		if(option == 1) telaAnuncios.menuAnuncios();
		else if(option == 2) telaFretes.menuFretes();
	}
		
}
