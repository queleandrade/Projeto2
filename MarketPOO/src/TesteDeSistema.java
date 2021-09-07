// Classe responsável por realizar testes do sistema

public class TesteDeSistema {
	
	// Método responsável por testar a criação de um novo Anúncio
	public void testeNovoAnuncio(ScreenMain tela) {
		System.out.println("*** Criando um Anúncio ***\n");
		String title = "Anúncio de Teste";
		double value = 75.30;
		String bookCollectionName = "Coleção de Teste";
		AnnouncementBookCollection anuncioTeste = new AnnouncementBookCollection(title, value, bookCollectionName);
		tela.telaAnuncios.addAnuncio(anuncioTeste);
		System.out.println(anuncioTeste);
		System.out.println("Fim -> Anúncio criado com sucesso\n");
		System.out.println("---------------------------------------\n");
	}
	
	// Método responsável por testar a criação de um novo Frete
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
