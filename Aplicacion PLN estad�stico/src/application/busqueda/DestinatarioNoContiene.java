package application.busqueda;

import application.model.Mensaje;

/**
 * Clase que comprueba si el Destinatario (Individuo) del mensaje no contiene el
 * String valor
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class DestinatarioNoContiene extends CriterioBusquedaValor {

	public DestinatarioNoContiene(String valor) {
		super(valor);
	}

	@Override
	protected boolean cumpleCriterio(Mensaje m) {
		if (m.getReceptor() == null) {
			return false;
		}
		return !m.getReceptor().toString().contains(valor);
	}

}
