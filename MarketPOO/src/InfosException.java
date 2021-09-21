//InfosException subclasse de RuntimeException com o objetivo de lan�ar exe��es com mensagem de detalhe especificada
public class InfosException extends RuntimeException{

	private static final long serialVersionUID = 1L; //identificador de vers�o universal para uma classe Serializable

	//construtor da classed DateException
	public InfosException(String msg) { //referenciando a classe pai
		super(msg);
	}

	// M�todo criado para tratar erro no CPF
	//Caso a quantidade de n�mero inserida pelo usu�rio do cpf for diferente de 11 n�meros, gera uma exce��o
	public static void validarCPF(String CPF) {
		if (CPF.length() != 11) throw new InfosException("CPF inv�lido");
	}
}

