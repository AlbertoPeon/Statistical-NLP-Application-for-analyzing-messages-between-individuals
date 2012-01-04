package application.busqueda;

import application.model.Mensaje;

/**
 * Clase que comprueba si el texto del mensaje empieza por el String valor
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class MensajeEmpiezaPor extends CriterioBusquedaValor {

	public MensajeEmpiezaPor(String valor) {
		super(valor);
	}

	@Override
	protected boolean cumpleCriterio(Mensaje m) {
		if (m.getTexto() == null)
			return false;
		return m.getTexto().startsWith(valor);
	}

}
