// Classe Principal responsável por inicializar a aplicação e inserir os primeiros anúncios e fretes

public class Principal {
	public static void main(String[] args) {
		
		//Cria o objeto tela refrente a classe responsável por renderizar todos os menus do projeto
		ScreenMain tela = new ScreenMain();
		
		//Criando o usuário direto no código
		User usuarioAdm = new User("Mateus","Brasil","07893080531","teu@gmail.com","Amargosa","123456","Admnistrador");
		User usuarioComum = new User("Lucas","Alencar","07893080531","lucas@gmail.com","Amargosa","123456","Comum");
		
		//adicionando o usuário ao sistema
		tela.usuarios.add(usuarioAdm);
		tela.usuarios.add(usuarioComum);
		tela.usuarioAtual = usuarioAdm;
		
		//adcionando os tipos de frete, sendo quatros tipos distintos
		tela.telaFretes.addFrete(new Shipping("Correios","10 dias",250,10));
		tela.telaFretes.addFrete(new Shipping("Mercado livre","5 dias",400,40));
		tela.telaFretes.addFrete(new Shipping("Sedex","2 dias",500,60));
		tela.telaFretes.addFrete(new Shipping("FedEx","1 dias",800,100));

		//cadastro de 21 anúncios 
		tela.telaCliente.addAnuncio(new AnnouncementBook("Compre o melhor livro de C.S. Lewis", 52.65,usuarioAdm,"Crônicas de Nárnia","C.S. Lewis","WMF Martins Fontes",new Date(2009,1,8)),usuarioAdm);
		tela.telaCliente.addAnuncio(new AnnouncementBook("Compre o livro que descreve o liberalismo clássico",115.60, usuarioAdm,"A Riqueza das Nações","Adam Smith","Nova Fronteira",new Date(1776,3,9)),usuarioAdm);
		tela.telaCliente.addAnuncio(new AnnouncementBook("Compre o livro que descreve as incongruências capitalistas",250.60,usuarioAdm,"O Capital","Karl Marx","Veneta",new Date(1867,9,14)),usuarioAdm);
		tela.telaCliente.addAnuncio(new AnnouncementBook("Compre a melhor obra de George Orwell", 52.30,usuarioAdm,"A revolução dos bichos","George Orwell","Veneta",new Date(1945,8,17)),usuarioAdm);
		tela.telaCliente.addAnuncio(new AnnouncementBook("Compre a melhor obra de J. R. R. Tolkien", 78.90,usuarioAdm,"O Senhor dos Anéis","J. R. R. Tolkien","Veneta",new Date(1609,10,11)),usuarioAdm);
		tela.telaCliente.addAnuncio(new AnnouncementBook("Compre uma das melhores obras de William Shakespeare", 53.40,usuarioAdm,"Hamlet","William Shakespeare","Veneta",new Date(1954,7,29)),usuarioAdm);
		tela.telaCliente.addAnuncio(new AnnouncementBook("Compre uma das melhores obras de Machado de Assis", 85.20,usuarioAdm,"Dom Casmurro","Machado de Assis","Veneta",new Date(1890,2,13)),usuarioAdm);
		tela.telaCliente.addAnuncio(new AnnouncementBook("Compre uma das melhores obras de Miguel de Cervantes", 75.60,usuarioAdm,"Dom Quixote","Miguel de Cervantes","Veneta",new Date(1605,7,10)),usuarioAdm);	
		tela.telaCliente.addAnuncio(new AnnouncementBook("Compre um clássico da literatura brasileira",45.85,usuarioAdm,"Memórias Póstumas de Brás Cubas","Machado de Assis","Veneta",new Date(1881,12,7)),usuarioAdm);	
		tela.telaCliente.addAnuncio(new AnnouncementMagazine("Se informe com a Veja", 11.70,usuarioAdm, "Revista Veja","Eleições 2022",new Date(2021,8,18)),usuarioAdm);
		tela.telaCliente.addAnuncio(new AnnouncementMagazineSubscription("Se informe mensalmente com a Veja", 12.70,usuarioAdm, "Revista Veja"),usuarioAdm);
		tela.telaCliente.addAnuncio(new AnnouncementMagazine("Se informe com a Carta Capital", 11.70,usuarioAdm, "Carta Capital","O vírus Bolsonaro",new Date(2021,8,15)),usuarioAdm);
		tela.telaCliente.addAnuncio(new AnnouncementMagazineSubscription("Se informe mensalmente com a Carta Capital", 12.70,usuarioAdm, "Carta Capital"),usuarioAdm);
		tela.telaCliente.addAnuncio(new AnnouncementBookCollection("Coleção C.S. Lewis", 125.80,usuarioAdm, "Coleção de Livros de C.S. Lewis"),usuarioAdm);
		tela.telaCliente.addAnuncio(new AnnouncementBookCollection("Coleção Adam Smith", 170.85,usuarioAdm, "Coleção de Livros de Adam Smith"),usuarioAdm);
		tela.telaCliente.addAnuncio(new AnnouncementBookCollection("Coleção Karl Marx", 285.96,usuarioAdm, "Coleção de Livros de Karl Marx"),usuarioAdm);
		tela.telaCliente.addAnuncio(new AnnouncementBookCollection("Coleção J. R. R. Tolkien", 356.80,usuarioAdm, "Coleção de Livros de J. R. R. Tolkien"),usuarioAdm);
		tela.telaCliente.addAnuncio(new AnnouncementBookCollection("Coleção Machado de Assis", 235.50,usuarioAdm, "Coleção de Livros de Machado de Assis"),usuarioAdm);
		tela.telaCliente.addAnuncio(new AnnouncementBookCollection("Coleção George Orwell", 240.65,usuarioAdm, "Coleção de Livros de George Orwell"),usuarioAdm);
		tela.telaCliente.addAnuncio(new AnnouncementBookCollection("Coleção Miguel de Cervantes", 235.74,usuarioAdm, "Coleção de Livros de Miguel de Cervantes"),usuarioAdm);
		tela.telaCliente.addAnuncio(new AnnouncementBookCollection("Coleção William Shakespeare", 195.63,usuarioAdm, "Coleção de Livros de William Shakespeare"),usuarioAdm);

		//chamando o menu principal
		tela.menuPrincipal();
	}
}
