package application.operations;

import java.util.concurrent.ExecutionException;

import application.main.Main;
import application.model.Individuo;

/**
 * Muestra en la interfaz gráfica los mensajes cargados mediante
 * {@link MensajesUsuarioOperacion}
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class MostrarMensajesIndividuoOperacion extends MensajesUsuarioOperacion {

	public MostrarMensajesIndividuoOperacion(Main m, Individuo u) {
		super(m, u);
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
