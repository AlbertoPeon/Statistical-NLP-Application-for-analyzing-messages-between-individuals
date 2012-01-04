package application.operations;

import java.util.concurrent.ExecutionException;

import application.classifier.FiltroMensajes;
import application.main.Main;
import application.model.Mensaje;

/**
 * Muestra en la interfaz gráfica los mensajes cargados mediante
 * {@link MensajesSimilaresOperacion}
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class MostrarMensajesSimilaresOperacion extends
		MensajesSimilaresOperacion {
	public MostrarMensajesSimilaresOperacion(Main m, Mensaje mensaje,
			FiltroMensajes filtro) {
		super(m, mensaje, filtro);
	}

	@Override
	protected void done() {
		try {
			main.getInterfaz().setListaBusqueda(get());
			main.getInterfaz().mostrarResultado(get());
			main.getInterfaz().finalizarCarga();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
