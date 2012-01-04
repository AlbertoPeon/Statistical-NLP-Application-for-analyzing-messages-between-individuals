package application.operations;

import java.util.concurrent.ExecutionException;

import application.main.Main;
import application.model.Mensaje;

/**
 * Muestra en la interfáz gráfica los mensajes calculados mediante
 * {@link MensajesMismasTagsOperacion}
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class MostrarMensajesMismasTagsOperacion extends
		MensajesMismasTagsOperacion {

	public MostrarMensajesMismasTagsOperacion(Main main, Mensaje mensaje) {
		super(main, mensaje);
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
