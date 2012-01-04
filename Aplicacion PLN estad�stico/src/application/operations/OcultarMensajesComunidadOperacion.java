package application.operations;

import java.util.List;
import java.util.concurrent.ExecutionException;

import application.main.Main;
import application.model.Grupo;

/**
 * Marca los mensajes calculados por {@link MensajesComunidadOperacion} como no
 * visibles
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class OcultarMensajesComunidadOperacion extends
		MensajesComunidadOperacion {

	public OcultarMensajesComunidadOperacion(Main main, List<Grupo> grupos) {
		super(main, grupos);
	}

	@Override
	protected void done() {
		try {
			main.ocultarMensajes(get());
			main.getInterfaz().mostrarResultado();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
