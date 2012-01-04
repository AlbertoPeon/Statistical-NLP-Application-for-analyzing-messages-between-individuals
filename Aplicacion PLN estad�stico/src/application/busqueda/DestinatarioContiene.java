package application.busqueda;

import application.model.Mensaje;

/**
 * Clase que comprueba si el Destinatario (Individuo) del mensaje contiene el
 * String valor
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class DestinatarioContiene extends CriterioBusquedaValor {

	public DestinatarioContiene(String valor) {
		super(valor);
	}

	@Override
	protected boolean cumpleCriterio(Mensaje m) {
		if (m.getReceptor() == null) {
			return false;
		}
		return m.getReceptor().toString().contains(valor);
	}
}