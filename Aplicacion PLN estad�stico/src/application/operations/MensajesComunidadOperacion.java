package application.operations;

import java.util.LinkedList;
import java.util.List;

import application.main.Main;
import application.model.Grupo;
import application.model.Mensaje;

/**
 * Calcula los mensajes de la lista de búsqueda que pertenecen a los grupos
 * indicados
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
abstract public class MensajesComunidadOperacion extends Operacion {
	private List<Grupo> grupos;

	public MensajesComunidadOperacion(Main main, List<Grupo> grupos) {
		super(main);
		this.grupos = grupos;
		seleccionarMaxTarea(main.getListaBusqueda().size());
	}

	@Override
	protected List<Mensaje> doInBackground() throws Exception {
		List<Mensaje> resultado = new LinkedList<Mensaje>();
		int i = 0;
		for (Mensaje m : main.getListaBusqueda()) {
			if (m.getEmisor() != null
					&& m.getEmisor().tieneMismosGrupos(grupos)) {
				resultado.add(m);
			} else if (m.getReceptor() != null
					&& m.getReceptor().tieneMismosGrupos(grupos)) {
				resultado.add(m);
			}
			publish(i);
			i++;
		}
		return resultado;
	}

}
