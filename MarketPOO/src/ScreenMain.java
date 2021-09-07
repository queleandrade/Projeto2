// Classe respons�vel por renderizar todos os menus do projeto

public class ScreenMain extends Screen {
	ScreenShipping telaFretes = new ScreenShipping(this);
	ScreenAnnouncement telaAnuncios = new ScreenAnnouncement(this);
	
	// M�todo respons�vel por mostrar na tela as op��es do menu Principal
	public void menuPrincipal(){
		System.out.println("*** Menu Principal ***\n");
		System.out.println("(1) An�ncios");
		System.out.println("(2) Fretes");
		System.out.println("(3) Sair\n");
		
		int options[] = {1,2,3};
		
		int option = takeIntInPrompt("Digite a op��o desejada -> ","Op��o n�o existente!\n",options);
		
		input.nextLine();
		
		System.out.println("\n###################################\n");
		
		if(option == 1) telaAnuncios.menuAnuncios();
		else if(option == 2) telaFretes.menuFretes();
	}
		
}
