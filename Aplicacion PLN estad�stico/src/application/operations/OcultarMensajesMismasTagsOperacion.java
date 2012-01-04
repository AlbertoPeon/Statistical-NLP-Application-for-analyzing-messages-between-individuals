package application.operations;

import java.util.concurrent.ExecutionException;

import application.main.Main;
import application.model.Mensaje;

/**
 * Marca los mensajes calculados por {@link MensajesMismasTagsOperacion} como no
 * visibles
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class OcultarMensajesMismasTagsOperacion extends
		MensajesMismasTagsOperacion {

	public OcultarMensajesMismasTagsOperacion(Main main, Mensaje mensaje) {
		super(main, mensaje);
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
