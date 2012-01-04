package application.busqueda;

import application.model.Mensaje;
import application.util.TimeStamp;

/**
 * Clase que comprueba si el TimeStamp del mensaje es anterior al valor
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class TimeStampPosterior extends CriterioBusqueda {
	private TimeStamp t;

	public TimeStampPosterior(String s) {
		super();
		t = new TimeStamp(s);
	}

	@Override
	protected boolean cumpleCriterio(Mensaje m) {
		return m.getTimestamp().posteriorA(t);
	}

}
