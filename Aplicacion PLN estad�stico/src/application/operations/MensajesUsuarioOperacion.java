package application.operations;

import java.util.LinkedList;
import java.util.List;

import application.main.Main;
import application.model.Mensaje;
import application.model.Individuo;

/**
 * Calcula los mensajes cuyo emisor o receptor es el Individuo indicado
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
abstract public class MensajesUsuarioOperacion extends Operacion {
	private Individuo individuo;

	public MensajesUsuarioOperacion(Main m, Individuo u) {
		super(m);
		this.individuo = u;
		seleccionarMaxTarea(this.main.getListaBusqueda().size());
	}

	@Override
	protected List<Mensaje> doInBackground() throws Exception {
		List<Mensaje> resultado = new LinkedList<Mensaje>();
		int i = 0;
		for (Mensaje m : this.main.getListaBusqueda()) {
			if (individuo.equals(m.getEmisor())
					|| individuo.equals(m.getReceptor())) {
				resultado.add(m);
			}
		}
		i++;
		publish(i);
		return resultado;
	}

}