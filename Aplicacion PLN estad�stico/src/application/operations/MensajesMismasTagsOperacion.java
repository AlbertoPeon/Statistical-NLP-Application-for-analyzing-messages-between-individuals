package application.operations;

import java.util.LinkedList;
import java.util.List;

import application.main.Main;
import application.model.Mensaje;

/**
 * En esta clase se calculan aquellos mensajes pertenecientes a la lista de
 * búsqueda que tienen las etiquetas que tiene el mensaje indicado
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
abstract public class MensajesMismasTagsOperacion extends Operacion {
	protected Mensaje mensaje;

	public MensajesMismasTagsOperacion(Main main, Mensaje mensaje) {
		super(main);
		this.mensaje = mensaje;
		seleccionarMaxTarea(main.getListaBusqueda().size());
	}

	@Override
	protected List<Mensaje> doInBackground() throws Exception {
		List<Mensaje> resultado = new LinkedList<Mensaje>();
		int i = 0;
		for (Mensaje m : this.main.getListaBusqueda()) {
			if (mensaje.tieneMismasTags(m)) {
				resultado.add(m);
			}
			i++;
			publish(i);
		}
		return resultado;
	}

}
