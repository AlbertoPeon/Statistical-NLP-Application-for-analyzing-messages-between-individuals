package application.operations;

import java.util.List;
import java.util.concurrent.ExecutionException;

import application.main.Main;
import application.model.Grupo;
import application.model.Mensaje;

/**
 * A aquellos mensajes calculados que tienen las mismas etiquetas, se selecciona
 * su Receptor y se le hace pertenecer a la lista de grupos
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class AddGrupoMensajesMismasTagsOperacion extends
		MensajesMismasTagsOperacion {
	private List<Grupo> grupos;

	public AddGrupoMensajesMismasTagsOperacion(Main main, Mensaje mensaje,
			List<Grupo> grupos) {
		super(main, mensaje);
		this.grupos = grupos;
	}

	@Override
	protected void done() {
		try {
			main.addGrupoRecibeMensajes(get(), grupos);
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
