package application.operations;

import application.main.Main;
import application.model.Grupo;
import application.model.Mensaje;

/**
 * A los mensajes resultado de aplicar un filtro, se selecciona su receptor y se
 * le añade al grupo
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class AddGrupoReceptorAplicarFiltroOperacion extends
		AplicarFiltroOperacion {
	private Grupo grupo;

	public AddGrupoReceptorAplicarFiltroOperacion(Main m, String categoria,
			Grupo grupo) {
		super(m, categoria);
		this.grupo = grupo;
	}

	@Override
	protected void tratarMensaje(Mensaje mensaje) {
		if (mensaje.getReceptor() != null)
			mensaje.getReceptor().addGrupo(grupo);
	}

}
