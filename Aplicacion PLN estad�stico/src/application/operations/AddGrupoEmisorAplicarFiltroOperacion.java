package application.operations;

import application.main.Main;
import application.model.Grupo;
import application.model.Mensaje;

/**
 * A los mensajes resultado de aplicar un filtro, se selecciona su emisor y se
 * le añade al grupo
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class AddGrupoEmisorAplicarFiltroOperacion extends
		AplicarFiltroOperacion {
	private Grupo grupo;

	public AddGrupoEmisorAplicarFiltroOperacion(Main m, String categoria,
			Grupo grupo) {
		super(m, categoria);
		this.grupo = grupo;
	}

	@Override
	protected void tratarMensaje(Mensaje mensaje) {
		if (mensaje.getEmisor() != null)
			mensaje.getEmisor().addGrupo(grupo);
	}

}
