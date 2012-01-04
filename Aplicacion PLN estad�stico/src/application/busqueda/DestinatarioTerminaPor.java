package application.busqueda;

import application.model.Mensaje;

/**
 * Clase que comprueba si el Destinatario (Individuo) del mensaje termina por el
 * String valor
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class DestinatarioTerminaPor extends CriterioBusquedaValor {

	public DestinatarioTerminaPor(String valor) {
		super(valor);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean cumpleCriterio(Mensaje m) {
		if (m.getReceptor() == null) {
			return false;
		}
		return m.getReceptor().toString().endsWith(valor);
	}

}
