package application.busqueda;

import application.model.Mensaje;
import application.util.TimeStamp;

/**
 * Clase que comprueba si el TimeStamp del mensaje es anterior al valor
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class TimeStampAnterior extends CriterioBusqueda {
	private TimeStamp t;

	public TimeStampAnterior(String fecha) {
		super();
		t = new TimeStamp(fecha);
	}

	@Override
	protected boolean cumpleCriterio(Mensaje m) {
		return m.getTimestamp().anteriorA(t);
	}

}
