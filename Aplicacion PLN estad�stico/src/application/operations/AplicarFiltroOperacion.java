package application.operations;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import application.main.Main;
import application.model.Mensaje;

/**
 * Se aplica el filtro sobre los mensajes de la lista búsqueda cribandolos, de
 * tal forma que obtengamos aquellos que pueden pertenecer a la categoria. Para
 * aplicar un filtro, este debe haber sido entrenado previamente en dicha
 * categoría.
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
abstract public class AplicarFiltroOperacion extends Operacion {
	private List<Mensaje> mensajes;
	private String categoria;

	public AplicarFiltroOperacion(Main m, String categoria) {
		super(m);
		this.mensajes = this.main.getListaBusqueda();
		this.categoria = categoria;
		seleccionarMaxTarea(mensajes.size());
	}

	@Override
	protected List<Mensaje> doInBackground() throws Exception {
		return aplicarFiltro();
	}

	private List<Mensaje> aplicarFiltro() {
		int i = 0;
		int errores = 0;
		List<Mensaje> resultado = new LinkedList<Mensaje>();
		for (Mensaje mensaje : mensajes) {
			if (this.main.getClasificador().esAcierto(mensaje, categoria)) {
				tratarMensaje(mensaje);
				resultado.add(mensaje);
			} else {
				errores++;
			}
			publish(i++);
		}

		System.out.println("Nº fallos" + errores + " de " + mensajes.size());
		return resultado;
	}

	abstract protected void tratarMensaje(Mensaje mensaje);

	@Override
	protected void done() {
		try {
			main.getInterfaz().setListaBusqueda(get());
			main.getInterfaz().mostrarResultado(get());
			main.getInterfaz().finalizarCarga();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
