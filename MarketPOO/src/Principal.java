// Classe Principal responsável por inicializar a aplicação e inserir os primeiros anúncios e fretes

public class Principal {
	public static void main(String[] args) {
		TesteDeSistema teste = new TesteDeSistema();
		ScreenMain tela = new ScreenMain();

		//System.out.println("-> Início dos Testes\n");
		
		//teste.testeNovoAnuncio(tela);
		//teste.testeNovoFrete(tela);
		
		//System.out.println("Fim dos Testes");
		//System.out.println("\n###################################\n");
		
		tela.telaFretes.addFrete(new Shipping("Correios","10 dias",250,10));
		tela.telaFretes.addFrete(new Shipping("Mercado livre","5 dias",400,40));
		tela.telaFretes.addFrete(new Shipping("Sedex","2 dias",500,60));
		tela.telaFretes.addFrete(new Shipping("FedEx","1 dias",800,100));
		
		tela.telaAnuncios.addAnuncio(new AnnouncementBook("Compre o melhor livro de C.S. Lewis", 52.65,"Crônicas de Nárnia","C.S. Lewis","WMF Martins Fontes",new Date(2009,1,8)));
		tela.telaAnuncios.addAnuncio(new AnnouncementBook("Compre o livro que descreve o liberalismo clássico", 115.60,"A Riqueza das Nações","Adam Smith","Nova Fronteira",new Date(1776,3,9)));
		tela.telaAnuncios.addAnuncio(new AnnouncementBook("Compre o livro que descreve as incongruências capitalistas",250.60,"O Capital","Karl Marx","Veneta",new Date(1867,9,14)));
		tela.telaAnuncios.addAnuncio(new AnnouncementBook("Compre a melhor obra de George Orwell", 52.30,"A revolução dos bichos","George Orwell","Veneta",new Date(1945,8,17)));
		tela.telaAnuncios.addAnuncio(new AnnouncementBook("Compre a melhor obra de J. R. R. Tolkien", 78.90,"O Senhor dos Anéis","J. R. R. Tolkien","Veneta",new Date(1609,10,11)));
		tela.telaAnuncios.addAnuncio(new AnnouncementBook("Compre uma das melhores obras de William Shakespeare", 53.40,"Hamlet","William Shakespeare","Veneta",new Date(1954,7,29)));
		tela.telaAnuncios.addAnuncio(new AnnouncementBook("Compre uma das melhores obras de Machado de Assis", 85.20,"Dom Casmurro","Machado de Assis","Veneta",new Date(1890,2,13)));
		tela.telaAnuncios.addAnuncio(new AnnouncementBook("Compre uma das melhores obras de Miguel de Cervantes", 75.60,"Dom Quixote","Miguel de Cervantes","Veneta",new Date(1605,7,10)));	
		tela.telaAnuncios.addAnuncio(new AnnouncementBook("Compre um clássico da literatura brasileira",45.85,"Memórias Póstumas de Brás Cubas","Machado de Assis","Veneta",new Date(1881,12,7)));	
		tela.telaAnuncios.addAnuncio(new AnnouncementMagazine("Se informe com a Veja", 11.70, "Revista Veja","Eleições 2022",new Date(2021,8,18)));
		tela.telaAnuncios.addAnuncio(new AnnouncementMagazineSubscription("Se informe mensalmente com a Veja", 12.70, "Revista Veja"));
		tela.telaAnuncios.addAnuncio(new AnnouncementMagazine("Se informe com a Carta Capital", 11.70, "Carta Capital","O vírus Bolsonaro",new Date(2021,8,15)));
		tela.telaAnuncios.addAnuncio(new AnnouncementMagazineSubscription("Se informe mensalmente com a Carta Capital", 12.70, "Carta Capital"));
		tela.telaAnuncios.addAnuncio(new AnnouncementBookCollection("Coleção C.S. Lewis", 125.80, "Coleção de Livros de C.S. Lewis"));
		tela.telaAnuncios.addAnuncio(new AnnouncementBookCollection("Coleção Adam Smith", 170.85, "Coleção de Livros de Adam Smith"));
		tela.telaAnuncios.addAnuncio(new AnnouncementBookCollection("Coleção Karl Marx", 285.96, "Coleção de Livros de Karl Marx"));
		tela.telaAnuncios.addAnuncio(new AnnouncementBookCollection("Coleção J. R. R. Tolkien", 356.80, "Coleção de Livros de J. R. R. Tolkien"));
		tela.telaAnuncios.addAnuncio(new AnnouncementBookCollection("Coleção Machado de Assis", 235.50, "Coleção de Livros de Machado de Assis"));
		tela.telaAnuncios.addAnuncio(new AnnouncementBookCollection("Coleção George Orwell", 240.65, "Coleção de Livros de George Orwell"));
		tela.telaAnuncios.addAnuncio(new AnnouncementBookCollection("Coleção Miguel de Cervantes", 235.74, "Coleção de Livros de Miguel de Cervantes"));
		tela.telaAnuncios.addAnuncio(new AnnouncementBookCollection("Coleção William Shakespeare", 195.63, "Coleção de Livros de William Shakespeare"));
		
		tela.menuPrincipal();
	}
}
