package application.busqueda;

import application.model.Mensaje;

/**
 * Clase que comprueba si los Grupos del mensaje contienen el String valor
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class GruposContiene extends CriterioBusquedaValor {

	public GruposContiene(String valor) {
		super(valor);
	}

	@Override
	protected boolean cumpleCriterio(Mensaje m) {
		if (m.getEmisor() != null)
			if (contieneGrupos(m.getEmisor().getGrupos()) == true)
				return true;

		if (m.getReceptor() != null)
			if (contieneGrupos(m.getReceptor().getGrupos()) == true)
				return true;

		return false;
	}
}
