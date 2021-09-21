//Subclasse da classe screen para tela de exibir anúncios

public class ScreenAnnouncement extends Screen{
	//Variavéis de instâncias
	ScreenMain telaPrincipal;
	private int pageAnuncios;
	
	//construtor
	public ScreenAnnouncement(ScreenMain telaPrincipal) {
		super(); ////referenciando a classe pai
		this.telaPrincipal = telaPrincipal;
		this.pageAnuncios = 1;
	}

	// Método responsável por mostrar na tela uma listagem de códigos dos Fretes ou Anúncios cadastrados
	public void menuListagem(int page) {
		int contador;

		int atualPage = pageAnuncios ;

		int total = telaPrincipal.anuncios.size();

		int totalPages = (int) Math.ceil((float)total/telaPrincipal.itensPorPagina);

		atualPage = page < 1 ? 1 : (page > totalPages ? totalPages : page);

		pageAnuncios = atualPage;

		int limitFor = atualPage == totalPages ? (total - (totalPages - 1)*telaPrincipal.itensPorPagina) : telaPrincipal.itensPorPagina;

		int optionProx = -1;

		int optionAnt = -1;

		int optionVolt = -1;

		System.out.println("*** Lista de Anúncios ***\n");
		System.out.printf("Página atual      -> %d\n",atualPage);
		System.out.printf("Total de Páginas  -> %d\n",totalPages);
		System.out.printf("Total de Anúncios -> %d\n\n",total);
		
		for(contador = 0 ; contador < limitFor ; contador++) {
			int posicaoItem = contador + ((atualPage - 1)*telaPrincipal.itensPorPagina);
			Announcement anuncio = telaPrincipal.anuncios.get(posicaoItem);
			String codigo = anuncio.getCod();
			String nome = "";
			//instanceof testa se é uma instância do tipo especificado, após o nome de cada produto vai para sua classe em especifico
			if(anuncio instanceof AnnouncementBook) nome = ((AnnouncementBook) anuncio).getBookName();
			else if(anuncio instanceof AnnouncementMagazine) nome = ((AnnouncementMagazine) anuncio).getMagazineName();
			else if(anuncio instanceof AnnouncementMagazineSubscription) nome = ((AnnouncementMagazineSubscription) anuncio).getMagazineName();
			else if(anuncio instanceof AnnouncementBookCollection) nome = ((AnnouncementBookCollection) anuncio).getBookCollectionName();
			System.out.printf("(%d) %s - %s\n",contador + 1,(contador + 1) < 10 ? (" " + nome) : nome,codigo);
		}

		if(atualPage == totalPages && totalPages > 1) {
			System.out.printf("(%d) %sAnterior \n",++contador,contador > 9 ? "" : " ");
			optionAnt = contador;
		}
		else if (atualPage < totalPages && atualPage == 1) {
			System.out.printf("(%d) %sPróxima \n",++contador,contador > 9 ? "" : " ");
			optionProx = contador;
		}
		else if (atualPage < totalPages && atualPage > 1) {
			System.out.printf("(%d) %sAnterior \n",++contador,contador > 9 ? "" : " ");
			optionAnt = contador;
			System.out.printf("(%d) %sPróxima \n",++contador,contador > 9 ? "" : " ");
			optionProx = contador;
		}

		System.out.printf("(%d) %sVoltar para Menu Principal\n\n",++contador,contador > 9 ? "" : " ");

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
			Announcement itemAnuncio = telaPrincipal.anuncios.get(posItem);
			detalharAnuncio(itemAnuncio);
		}
	}

	//Método para exibir detalhes do anúncio
	public void detalharAnuncio(Announcement item) {
		System.out.println("*** Detalhes do Anúncio ***\n");
		System.out.println(item);
		System.out.println("(1) Voltar para a Listagem de Anúncios\n");

		int options[] = {1};

		takeIntInPrompt("Digite a opção desejada -> ","Opção não existente!\n",options,telaPrincipal.input);

		System.out.println("\n###################################\n");

		menuListagem(pageAnuncios);
	}

}
