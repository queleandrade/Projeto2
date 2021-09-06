// Classe de An�ncio de Cole��o de Livros

public class AnnouncementBookCollection extends Announcement{
	private String bookCollectionName;

	public AnnouncementBookCollection(String title, double value, String bookCollectionName) {
		super(title, value);
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
		return String.format("%sTipo              -> Cole��o de Livros \nNome da Cole��o   -> %s \n",super.toString(),bookCollectionName);
	}
}
