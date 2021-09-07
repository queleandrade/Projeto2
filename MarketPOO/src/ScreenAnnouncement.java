public class ScreenAnnouncement extends Screen{
	ScreenMain telaPrincipal;
	private int pageAnuncios;
	
	public ScreenAnnouncement(ScreenMain telaPrincipal) {
		super();
		this.telaPrincipal = telaPrincipal;
		this.pageAnuncios = 1;
	}

	// Método responsável por mostrar na tela as opções gerais de Anúncios
	public void menuAnuncios() {
		System.out.println("*** Menu Anúncios ***\n");
		System.out.println("(1) Ver Anúncios");
		System.out.println("(2) Novo Anúncio");
		System.out.println("(3) Voltar para o Menu Principal\n");

		int options[] = {1,2,3};

		int option = takeIntInPrompt("Digite a opção desejada -> ","Opção não existente!\n",options);

		input.nextLine();

		System.out.println("\n###################################\n");

		if(option == 1) {
			if(anuncios.size() > 0) {
				pageAnuncios = 1;
				menuListagem(1);
			}
			else {
				System.out.println("Info -> Nenhum Anúncio foi cadastrado ainda!\n");
				System.out.println("###################################\n");
				menuAnuncios();
			}
		}
		else if(option == 2) telaNovoAnuncio();
		else if(option == 3) telaPrincipal.menuPrincipal();

	}

	// Método responsável por mostrar na tela uma listagem de códigos dos Fretes ou Anúncios cadastrados
	public void menuListagem(int page) {
		int contador;

		int atualPage = pageAnuncios ;

		int total = anuncios.size();

		int totalPages = (int) Math.ceil((float)total/itensPorPagina);

		atualPage = page < 1 ? 1 : (page > totalPages ? totalPages : page);

		pageAnuncios = atualPage;

		int limitFor = atualPage == totalPages ? (total - (totalPages - 1)*itensPorPagina) : itensPorPagina;

		int optionProx = -1;

		int optionAnt = -1;

		int optionVolt = -1;

		System.out.println("*** Lista de Anúncios ***\n");

		System.out.printf("Página atual     -> %d\n",atualPage);
		System.out.printf("Total de Páginas -> %d\n\n",totalPages);

		for(contador = 0 ; contador < limitFor ; contador++) {
			int posicaoItem = contador + ((atualPage - 1)*itensPorPagina);
			String codigo = anuncios.get(posicaoItem).getCod();
			System.out.printf("(%d) %s\n",contador+1,codigo);
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

		System.out.printf("(%d) Voltar para Menu de Anúncios\n\n",++contador);

		optionVolt = contador;

		int options[] = new int[contador];

		for(int i = 0; i < contador;i++)options[i] = i + 1;

		int option = takeIntInPrompt("Digite o indice para detalhes -> ","Opção não existente!\n",options);

		input.nextLine();

		System.out.println("\n###################################\n");

		if(option == optionProx)menuListagem(atualPage + 1);
		else if(option == optionAnt)menuListagem(atualPage - 1);
		else if(option == optionVolt)menuAnuncios();
		else if(option <= limitFor && option >= 1) {
			int posItem = (option - 1) + ((atualPage - 1)*itensPorPagina);
			Announcement itemAnuncio = anuncios.get(posItem);
			if(itemAnuncio instanceof AnnouncementBook) detalharAnuncioLivro((AnnouncementBook)itemAnuncio);
			else if(itemAnuncio instanceof AnnouncementBookCollection) detalharAnuncioColecao((AnnouncementBookCollection)itemAnuncio);
			else if(itemAnuncio instanceof  AnnouncementMagazine) detalharAnuncioRevista((AnnouncementMagazine)itemAnuncio);
			else if(itemAnuncio instanceof  AnnouncementMagazineSubscription) detalharAnuncioAssinatura((AnnouncementMagazineSubscription)itemAnuncio);
		}
	}

	// Método responsável por mostrar na tela os detalhes de um Anúncio de Livro e possibilita a edição ou remoção do mesmo 
	public void detalharAnuncioLivro(AnnouncementBook item) {

		boolean goBack = false;
		boolean delete = false;

		System.out.println("*** Detalhes do Anúncio ***\n");
		System.out.println(item);
		System.out.println("(1) Alterar Título do Anúncio");
		System.out.println("(2) Alterar Preço do Livro");
		System.out.println("(3) Alterar Nome do Livro");
		System.out.println("(4) Alterar Autor do Livro");
		System.out.println("(5) Alterar Editora do Livro");
		System.out.println("(6) Alterar Data da Publicação do Livro");
		System.out.println("(7) Deletar Anúncio");
		System.out.println("(8) Voltar para a Listagem de Anúncios\n");

		int options[] = {1,2,3,4,5,6,7,8};

		int option = takeIntInPrompt("Digite a opção desejada -> ","Opção não existente!\n",options);

		input.nextLine();

		if(option == 1) {
			String newTitle = requestString("\nDigite o novo Título do Anúncio -> ","Problema com o novo Título do Anúncio!");
			item.setTitle(newTitle);
		}
		else if(option == 2) {
			double value = requestDouble("\nDigite o novo Preço do Livro -> ","Problema com o novo Preço do Livro!");
			item.setValue(value);
		}
		else if(option == 3) {
			String newName = requestString("\nDigite o novo Nome do Livro -> ","Problema com o novo Nome do Livro!");
			item.setBookName(newName);
		}
		else if(option == 4) {
			String newAuthor = requestString("\nDigite o novo Autor do Livro -> ","Problema com o novo Autor do Livro!");
			item.setBookAuthor(newAuthor);
		}
		else if(option == 5) {
			String newPublishingCompany = requestString("\nDigite o nova Editora do Livro -> ","Problema com o nova Editora do Livro!");
			item.setBookPublishingCompany(newPublishingCompany);
		}
		else if(option == 6) {
			Date newDate = solicitarDataPublicacao("livro",true);
			item.setBookPublicationDate(newDate);
		}
		else if(option == 7) {
			int pos = findAnuncioById(item.getCod());
			anuncios.remove(pos);
			delete = true;
		}
		else if(option == 8) goBack = true;

		System.out.println("\n###################################\n");

		if(goBack)menuListagem(pageAnuncios);
		else if(delete)menuAnuncios();
		else detalharAnuncioLivro(item);
	}

	// Método responsável por mostrar na tela os detalhes de um Anúncio de Coleção de Livros e possibilita a edição ou remoção do mesmo 
	public void detalharAnuncioColecao(AnnouncementBookCollection item) {

		boolean goBack = false;
		boolean delete = false;

		System.out.println("*** Detalhes do Anúncio ***\n");
		System.out.println(item);
		System.out.println("(1) Alterar Título do Anúncio");
		System.out.println("(2) Alterar Preço da Coleção");
		System.out.println("(3) Alterar Nome da Coleção");
		System.out.println("(4) Deletar Anúncio");
		System.out.println("(5) Voltar para a Listagem de Anúncios\n");

		int options[] = {1,2,3,4,5};

		int option = takeIntInPrompt("Digite a opção desejada -> ","Opção não existente!\n",options);

		input.nextLine();

		if(option == 1) {
			String newTitle = requestString("\nDigite o novo Título do Anúncio -> ","Problema com o novo Título do Anúncio!");
			item.setTitle(newTitle);
		}
		else if(option == 2) {
			double value = requestDouble("\nDigite o novo Preço da Coleção de Livros -> ","Problema com o novo Preço da Coleção de Livros!");
			item.setValue(value);
		}
		else if(option == 3) {
			String newName = requestString("\nDigite o novo Nome da Coleção de Livros -> ","Problema com o novo Nome da Coleção de Livros!");
			item.setBookCollectionName(newName);
		}
		else if(option == 4) {
			int pos = findAnuncioById(item.getCod());
			anuncios.remove(pos);
			delete = true;
		}
		else if(option == 5) goBack = true;

		System.out.println("\n###################################\n");

		if(goBack)menuListagem(pageAnuncios);
		else if(delete)menuAnuncios();
		else detalharAnuncioColecao(item);
	}

	// Método responsável por mostrar na tela os detalhes de um Anúncio de Revista e possibilita a edição ou remoção do mesmo 
	public void detalharAnuncioRevista(AnnouncementMagazine item) {

		boolean goBack = false;
		boolean delete = false;

		System.out.println("*** Detalhes do Anúncio ***\n");
		System.out.println(item);
		System.out.println("(1) Alterar Título do Anúncio");
		System.out.println("(2) Alterar Preço da Revista");
		System.out.println("(3) Alterar Nome da Revista");
		System.out.println("(4) Alterar Título da Revista");
		System.out.println("(5) Alterar Data da Publicação da Revista");
		System.out.println("(6) Deletar Anúncio");
		System.out.println("(7) Voltar para a Listagem de Anúncios\n");

		int options[] = {1,2,3,4,5,6,7};

		int option = takeIntInPrompt("Digite a opção desejada -> ","Opção não existente!\n",options);

		input.nextLine();

		if(option == 1) {
			String newTitle = requestString("\nDigite o novo Título do Anúncio -> ","Problema com o novo Título do Anúncio!");
			item.setTitle(newTitle);
		}
		else if(option == 2) {
			double value = requestDouble("\nDigite o novo Preço da Revista -> ","Problema com o novo Preço da Revista!");
			item.setValue(value);
		}
		else if(option == 3) {
			String newName = requestString("\nDigite o novo Nome da Revista -> ","Problema com o novo Nome da Revista!");
			item.setMagazineName(newName);
		}
		else if(option == 4) {
			String newTitleMagazine = requestString("\nDigite o novo Título da Revista -> ","Problema com o novo Título da Revista!");
			item.setMagazineTitle(newTitleMagazine);
		}
		else if(option == 5) {
			Date newDate = solicitarDataPublicacao("revista",true);
			item.setMagazinePublicationDate(newDate);
		}
		else if(option == 6) {
			int pos = findAnuncioById(item.getCod());
			anuncios.remove(pos);
			delete = true;
		}
		else if(option == 7)goBack = true;

		System.out.println("\n###################################\n");

		if(goBack)menuListagem(pageAnuncios);
		else if(delete)menuAnuncios();
		else detalharAnuncioRevista(item);
	}

	// Método responsável por mostrar na tela os detalhes de um Anúncio de Assinatura de Revista e possibilita a edição ou remoção do mesmo 
	public void detalharAnuncioAssinatura(AnnouncementMagazineSubscription item) {

		boolean goBack = false;
		boolean delete = false;

		System.out.println("*** Detalhes do Anúncio ***\n");
		System.out.println(item);
		System.out.println("(1) Alterar Título do Anúncio");
		System.out.println("(2) Alterar Preço da Assinatura da Revista");
		System.out.println("(3) Alterar Nome da Revista");
		System.out.println("(4) Deletar Anúncio");
		System.out.println("(5) Voltar para a Listagem de Anúncios\n");

		int options[] = {1,2,3,4,5};

		int option = takeIntInPrompt("Digite a opção desejada -> ","Opção não existente!\n",options);

		input.nextLine();

		if(option == 1) {
			String newTitle = requestString("\nDigite o novo Título do Anúncio -> ","Problema com o novo Título do Anúncio!");
			item.setTitle(newTitle);
		}
		else if(option == 2) {
			double newValue = requestDouble("\nDigite o novo Preço da Assinatura da Revista -> ","Problema com o novo Preço da Assinatura da Revista!");
			item.setValue(newValue);
		}
		else if(option == 3) {
			String newName = requestString("\nDigite o novo Nome da Revista -> ","Problema com o novo Nome da Revista!");
			item.setMagazineName(newName);
		}
		else if(option == 4) {
			int pos = findAnuncioById(item.getCod());
			anuncios.remove(pos);
			delete = true;
		}
		else if(option == 5) goBack = true;

		System.out.println("\n###################################\n");

		if(goBack)menuListagem(pageAnuncios);
		else if(delete)menuAnuncios();
		else detalharAnuncioAssinatura(item);
	}

	// Método responsável por perguntar qual tipo de Anúncio o usuário quer criar
	public void telaNovoAnuncio() {
		System.out.println("*** Novo Anúncio ***\n");
		System.out.println("(1) Anúncio de Livro");
		System.out.println("(2) Anúncio de Coleção de Livros");
		System.out.println("(3) Anúncio de Revista");
		System.out.println("(4) Anúncio de Assinatura de Revista");
		System.out.println("(5) Voltar para Menu de Anúncios\n");

		int options[] = {1,2,3,4,5};

		int option = takeIntInPrompt("Informe qual tipo do novo anúncio -> ","Opção não existente!\n",options);

		input.nextLine();

		System.out.println("\n###################################\n");

		if(option == 1)novoAnuncioLivro();
		else if(option == 2)novoAnuncioColecao();
		else if(option == 3)novoAnuncioRevista();
		else if(option == 4)novoAnuncioAssinatura();
		else if(option == 5)menuAnuncios();
	}

	// Método responsável por solicitar ao usuário as informações necessárias para criar um novo Anúncio de Livro
	public void novoAnuncioLivro() {

		System.out.println("*** Novo Anúncio de Livro ***\n");

		String title = requestString("Título do Anúncio          -> ", "Problema com o Título do Anúncio!\n");

		double value = requestDouble("Preço do Livro             -> R$ ","Problema com o Preço do Livro!\n");

		input.nextLine();

		String name = requestString("Nome do Livro              -> ","Problema com o Nome do Livro!\n");

		String author = requestString("Autor do Livro             -> ","Problema com o Autor do Livro\n");

		String publishingCompany = requestString("Editora do Livro           -> ","Problema com a Editora do Livro\n");

		Date date = solicitarDataPublicacao("livro",false);

		AnnouncementBook newBook = new AnnouncementBook(title, value, name, author, publishingCompany,date);

		addAnuncio(newBook);

		System.out.println("\n###################################\n");

		menuAnuncios();
	}

	// Método responsável por solicitar ao usuário as informações necessárias para criar um novo Anúncio de Coleção de Livros
	public void novoAnuncioColecao() {

		System.out.println("*** Novo Anúncio de Coleção de Livros ***\n");

		String title = requestString("Título do Anúncio          -> ", "Problema com o Título do Anúncio!\n");

		double value = requestDouble("Preço da Coleção de Livros -> R$ ","Problema com o Preço da Coleção de Livros!\n");

		input.nextLine();

		String name = requestString("Nome da Coleção de Livros  -> ","Problema com o Nome da Coleção de Livros!\n");

		AnnouncementBookCollection newBookCollection = new AnnouncementBookCollection(title, value, name);

		addAnuncio(newBookCollection);

		System.out.println("\n###################################\n");

		menuAnuncios();
	}

	// Método responsável por solicitar ao usuário as informações necessárias para criar um novo Anúncio de Revista
	public void novoAnuncioRevista() {
		System.out.println("*** Novo Anúncio de Revista ***\n");

		String title = requestString("Título do Anúncio -> ", "Problema com o Título do Anúncio!\n");

		double value = requestDouble("Preço da Revista  -> R$ ","Problema com o Preço da Revista!\n");

		input.nextLine();

		String magazineName = requestString("Nome da Revista   -> ","Problema com o Nome da Revista!\n");

		String magazineTitle = requestString("Título da Revista -> ","Problema com o Título da Revista\n");

		Date date = solicitarDataPublicacao("revista",false);

		AnnouncementMagazine newMagazine = new AnnouncementMagazine(title, value, magazineName,magazineTitle,date);

		addAnuncio(newMagazine);

		System.out.println("\n###################################\n");

		menuAnuncios();
	}

	// Método responsável por solicitar ao usuário as informações necessárias para criar um novo Anúncio de Assinatura de Revista
	public void novoAnuncioAssinatura() {

		System.out.println("*** Novo Anúncio de Assinatura de Revista ***\n");

		String title = requestString("Título do Anúncio              -> ", "Problema com o Título do Anúncio!\n");

		double value = requestDouble("Preço da Assinatura de Revista -> R$ ","Problema com o Preço da Assinatura de Revista!\n");

		input.nextLine();

		String magazineSubscriptionName = requestString("Nome da Revista                -> ","Problema com o Nome da Revista!\n");

		AnnouncementMagazineSubscription newMagazineSubscription = new AnnouncementMagazineSubscription(title, value, magazineSubscriptionName);

		addAnuncio(newMagazineSubscription);

		System.out.println("\n###################################\n");

		menuAnuncios();
	}

	// Método responsável por encontrar um Anúncio
	public int findAnuncioById(String cod) {
		for(int i = 0; i < anuncios.size(); i++) {
			if(anuncios.get(i).getCod() == cod)return i;
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

		int newDay = requestInt(questionDay,msgDay);
		int newMonth = requestInt(questionMonth,msgMonth);
		int newYear = requestInt(questionYear,msgYear);

		try {
			newDate = new Date(newYear,newMonth,newDay);
		}catch(Exception e) {
			System.out.println("\nErro -> Data inválida!");
			newDate = solicitarDataPublicacao(type,isNew);
		}

		return newDate;
	}

}
