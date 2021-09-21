// Subclasse de An�ncio para o an�ncio dos livros

public class AnnouncementBook extends Announcement{
	//variav�is de inst�ncias
	private String bookName;
	private String bookAuthor;
	private String bookPublishingCompany;
	private Date bookPublicationDate;
	
	//construtor
	public AnnouncementBook(String title, double value, User advertiser, String bookName, String bookAuthor, String bookPublishingCompany, Date bookPublicationDate) {
		super(title, value, advertiser); //referenciando a classe pai
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPublishingCompany = bookPublishingCompany;
		this.bookPublicationDate = bookPublicationDate;
	}

	//M�todo getters e setters
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

	//M�todo toString sobrescrito que mostra os dados para o usu�rio
	@Override
	public String toString() {
		return String.format("%sTipo              -> Livro\nNome do livro     -> %s \nAutor             -> %s \nEditora           -> %s \nPublica��o        -> %s\n",super.toString(),bookName,bookAuthor,bookPublishingCompany,bookPublicationDate);
	}
}
