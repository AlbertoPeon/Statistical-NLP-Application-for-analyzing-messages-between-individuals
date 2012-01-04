package application.operations;

import java.util.concurrent.ExecutionException;

import application.main.Main;
import application.model.Mensaje;

/**
 * Ignora los mensajes calculados por {@link MensajesMismasTagsOperacion}
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class IgnorarMensajesMismasTagsOperacion extends
		MensajesMismasTagsOperacion {

	public IgnorarMensajesMismasTagsOperacion(Main main, Mensaje mensaje) {
		super(main, mensaje);
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
