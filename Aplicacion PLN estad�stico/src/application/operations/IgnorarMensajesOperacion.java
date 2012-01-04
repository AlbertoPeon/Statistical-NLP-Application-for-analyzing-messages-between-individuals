package application.operations;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import application.main.Main;
import application.model.Mensaje;

/**
 * En esta clase se realiza la operación de eliminar los mensajes indicados de
 * la lista de búsqueda actual
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class IgnorarMensajesOperacion extends Operacion {
	private List<Mensaje> mensajes;

	public IgnorarMensajesOperacion(Main main, List<Mensaje> mensajes) {
		super(main);
		this.mensajes = mensajes;
		seleccionarMaxTarea(mensajes.size());
	}

	@Override
	protected List<Mensaje> doInBackground() {
		return ignorarConLinkedHashMap();
		// return ignorarConListas();
	}

	private List<Mensaje> ignorarConLinkedHashMap() {
		Map<String, Mensaje> hashtable;
		hashtable = new LinkedHashMap<String, Mensaje>(main.getListaBusqueda()
				.size());
		for (Mensaje m : main.getListaBusqueda()) {
			hashtable.put(m.getId() + "", m);
		}
		int i = 0;
		for (Mensaje m : this.mensajes) {
			hashtable.remove(m.getId() + "");
			publish(i);
			i++;
		}
		List<Mensaje> resultantes = new LinkedList<Mensaje>();
		for (Mensaje m : hashtable.values()) {
			resultantes.add(m);
		}
		return resultantes;
	}

	@SuppressWarnings("unused")
	private List<Mensaje> ignorarConListas() {
		List<Mensaje> resultante = new LinkedList<Mensaje>(
				main.getListaBusqueda());
		int i = 0;
		for (Mensaje mensaje : mensajes) {
			resultante.remove(mensaje);
			publish(i);
			i++;
		}
		return resultante;
	}

	@Override
	protected void done() {
		try {
			main.getInterfaz().setListaBusqueda(get());
			main.getInterfaz().mostrarResultado(get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

	}

}
