public class ScreenAdministrator extends Screen{
	ScreenMain telaPrincipal;

	public ScreenAdministrator(ScreenMain telaPrincipal) {
		super();
		this.telaPrincipal = telaPrincipal;
	}

	public void telaAdm() {
		System.out.println("*** �rea do ADM ***\n");
		System.out.println("(1) Novo Frete");
		System.out.println("(2) Listar Fretes");
		System.out.println("(3) Relat�rio de vendas");
		System.out.println("(4) Voltar para o Menu Principal\n");

		int[] options = new int[]{1,2,3,4} ;

		int option = takeIntInPrompt("Digite a op��o desejada -> ","Op��o n�o existente!\n",options,telaPrincipal.input);
	
		telaPrincipal.input.nextLine();
		
		System.out.println("\n###################################\n");
		
		if(option == 4)telaPrincipal.menuPrincipal();
	}
}
