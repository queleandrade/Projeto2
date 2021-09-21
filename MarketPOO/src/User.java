import java.util.ArrayList;
import java.util.Random;

//classe do usuário que contém seus atributos como nome, sobrenome, cpf, e-mail, cidade, senha e o tipo de usuário.

public class User {
	//varaivéis de instâncias
	private String id;
	private String name;
	private String surname;
	private String cpf;
	private String email;
	private String city;
	private String password;
	private String type;
	private ArrayList<Shopping> myShopping;
	private ArrayList<Shopping> mySales;
	private ArrayList<Announcement> myAnnouncement;
	
   //construtor
	public User(String name, String surname, String cpf, String email, String city, String password, String type) {
		this.id = GenerateId();
		this.name = name;
		this.surname = surname;
		this.cpf = cpf;
		this.email = email;
		this.city = city;
		this.password = password;
		this.type = type;
		this.myShopping = new ArrayList<Shopping>();
		this.mySales = new ArrayList<Shopping>();
		this.myAnnouncement = new ArrayList<Announcement>();
	}
	
	//Método para adicionar anúncio
	public void addAnnouncement(Announcement item) {
		myAnnouncement.add(item);
	}
	
	//Método para adicionar compras
	public void addShopping(Shopping item) {
		myShopping.add(item);
	}
	
	//Método para adicioanr vendas
	public void addSales(Shopping item) {
		mySales.add(item);
	}
	
	//método settters e getters
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEmail() {
		return email;
	}
	
	public ArrayList<Shopping> getMyShopping() {
		return myShopping;
	}

	public ArrayList<Shopping> getMySales() {
		return mySales;
	}

	public ArrayList<Announcement> getMyAnnouncement() {
		return myAnnouncement;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	//método de exibir os dados do usuário após cadastrado
	public String toString() {
		return "\n" + "Nome: " + getName() + "\n" + "Sobrenome: " + getSurname() +
				"\n" + "CPF: " + getCpf() + "\n" + "E-mail: " + getEmail() + 
				"\n" + "Cidade: " + getCity() + "\n" + "Senha: " + getPassword() +
				"\n" + "Tipo do usuário: " + getType();
	}
	
	//Método para gerar o código
	private String GenerateId() {
		String cod = "";
		Random random = new Random();
		int length = 10;

		char[] characters = {'Q','W','E','R','T','Y','U','I','O','P','A','S','D','F','G','H','J','K','L','Z','X','C','V','B','N','M','0','1','2','3','4','5','6','7','8','9'};

		for(int i = 0; i < length ; i++)cod += characters[random.nextInt(characters.length)];

		return cod;
	}
}
