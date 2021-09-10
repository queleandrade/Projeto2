public class ScreenShipping extends Screen{
	ScreenMain telaPrincipal;
	private int pageFretes;

	public ScreenShipping(ScreenMain telaPrincipal) {
		super();
		this.telaPrincipal = telaPrincipal;
		this.pageFretes = 1;
	}

	// Método responsável por mostrar na tela os detalhes de um Frete e possibilita a edição ou remoção do mesmo
	public void detalharFrete(Shipping item) {
		System.out.println("*** Detalhes do Frete ***\n");
		System.out.println(item);
		System.out.println("(1) Voltar para a Listagem de Fretes\n");

		int options[] = {1};

		takeIntInPrompt("Digite a opção desejada -> ","Opção não existente!\n",options,telaPrincipal.input);

		System.out.println("\n###################################\n");

		menuListagem(pageFretes);
	}

	// Método responsável por mostrar na tela uma listagem de códigos dos Fretes ou Anúncios cadastrados
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

		System.out.printf("Página atual     -> %d\n",atualPage);
		System.out.printf("Total de Páginas -> %d\n\n",totalPages);

		for(contador = 0 ; contador < limitFor ; contador++) {
			int posicaoItem = contador + ((atualPage - 1)*telaPrincipal.itensPorPagina);
			String codigo = telaPrincipal.fretes.get(posicaoItem).getCod();
			String company = telaPrincipal.fretes.get(posicaoItem).getCompany();
			System.out.printf("(%d) %s - %s\n",contador+1,company,codigo);
		}

		if(atualPage == totalPages && totalPages > 1) {
			System.out.printf("(%d) Anterior \n",++contador);
			optionAnt = contador;
		}
		else if (atualPage < totalPages && atualPage == 1) {
			System.out.printf("(%d) Próxima \n",++contador);
			optionProx = contador;
		}
		else if (atualPage < totalPages && atualPage > 1) {
			System.out.printf("(%d) Anterior \n",++contador);
			optionAnt = contador;
			System.out.printf("(%d) Próxima \n",++contador);
			optionProx = contador;
		}

		System.out.printf("(%d) Voltar para Menu Principal\n\n",++contador);

		optionVolt = contador;

		int options[] = new int[contador];

		for(int i = 0; i < contador;i++)options[i] = i + 1;

		int option = takeIntInPrompt("Digite o indice para detalhes -> ","Opção não existente!\n",options,telaPrincipal.input);

		telaPrincipal.input.nextLine();

		System.out.println("\n###################################\n");

		if(option == optionProx)menuListagem(atualPage + 1);
		else if(option == optionAnt)menuListagem(atualPage - 1);
		else if(option == optionVolt)telaPrincipal.menuPrincipal();
		else if(option <= limitFor && option >= 1) {
			int posItem = (option - 1) + ((atualPage - 1)*telaPrincipal.itensPorPagina);
			Shipping itemFrete = telaPrincipal.fretes.get(posItem);
			detalharFrete(itemFrete);
		}
	}

	// Método responsável por encontrar um Frete
	public int findFreteById(String cod) {
		for(int i = 0; i < telaPrincipal.fretes.size(); i++) {
			if(telaPrincipal.fretes.get(i).getCod() == cod)return i;
		}
		return -1;
	}

	// Método responsável por adicionar um novo Frete no ArrayList 'fretes'
	public void addFrete(Shipping item) {
		telaPrincipal.fretes.add(item);
	}

}
