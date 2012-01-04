package application.operations;

import java.util.LinkedList;
import java.util.List;
import application.busqueda.CriterioBusqueda;
import application.main.Main;
import application.model.*;

/**
 * Clase abstracta que realiza una búsqueda en la lista de búsqueda actual en
 * función de uno o más criterios de búsqueda
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
abstract public class CriterioBusquedaOperacion extends Operacion {
	private List<CriterioBusqueda> listCB;

	public CriterioBusquedaOperacion(Main main, CriterioBusqueda cb) {
		super(main);
		this.listCB = new LinkedList<CriterioBusqueda>();
		this.listCB.add(cb);
	}

	public CriterioBusquedaOperacion(Main main, List<CriterioBusqueda> listCB) {
		super(main);
		this.listCB = listCB;
	}

	@Override
	protected List<Mensaje> doInBackground() throws Exception {
		List<Mensaje> resultado = new LinkedList<Mensaje>();
		for (CriterioBusqueda cb : this.listCB) {
			resultado = cribarResultado(resultado, cb);
		}
		return resultado;
	}

	/**
	 * A la lista que se le pasa como parámetro se le aplica el criterio de
	 * búsqueda indicado
	 * 
	 * @param original
	 *            lista a cribar
	 * @param cb
	 *            CriterioBusqueda que se va a utilizar para cribar la búsqueda
	 * @return los mensajes que cumplen el criterio de búsqueda
	 */
	private List<Mensaje> cribarResultado(List<Mensaje> original,
			CriterioBusqueda cb) {
		if (original.size() == 0)
			return cb
					.seleccionarMensajes(main.getInterfaz().getListaBusqueda());
		return cb.seleccionarMensajes(original);
	}
}
