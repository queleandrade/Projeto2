// Classe responsável por renderizar todos os menus do projeto

public class ScreenMain extends Screen {
	ScreenShipping telaFretes = new ScreenShipping(this);
	ScreenAnnouncement telaAnuncios = new ScreenAnnouncement(this);
	
	// Método responsável por mostrar na tela as opções do menu Principal
	public void menuPrincipal(){
		System.out.println("*** Menu Principal ***\n");
		System.out.println("(1) Anúncios");
		System.out.println("(2) Fretes");
		System.out.println("(3) Sair\n");
		
		int options[] = {1,2,3};
		
		int option = takeIntInPrompt("Digite a opção desejada -> ","Opção não existente!\n",options);
		
		input.nextLine();
		
		System.out.println("\n###################################\n");
		
		if(option == 1) telaAnuncios.menuAnuncios();
		else if(option == 2) telaFretes.menuFretes();
	}
		
}
