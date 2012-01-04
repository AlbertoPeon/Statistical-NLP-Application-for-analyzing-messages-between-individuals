package application.operations;

import java.util.concurrent.ExecutionException;

import application.classifier.FiltroMensajes;
import application.main.Main;
import application.model.Mensaje;

/**
 * Ignora los mensajes calculados por {@link MensajesSimilaresOperacion}
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class IgnorarMensajesSimilaresOperacion extends MensajesSimilaresOperacion {
	public IgnorarMensajesSimilaresOperacion(Main m, Mensaje mensaje,
			FiltroMensajes filtro) {
		super(m, mensaje, filtro);
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
