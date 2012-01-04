package application.io;

/**
 * Excepción que se lanza en caso de que los mensajes leidos de archivo no
 * puedan ser identificados porque no contienen el protocolo adecuado. Esto solo
 * afecta los mensajes formateados de la forma que lo están los liberados por
 * Wikileaks
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
@SuppressWarnings("serial")
public class NoProtocolException extends Exception {
	private String message;

	public NoProtocolException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
