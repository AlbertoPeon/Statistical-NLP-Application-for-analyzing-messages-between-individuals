package application.busqueda;

import application.model.Mensaje;

/**
 * Clase que comprueba si las Etiquetas del mensaje contienen el String valor
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class EtiquetasContiene extends CriterioBusquedaValor {

	public EtiquetasContiene(String valor) {
		super(valor);
	}

	@Override
	protected boolean cumpleCriterio(Mensaje m) {
		if (m.getEtiquetas() == null)
			return false;
		return contieneEtiquetas(m.getEtiquetas());
	}

}
