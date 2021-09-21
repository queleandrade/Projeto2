// Subclasse da classe anúncio para coleção de livros 

public class AnnouncementBookCollection extends Announcement{
	//variavéis de instâncias
	private String bookCollectionName;

	//construtor
	public AnnouncementBookCollection(String title, double value, User advertiser, String bookCollectionName) {
		super(title, value, advertiser); //referenciando a classe pai
		this.bookCollectionName = bookCollectionName;
	}

	//método get e set
	public String getBookCollectionName() {
		return bookCollectionName;
	}

	public void setBookCollectionName(String bookCollectionName) {
		this.bookCollectionName = bookCollectionName;
	}
	
	//Método toString sobrescrito que mostra os dados para o usuário
	@Override
	public String toString() {
		return String.format("%sTipo              -> Coleção de Livros \nNome da Coleção   -> %s \n",super.toString(),bookCollectionName);
	}
}
