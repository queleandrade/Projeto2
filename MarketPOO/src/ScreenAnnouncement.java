public class ScreenAnnouncement extends Screen{
	ScreenMain telaPrincipal;
	private int pageAnuncios;
	
	public ScreenAnnouncement(ScreenMain telaPrincipal) {
		super();
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
		System.out.printf("Página atual     -> %d\n",atualPage);
		System.out.printf("Total de Páginas -> %d\n\n",totalPages);

		for(contador = 0 ; contador < limitFor ; contador++) {
			int posicaoItem = contador + ((atualPage - 1)*telaPrincipal.itensPorPagina);
			Announcement anuncio = telaPrincipal.anuncios.get(posicaoItem);
			String codigo = anuncio.getCod();
			String nome = "";
			if(anuncio instanceof AnnouncementBook) nome = ((AnnouncementBook) anuncio).getBookName();
			else if(anuncio instanceof AnnouncementMagazine) nome = ((AnnouncementMagazine) anuncio).getMagazineName();
			else if(anuncio instanceof AnnouncementMagazineSubscription) nome = ((AnnouncementMagazineSubscription) anuncio).getMagazineName();
			else if(anuncio instanceof AnnouncementBookCollection) nome = ((AnnouncementBookCollection) anuncio).getBookCollectionName();
			System.out.printf("(%d) %s - %s\n",contador + 1,(contador + 1) < 10 ? (" " + nome) : nome,codigo);
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
			Announcement itemAnuncio = telaPrincipal.anuncios.get(posItem);
			detalharAnuncio(itemAnuncio);
		}
	}

	public void detalharAnuncio(Announcement item) {
		System.out.println("*** Detalhes do Anúncio ***\n");
		System.out.println(item);
		System.out.println("(1) Voltar para a Listagem de Anúncios\n");

		int options[] = {1};

		takeIntInPrompt("Digite a opção desejada -> ","Opção não existente!\n",options,telaPrincipal.input);

		System.out.println("\n###################################\n");

		menuListagem(pageAnuncios);
	}

	// Método responsável por encontrar um Anúncio
	public int findAnuncioById(String cod) {
		for(int i = 0; i < telaPrincipal.anuncios.size(); i++) {
			if(telaPrincipal.anuncios.get(i).getCod() == cod)return i;
		}
		return -1;
	}

	// Método responsável por solicitar uma Data para o usuário
	public Date solicitarDataPublicacao(String type,boolean isNew) {
		Date newDate;
		String questionDay = String.format("\nDigite o%s dia da Publicação %s -> ",isNew ? " novo" : "", type == "livro" ? "do Livro" : "da Revista");
		String questionMonth = String.format("\nDigite o%s mês da Publicação %s -> ",isNew ? " novo" : "", type == "livro" ? "do Livro" : "da Revista");
		String questionYear = String.format("\nDigite o%s ano da Publicação %s -> ",isNew ? " novo" : "", type == "livro" ? "do Livro" : "da Revista");
		String msgDay = String.format("Problema com o%s dia da Publicação %s!",isNew ? " novo" : "", type == "livro" ? "do Livro" : "da Revista");
		String msgMonth = String.format("Problema com o%s mês da Publicação %s!",isNew ? " novo" : "", type == "livro" ? "do Livro" : "da Revista");
		String msgYear = String.format("Problema com o%s ano da Publicação %s!",isNew ? " novo" : "", type == "livro" ? "do Livro" : "da Revista");

		int newDay = requestInt(questionDay,msgDay,telaPrincipal.input);
		int newMonth = requestInt(questionMonth,msgMonth,telaPrincipal.input);
		int newYear = requestInt(questionYear,msgYear,telaPrincipal.input);

		try {
			newDate = new Date(newYear,newMonth,newDay);
		}catch(Exception e) {
			System.out.println("\nErro -> Data inválida!");
			newDate = solicitarDataPublicacao(type,isNew);
		}

		return newDate;
	}

	// Método responsável por adicionar um novo Anúncio no ArrayList 'anuncios'
	public void addAnuncio(Announcement item) {
		telaPrincipal.anuncios.add(item);
	}
		
}
