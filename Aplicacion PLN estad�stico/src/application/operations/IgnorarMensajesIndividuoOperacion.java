package application.operations;

import java.util.concurrent.ExecutionException;

import application.main.Main;
import application.model.Individuo;

/**
 * Ignora los mensajes calculados por {@link MensajesUsuarioOperacion}
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class IgnorarMensajesIndividuoOperacion extends MensajesUsuarioOperacion {

	public IgnorarMensajesIndividuoOperacion(Main m, Individuo u) {
		super(m, u);
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
