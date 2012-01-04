package application.operations;

import application.main.Main;
import application.model.Etiqueta;
import application.model.Mensaje;

/**
 * A los mensajes resultado de aplicar un filtro, se les añade la etiqueta
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class EtiquetarAplicarFiltroOperacion extends AplicarFiltroOperacion {
	private Etiqueta etiqueta;

	public EtiquetarAplicarFiltroOperacion(Main m, String categoria,
			Etiqueta etiqueta) {
		super(m, categoria);
		this.etiqueta = etiqueta;
	}

	@Override
	protected void tratarMensaje(Mensaje mensaje) {
		mensaje.etiquetar(etiqueta);
	}

}
