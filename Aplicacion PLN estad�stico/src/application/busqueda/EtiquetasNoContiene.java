package application.busqueda;

import application.model.Mensaje;

/**
 * Clase que comprueba si las Etiquetas del mensaje no contienen el String valor
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class EtiquetasNoContiene extends CriterioBusquedaValor {

	public EtiquetasNoContiene(String valor) {
		super(valor);
	}

	@Override
	protected boolean cumpleCriterio(Mensaje m) {
		if (m.getEtiquetas() == null)
			return false;
		return !contieneEtiquetas(m.getEtiquetas());
	}

}
