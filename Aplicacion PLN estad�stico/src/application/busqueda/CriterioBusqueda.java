package application.busqueda;

import java.util.LinkedList;
import java.util.List;

import application.model.Mensaje;

/**
 * Clase abstracta que sirve como esqueleto de cada uno de los criterios por los
 * que se puede hacer una búsqueda
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
abstract public class CriterioBusqueda {

	/**
	 * A partir de una lista de mensajes que se le pasa, devuelve una lista con
	 * aquellos que cumplen el criterio de búsqueda
	 * 
	 * @param todos
	 *            Lista de mensajes a comprobar
	 * @return Mensajes que cumplen el criterio de búsqueda
	 */
	public List<Mensaje> seleccionarMensajes(List<Mensaje> todos) {
		List<Mensaje> seleccionados = new LinkedList<Mensaje>();
		for (Mensaje m : todos) {
			if (cumpleCriterio(m))
				seleccionados.add(m);
		}
		return seleccionados;
	}

	abstract protected boolean cumpleCriterio(Mensaje m);

}
