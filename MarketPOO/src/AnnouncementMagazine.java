// Classe de Anúncio de Revistas

public class AnnouncementMagazine extends Announcement{
	private String magazineName;
	private String magazineTitle;
	private Date magazinePublicationDate;
	
	public AnnouncementMagazine(String title, double value, String magazineName, String magazineTitle, Date magazinePublicationDate) {
		super(title, value);
		this.magazineName = magazineName;
		this.magazineTitle = magazineTitle;
		this.magazinePublicationDate = magazinePublicationDate;
	}

	public String getMagazineName() {
		return magazineName;
	}

	public void setMagazineName(String magazineName) {
		this.magazineName = magazineName;
	}

	public String getMagazineTitle() {
		return magazineTitle;
	}

	public void setMagazineTitle(String magazineTitle) {
		this.magazineTitle = magazineTitle;
	}

	public Date getMagazinePublicationDate() {
		return magazinePublicationDate;
	}

	public void setMagazinePublicationDate(Date magazinePublicationDate) {
		this.magazinePublicationDate = magazinePublicationDate;
	}
	
	@Override
	public String toString() {
		return String.format("%sTipo              -> Revista \nNome da Revista   -> %s \nTítulo da Revista -> %s \nPublicação        -> %s \n",super.toString(),magazineName,magazineTitle,magazinePublicationDate);
	}
	
}
