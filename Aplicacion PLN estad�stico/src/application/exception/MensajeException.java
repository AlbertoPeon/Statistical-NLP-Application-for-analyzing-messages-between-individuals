package application.exception;

/**
 * Excepción que se lanza cuando se produce algún problema con un mensaje (por
 * ejemplo, se busca un mensaje que no existe)
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
@SuppressWarnings("serial")
public class MensajeException extends Exception {
	private String texto;

	public MensajeException(String texto) {
		this.texto = texto;
	}

	@Override
	public String getMessage() {
		return texto;
	}
}
