import java.util.ArrayList;

public class ScreenClient extends Screen{
	ScreenMain telaPrincipal;
	private int pageMeusAnuncios;

	public ScreenClient(ScreenMain telaPrincipal) {
		super();
		this.telaPrincipal = telaPrincipal;
		this.pageMeusAnuncios = 1;
	}

	public void telaCliente() {
		System.out.println("*** Área do Cliente ***\n");
		System.out.println("(1) Comprar");
		System.out.println("(2) Cadastrar Anúncio");
		System.out.println("(3) Meus anúncios");
		System.out.println("(4) Minhas compras");
		System.out.println("(5) Minhas vendas");
		System.out.println("(6) Voltar para o Menu Principal\n");

		int[] options = new int[]{1,2,3,4,5,6} ;

		int option = takeIntInPrompt("Digite a opção desejada -> ","Opção não existente!\n",options,telaPrincipal.input);

		telaPrincipal.input.nextLine();

		System.out.println("\n###################################\n");

		if(option == 2)telaNovoAnuncio();
		else if(option == 3) {
			if(telaPrincipal.usuarioAtual.getMyAnnouncement().size() == 0) {
				System.out.println("Info -> Você não possui nenhum anúncio cadastrado!\n");
				System.out.println("###################################\n");
				telaCliente();
			}
			else menuListagem(1);
		}
		else if(option == 6)telaPrincipal.menuPrincipal();
	}

	// Método responsável por perguntar qual tipo de Anúncio o usuário quer criar
	public void telaNovoAnuncio() {
		System.out.println("*** Novo Anúncio ***\n");
		System.out.println("(1) Anúncio de Livro");
		System.out.println("(2) Anúncio de Coleção de Livros");
		System.out.println("(3) Anúncio de Revista");
		System.out.println("(4) Anúncio de Assinatura de Revista");
		System.out.println("(5) Voltar para Área do Cliente\n");

		int options[] = {1,2,3,4,5};

		int option = takeIntInPrompt("Informe qual tipo do novo anúncio -> ","Opção não existente!\n",options,telaPrincipal.input);

		telaPrincipal.input.nextLine();

		System.out.println("\n###################################\n");

		if(option == 1)novoAnuncioLivro();
		else if(option == 2)novoAnuncioColecao();
		else if(option == 3)novoAnuncioRevista();
		else if(option == 4)novoAnuncioAssinatura();
		else if(option == 5)telaCliente();
	}

	// Método responsável por solicitar ao usuário as informações necessárias para criar um novo Anúncio de Livro
	public void novoAnuncioLivro() {

		System.out.println("*** Novo Anúncio de Livro ***\n");

		String title = requestString("Título do Anúncio          -> ", "Problema com o Título do Anúncio!\n",telaPrincipal.input);

		double value = requestDouble("Preço do Livro             -> R$ ","Problema com o Preço do Livro!\n",telaPrincipal.input);

		telaPrincipal.input.nextLine();

		String name = requestString("Nome do Livro              -> ","Problema com o Nome do Livro!\n",telaPrincipal.input);

		String author = requestString("Autor do Livro             -> ","Problema com o Autor do Livro\n",telaPrincipal.input);

		String publishingCompany = requestString("Editora do Livro           -> ","Problema com a Editora do Livro\n",telaPrincipal.input);

		Date date = solicitarDataPublicacao("livro",false);

		AnnouncementBook newBook = new AnnouncementBook(title, value,telaPrincipal.usuarioAtual, name, author, publishingCompany,date);

		addAnuncio(newBook,telaPrincipal.usuarioAtual);

		System.out.println("\n###################################\n");

		telaCliente();
	}

	// Método responsável por solicitar ao usuário as informações necessárias para criar um novo Anúncio de Coleção de Livros
	public void novoAnuncioColecao() {

		System.out.println("*** Novo Anúncio de Coleção de Livros ***\n");

		String title = requestString("Título do Anúncio          -> ", "Problema com o Título do Anúncio!\n",telaPrincipal.input);

		double value = requestDouble("Preço da Coleção de Livros -> R$ ","Problema com o Preço da Coleção de Livros!\n",telaPrincipal.input);

		telaPrincipal.input.nextLine();

		String name = requestString("Nome da Coleção de Livros  -> ","Problema com o Nome da Coleção de Livros!\n",telaPrincipal.input);

		AnnouncementBookCollection newBookCollection = new AnnouncementBookCollection(title, value,telaPrincipal.usuarioAtual, name);

		addAnuncio(newBookCollection,telaPrincipal.usuarioAtual);

		System.out.println("\n###################################\n");

		telaCliente();
	}

	// Método responsável por solicitar ao usuário as informações necessárias para criar um novo Anúncio de Revista
	public void novoAnuncioRevista() {
		System.out.println("*** Novo Anúncio de Revista ***\n");

		String title = requestString("Título do Anúncio -> ", "Problema com o Título do Anúncio!\n",telaPrincipal.input);

		double value = requestDouble("Preço da Revista  -> R$ ","Problema com o Preço da Revista!\n",telaPrincipal.input);

		telaPrincipal.input.nextLine();

		String magazineName = requestString("Nome da Revista   -> ","Problema com o Nome da Revista!\n",telaPrincipal.input);

		String magazineTitle = requestString("Título da Revista -> ","Problema com o Título da Revista\n",telaPrincipal.input);

		Date date = solicitarDataPublicacao("revista",false);

		AnnouncementMagazine newMagazine = new AnnouncementMagazine(title, value,telaPrincipal.usuarioAtual, magazineName,magazineTitle,date);

		addAnuncio(newMagazine,telaPrincipal.usuarioAtual);

		System.out.println("\n###################################\n");

		telaCliente();
	}

	// Método responsável por solicitar ao usuário as informações necessárias para criar um novo Anúncio de Assinatura de Revista
	public void novoAnuncioAssinatura() {

		System.out.println("*** Novo Anúncio de Assinatura de Revista ***\n");

		String title = requestString("Título do Anúncio              -> ", "Problema com o Título do Anúncio!\n",telaPrincipal.input);

		double value = requestDouble("Preço da Assinatura de Revista -> R$ ","Problema com o Preço da Assinatura de Revista!\n",telaPrincipal.input);

		telaPrincipal.input.nextLine();

		String magazineSubscriptionName = requestString("Nome da Revista                -> ","Problema com o Nome da Revista!\n",telaPrincipal.input);

		AnnouncementMagazineSubscription newMagazineSubscription = new AnnouncementMagazineSubscription(title, value,telaPrincipal.usuarioAtual, magazineSubscriptionName);

		addAnuncio(newMagazineSubscription,telaPrincipal.usuarioAtual);

		System.out.println("\n###################################\n");

		telaCliente();
	}

	// Método responsável por adicionar um novo Anúncio no ArrayList 'anuncios'
	public void addAnuncio(Announcement item,User usuario) {
		telaPrincipal.anuncios.add(item);
		usuario.addAnnouncement(item);
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

	// Método responsável por mostrar na tela uma listagem de códigos dos Fretes ou Anúncios cadastrados
	public void menuListagem(int page) {
		int contador;

		int atualPage = pageMeusAnuncios ;

		int total = telaPrincipal.usuarioAtual.getMyAnnouncement().size();

		int totalPages = (int) Math.ceil((float)total/telaPrincipal.itensPorPagina);

		atualPage = page < 1 ? 1 : (page > totalPages ? totalPages : page);

		pageMeusAnuncios = atualPage;

		int limitFor = atualPage == totalPages ? (total - (totalPages - 1)*telaPrincipal.itensPorPagina) : telaPrincipal.itensPorPagina;

		int optionProx = -1;

		int optionAnt = -1;

		int optionVolt = -1;

		System.out.println("*** Lista de Anúncios ***\n");
		System.out.printf("Página atual     -> %d\n",atualPage);
		System.out.printf("Total de Páginas -> %d\n\n",totalPages);

		for(contador = 0 ; contador < limitFor ; contador++) {
			int posicaoItem = contador + ((atualPage - 1)*telaPrincipal.itensPorPagina);
			Announcement anuncio = telaPrincipal.usuarioAtual.getMyAnnouncement().get(posicaoItem);
			String codigo = anuncio.getCod();
			String nome = "";
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
			Announcement itemAnuncio = telaPrincipal.usuarioAtual.getMyAnnouncement().get(posItem);
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

		int option = takeIntInPrompt("Digite a opção desejada -> ","Opção não existente!\n",options,telaPrincipal.input);

		telaPrincipal.input.nextLine();

		if(option == 1) {
			String newTitle = requestString("\nDigite o novo Título do Anúncio -> ","Problema com o novo Título do Anúncio!",telaPrincipal.input);
			item.setTitle(newTitle);
		}
		else if(option == 2) {
			double value = requestDouble("\nDigite o novo Preço do Livro -> ","Problema com o novo Preço do Livro!",telaPrincipal.input);
			item.setValue(value);
		}
		else if(option == 3) {
			String newName = requestString("\nDigite o novo Nome do Livro -> ","Problema com o novo Nome do Livro!",telaPrincipal.input);
			item.setBookName(newName);
		}
		else if(option == 4) {
			String newAuthor = requestString("\nDigite o novo Autor do Livro -> ","Problema com o novo Autor do Livro!",telaPrincipal.input);
			item.setBookAuthor(newAuthor);
		}
		else if(option == 5) {
			String newPublishingCompany = requestString("\nDigite o nova Editora do Livro -> ","Problema com o nova Editora do Livro!",telaPrincipal.input);
			item.setBookPublishingCompany(newPublishingCompany);
		}
		else if(option == 6) {
			Date newDate = solicitarDataPublicacao("livro",true);
			item.setBookPublicationDate(newDate);
		}
		else if(option == 7) {
			removerAnuncio(item.getCod());
			delete = true;
		}
		else if(option == 8) goBack = true;

		System.out.println("\n###################################\n");

		if(goBack)menuListagem(pageMeusAnuncios);
		else if(delete)telaCliente();
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

		int option = takeIntInPrompt("Digite a opção desejada -> ","Opção não existente!\n",options,telaPrincipal.input);

		telaPrincipal.input.nextLine();

		if(option == 1) {
			String newTitle = requestString("\nDigite o novo Título do Anúncio -> ","Problema com o novo Título do Anúncio!",telaPrincipal.input);
			item.setTitle(newTitle);
		}
		else if(option == 2) {
			double value = requestDouble("\nDigite o novo Preço da Coleção de Livros -> ","Problema com o novo Preço da Coleção de Livros!",telaPrincipal.input);
			item.setValue(value);
		}
		else if(option == 3) {
			String newName = requestString("\nDigite o novo Nome da Coleção de Livros -> ","Problema com o novo Nome da Coleção de Livros!",telaPrincipal.input);
			item.setBookCollectionName(newName);
		}
		else if(option == 4) {
			removerAnuncio(item.getCod());
			delete = true;
		}
		else if(option == 5) goBack = true;

		System.out.println("\n###################################\n");

		if(goBack)menuListagem(pageMeusAnuncios);
		else if(delete)telaCliente();
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

		int option = takeIntInPrompt("Digite a opção desejada -> ","Opção não existente!\n",options,telaPrincipal.input);

		telaPrincipal.input.nextLine();

		if(option == 1) {
			String newTitle = requestString("\nDigite o novo Título do Anúncio -> ","Problema com o novo Título do Anúncio!",telaPrincipal.input);
			item.setTitle(newTitle);
		}
		else if(option == 2) {
			double value = requestDouble("\nDigite o novo Preço da Revista -> ","Problema com o novo Preço da Revista!",telaPrincipal.input);
			item.setValue(value);
		}
		else if(option == 3) {
			String newName = requestString("\nDigite o novo Nome da Revista -> ","Problema com o novo Nome da Revista!",telaPrincipal.input);
			item.setMagazineName(newName);
		}
		else if(option == 4) {
			String newTitleMagazine = requestString("\nDigite o novo Título da Revista -> ","Problema com o novo Título da Revista!",telaPrincipal.input);
			item.setMagazineTitle(newTitleMagazine);
		}
		else if(option == 5) {
			Date newDate = solicitarDataPublicacao("revista",true);
			item.setMagazinePublicationDate(newDate);
		}
		else if(option == 6) {
			removerAnuncio(item.getCod());
			delete = true;
		}
		else if(option == 7)goBack = true;

		System.out.println("\n###################################\n");

		if(goBack)menuListagem(pageMeusAnuncios);
		else if(delete)telaCliente();
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

		int option = takeIntInPrompt("Digite a opção desejada -> ","Opção não existente!\n",options,telaPrincipal.input);

		telaPrincipal.input.nextLine();

		if(option == 1) {
			String newTitle = requestString("\nDigite o novo Título do Anúncio -> ","Problema com o novo Título do Anúncio!",telaPrincipal.input);
			item.setTitle(newTitle);
		}
		else if(option == 2) {
			double newValue = requestDouble("\nDigite o novo Preço da Assinatura da Revista -> ","Problema com o novo Preço da Assinatura da Revista!",telaPrincipal.input);
			item.setValue(newValue);
		}
		else if(option == 3) {
			String newName = requestString("\nDigite o novo Nome da Revista -> ","Problema com o novo Nome da Revista!",telaPrincipal.input);
			item.setMagazineName(newName);
		}
		else if(option == 4) {
			removerAnuncio(item.getCod());
			delete = true;
		}
		else if(option == 5) goBack = true;

		System.out.println("\n###################################\n");

		if(goBack)menuListagem(pageMeusAnuncios);
		else if(delete)telaCliente();
		else detalharAnuncioAssinatura(item);
	}

	// Método responsável por encontrar um Anúncio
	public int findAnuncioById(String cod,ArrayList<Announcement> anuncios) {
		for(int i = 0; i < anuncios.size(); i++) {
			if(anuncios.get(i).getCod() == cod)return i;
		}
		return -1;
	}

	public void removerAnuncio(String cod) {
		int pos = findAnuncioById(cod,telaPrincipal.anuncios);
		telaPrincipal.anuncios.remove(pos);
		pos = findAnuncioById(cod,telaPrincipal.usuarioAtual.getMyAnnouncement());
		telaPrincipal.usuarioAtual.getMyAnnouncement().remove(pos);
	}

}
