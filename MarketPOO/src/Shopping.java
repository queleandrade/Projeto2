
public class Shopping {
	private Announcement product;
	private User buyer;
	private User salesman;
	private Shipping shipping;
	private int quantity;
	
	public Shopping(Announcement product, User buyer, User salesman, Shipping shipping, int quantity) {
		this.product = product;
		this.buyer = buyer;
		this.salesman = salesman;
		this.shipping = shipping;
		this.quantity = quantity;
	}

	//getters e setters
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Announcement getProduct() {
		return product;
	}

	public void setProduct(Announcement product) {
		this.product = product;
	}

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	public User getSalesman() {
		return salesman;
	}

	public void setSalesman(User salesman) {
		this.salesman = salesman;
	}

	public Shipping getShipping() {
		return shipping;
	}

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}
	
	public String getProductName() {
		String produtoNome = "NENHUM";
		if(product instanceof AnnouncementBook) produtoNome = ((AnnouncementBook) product).getBookName();
		else if(product instanceof AnnouncementMagazine) produtoNome = ((AnnouncementMagazine) product).getMagazineName();
		else if(product instanceof AnnouncementMagazineSubscription) produtoNome = ((AnnouncementMagazineSubscription) product).getMagazineName();
		else if(product instanceof AnnouncementBookCollection) produtoNome = ((AnnouncementBookCollection) product).getBookCollectionName();
		return produtoNome;
	}
	
	public String toString() {
		return String.format("Produto       -> %s \nComprador     -> %s \nVendedor      -> %s \nTipo de Frete -> %s \nQuantidade    -> %d", getProductName(),buyer.getName() + " " + buyer.getSurname(),salesman.getName() + " " + salesman.getSurname(),shipping.getCompany(),quantity);
	}

}
