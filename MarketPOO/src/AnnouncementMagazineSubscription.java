// Classe de Anúncio de assinatura de Revista

public class AnnouncementMagazineSubscription extends Announcement{
	private String magazineName;

	public AnnouncementMagazineSubscription(String title, double value, User advertiser, String magazineName) {
		super(title, value, advertiser);
		this.magazineName = magazineName;
	}

	public String getMagazineName() {
		return magazineName;
	}

	public void setMagazineName(String magazineName) {
		this.magazineName = magazineName;
	}
	
	@Override
	public String toString() {
		return String.format("%sTipo              -> Assinatura de Revista \nNome da Revista   -> %s \n",super.toString(),magazineName);
	}
}
