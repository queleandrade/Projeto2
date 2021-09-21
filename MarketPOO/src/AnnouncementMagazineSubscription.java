// Subclasse de anúncio para anúncio de assinatura de revista

public class AnnouncementMagazineSubscription extends Announcement{
	private String magazineName; //variavél de instância

	//construtor
	public AnnouncementMagazineSubscription(String title, double value, User advertiser, String magazineName) {
		super(title, value, advertiser); //referenciando a classe pai
		this.magazineName = magazineName;
	}

	//Método get e set
	public String getMagazineName() {
		return magazineName;
	}

	public void setMagazineName(String magazineName) {
		this.magazineName = magazineName;
	}
	
	//Método toString sobrescrito que mostra os dados para o usuário
	@Override
	public String toString() {
		return String.format("%sTipo              -> Assinatura de Revista \nNome da Revista   -> %s \n",super.toString(),magazineName);
	}
}
