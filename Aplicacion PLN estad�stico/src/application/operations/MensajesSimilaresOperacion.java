package application.operations;

import java.util.ArrayList;
import java.util.List;
import application.classifier.FiltroMensajes;
import application.main.Main;
import application.model.*;

/**
 * 
 * Realiza la operación que calcula si varios mensajes son similares a otro
 * utilizando un filtro
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
abstract public class MensajesSimilaresOperacion extends Operacion {
	private List<Mensaje> mensajes;
	private Mensaje mensaje;
	private FiltroMensajes filtro;

	public MensajesSimilaresOperacion(Main m, Mensaje mensaje,
			FiltroMensajes filtro) {
		super(m);
		this.mensaje = mensaje;
		this.mensajes = m.getListaBusqueda();
		this.filtro = filtro;
		seleccionarMaxTarea(mensajes.size());
	}

	@Override
	protected List<Mensaje> doInBackground() throws Exception {
		return obtenerMensajesSimilares();
	}

	/**
	 * En este método se calculan los mensajes similares al mensaje dado. Se
	 * calcula el simhash de cada mensaje y si coincide con el del mensaje dado,
	 * se añade a la lista de Mensajes
	 * 
	 * @return lista con los mensajes cuyo simhash coincide con el original
	 */
	public List<Mensaje> obtenerMensajesSimilares() {
		List<Mensaje> resultado = new ArrayList<Mensaje>();
		int i = 0;
		for (Mensaje m : mensajes) {
			if (filtro.esSimilar(mensaje, m)) {
				resultado.add(m);
			}
			publish(i);
			i++;
		}
		return resultado;
	}

}
