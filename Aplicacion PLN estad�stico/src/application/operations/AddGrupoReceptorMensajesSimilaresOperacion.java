package application.operations;

import java.util.concurrent.ExecutionException;

import application.classifier.FiltroMensajes;
import application.main.Main;
import application.model.Grupo;
import application.model.Mensaje;

/**
 * Se calculan los mensajes similares y una vez hecho, a los receptores de
 * dichos mensajes se les hace pertenecer a un determinado grupo
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class AddGrupoReceptorMensajesSimilaresOperacion extends
		MensajesSimilaresOperacion {
	private Grupo grupo;

	public AddGrupoReceptorMensajesSimilaresOperacion(Main main,
			Mensaje mensaje, Grupo grupo, FiltroMensajes filtro) {
		super(main, mensaje, filtro);
		this.grupo = grupo;
	}

	@Override
	protected void done() {
		try {
			main.addGrupoRecibeMensajes(get(), grupo);
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
