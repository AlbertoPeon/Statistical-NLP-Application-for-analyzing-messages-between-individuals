package application.busqueda;

import application.model.Mensaje;

/**
 * Clase que comprueba si el texto del mensaje termina por el String valor
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class MensajeTerminaPor extends CriterioBusquedaValor {

	public MensajeTerminaPor(String valor) {
		super(valor);
	}

	@Override
	protected boolean cumpleCriterio(Mensaje m) {
		if (m.getTexto() == null)
			return false;
		return m.getTexto().endsWith(valor);
	}

}
