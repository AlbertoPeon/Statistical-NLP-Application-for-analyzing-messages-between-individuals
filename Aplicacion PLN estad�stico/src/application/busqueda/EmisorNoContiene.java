package application.busqueda;

import application.model.Mensaje;

/**
 * Clase que comprueba si el Emisor (Individuo) del mensaje no contiene el
 * String valor
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class EmisorNoContiene extends CriterioBusquedaValor {

	public EmisorNoContiene(String valor) {
		super(valor);
	}

	@Override
	protected boolean cumpleCriterio(Mensaje m) {
		if (m.getEmisor() == null) {
			return false;
		}
		return !m.getEmisor().toString().contains(valor);

	}

}
