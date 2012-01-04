package application.operations;

import java.util.List;
import application.main.Main;
import application.model.Mensaje;

/**
 * 
 * Esta clase realiza la operación de cargar los datos de la aplicación desde la
 * Base de Datos
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class CargarBDOperacion extends Operacion {

	public CargarBDOperacion(Main main) {
		super(main);
	}

	@Override
	protected List<Mensaje> doInBackground() {
		this.main.setPatrones(this.main.getLector().leerPatrones());
		this.main.setEtiquetas(this.main.getLector().leerEtiquetas());
		this.main.setGrupos(this.main.getLector().leerGrupos());
		this.main.setMensajes(this.main.getLector().leerMensajes());
		this.main.setIndividuos(this.main.getLector().leerIndividuos());
		return this.main.getMensajes();
	}

	@Override
	protected void done() {
		try {
			List<Mensaje> todos = get();
			this.main.setMensajes(todos);
			if (todos.isEmpty()) {
				this.main.setListaBusqueda(todos);
				this.main.getInterfaz().mostrarResultadoVacia();

			} else {
				this.main.getInterfaz().setListaBusqueda(todos);
				this.main.getInterfaz().mostrarResultado(get());
			}
		} catch (Exception e) {
			this.main.getInterfaz().finalizarCarga();
		}
	}
}
