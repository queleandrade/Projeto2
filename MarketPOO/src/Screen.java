// Classe respons�vel por renderizar todos os menus do projeto

import java.util.ArrayList;
import java.util.Scanner;

public class Screen {
	private ArrayList<Announcement> anuncios = new ArrayList<Announcement>();
	private ArrayList<Shipping> fretes = new ArrayList<Shipping>();
	
	private int itensPorPagina = 10;
	private Scanner input = new Scanner(System.in);
	private int pageAnuncios = 1;
	private int pageFretes = 1;
	
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
		
		if(option == 1) menuAnuncios();
		else if(option == 2) menuFretes();
	}
	
	// M�todo respons�vel por mostrar na tela as op��es gerais de An�ncios
	public void menuAnuncios() {
		System.out.println("*** Menu An�ncios ***\n");
		System.out.println("(1) Ver An�ncios");
		System.out.println("(2) Novo An�ncio");
		System.out.println("(3) Voltar para o Menu Principal\n");
		
		int options[] = {1,2,3};
		
		int option = takeIntInPrompt("Digite a op��o desejada -> ","Op��o n�o existente!\n",options);
		
		input.nextLine();
		
		System.out.println("\n###################################\n");
		
		if(option == 1) {
			if(anuncios.size() > 0) {
				pageAnuncios = 1;
				menuListagem(1,"anuncios");
			}
			else {
				System.out.println("Info -> Nenhum An�ncio foi cadastrado ainda!\n");
				System.out.println("###################################\n");
				menuAnuncios();
			}
		}
		else if(option == 2) telaNovoAnuncio();
		else if(option == 3) menuPrincipal();
			
	}
	
	// M�todo respons�vel por mostrar na tela as op��es gerais de Fretes
	public void menuFretes() {
		System.out.println("*** Menu Fretes ***\n");
		System.out.println("(1) Ver Fretes");
		System.out.println("(2) Novo Frete");
		System.out.println("(3) Voltar para o Menu Principal\n");
		
		int options[] = {1,2,3};
		
		int option = takeIntInPrompt("Digite a op��o desejada -> ","Op��o n�o existente!\n",options);
		
		input.nextLine();
		
		System.out.println("\n###################################\n");
		
		if(option == 1) {
			if(fretes.size() > 0) {
				pageFretes = 1;
				menuListagem(1,"fretes");
			}
			else {
				System.out.println("Info -> Nenhum Frete foi cadastrado ainda!\n");
				System.out.println("###################################\n");
				menuFretes();
			}
		}
		else if(option == 2) telaNovoFrete();
		else if(option == 3) menuPrincipal();
	}
	
	// M�todo respons�vel por mostrar na tela uma listagem de c�digos dos Fretes ou An�ncios cadastrados
	public void menuListagem(int page,String typeItems) {
		int contador;
		
		int atualPage = typeItems == "anuncios" ? pageAnuncios : pageFretes;
		
		int total = typeItems == "anuncios" ? anuncios.size() : fretes.size();
	
		int totalPages = (int) Math.ceil((float)total/itensPorPagina);
		
		atualPage = page < 1 ? 1 : (page > totalPages ? totalPages : page);
		
		if(typeItems == "anuncios")pageAnuncios = atualPage;
		else pageFretes = atualPage;
		
		int limitFor = atualPage == totalPages ? (total - (totalPages - 1)*itensPorPagina) : itensPorPagina;
		
		int optionProx = -1;
		
		int optionAnt = -1;
		
		int optionVolt = -1;
		
		if(typeItems == "anuncios") System.out.println("*** Lista de An�ncios ***\n");
		else System.out.println("*** Lista de Fretes ***\n");
		
		System.out.printf("P�gina atual     -> %d\n",atualPage);
		System.out.printf("Total de P�ginas -> %d\n\n",totalPages);
		
		for(contador = 0 ; contador < limitFor ; contador++) {
			int posicaoItem = contador + ((atualPage - 1)*itensPorPagina);
			String codigo = typeItems == "anuncios" ? anuncios.get(posicaoItem).getCod() : fretes.get(posicaoItem).getCod();
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
		
		if(typeItems == "anuncios") System.out.printf("(%d) Voltar para Menu de An�ncios\n\n",++contador);
		else System.out.printf("(%d) Voltar para Menu de Fretes\n\n",++contador);
		
		optionVolt = contador;
		
		int options[] = new int[contador];
		
		for(int i = 0; i < contador;i++)options[i] = i + 1;
		
		int option = takeIntInPrompt("Digite o indice para detalhes -> ","Op��o n�o existente!\n",options);
		
		input.nextLine();
		
		System.out.println("\n###################################\n");
		
		if(option == optionProx)menuListagem(atualPage + 1,typeItems);
		else if(option == optionAnt)menuListagem(atualPage - 1,typeItems);
		else if(option == optionVolt){
			if(typeItems == "anuncios")menuAnuncios();
			else menuFretes();
		}
		else if(option <= limitFor && option >= 1) {
			int posItem = (option - 1) + ((atualPage - 1)*itensPorPagina);
			if(typeItems == "anuncios"){
				Announcement itemAnuncio = anuncios.get(posItem);
				if(itemAnuncio instanceof AnnouncementBook) detalharAnuncioLivro((AnnouncementBook)itemAnuncio);
				else if(itemAnuncio instanceof AnnouncementBookCollection) detalharAnuncioColecao((AnnouncementBookCollection)itemAnuncio);
				else if(itemAnuncio instanceof  AnnouncementMagazine) detalharAnuncioRevista((AnnouncementMagazine)itemAnuncio);
				else if(itemAnuncio instanceof  AnnouncementMagazineSubscription) detalharAnuncioAssinatura((AnnouncementMagazineSubscription)itemAnuncio);
			}
			else {
				Shipping itemFrete = fretes.get(posItem);
				detalharFrete(itemFrete);
			}
		}
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
		
		int option = takeIntInPrompt("Digite a op��o desejada -> ","Op��o n�o existente!\n",options);
		
		input.nextLine();
		
		if(option == 1) {
			String newCompany = requestString("\nDigite a nova Empresa -> ","Problema com a nova Empresa!");
			item.setCompany(newCompany);
		}
		else if(option == 2) {
			String newTermMax = requestString("\nDigite o novo Prazo m�ximo -> ","Problema com o novo Prazo m�ximo!");
			item.setTermMax(newTermMax);
		}
		else if(option == 3) {
			double newValueMin = requestDouble("\nDigite o novo Valor m�nimo -> ","Problema com o novo Valor m�nimo!");
			item.setValueMin(newValueMin);
		}
		else if(option == 4) {
			double newCost = requestDouble("\nDigite o novo Custo do frete -> ","Problema com o novo Custo do frete!");
			item.setCost(newCost);
		}
		else if(option == 5) {
			int pos = findFreteById(item.getCod());
			fretes.remove(pos);
			delete = true;
		}
		else if(option == 6) goBack = true;
		
		System.out.println("\n###################################\n");
		
		if(goBack)menuListagem(pageFretes,"fretes");
		else if(delete)menuFretes();
		else detalharFrete(item);
	}
	
	// M�todo respons�vel por mostrar na tela os detalhes de um An�ncio de Livro e possibilita a edi��o ou remo��o do mesmo 
	public void detalharAnuncioLivro(AnnouncementBook item) {
		
		boolean goBack = false;
		boolean delete = false;
		
		System.out.println("*** Detalhes do An�ncio ***\n");
		System.out.println(item);
		System.out.println("(1) Alterar T�tulo do An�ncio");
		System.out.println("(2) Alterar Pre�o do Livro");
		System.out.println("(3) Alterar Nome do Livro");
		System.out.println("(4) Alterar Autor do Livro");
		System.out.println("(5) Alterar Editora do Livro");
		System.out.println("(6) Alterar Data da Publica��o do Livro");
		System.out.println("(7) Deletar An�ncio");
		System.out.println("(8) Voltar para a Listagem de An�ncios\n");
		
		int options[] = {1,2,3,4,5,6,7,8};
		
		int option = takeIntInPrompt("Digite a op��o desejada -> ","Op��o n�o existente!\n",options);
		
		input.nextLine();
		
		if(option == 1) {
			String newTitle = requestString("\nDigite o novo T�tulo do An�ncio -> ","Problema com o novo T�tulo do An�ncio!");
			item.setTitle(newTitle);
		}
		else if(option == 2) {
			double value = requestDouble("\nDigite o novo Pre�o do Livro -> ","Problema com o novo Pre�o do Livro!");
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
		
		if(goBack)menuListagem(pageAnuncios,"anuncios");
		else if(delete)menuAnuncios();
		else detalharAnuncioLivro(item);
	}
	
	// M�todo respons�vel por mostrar na tela os detalhes de um An�ncio de Cole��o de Livros e possibilita a edi��o ou remo��o do mesmo 
 	public void detalharAnuncioColecao(AnnouncementBookCollection item) {
 		
 		boolean goBack = false;
		boolean delete = false;
		
		System.out.println("*** Detalhes do An�ncio ***\n");
		System.out.println(item);
		System.out.println("(1) Alterar T�tulo do An�ncio");
		System.out.println("(2) Alterar Pre�o da Cole��o");
		System.out.println("(3) Alterar Nome da Cole��o");
		System.out.println("(4) Deletar An�ncio");
		System.out.println("(5) Voltar para a Listagem de An�ncios\n");
		
		int options[] = {1,2,3,4,5};
		
		int option = takeIntInPrompt("Digite a op��o desejada -> ","Op��o n�o existente!\n",options);
		
		input.nextLine();
		
		if(option == 1) {
			String newTitle = requestString("\nDigite o novo T�tulo do An�ncio -> ","Problema com o novo T�tulo do An�ncio!");
			item.setTitle(newTitle);
		}
		else if(option == 2) {
			double value = requestDouble("\nDigite o novo Pre�o da Cole��o de Livros -> ","Problema com o novo Pre�o da Cole��o de Livros!");
			item.setValue(value);
		}
		else if(option == 3) {
			String newName = requestString("\nDigite o novo Nome da Cole��o de Livros -> ","Problema com o novo Nome da Cole��o de Livros!");
			item.setBookCollectionName(newName);
		}
		else if(option == 4) {
			int pos = findAnuncioById(item.getCod());
			anuncios.remove(pos);
			delete = true;
		}
		else if(option == 5) goBack = true;
		
		System.out.println("\n###################################\n");
		
		if(goBack)menuListagem(pageAnuncios,"anuncios");
		else if(delete)menuAnuncios();
		else detalharAnuncioColecao(item);
	}
	
 	// M�todo respons�vel por mostrar na tela os detalhes de um An�ncio de Revista e possibilita a edi��o ou remo��o do mesmo 
	public void detalharAnuncioRevista(AnnouncementMagazine item) {
		
		boolean goBack = false;
		boolean delete = false;
		
		System.out.println("*** Detalhes do An�ncio ***\n");
		System.out.println(item);
		System.out.println("(1) Alterar T�tulo do An�ncio");
		System.out.println("(2) Alterar Pre�o da Revista");
		System.out.println("(3) Alterar Nome da Revista");
		System.out.println("(4) Alterar T�tulo da Revista");
		System.out.println("(5) Alterar Data da Publica��o da Revista");
		System.out.println("(6) Deletar An�ncio");
		System.out.println("(7) Voltar para a Listagem de An�ncios\n");
		
		int options[] = {1,2,3,4,5,6,7};
		
		int option = takeIntInPrompt("Digite a op��o desejada -> ","Op��o n�o existente!\n",options);
		
		input.nextLine();
		
		if(option == 1) {
			String newTitle = requestString("\nDigite o novo T�tulo do An�ncio -> ","Problema com o novo T�tulo do An�ncio!");
			item.setTitle(newTitle);
		}
		else if(option == 2) {
			double value = requestDouble("\nDigite o novo Pre�o da Revista -> ","Problema com o novo Pre�o da Revista!");
			item.setValue(value);
		}
		else if(option == 3) {
			String newName = requestString("\nDigite o novo Nome da Revista -> ","Problema com o novo Nome da Revista!");
			item.setMagazineName(newName);
		}
		else if(option == 4) {
			String newTitleMagazine = requestString("\nDigite o novo T�tulo da Revista -> ","Problema com o novo T�tulo da Revista!");
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
		
		if(goBack)menuListagem(pageAnuncios,"anuncios");
		else if(delete)menuAnuncios();
		else detalharAnuncioRevista(item);
	}
	
	// M�todo respons�vel por mostrar na tela os detalhes de um An�ncio de Assinatura de Revista e possibilita a edi��o ou remo��o do mesmo 
	public void detalharAnuncioAssinatura(AnnouncementMagazineSubscription item) {
		
		boolean goBack = false;
		boolean delete = false;
		
		System.out.println("*** Detalhes do An�ncio ***\n");
		System.out.println(item);
		System.out.println("(1) Alterar T�tulo do An�ncio");
		System.out.println("(2) Alterar Pre�o da Assinatura da Revista");
		System.out.println("(3) Alterar Nome da Revista");
		System.out.println("(4) Deletar An�ncio");
		System.out.println("(5) Voltar para a Listagem de An�ncios\n");
		
		int options[] = {1,2,3,4,5};
		
		int option = takeIntInPrompt("Digite a op��o desejada -> ","Op��o n�o existente!\n",options);
		
		input.nextLine();
		
		if(option == 1) {
			String newTitle = requestString("\nDigite o novo T�tulo do An�ncio -> ","Problema com o novo T�tulo do An�ncio!");
			item.setTitle(newTitle);
		}
		else if(option == 2) {
			double newValue = requestDouble("\nDigite o novo Pre�o da Assinatura da Revista -> ","Problema com o novo Pre�o da Assinatura da Revista!");
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
		
		if(goBack)menuListagem(pageAnuncios,"anuncios");
		else if(delete)menuAnuncios();
		else detalharAnuncioAssinatura(item);
	}

	// M�todo respons�vel por solicitar ao usu�rio as informa��es necess�rias para criar um novo Frete
	public void telaNovoFrete() {
		System.out.println("*** Novo Frete ***\n");
		
		String company = requestString("Nome da Empresa -> ", "Problema com o Nome da Empresa!\n");
		
		String termMax = requestString("Prazo m�ximo    -> ","Problema com o Prazo m�ximo!\n");
			
		double valueMin = requestDouble("Valor m�nimo    -> R$","Problema com o Valor m�nimo!\n");

		double cost = requestDouble("Custo           -> R$","Problema com o Custo\n");
			
		input.nextLine();
		
		Shipping newFrete = new Shipping(company, termMax, valueMin, cost);
			
		addFrete(newFrete);
			
		System.out.println("\n###################################\n");
			
		menuFretes();
	}
	
	// M�todo respons�vel por perguntar qual tipo de An�ncio o usu�rio quer criar
	public void telaNovoAnuncio() {
		System.out.println("*** Novo An�ncio ***\n");
		System.out.println("(1) An�ncio de Livro");
		System.out.println("(2) An�ncio de Cole��o de Livros");
		System.out.println("(3) An�ncio de Revista");
		System.out.println("(4) An�ncio de Assinatura de Revista");
		System.out.println("(5) Voltar para Menu de An�ncios\n");

		int options[] = {1,2,3,4,5};
		
		int option = takeIntInPrompt("Informe qual tipo do novo an�ncio -> ","Op��o n�o existente!\n",options);
		
		input.nextLine();
		
		System.out.println("\n###################################\n");
		
		if(option == 1)novoAnuncioLivro();
		else if(option == 2)novoAnuncioColecao();
		else if(option == 3)novoAnuncioRevista();
		else if(option == 4)novoAnuncioAssinatura();
		else if(option == 5)menuAnuncios();
	}
	
	// M�todo respons�vel por solicitar ao usu�rio as informa��es necess�rias para criar um novo An�ncio de Livro
	public void novoAnuncioLivro() {

		System.out.println("*** Novo An�ncio de Livro ***\n");
			
		String title = requestString("T�tulo do An�ncio          -> ", "Problema com o T�tulo do An�ncio!\n");
		
		double value = requestDouble("Pre�o do Livro             -> R$ ","Problema com o Pre�o do Livro!\n");
			
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

	// M�todo respons�vel por solicitar ao usu�rio as informa��es necess�rias para criar um novo An�ncio de Cole��o de Livros
	public void novoAnuncioColecao() {
		
		System.out.println("*** Novo An�ncio de Cole��o de Livros ***\n");
			
		String title = requestString("T�tulo do An�ncio          -> ", "Problema com o T�tulo do An�ncio!\n");
		
		double value = requestDouble("Pre�o da Cole��o de Livros -> R$ ","Problema com o Pre�o da Cole��o de Livros!\n");
			
		input.nextLine();
			
		String name = requestString("Nome da Cole��o de Livros  -> ","Problema com o Nome da Cole��o de Livros!\n");
			
		AnnouncementBookCollection newBookCollection = new AnnouncementBookCollection(title, value, name);
			
		addAnuncio(newBookCollection);
			
		System.out.println("\n###################################\n");
			
		menuAnuncios();
	}
	
	// M�todo respons�vel por solicitar ao usu�rio as informa��es necess�rias para criar um novo An�ncio de Revista
	public void novoAnuncioRevista() {
		System.out.println("*** Novo An�ncio de Revista ***\n");
			
		String title = requestString("T�tulo do An�ncio -> ", "Problema com o T�tulo do An�ncio!\n");
		
		double value = requestDouble("Pre�o da Revista  -> R$ ","Problema com o Pre�o da Revista!\n");
			
		input.nextLine();
			
		String magazineName = requestString("Nome da Revista   -> ","Problema com o Nome da Revista!\n");

		String magazineTitle = requestString("T�tulo da Revista -> ","Problema com o T�tulo da Revista\n");
			
		Date date = solicitarDataPublicacao("revista",false);
			
		AnnouncementMagazine newMagazine = new AnnouncementMagazine(title, value, magazineName,magazineTitle,date);
			
		addAnuncio(newMagazine);
			
		System.out.println("\n###################################\n");
			
		menuAnuncios();
	}
	
	// M�todo respons�vel por solicitar ao usu�rio as informa��es necess�rias para criar um novo An�ncio de Assinatura de Revista
	public void novoAnuncioAssinatura() {
	
		System.out.println("*** Novo An�ncio de Assinatura de Revista ***\n");
			
		String title = requestString("T�tulo do An�ncio              -> ", "Problema com o T�tulo do An�ncio!\n");
		
		double value = requestDouble("Pre�o da Assinatura de Revista -> R$ ","Problema com o Pre�o da Assinatura de Revista!\n");
			
		input.nextLine();
			
		String magazineSubscriptionName = requestString("Nome da Revista                -> ","Problema com o Nome da Revista!\n");
			
		AnnouncementMagazineSubscription newMagazineSubscription = new AnnouncementMagazineSubscription(title, value, magazineSubscriptionName);
			
		addAnuncio(newMagazineSubscription);
			
		System.out.println("\n###################################\n");
			
		menuAnuncios();
	}
	
	// M�todo respons�vel por solicitar um valor inteiro dentre as op��es de um menu
	public int takeIntInPrompt(String question,String msgError,int options[]) {
		System.out.print(question);
		int value = -1;
		
		try {
			value = input.nextInt();
			boolean isValid = false;
			for(int i = 0; i < options.length;i++) if(options[i] == value)isValid = true;
			if(!isValid) {
				System.out.printf("\nErro -> %s\n",msgError);
				value = takeIntInPrompt(question,msgError,options);
			}
			
		}catch(Exception e) {
			System.out.printf("\nErro -> %s\n",msgError);
			input.nextLine();
			value = takeIntInPrompt(question,msgError,options);
		}
		
		return value;
	}

	// M�todo respons�vel por adicionar um novo An�ncio no ArrayList 'anuncios'
	public void addAnuncio(Announcement item) {
		anuncios.add(item);
	}

	// M�todo respons�vel por adicionar um novo Frete no ArrayList 'fretes'
	public void addFrete(Shipping item) {
		fretes.add(item);
	}
		
	// M�todo respons�vel por encontrar um An�ncio
	public int findAnuncioById(String cod) {
		for(int i = 0; i < anuncios.size(); i++) {
			if(anuncios.get(i).getCod() == cod)return i;
		}
		return -1;
	}
	
	// M�todo respons�vel por encontrar um Frete
	public int findFreteById(String cod) {
		for(int i = 0; i < fretes.size(); i++) {
			if(fretes.get(i).getCod() == cod)return i;
		}
		return -1;
	}

	// M�todo respons�vel por solicitar um inteiro positivo qualquer para o usu�rio
	public int requestInt(String question,String msgError) {
		System.out.print(question);
		int value = -1;
		
		try {
			value = input.nextInt();
			if(value <= 0) {
				System.out.printf("\nErro -> %s\n",msgError);
				value = requestInt(question,msgError);
			}
		}catch(Exception e) {
			System.out.printf("\nErro -> %s\n",msgError);
			input.nextLine();
			value = requestInt(question,msgError);
		}
		
		return value;
	}
	
	// M�todo respons�vel por solicitar um double para o usu�rio
	public double requestDouble(String question,String msgError) {
		System.out.print(question);
		double value = -1;
		
		try {
			value = input.nextDouble();
			if(value <= 0) {
				System.out.printf("\nErro -> %s\n",msgError);
				value = requestDouble(question,msgError);
			}
		}catch(Exception e) {
			System.out.printf("\nErro -> %s\n",msgError);
			input.nextLine();
			value = requestDouble(question,msgError);
		}
		
		return value;
	}
	
	// M�todo respons�vel por solicitar uma String para o usu�rio
	public String requestString(String question,String msgError) {
		System.out.print(question);
		String value = "";
		
		try {
			value = input.nextLine();
			if(value == "") {
				System.out.printf("\nErro -> %s\n",msgError);
				value = requestString(question,msgError);
			}
		}catch(Exception e) {
			System.out.printf("\nErro -> %s\n",msgError);
			input.nextLine();
			value = requestString(question,msgError);
		}
		
		return value;
	}

	// M�todo respons�vel por solicitar uma Data para o usu�rio
	public Date solicitarDataPublicacao(String type,boolean isNew) {
		Date newDate;
		String questionDay = String.format("\nDigite o%s dia da Publica��o %s -> ",isNew ? " novo" : "", type == "livro" ? "do Livro" : "da Revista");
		String questionMonth = String.format("\nDigite o%s m�s da Publica��o %s -> ",isNew ? " novo" : "", type == "livro" ? "do Livro" : "da Revista");
		String questionYear = String.format("\nDigite o%s ano da Publica��o %s -> ",isNew ? " novo" : "", type == "livro" ? "do Livro" : "da Revista");
		String msgDay = String.format("Problema com o%s dia da Publica��o %s!",isNew ? " novo" : "", type == "livro" ? "do Livro" : "da Revista");
		String msgMonth = String.format("Problema com o%s m�s da Publica��o %s!",isNew ? " novo" : "", type == "livro" ? "do Livro" : "da Revista");
		String msgYear = String.format("Problema com o%s ano da Publica��o %s!",isNew ? " novo" : "", type == "livro" ? "do Livro" : "da Revista");
		
		int newDay = requestInt(questionDay,msgDay);
		int newMonth = requestInt(questionMonth,msgMonth);
		int newYear = requestInt(questionYear,msgYear);
		
		try {
			newDate = new Date(newYear,newMonth,newDay);
		}catch(Exception e) {
			System.out.println("\nErro -> Data inv�lida!");
			newDate = solicitarDataPublicacao(type,isNew);
		}
		
		return newDate;
	}
	
}
