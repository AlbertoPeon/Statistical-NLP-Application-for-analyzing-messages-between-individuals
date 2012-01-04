package application.operations;

import java.util.concurrent.ExecutionException;

import application.main.Main;
import application.model.Individuo;

/**
 * Marca los mensajes calculados por {@link MensajesUsuarioOperacion} como no
 * visibles
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class OcultarMensajesIndividuoOperacion extends MensajesUsuarioOperacion {

	public OcultarMensajesIndividuoOperacion(Main m, Individuo u) {
		super(m, u);
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
