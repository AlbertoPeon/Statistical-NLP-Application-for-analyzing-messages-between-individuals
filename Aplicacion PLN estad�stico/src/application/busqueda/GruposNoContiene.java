package application.busqueda;

import application.model.Mensaje;

/**
 * Clase que comprueba si los Grupos del mensaje no contienen el String valor
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class GruposNoContiene extends CriterioBusquedaValor {

	public GruposNoContiene(String valor) {
		super(valor);
	}

	@Override
	protected boolean cumpleCriterio(Mensaje m) {
		if (m.getEmisor() != null)
			if (contieneGrupos(m.getEmisor().getGrupos()) == true)
				return false;

		if (m.getReceptor() != null)
			if (contieneGrupos(m.getReceptor().getGrupos()) == true)
				return false;

		return true;
	}

}
