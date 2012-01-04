package application.busqueda;

import application.model.Mensaje;

/**
 * Clase que comprueba si el Destinatario (Individuo) del mensaje empieza por el
 * String valor
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class DestinatarioEmpiezaPor extends CriterioBusquedaValor {

	public DestinatarioEmpiezaPor(String valor) {
		super(valor);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean cumpleCriterio(Mensaje m) {
		if (m.getReceptor() == null) {
			return false;
		}
		return m.getReceptor().toString().startsWith(valor);
	}
}
