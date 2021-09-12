// Classe respons�vel por realizar testes do sistema

public class TesteDeSistema {
	
	// M�todo respons�vel por testar a cria��o de um novo An�ncio
	public void testeNovoAnuncio(ScreenMain tela) {
		System.out.println("*** Criando um An�ncio ***\n");
		String title = "An�ncio de Teste";
		double value = 75.30;
		String bookCollectionName = "Cole��o de Teste";
		User usuarioAdm = new User("Mateus","Brasil","07893080531","teu@gmail.com","Amargosa","123456","Admnistrador");
		AnnouncementBookCollection anuncioTeste = new AnnouncementBookCollection(title, value,usuarioAdm, bookCollectionName);
		tela.telaCliente.addAnuncio(anuncioTeste,usuarioAdm);
		System.out.println(anuncioTeste);
		System.out.println("Fim -> An�ncio criado com sucesso\n");
		System.out.println("---------------------------------------\n");
	}
	
	// M�todo respons�vel por testar a cria��o de um novo Frete
	public void testeNovoFrete(ScreenMain tela) {
		System.out.println("*** Criando um Frete ***\n");
		String company = "Frete de Teste";
		double valueMin = 115.80;
		double cost = 25.50;
		String termMax = "7 dias";
		Shipping freteTeste = new Shipping(company, termMax, valueMin, cost);
		tela.telaFretes.addFrete(freteTeste);
		System.out.println(freteTeste);
		System.out.println("Fim -> Frete criado com sucesso\n");
		System.out.println("---------------------------------------\n");
	}

}
