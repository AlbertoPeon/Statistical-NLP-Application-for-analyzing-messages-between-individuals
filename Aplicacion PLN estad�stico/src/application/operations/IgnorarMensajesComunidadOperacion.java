package application.operations;

import java.util.List;
import java.util.concurrent.ExecutionException;

import application.main.Main;
import application.model.Grupo;

/**
 * Ignora los mensajes calculados por {@link MensajesComunidadOperacion}
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class IgnorarMensajesComunidadOperacion extends
		MensajesComunidadOperacion {

	public IgnorarMensajesComunidadOperacion(Main main, List<Grupo> grupos) {
		super(main, grupos);
	}

	@Override
	protected void done() {
		try {
			Operacion sw = new IgnorarMensajesOperacion(main, get());
			sw.execute();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
