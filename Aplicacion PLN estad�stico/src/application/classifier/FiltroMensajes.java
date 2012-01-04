package application.classifier;

import application.model.Mensaje;

/**
 * Interfaz que deberán implementar todas las clases que implementen algún
 * algoritmo de búsqueda de mensajes similares
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public interface FiltroMensajes {
	/**
	 * Comparara si los dos mensajes que se le pasan como parámetro son
	 * similares
	 * 
	 * @return true si son similares, false si no lo son
	 */
	public boolean esSimilar(Mensaje m1, Mensaje m2);
}
