// Subclasse da classe an�ncio para cole��o de livros 

public class AnnouncementBookCollection extends Announcement{
	//variav�is de inst�ncias
	private String bookCollectionName;

	//construtor
	public AnnouncementBookCollection(String title, double value, User advertiser, String bookCollectionName) {
		super(title, value, advertiser); //referenciando a classe pai
		this.bookCollectionName = bookCollectionName;
	}

	//m�todo get e set
	public String getBookCollectionName() {
		return bookCollectionName;
	}

	public void setBookCollectionName(String bookCollectionName) {
		this.bookCollectionName = bookCollectionName;
	}
	
	//M�todo toString sobrescrito que mostra os dados para o usu�rio
	@Override
	public String toString() {
		return String.format("%sTipo              -> Cole��o de Livros \nNome da Cole��o   -> %s \n",super.toString(),bookCollectionName);
	}
}
