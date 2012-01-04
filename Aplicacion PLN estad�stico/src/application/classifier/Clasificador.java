package application.classifier;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import application.model.Mensaje;

/**
 * Clase que implementa un clasificador de mensajes entrenable que permita, una
 * vez suficientemente entrenado, identificar mensajes similares. Funciona como
 * patrón Adapter para acceder a la biblioteca que implementa el verdadero
 * funcionamiento del clasificador
 * 
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class Clasificador implements Serializable {
	private ClasificadorBayesianoIngenuo classifier;
	/**
	 * 
	 */
	private static final long serialVersionUID = 6584440774651915806L;
	private static final String DEFAULT_CATEGORY = "";
	private List<String> categorias;

	public Clasificador() {
		classifier = new ClasificadorBayesianoIngenuo();
		categorias = new LinkedList<String>();
	}

	/**
	 * Entrena el mensajes que se le pasa como parámetro en la categoría
	 * indicada
	 * 
	 * @param mensaje
	 *            Mensaje que se va a utilizar para entrenar el clasificador
	 * @param categoria
	 *            Categoría a la que pertenece ese mensaje
	 */
	public void entrenar(Mensaje mensaje, String categoria) {
		if (!categorias.contains(categoria)
				&& !categoria.equals(DEFAULT_CATEGORY))
			categorias.add(categoria);
		classifier.train(mensaje.getTexto(), categoria);
	}

	/**
	 * Permite comprobar si el mensaje que se le pasa por parámetro pertenece a
	 * la categoría
	 * 
	 * @param mensaje
	 * @param categoria
	 * @return true si el clasificador identifica el mensaje como perteneciente
	 *         a la categoría, false en caso contrario
	 */
	public boolean esAcierto(Mensaje mensaje, String categoria) {
		boolean b = classifier.classification(mensaje.getTexto()).equals(
				categoria);
		return b;
	}

	/**
	 * 
	 * @return devuelve la lista de categorias del clasificador
	 */
	public List<String> getCategorias() {
		return categorias;
	}

	/**
	 * Clasifica el texto que se le pasa como parámetro
	 * 
	 * @param texto
	 *            texto a clasificar
	 * @return la categoría a la que tiene más probabilidad de pertenecer el
	 *         texto
	 */
	public String clasificar(String texto) {
		String categoria = classifier.featureClassification(texto);
		return categoria;
	}

	/**
	 * Se entrena el mensaje en la categoría por defecto
	 * 
	 * @param mensaje
	 *            mensaje a entrenar
	 */
	public void entrenar(Mensaje mensaje) {
		entrenar(mensaje, DEFAULT_CATEGORY);

	}

}
