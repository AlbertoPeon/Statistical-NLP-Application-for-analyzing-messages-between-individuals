package application.model;

/**
 * Simhash es un valor que se calcula para cada uno de los mensajes y permite
 * identificar mensajes cuyo texto es similar, ya que el valor del Simhash será
 * el mismo en dichos mensajes
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class Simhash {
	private int value;

	public Simhash(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value + "";
	}

}
