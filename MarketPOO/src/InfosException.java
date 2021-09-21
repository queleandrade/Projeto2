//InfosException subclasse de RuntimeException com o objetivo de lançar exeções com mensagem de detalhe especificada
public class InfosException extends RuntimeException{

	private static final long serialVersionUID = 1L; //identificador de versão universal para uma classe Serializable

	//construtor da classed DateException
	public InfosException(String msg) { //referenciando a classe pai
		super(msg);
	}

	// Método criado para tratar erro no CPF
	//Caso a quantidade de número inserida pelo usuário do cpf for diferente de 11 números, gera uma exceção
	public static void validarCPF(String CPF) {
		if (CPF.length() != 11) throw new InfosException("CPF inválido");
	}
}

