// Classe de Anúncio de Livro

public class AnnouncementBook extends Announcement{
	private String bookName;
	private String bookAuthor;
	private String bookPublishingCompany;
	private Date bookPublicationDate;
	
	public AnnouncementBook(String title, double value, String bookName, String bookAuthor, String bookPublishingCompany, Date bookPublicationDate) {
		super(title, value);
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPublishingCompany = bookPublishingCompany;
		this.bookPublicationDate = bookPublicationDate;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookPublishingCompany() {
		return bookPublishingCompany;
	}

	public void setBookPublishingCompany(String bookPublishingCompany) {
		this.bookPublishingCompany = bookPublishingCompany;
	}

	public Date getBookPublicationDate() {
		return bookPublicationDate;
	}

	public void setBookPublicationDate(Date bookPublicationDate) {
		this.bookPublicationDate = bookPublicationDate;
	}

	@Override
	public String toString() {
		return String.format("%sTipo              -> Livro\nNome do livro     -> %s \nAutor             -> %s \nEditora           -> %s \nPublicação        -> %s\n",super.toString(),bookName,bookAuthor,bookPublishingCompany,bookPublicationDate);
	}
}
