
public class InfosException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InfosException(String msg) {
		super(msg);
	}

	// Método criado para tratar erro no CPF
	public static void validarCPF(String CPF) {
		if (CPF.length() != 11) throw new InfosException("CPF inválido");
	}

}
