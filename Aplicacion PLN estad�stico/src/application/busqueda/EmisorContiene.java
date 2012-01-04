package application.busqueda;

import application.model.Mensaje;

/**
 * Clase que comprueba si el Emisor (Individuo) del mensaje contiene el String
 * valor
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class EmisorContiene extends CriterioBusquedaValor {

	public EmisorContiene(String valor) {
		super(valor);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean cumpleCriterio(Mensaje m) {
		if (m.getEmisor() == null) {
			return false;
		}
		return m.getEmisor().toString().contains(valor);

	}

}
