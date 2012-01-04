package application.busqueda;

import application.model.Mensaje;

/**
 * Clase que comprueba si el texto del mensaje contiene el String valor
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class MensajeContiene extends CriterioBusquedaValor {

	public MensajeContiene(String valor) {
		super(valor);
	}

	@Override
	protected boolean cumpleCriterio(Mensaje m) {
		if (m.getTexto() == null)
			return false;
		return m.getTexto().contains(valor);
	}

}
