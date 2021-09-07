
public class Shopping {
	private Announcement product;
	private User buyer;
	private User salesman;
	private Shipping shipping;
	
	//construtor
	public Shopping(Announcement product, User buyer, User salesman, Shipping shipping) {
		super();
		this.product = product;
		this.buyer = buyer;
		this.salesman = salesman;
		this.shipping = shipping;
	}

	//getters e setters
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
	
	//método de exibir os dados do usuário após cadastrado
	public String toString() {
		return "\n" + "Produto: " + getProduct() + "\n" + "Comprador(a): " + getBuyer() +
				"\n" + "Vendedor: " + getSalesman() + "\n" + "Envio: " + getShipping();
	}
}
