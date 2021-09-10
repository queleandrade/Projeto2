import java.util.ArrayList;

//classe do usuário que contém seus atributos como nome, sobrenome, cpf, e-mail, cidade, senha e o tipo de usuário.

public class User {
	private String name;
	private String surname;
	private String cpf;
	private String email;
	private String city;
	private String password;
	private String type;
	private ArrayList<Shopping> myShopping;
	private ArrayList<Shopping> mySales;
	
   //construtor
	public User(String name, String surname, String cpf, String email, String city, String password, String type) {
		super();
		this.name = name;
		this.surname = surname;
		this.cpf = cpf;
		this.email = email;
		this.city = city;
		this.password = password;
		this.type = type;
	}
	
	//método settters e getters
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
}
