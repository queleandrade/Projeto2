// Subclasse da classe anúncio para anúncio de revistas

public class AnnouncementMagazine extends Announcement{
	//variavéis de instâncias
	private String magazineName;
	private String magazineTitle;
	private Date magazinePublicationDate;
	
	//construtor
	public AnnouncementMagazine(String title, double value, User advertiser, String magazineName, String magazineTitle, Date magazinePublicationDate) {
		super(title, value, advertiser); //referenciando a classe pai
		this.magazineName = magazineName;
		this.magazineTitle = magazineTitle;
		this.magazinePublicationDate = magazinePublicationDate;
	}

	//Metódo getters e stters
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
	
	//Método toString sobrescrito que mostra os dados para o usuário
	@Override
	public String toString() {
		return String.format("%sTipo              -> Revista \nNome da Revista   -> %s \nTítulo da Revista -> %s \nPublicação        -> %s \n",super.toString(),magazineName,magazineTitle,magazinePublicationDate);
	}
	
}
