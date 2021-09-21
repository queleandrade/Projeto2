// Subclasse de an�ncio para an�ncio de assinatura de revista

public class AnnouncementMagazineSubscription extends Announcement{
	private String magazineName; //variav�l de inst�ncia

	//construtor
	public AnnouncementMagazineSubscription(String title, double value, User advertiser, String magazineName) {
		super(title, value, advertiser); //referenciando a classe pai
		this.magazineName = magazineName;
	}

	//M�todo get e set
	public String getMagazineName() {
		return magazineName;
	}

	public void setMagazineName(String magazineName) {
		this.magazineName = magazineName;
	}
	
	//M�todo toString sobrescrito que mostra os dados para o usu�rio
	@Override
	public String toString() {
		return String.format("%sTipo              -> Assinatura de Revista \nNome da Revista   -> %s \n",super.toString(),magazineName);
	}
}
