// Classe de Anúncio de Coleção de Livros

public class AnnouncementBookCollection extends Announcement{
	private String bookCollectionName;

	public AnnouncementBookCollection(String title, double value, User advertiser, String bookCollectionName) {
		super(title, value, advertiser);
		this.bookCollectionName = bookCollectionName;
	}

	public String getBookCollectionName() {
		return bookCollectionName;
	}

	public void setBookCollectionName(String bookCollectionName) {
		this.bookCollectionName = bookCollectionName;
	}
	
	@Override
	public String toString() {
		return String.format("%sTipo              -> Coleção de Livros \nNome da Coleção   -> %s \n",super.toString(),bookCollectionName);
	}
}
