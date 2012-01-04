package application.busqueda;

import application.model.Mensaje;

/**
 * Clase que comprueba si el texto del mensaje no contiene el String valor
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class MensajeNoContiene extends CriterioBusquedaValor {

	public MensajeNoContiene(String valor) {
		super(valor);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean cumpleCriterio(Mensaje m) {
		if (m.getTexto() == null)
			return false;
		return !m.getTexto().contains(valor);
	}

}
