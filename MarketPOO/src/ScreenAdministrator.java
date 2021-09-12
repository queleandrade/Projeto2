public class ScreenAdministrator extends Screen{
	ScreenMain telaPrincipal;

	public ScreenAdministrator(ScreenMain telaPrincipal) {
		super();
		this.telaPrincipal = telaPrincipal;
	}

	public void telaAdm() {
		System.out.println("*** Área do ADM ***\n");
		System.out.println("(1) Novo Frete");
		System.out.println("(2) Listar Fretes");
		System.out.println("(3) Relatório de vendas");
		System.out.println("(4) Voltar para o Menu Principal\n");

		int[] options = new int[]{1,2,3,4} ;

		int option = takeIntInPrompt("Digite a opção desejada -> ","Opção não existente!\n",options,telaPrincipal.input);
	
		telaPrincipal.input.nextLine();
		
		System.out.println("\n###################################\n");
		
		if(option == 4)telaPrincipal.menuPrincipal();
	}
}
