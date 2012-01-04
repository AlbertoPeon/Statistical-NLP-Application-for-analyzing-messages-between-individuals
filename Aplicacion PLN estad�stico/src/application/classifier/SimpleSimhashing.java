package application.classifier;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import application.model.Mensaje;
import application.model.Simhash;

/**
 * Calcula mensajes similares utilizando la técnica de Simhashing, por la cual
 * se calcula un hash para cada mensaje de tal forma que mensajes con terminos
 * similares tengan el mismo hash.
 * 
 * 
 * @see <a href="http://knol.google.com/k/simple-simhashing#">Knol de Simple
 *      Simhashing</a>
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class SimpleSimhashing implements FiltroMensajes {
	private int numeroRepeticion;
	private int nGramNumber;
	public final static int DEFAULT_NUMERO_REPETICION = 3;
	public final static int DEFAULT_NGRAM_NUMBER = 3;

	public SimpleSimhashing() {
		this.numeroRepeticion = DEFAULT_NUMERO_REPETICION;
		this.nGramNumber = DEFAULT_NGRAM_NUMBER;
	}

	public SimpleSimhashing(int numeroRepeticion, int nGramNumber) {
		super();
		this.numeroRepeticion = numeroRepeticion;
		this.nGramNumber = nGramNumber;
	}

	/**
	 * Calcula si los dos mensajes que se pasan como parámetro son similares
	 * 
	 * @return true si ambos mensajes tienen el mismo Simhash, y por tanto son
	 *         similares, false si no lo son
	 */
	@Override
	public boolean esSimilar(Mensaje m1, Mensaje m2) {
		return calcularSimhash(m1) == calcularSimhash(m2);
	}

	/**
	 * Para calcular el simhashing de un mensaje, primero se convierte el texto
	 * en un Set de String, se añade a una cola de prioridad los hash de cada
	 * String del Set y se seleccionan un número de hashcodes que se suman. Eso
	 * da como resultado el Simhash de cada elemento
	 * 
	 * @param mensaje
	 *            mensaje cuyo simhash se va a calcular
	 * @return valor del simhash del mensaje
	 */
	private int calcularSimhash(Mensaje mensaje) {
		if (mensaje.getSimhash() != null) {
			return mensaje.getSimhash().getValue();
		}
		int simhash = 0;
		Set<String> set = convertirMensajeSet(mensaje.getTexto());
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for (String s : set) {
			queue.add(s.hashCode());
		}
		for (int i = 0; i < this.numeroRepeticion && i < queue.size(); i++) {
			simhash += queue.poll();
		}
		mensaje.setSimhash(new Simhash(simhash));
		return simhash;
	}

	private Set<String> convertirMensajeSet(String texto) {
		Set<String> set = new HashSet<String>();
		String[] palabras = texto.split(" ");

		for (int i = 0; i < palabras.length - this.nGramNumber + 1; i++) {
			String concatenado = "";
			for (int j = 0; j < nGramNumber; j++) {
				concatenado += palabras[i + j] + " ";
			}
			concatenado = concatenado.substring(0, concatenado.length() - 1);
			set.add(concatenado);
		}
		return set;
	}

}
