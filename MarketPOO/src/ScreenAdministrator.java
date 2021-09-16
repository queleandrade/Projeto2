public class ScreenAdministrator extends Screen{
	ScreenMain telaPrincipal;
	private int pageFretes;
	private int pageCompras;
	
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
		if(option == 1)telaNovoFrete();
		else if(option == 2) {
			if(telaPrincipal.fretes.size() == 0) {
				System.out.println("Info -> Nenhum frete cadastrado\n");
				System.out.println("###################################\n");
				telaAdm();
			}
			else menuListagem(1,"fretes");
		}
		else if(option == 3) {
			if(telaPrincipal.vendas.size() == 0) {
				System.out.println("Info -> Nenhuma venda realizada\n");
				System.out.println("###################################\n");
				telaAdm();
			}
			else menuRelatorios();
		}
		else if(option == 4)telaPrincipal.menuPrincipal();
	}

	public void menuRelatorios() {
		System.out.println("*** Relatórios ***\n");
		System.out.println("(1) Ver todas as compras");
		System.out.println("(2) Ver total de taxa sobre vendas");
		System.out.println("(3) Voltar para a Área do ADM\n");
		
		int[] options = new int[]{1,2,3} ;

		int option = takeIntInPrompt("Digite a opção desejada -> ","Opção não existente!\n",options,telaPrincipal.input);

		telaPrincipal.input.nextLine();

		System.out.println("\n###################################\n");
		
		if(option == 1)menuListagem(1,"compras");
		else if(option == 2)relatorioTaxa();
		else if(option == 3)telaAdm();
	}
	
	// Método responsável por solicitar ao usuário as informações necessárias para criar um novo Frete
	public void telaNovoFrete() {
		System.out.println("*** Novo Frete ***\n");

		String company = requestString("Nome da Empresa -> ", "Problema com o Nome da Empresa!\n",telaPrincipal.input);

		String termMax = requestString("Prazo máximo    -> ","Problema com o Prazo máximo!\n",telaPrincipal.input);

		double valueMin = requestDouble("Valor mínimo    -> R$","Problema com o Valor mínimo!\n",telaPrincipal.input);

		double cost = requestDouble("Custo           -> R$","Problema com o Custo\n",telaPrincipal.input);

		telaPrincipal.input.nextLine();

		Shipping newFrete = new Shipping(company, termMax, valueMin, cost);

		addFrete(newFrete);

		System.out.println("\n###################################\n");

		telaAdm();
	}

	// Método responsável por adicionar um novo Frete no ArrayList 'fretes'
	public void addFrete(Shipping item) {
		telaPrincipal.fretes.add(item);
	}

	// Método responsável por mostrar na tela uma listagem de códigos dos Fretes ou Anúncios cadastrados
	public void menuListagem(int page,String type) {
		int contador;

		int atualPage = type == "fretes" ? pageFretes : pageCompras;

		int total = type == "fretes" ? telaPrincipal.fretes.size() : telaPrincipal.vendas.size();

		int totalPages = (int) Math.ceil((float)total/telaPrincipal.itensPorPagina);

		atualPage = page < 1 ? 1 : (page > totalPages ? totalPages : page);

		if(type == "fretes")pageFretes = atualPage;
		else pageCompras = atualPage;

		int limitFor = atualPage == totalPages ? (total - (totalPages - 1)*telaPrincipal.itensPorPagina) : telaPrincipal.itensPorPagina;

		int optionProx = -1;

		int optionAnt = -1;

		int optionVolt = -1;

		System.out.printf("*** Lista de %s ***\n\n",type == "fretes" ? "Fretes" : "Compras");

		System.out.printf("Página atual     -> %d\n",atualPage);
		System.out.printf("Total de Páginas -> %d\n",totalPages);
		
		if(type == "fretes")System.out.printf("Total de Fretes  -> %d\n\n",total);
		else System.out.printf("Total de Compras -> %d\n\n",total);
		
		for(contador = 0 ; contador < limitFor ; contador++) {
			int posicaoItem = contador + ((atualPage - 1)*telaPrincipal.itensPorPagina);
			if(type == "fretes") {
				String codigo = telaPrincipal.fretes.get(posicaoItem).getCod();
				String company = telaPrincipal.fretes.get(posicaoItem).getCompany();
				System.out.printf("(%d) %s - %s\n",contador+1,company,codigo);
			}
			else {
				Shopping compra = telaPrincipal.vendas.get(posicaoItem);
				System.out.printf("(%d) Produto: %s - Quantidade: %s\n",contador + 1,compra.getProductName(),compra.getQuantity());
			}
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

		System.out.printf("(%d) Voltar para %s\n\n",++contador,type == "fretes" ? "Área do ADM" : "Relatórios");

		optionVolt = contador;

		int options[] = new int[contador];

		for(int i = 0; i < contador;i++)options[i] = i + 1;

		int option = takeIntInPrompt("Digite o indice para detalhes -> ","Opção não existente!\n",options,telaPrincipal.input);

		telaPrincipal.input.nextLine();

		System.out.println("\n###################################\n");

		if(option == optionProx)menuListagem(atualPage + 1,type);
		else if(option == optionAnt)menuListagem(atualPage - 1,type);
		else if(option == optionVolt) {
			if(type == "fretes")telaAdm();
			else menuRelatorios();
		}
		else if(option <= limitFor && option >= 1) {
			int posItem = (option - 1) + ((atualPage - 1)*telaPrincipal.itensPorPagina);
			if(type == "fretes") {
				Shipping itemFrete = telaPrincipal.fretes.get(posItem);
				detalharFrete(itemFrete);
			}
			else {
				Shopping itemCompra = telaPrincipal.vendas.get(posItem);
				detalharCompra(itemCompra);
			}
		}
	}

	// Método responsável por mostrar na tela os detalhes de um Frete e possibilita a edição ou remoção do mesmo
	public void detalharFrete(Shipping item) {
		boolean goBack = false;
		boolean delete = false;

		System.out.println("*** Detalhes do Frete ***\n");
		System.out.println(item);
		System.out.println("(1) Alterar Empresa");
		System.out.println("(2) Alterar Prazo máximo");
		System.out.println("(3) Alterar Valor mínimo");
		System.out.println("(4) Alterar Custo do frete");
		System.out.println("(5) Deletar Frete");
		System.out.println("(6) Voltar para a Listagem de Fretes\n");

		int options[] = {1,2,3,4,5,6};

		int option = takeIntInPrompt("Digite a opção desejada -> ","Opção não existente!\n",options,telaPrincipal.input);

		telaPrincipal.input.nextLine();

		if(option == 1) {
			String newCompany = requestString("\nDigite a nova Empresa -> ","Problema com a nova Empresa!",telaPrincipal.input);
			item.setCompany(newCompany);
		}
		else if(option == 2) {
			String newTermMax = requestString("\nDigite o novo Prazo máximo -> ","Problema com o novo Prazo máximo!",telaPrincipal.input);
			item.setTermMax(newTermMax);
		}
		else if(option == 3) {
			double newValueMin = requestDouble("\nDigite o novo Valor mínimo -> ","Problema com o novo Valor mínimo!",telaPrincipal.input);
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

		if(goBack)menuListagem(pageFretes,"fretes");
		else if(delete)telaAdm();
		else detalharFrete(item);
	}

	// Método responsável por encontrar um Anúncio
	public int findFreteById(String cod) {
		for(int i = 0; i < telaPrincipal.fretes.size(); i++) {
			if(telaPrincipal.fretes.get(i).getCod().compareTo(cod) == 0)return i;
		}
		return -1;
	}
	
	public void detalharCompra(Shopping item) {
		System.out.println("*** Detalhes da Compra ***\n");
		System.out.println(item);
		System.out.println("\n(1) Voltar para Listagem de Compras\n");

		int options[] = {1};

		takeIntInPrompt("Digite a opção desejada -> ","Opção não existente!\n",options,telaPrincipal.input);

		System.out.println("\n###################################\n");

		menuListagem(pageCompras,"compras");
	}

	public void relatorioTaxa() {
		double valorTotal = 0;
		double taxaTotal = 0;
		for(int i = 0; i < telaPrincipal.vendas.size();i++)valorTotal += telaPrincipal.vendas.get(i).valorTotal();
		
		taxaTotal = valorTotal * 0.05;
		
		System.out.printf("Valor total de vendas -> R$ %s\n",mascara(String.format("%.2f",valorTotal),"dinheiro"));
		System.out.printf("Valor total de taxas  -> R$ %s\n",mascara(String.format("%.2f",taxaTotal),"dinheiro"));
		System.out.println("\n###################################\n");
		
		menuRelatorios();
	}
}
