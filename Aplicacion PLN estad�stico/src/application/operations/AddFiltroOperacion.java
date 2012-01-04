package application.operations;

import java.util.List;
import java.util.concurrent.ExecutionException;

import application.classifier.Clasificador;
import application.main.Main;
import application.model.Etiqueta;
import application.model.Grupo;
import application.model.Mensaje;

/**
 * Esta clase que hereda de Operacion realiza la acción de entrenar al
 * clasificador en la categoria indicada a partir de los mensajes que se
 * calculan.
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class AddFiltroOperacion extends Operacion {
	private String categoria;
	private List<Mensaje> mensajes;
	private Clasificador filtro;

	public AddFiltroOperacion(Main m, String categoria, Etiqueta e) {
		super(m);
		this.categoria = categoria;
		this.mensajes = this.main.obtenerMensajePorEtiqueta(e);
		this.filtro = m.getClasificador();
		seleccionarMaxTarea(mensajes.size());

	}

	public AddFiltroOperacion(Main m, String categoria, Grupo g,
			boolean isEmisor) {
		super(m);
		this.categoria = categoria;
		if (isEmisor) {
			this.mensajes = this.main.obtenerMensajePorGrupoEmisor(g);
		} else {
			this.mensajes = this.main.obtenerMensajePorGrupoReceptor(g);
		}
		this.filtro = m.getClasificador();
		seleccionarMaxTarea(mensajes.size());

	}

	@Override
	protected List<Mensaje> doInBackground() throws Exception {
		if (this.filtro == null)
			crearFiltro();
		entrenarFiltro(mensajes, categoria);
		return mensajes;
	}

	/**
	 * En el caso de que no exista el filtro, se crea y se entrena en la
	 * categoría por defecto con todos los mensajes
	 */
	private void crearFiltro() {
		this.filtro = new Clasificador();
		int i = 0;
		seleccionarMaxTarea(this.main.getMensajes().size());
		for (Mensaje mensaje : this.main.getMensajes()) {
			this.filtro.entrenar(mensaje);
			publish(i);
			i++;
		}
		this.main.setClasificador(filtro);
	}

	/**
	 * Se entrena el filtro con los mensajes que se pasan como parámetro en la
	 * categoria indicada.
	 * 
	 * @param entrenamiento
	 *            mensajes que se van a utilizar para entrenar el clasificador
	 * @param categoria
	 *            la categoria a entrenar
	 */
	private void entrenarFiltro(List<Mensaje> entrenamiento, String categoria) {
		int i = 0;
		for (Mensaje mensaje : entrenamiento) {
			this.main.getClasificador().entrenar(mensaje, categoria);
			publish(i++);
		}
	}

	@Override
	protected void done() {
		try {
			main.getInterfaz().setListaBusqueda(get());
			main.getInterfaz().mostrarResultado(get());
			main.getInterfaz().finalizarEntrenamiento(get(), this.categoria);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
