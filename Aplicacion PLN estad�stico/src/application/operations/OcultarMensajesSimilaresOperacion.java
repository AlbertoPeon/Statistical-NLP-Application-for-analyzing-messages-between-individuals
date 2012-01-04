/**
 * 
 */
package application.operations;

import java.util.concurrent.ExecutionException;

import application.classifier.FiltroMensajes;
import application.main.Main;
import application.model.Mensaje;

/**
 * Marca los mensajes calculados por {@link MensajesSimilaresOperacion} como no
 * visibles
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class OcultarMensajesSimilaresOperacion extends
		MensajesSimilaresOperacion {

	public OcultarMensajesSimilaresOperacion(Main m, Mensaje mensaje,
			FiltroMensajes filtro) {
		super(m, mensaje, filtro);
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
