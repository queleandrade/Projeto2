// Subclasse da classe an�ncio para an�ncio de revistas

public class AnnouncementMagazine extends Announcement{
	//variav�is de inst�ncias
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

	//Met�do getters e stters
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
	
	//M�todo toString sobrescrito que mostra os dados para o usu�rio
	@Override
	public String toString() {
		return String.format("%sTipo              -> Revista \nNome da Revista   -> %s \nT�tulo da Revista -> %s \nPublica��o        -> %s \n",super.toString(),magazineName,magazineTitle,magazinePublicationDate);
	}
	
}
