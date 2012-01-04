package application.busqueda;

import application.model.Mensaje;
import application.util.TimeStamp;

/**
 * Clase que comprueba si el TimeStamp del mensaje está comprendido entre el
 * TimeStamp Desde y el TimeStamp Hasta
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class TimeStampEntre extends CriterioBusqueda {
	private TimeStamp desde;
	private TimeStamp hasta;

	public TimeStampEntre(TimeStamp desde, TimeStamp hasta) {
		super();
		this.desde = desde;
		this.hasta = hasta;
	}

	public TimeStampEntre(String desde, String hasta) {
		super();
		this.desde = new TimeStamp(desde);
		this.hasta = new TimeStamp(hasta);
	}

	@Override
	protected boolean cumpleCriterio(Mensaje m) {
		if (m.getTimestamp() == null) {
			return false;
		}
		return m.getTimestamp().comprendidoEntre(desde, hasta);
	}

}
