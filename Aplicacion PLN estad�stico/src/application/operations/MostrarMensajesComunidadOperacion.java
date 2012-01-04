package application.operations;

import java.util.List;
import java.util.concurrent.ExecutionException;

import application.main.Main;
import application.model.Grupo;

/**
 * Muestra en la interfaz gráfica los mensajes calculados por
 * {@link MensajesComunidadOperacion}
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class MostrarMensajesComunidadOperacion extends
		MensajesComunidadOperacion {

	public MostrarMensajesComunidadOperacion(Main main, List<Grupo> grupos) {
		super(main, grupos);
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
