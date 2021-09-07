public class ScreenShipping extends Screen{
	ScreenMain telaPrincipal;
	private int pageFretes;
	
	public ScreenShipping(ScreenMain telaPrincipal) {
		super();
		this.telaPrincipal = telaPrincipal;
		this.pageFretes = 1;
	}
	
	// M�todo respons�vel por mostrar na tela as op��es gerais de Fretes
	public void menuFretes() {
		System.out.println("*** Menu Fretes ***\n");
		System.out.println("(1) Ver Fretes");
		System.out.println("(2) Novo Frete");
		System.out.println("(3) Voltar para o Menu Principal\n");
			
		int options[] = {1,2,3};
		
		int option = takeIntInPrompt("Digite a op��o desejada -> ","Op��o n�o existente!\n",options,telaPrincipal.input);
			
		telaPrincipal.input.nextLine();
			
		System.out.println("\n###################################\n");
			
		if(option == 1) {
			if(telaPrincipal.fretes.size() > 0) {
				pageFretes = 1;
				menuListagem(1);
			}
			else {
				System.out.println("Info -> Nenhum Frete foi cadastrado ainda!\n");
				System.out.println("###################################\n");
				menuFretes();
			}
		}
		else if(option == 2) telaNovoFrete();
		else if(option == 3) telaPrincipal.menuPrincipal();
	}
		
	// M�todo respons�vel por mostrar na tela os detalhes de um Frete e possibilita a edi��o ou remo��o do mesmo
	public void detalharFrete(Shipping item) {
		boolean goBack = false;
		boolean delete = false;
			
		System.out.println("*** Detalhes do Frete ***\n");
		System.out.println(item);
		System.out.println("(1) Alterar Empresa");
		System.out.println("(2) Alterar Prazo m�ximo");
		System.out.println("(3) Alterar Valor m�nimo");
		System.out.println("(4) Alterar Custo do frete");
		System.out.println("(5) Deletar Frete");
		System.out.println("(6) Voltar para a Listagem de Fretes\n");
			
		int options[] = {1,2,3,4,5,6};
			
		int option = takeIntInPrompt("Digite a op��o desejada -> ","Op��o n�o existente!\n",options,telaPrincipal.input);
			
		telaPrincipal.input.nextLine();
			
		if(option == 1) {
			String newCompany = requestString("\nDigite a nova Empresa -> ","Problema com a nova Empresa!",telaPrincipal.input);
			item.setCompany(newCompany);
		}
		else if(option == 2) {
			String newTermMax = requestString("\nDigite o novo Prazo m�ximo -> ","Problema com o novo Prazo m�ximo!",telaPrincipal.input);
			item.setTermMax(newTermMax);
		}
		else if(option == 3) {
			double newValueMin = requestDouble("\nDigite o novo Valor m�nimo -> ","Problema com o novo Valor m�nimo!",telaPrincipal.input);
			item.setValueMin(newValueMin);
		}
		else if(option == 4) {
			double newCost = requestDouble("\nDigite o novo Custo do frete -> ","Problema com o novo Custo do frete!",telaPrincipal.input);
			item.setCost(newCost);
		}
		else if(option == 5) {
			int pos = findFreteById(item.getCod());
			telaPrincipal.fretes.remove(pos);
			delete = true;
		}
		else if(option == 6) goBack = true;
			
		System.out.println("\n###################################\n");
			
		if(goBack)menuListagem(pageFretes);
		else if(delete)telaPrincipal.telaFretes.menuFretes();
		else detalharFrete(item);
	}

	// M�todo respons�vel por solicitar ao usu�rio as informa��es necess�rias para criar um novo Frete
	public void telaNovoFrete() {
		System.out.println("*** Novo Frete ***\n");
			
		String company = requestString("Nome da Empresa -> ", "Problema com o Nome da Empresa!\n",telaPrincipal.input);
			
		String termMax = requestString("Prazo m�ximo    -> ","Problema com o Prazo m�ximo!\n",telaPrincipal.input);
				
		double valueMin = requestDouble("Valor m�nimo    -> R$","Problema com o Valor m�nimo!\n",telaPrincipal.input);

		double cost = requestDouble("Custo           -> R$","Problema com o Custo\n",telaPrincipal.input);
				
		telaPrincipal.input.nextLine();
			
		Shipping newFrete = new Shipping(company, termMax, valueMin, cost);
				
		addFrete(newFrete);
				
		System.out.println("\n###################################\n");
				
		menuFretes();
	}

	// M�todo respons�vel por mostrar na tela uma listagem de c�digos dos Fretes ou An�ncios cadastrados
	public void menuListagem(int page) {
		int contador;
			
		int atualPage = pageFretes;
			
		int total = telaPrincipal.fretes.size();
		
		int totalPages = (int) Math.ceil((float)total/telaPrincipal.itensPorPagina);
			
		atualPage = page < 1 ? 1 : (page > totalPages ? totalPages : page);
			
		pageFretes = atualPage;
			
		int limitFor = atualPage == totalPages ? (total - (totalPages - 1)*telaPrincipal.itensPorPagina) : telaPrincipal.itensPorPagina;
			
		int optionProx = -1;
			
		int optionAnt = -1;
			
		int optionVolt = -1;
			
		System.out.println("*** Lista de Fretes ***\n");
			
		System.out.printf("P�gina atual     -> %d\n",atualPage);
		System.out.printf("Total de P�ginas -> %d\n\n",totalPages);
			
		for(contador = 0 ; contador < limitFor ; contador++) {
			int posicaoItem = contador + ((atualPage - 1)*telaPrincipal.itensPorPagina);
			String codigo = telaPrincipal.fretes.get(posicaoItem).getCod();
			System.out.printf("(%d) %s\n",contador+1,codigo);
		}
			
		if(atualPage == totalPages && totalPages > 1) {
			System.out.printf("(%d) Anterior \n",++contador);
			optionAnt = contador;
		}
		else if (atualPage < totalPages && atualPage == 1) {
			System.out.printf("(%d) Pr�xima \n",++contador);
			optionProx = contador;
		}
		else if (atualPage < totalPages && atualPage > 1) {
			System.out.printf("(%d) Anterior \n",++contador);
			optionAnt = contador;
			System.out.printf("(%d) Pr�xima \n",++contador);
			optionProx = contador;
		}
			
		System.out.printf("(%d) Voltar para Menu de Fretes\n\n",++contador);
			
		optionVolt = contador;
		
		int options[] = new int[contador];
			
		for(int i = 0; i < contador;i++)options[i] = i + 1;
			
		int option = takeIntInPrompt("Digite o indice para detalhes -> ","Op��o n�o existente!\n",options,telaPrincipal.input);
			
		telaPrincipal.input.nextLine();
			
		System.out.println("\n###################################\n");
			
		if(option == optionProx)menuListagem(atualPage + 1);
		else if(option == optionAnt)menuListagem(atualPage - 1);
		else if(option == optionVolt)menuFretes();
		else if(option <= limitFor && option >= 1) {
			int posItem = (option - 1) + ((atualPage - 1)*telaPrincipal.itensPorPagina);
			Shipping itemFrete = telaPrincipal.fretes.get(posItem);
			detalharFrete(itemFrete);
		}
	}
	
	// M�todo respons�vel por encontrar um Frete
	public int findFreteById(String cod) {
		for(int i = 0; i < telaPrincipal.fretes.size(); i++) {
			if(telaPrincipal.fretes.get(i).getCod() == cod)return i;
		}
		return -1;
	}
	
	// M�todo respons�vel por adicionar um novo Frete no ArrayList 'fretes'
	public void addFrete(Shipping item) {
		telaPrincipal.fretes.add(item);
	}
}
