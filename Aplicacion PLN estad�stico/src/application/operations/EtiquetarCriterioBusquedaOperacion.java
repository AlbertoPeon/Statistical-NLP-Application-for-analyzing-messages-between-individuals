package application.operations;

import java.util.List;
import java.util.concurrent.ExecutionException;
import application.busqueda.CriterioBusqueda;
import application.main.Main;
import application.model.Etiqueta;

/**
 * Realiza la operación de etiquetar mensajes que han sido obtenidos como
 * resultado de una búsqueda por Criterios de búsqueda
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class EtiquetarCriterioBusquedaOperacion extends
		CriterioBusquedaOperacion {
	private Etiqueta etiqueta;

	public EtiquetarCriterioBusquedaOperacion(Main main,
			List<CriterioBusqueda> cb, Etiqueta etiqueta) {
		super(main, cb);
		this.etiqueta = etiqueta;
	}

	@Override
	protected void done() {
		try {
			main.etiquetarMensajes(get(), etiqueta);
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
